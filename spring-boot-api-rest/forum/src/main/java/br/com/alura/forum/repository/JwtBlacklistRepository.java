package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.JwtBlacklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JwtBlacklistRepository extends JpaRepository<JwtBlacklist,Long> {

    Optional<JwtBlacklist> findByName(String jwt);
    boolean existsByName(String jwt);
}
