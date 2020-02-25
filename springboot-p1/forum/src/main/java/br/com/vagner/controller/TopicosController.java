package br.com.vagner.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public List<TopicoDTO> listar(String nomeCurso) {
		System.out.println(nomeCurso);
		
		List<Topico> topicos;
		if (nomeCurso != null) {
			topicos = topicoRepository.findByCursoNome(nomeCurso);
		} else {
			topicos = topicoRepository.findAll();
		}
		
		return TopicoDTO.converteLista(topicos);
	}
	
	@PostMapping
	@Transactional
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
	public TopicoDTO atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm topicoForm) throws Exception{
		
		Topico topico = topicoForm.atualizar(id, topicoRepository);
		return new TopicoDTO(topico);
	}
	
	@DeleteMapping(path = "/{id}")
	@Transactional
	public void remover(@PathVariable Long id) {
		topicoRepository.deleteById(id);
	}
	
}