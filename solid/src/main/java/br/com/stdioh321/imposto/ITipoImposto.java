package br.com.stdioh321.imposto;

import br.com.stdioh321.modelo.Orcamento;

import java.math.BigDecimal;

public interface ITipoImposto {
    BigDecimal calcular(Orcamento orcamento);
}
