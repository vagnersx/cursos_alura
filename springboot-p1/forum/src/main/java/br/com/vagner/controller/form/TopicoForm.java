package br.com.vagner.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.vagner.modelo.Curso;
import br.com.vagner.modelo.Topico;
import br.com.vagner.repository.CursoRepository;

public class TopicoForm {
	
	@NotNull @NotEmpty
	private String titulo;
	
	@NotEmpty @Length(min = 5)
	private String mensagem;
	
	@NotEmpty
	private String nomeCurso;

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

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(this.nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}

}
