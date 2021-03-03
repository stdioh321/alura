package br.com.alura.forum.controller;

import br.com.alura.forum.modelo.Usuario;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tmp")
public class TmpController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario hello(@RequestParam(name = "id") Long id) {
        Usuario user = new Usuario();
        user.setId(id);
        user.setNome("TESTttttt");
        user.setEmail("jjj@test.com");


        return user;
    }
}
