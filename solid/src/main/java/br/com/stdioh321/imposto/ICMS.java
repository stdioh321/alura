package br.com.stdioh321.imposto;

import br.com.stdioh321.modelo.Orcamento;

import java.math.BigDecimal;

public class ICMS implements ITipoImposto {
    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }
}
