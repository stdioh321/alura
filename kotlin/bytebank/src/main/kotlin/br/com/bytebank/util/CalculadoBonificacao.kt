package br.com.bytebank.util

import br.com.bytebank.model.Funcionario

class CalculadoBonificacao {
    var total: Double = 0.0
        private set

    fun registra(funcionario: Funcionario) {
        total += funcionario.bonificacao;
    }
}