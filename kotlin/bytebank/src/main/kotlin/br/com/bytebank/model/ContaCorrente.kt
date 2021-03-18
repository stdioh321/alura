package br.com.bytebank.model


class ContaCorrente(titular: String, numero: Int, saldo: Double) : Conta(
        titular = titular,
        numero = numero,
        saldo = saldo
) {

    override fun saca(valor: Double): Boolean {
        val valorComTaxa = valor + 0.10;
        return super.saca(valorComTaxa)
    }
}

