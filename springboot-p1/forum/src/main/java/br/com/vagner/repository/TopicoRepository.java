package br.com.vagner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vagner.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	List<Topico> findByCursoNome(String nome);

}
