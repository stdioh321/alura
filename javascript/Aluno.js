import {Pessoa} from './Pessoa.js';

export default class Aluno extends Pessoa{
    matricula;
    
    constructor(nome,rg,cpf,dtNascimento,matricula){
        super(nome,rg,cpf,dtNascimento);
        this.matricula = matricula;
    } 

}