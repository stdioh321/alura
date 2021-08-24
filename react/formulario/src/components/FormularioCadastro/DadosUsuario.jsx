import React, { useState, useContext, useEffect } from "react";
import { TextField, Button, Box, Grid } from "@material-ui/core";

import ValidacoesCadastro from "../../contexts/ValidacoesCadastro";
import useErros from "../../hooks/useErros";
import { Valido } from "../../models/cadastro";

function DadosUsuario({ aoEnviar }) {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const validacoes = useContext(ValidacoesCadastro);
  const data = validacoes.data;
  const [erros, validarCampos, possoEnviar] = useErros(validacoes);

  useEffect(() => {
    console.log(data);
  });

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (possoEnviar()) {
          aoEnviar({ email, senha });
        }
      }}
    >
      <TextField
        value={email}
        onChange={(event) => {
          const val = event.target.value;
          data.setData("email", val, () => {
            if (val.length < 3) return "Dever ser maior que 3";
          });
          setEmail(val);
        }}
        id="email"
        name="email"
        label="email"
        type="email"
        required
        variant="outlined"
        margin="normal"
        fullWidth
      />
      <TextField
        value={senha}
        onChange={(event) => {
          setSenha(event.target.value);
        }}
        onBlur={(ev) => {
          validarCampos(ev);
        }}
        error={!erros?.senha?.valido}
        helperText={erros?.senha?.texto}
        id="senha"
        name="senha"
        label="senha"
        type="password"
        required
        variant="outlined"
        margin="normal"
        fullWidth
      />
      <Button type="submit" variant="contained" color="primary">
        Próximo
      </Button>
    </form>
  );
}

export default DadosUsuario;
