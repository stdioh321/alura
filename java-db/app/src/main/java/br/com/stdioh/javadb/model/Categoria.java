package br.com.stdioh.javadb.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Categoria {
    private Integer id;

    @NonNull
    private String nome;

}
