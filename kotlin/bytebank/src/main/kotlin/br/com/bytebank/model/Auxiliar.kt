package br.com.bytebank.model

class Auxiliar(nome: String,
               cpf: String,
               salario: Double) : Funcionario(nome, cpf, salario) {
    var senha: String = "";


    override val bonificacao: Double get() = salario * 0.06;


}