package br.com.alura.forum.modelo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "jwt_blacklist")
public class JwtBlacklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
