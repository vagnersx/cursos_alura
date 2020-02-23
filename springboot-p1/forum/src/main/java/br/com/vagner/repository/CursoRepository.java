package br.com.vagner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vagner.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findByNome(String nomeCurso);

}
