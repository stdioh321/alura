package br.com.alura.forum.controller;


import br.com.alura.forum.controller.dto.UsuarioDto;
import br.com.alura.forum.controller.form.UsuarioPostForm;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public List<UsuarioDto> get() {
        List<UsuarioDto> usuarios = usuarioRepository.findAll().stream().map(UsuarioDto::new).collect(Collectors.toList());
        return usuarios;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getById(@PathVariable("id") Long id) {
        var usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new UsuarioDto(usuario.get()));
    }

    @PostMapping
    @Transactional
    public ResponseEntity post(@Valid @RequestBody UsuarioPostForm usuarioPostForm) {
        var usuario = usuarioPostForm.convert();
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new UsuarioDto(usuario));

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity put(@PathVariable("id") Long id, @Valid @RequestBody UsuarioPostForm usuarioPostForm) {
        if (usuarioRepository.findById(id).isEmpty()) return ResponseEntity.notFound().build();
        var usuario = usuarioPostForm.update(id, usuarioRepository);
        return ResponseEntity.ok(new UsuarioDto(usuario));
    }
}
