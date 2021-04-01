package br.com.stdioh321.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@ToString
public class Orcamento {
    private BigDecimal valor;
}
