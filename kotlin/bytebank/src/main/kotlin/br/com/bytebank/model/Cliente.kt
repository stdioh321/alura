package br.com.bytebank.model

 class Cliente(var nome: String, var cpf: String): Autenticavel {
    override var senha: String = ""
 }