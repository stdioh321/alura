package br.com.bytebank.model

interface Autenticavel {

    var senha: String;
    fun autentica(senha: String): Boolean {
        if (this.senha.equals(senha)) return true;
        return false;
    }
}