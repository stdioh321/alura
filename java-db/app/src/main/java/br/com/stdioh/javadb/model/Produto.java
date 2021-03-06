package br.com.stdioh.javadb.model;

import lombok.*;

import javax.annotation.Nullable;
import java.beans.ConstructorProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Produto {
    private Integer id;

    @NonNull
    private String nome;
    private String descricao;
    private Categoria categoria;
}
