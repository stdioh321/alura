import { Cliente } from "./Cliente.js";
import { ContaCorrente } from "./ContaCorrente.js";

const cliente1 = new Cliente("Joao", 12312312333);
const cc1 = new ContaCorrente()
cc1._cliente = cliente1;
cc1._agencia = 1234;
cc1._saldo = 123;


console.log(cc1);