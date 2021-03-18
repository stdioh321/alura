package br.com.bytebank.model

open abstract  class FuncionarioAutenticavel(var nome: String,
                                             var cpf: String,
                                             var salario: Double,
                                             var senha:String
) {
    abstract val bonificacao: Double;
}