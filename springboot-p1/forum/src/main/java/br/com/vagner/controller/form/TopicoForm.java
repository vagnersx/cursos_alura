package br.com.vagner.controller.form;

import br.com.vagner.modelo.Curso;
import br.com.vagner.modelo.Topico;
import br.com.vagner.repository.CursoRepository;

public class TopicoForm {
	private String titulo;
	private String mensagem;
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
