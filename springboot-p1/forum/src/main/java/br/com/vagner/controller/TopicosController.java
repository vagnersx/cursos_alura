package br.com.vagner.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vagner.controller.dto.TopicoDTO;
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
	public ResponseEntity<TopicoDTO> salvar(@RequestBody  TopicoForm topicoForm, UriComponentsBuilder uriBuilder) {
		Topico topico = topicoForm.converter(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}

}