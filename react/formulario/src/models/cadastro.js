function validarCPF(cpf) {
    if (cpf.length !== 11) {
        return new Valido(false, "CPF deve ter 11 dígitos.");
    } else {
        return new Valido();
    }
}

function validarSenha(senha) {
    if (senha.length < 4 || senha.length > 72) {
        return new Valido(false, "Senha deve ter 4 e 72 dígitos.");
    } else {
        return new Valido();
    }
}




class Valido {
    constructor(valido = true, texto = "") {
        this.valido = valido;
        this.texto = texto;
    }
}

export { validarCPF, validarSenha, Valido };