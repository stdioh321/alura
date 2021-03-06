package br.com.bytebank.model


abstract class Conta {
    var titular: Cliente
        get() = field
        set(value) {
            field = value
        }
    var numero: Int = 0
        get() = field
        set(value) {
            field = value
        }
    var saldo: Double = 0.0
        get() = field
        protected set(value) {
            field = value
        }

    constructor(titular: Cliente, numero: Int, saldo: Double) {
        this.titular = titular
        this.numero = numero
        this.saldo = saldo

        var tmp = object {
            var name = "tmp"
        }

    }

    init {
        println("Criando Conta");
//        Contador.total++;
        Companion.total++;
    }


    //    companion object Contador {
    companion object  {
        var total: Int = 0
            private set
    }
//
//    constructor() {
//
//    }


    open fun saca(valor: Double): Boolean {
        if (saldo != null && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    fun deposita(valor: Double): Boolean {
        if (valor != null && valor >= 0) {
            saldo += valor;
            return true;
        }
        return false;
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo > valor && destino != null) {
            if (saca(valor)) {
                if (destino.deposita(valor)) return true;
            }
        }
        return false;
    }


}

