package br.com.vagner.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.vagner.modelo.Topico;
import br.com.vagner.repository.TopicoRepository;

public class AtualizacaoTopicoForm {
	
	@NotNull
	@NotEmpty
	private String titulo;

	@NotEmpty
	@Length(min = 5)
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {

		this.mensagem = mensagem;
	}

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getOne(id);
		topico.setTitulo(titulo);
		topico.setMensagem(mensagem);
		return topico;
	}
}
