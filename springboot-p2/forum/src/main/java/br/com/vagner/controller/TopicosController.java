package br.com.vagner.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vagner.controller.dto.DetalhesTopicoDTO;
import br.com.vagner.controller.dto.TopicoDTO;
import br.com.vagner.controller.form.AtualizacaoTopicoForm;
import br.com.vagner.controller.form.TopicoForm;
import br.com.vagner.modelo.Topico;
import br.com.vagner.repository.CursoRepository;
import br.com.vagner.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	@Cacheable(value = "listaDeTopicos")
	public Page<TopicoDTO> listar(@RequestParam(required = false) String nomeCurso,
			@PageableDefault(direction = Direction.DESC, sort = "id", page = 0, size = 10) Pageable paginacao) {
		// @RequestParam int pagina, @RequestParam int qtd, @RequestParam String
		// ordenacao) {

		//Sort sort = Sort.by(Direction.ASC, "curso.nome").and(Sort.by(Direction.ASC, "id"));
		////Pageable paginacao = PageRequest.of(0, 2, Direction.ASC, "id");
		//Pageable paginacao = PageRequest.of(0, 10, sort);

		Page<Topico> topicos;
		if (nomeCurso == null) {
			topicos = topicoRepository.findAll(paginacao);
		} else {
			topicos = topicoRepository.findByCursoNome(nomeCurso, paginacao);
		}

		return TopicoDTO.converteLista(topicos);
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true ) // Limpar o cache
	public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder) {
		Topico topico = topicoForm.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<DetalhesTopicoDTO> detalhar(@PathVariable Long id) {
		//Topico topico = topicoRepository.getOne(id);
		Optional<Topico> topico = topicoRepository.findById(id);
		
		if (topico.isPresent()) {
			return ResponseEntity.ok(new DetalhesTopicoDTO(topico.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(path = "/{id}")
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true )
	public TopicoDTO atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm topicoForm) throws Exception{
		
		Topico topico = topicoForm.atualizar(id, topicoRepository);
		return new TopicoDTO(topico);
	}
	
	@DeleteMapping(path = "/{id}")
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true )
	public void remover(@PathVariable Long id) {
		topicoRepository.deleteById(id);
	}
	
}