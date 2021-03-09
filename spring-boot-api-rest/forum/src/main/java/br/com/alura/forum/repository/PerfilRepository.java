package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
