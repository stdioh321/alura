package br.com.stdioh321.imposto;

import br.com.stdioh321.modelo.Orcamento;

import java.math.BigDecimal;

public class CalculadoraImposto {
    public BigDecimal calcular(Orcamento orcamento, ITipoImposto iTipoImposto) {
        return iTipoImposto.calcular(orcamento);
    }
}
