package br.com.bytebank.model

class SistemInterno {

    fun entra(autenticavel: Autenticavel, senha: String): Boolean {
        if (autenticavel.autentica(senha)) {
            println("Bem vindo");
            return true;
        }
        println("Falha na Autenticacao");
        return false;
    }
}