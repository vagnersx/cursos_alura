package br.com.vagner.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vagner.controller.dto.TopicoDTO;
import br.com.vagner.modelo.Curso;
import br.com.vagner.modelo.Topico;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@GetMapping
	public List<TopicoDTO> listar() {
		Topico topico = new Topico("Dúvida", "Tenhum uma dúvida", new Curso("Spring", "Programação"));
		return TopicoDTO.converteLista(Arrays.asList(topico, topico, topico));
	}

}