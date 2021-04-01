package br.com.bytebank.model

class Endereco {

    var cep: String? = null;
    var cidade: String? = null;
    var estado: String? = null;

    constructor(cep: String? = null, estado: String? = null, cidade: String? = null) {
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }
}