package br.com.alura.forum.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorFormDto {
    private String campo;
    private String objeto;
    private String erro;
    private Object valorRejeitado;

}
