package br.com.bytebank.model

class Diretor(
    nome: String,
    cpf: String,
    salario: Double,
    senha: String
) : FuncionarioAutenticavel(nome, cpf, salario, senha), Autenticavel {


    override val bonificacao: Double get() = salario * 0.33;


//

}