package br.com.bytebank.model

class Gerente(
    nome: String,
    cpf: String,
    salario: Double,
    senha: String
) : FuncionarioAutenticavel(nome, cpf, salario, senha), Autenticavel {


    override val bonificacao: Double get() = salario * 0.2;


    override fun autentica(senha: String): Boolean {
        return this.senha.equals(senha);
    }

}