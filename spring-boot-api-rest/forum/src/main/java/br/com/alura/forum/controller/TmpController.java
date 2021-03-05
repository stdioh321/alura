package br.com.alura.forum.controller;

import br.com.alura.forum.modelo.Usuario;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TmpController {

    @GetMapping
    public String hello() {
        return "Hello World!";
    }
}
