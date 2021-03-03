package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class TopicoUpdateForm {

    @NotNull @NotEmpty @Length(min = 3)
    private String titulo;

    @NotNull @NotEmpty @Length(min = 3)
    private String mensagem;

    public Topico update(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getOne(id);
        topico.setTitulo(topico.getTitulo());

        topico.setMensagem(this.mensagem);
        topico.setTitulo(this.titulo);
        return topico;
    }
}
