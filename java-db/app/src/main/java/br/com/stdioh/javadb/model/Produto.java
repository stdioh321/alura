package br.com.stdioh.javadb.model;

import lombok.*;

import javax.annotation.Nullable;
import java.beans.ConstructorProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Produto {
    private int id;

    @NonNull
    private String nome;

    private String descricao;
}
