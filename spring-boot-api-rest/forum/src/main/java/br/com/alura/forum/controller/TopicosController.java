package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicoDetalhesDto;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.controller.form.TopicoUpdateForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.util.UriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@RestController
@RequestMapping("/topico")
public class TopicosController {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private MessageSource messageSource;


    @GetMapping
    public ResponseEntity<Page<TopicoDto>> get(@RequestParam(value = "nomeCurso", required = false) String nomeCurso,
                                               @PageableDefault(size = 3) Pageable paginacao) {


        Page<TopicoDto> all = topicoRepository.findAll(paginacao).map(TopicoDto::new);

        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDetalhesDto> getById(@PathVariable("id") Long id) {
        var topico = topicoRepository.findById(id);
        if (topico.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new TopicoDetalhesDto(topico.get()));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDto> post(@Valid @RequestBody TopicoForm form, UriComponentsBuilder uriComponentsBuilder) {
        var topico = form.convert(cursoRepository);
        topicoRepository.save(topico);
        URI uri = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> put(@PathVariable("id") Long id, @Valid @RequestBody TopicoUpdateForm form) {
        if (topicoRepository.findById(id).isEmpty()) return ResponseEntity.notFound().build();
        Topico topico = form.update(id, topicoRepository);
        return ResponseEntity.ok(new TopicoDto(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable("id") Long id) {
        if (topicoRepository.findById(id).isEmpty()) return ResponseEntity.notFound().build();
        topicoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

