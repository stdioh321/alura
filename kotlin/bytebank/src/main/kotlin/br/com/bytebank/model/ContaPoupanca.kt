package br.com.bytebank.model


class ContaPoupanca(titular: Cliente, numero: Int, saldo: Double) : Conta(
        titular = titular,
        numero = numero,
        saldo = saldo
) {

}

