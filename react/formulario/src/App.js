import React, { Component } from "react";
import "./App.css";
import FormularioCadastro from "./components/FormularioCadastro/FormularioCadastro";
import "fontsource-roboto";
import { Container, Typography } from "@material-ui/core";

import ValidacoesCadastro from "./contexts/ValidacoesCadastro";

import { validarCPF, validarSenha } from "./models/cadastro";
import useData, { DataWithValidation } from "./hooks/useData";

function App() {
  const [data, setField, errors, setErrors] = useData();
  const dataWithValidations = new DataWithValidation();
  return (
    <Container component="article" maxWidth="sm">
      <Typography variant="h3" component="h1" align="center">
        Formulário de cadastro
      </Typography>
      <ValidacoesCadastro.Provider
        value={{
          cpf: validarCPF,
          senha: validarSenha,
          nome: validarSenha,
          data: dataWithValidations,
        }}
      >
        <FormularioCadastro aoEnviar={aoEnviarForm} />
      </ValidacoesCadastro.Provider>
    </Container>
  );
}

function aoEnviarForm(dados) {
  console.log(dados);
}

export default App;
