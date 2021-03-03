package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {


    List<Topico> findByCurso_NomeIgnoreCaseContaining(String nomeCurso);
}
