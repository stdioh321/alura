package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class TopicoForm {

    @NotNull @NotEmpty @Length(min = 3)
    private String titulo;

    @NotNull @NotEmpty @Length(min = 3)
    private String mensagem;

    @NotNull @NotEmpty @Length(min = 1)
    private String nomeCurso;

    public Topico convert(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNomeIgnoreCase(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }

}
