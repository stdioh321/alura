package br.com.alura.leilao.leilao;

import br.com.alura.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeilaoTest {
    private LeilaoPage leilaoPage;

    @BeforeEach
    public void beforeEach() {
        var loginPage = new LoginPage();
        loginPage.accesaPaginaLogin();
        loginPage.preencheESubmeteLogin(LoginPage.user, LoginPage.pass);
        leilaoPage = new LeilaoPage(loginPage.getBrowser());
    }

    @AfterEach
    public void afterEach() {
        leilaoPage.closeBrowser();
    }


    @Test
    public void deveriaConterNomeDoUsuarioEBotaoDeSair() {
        leilaoPage.acessaPaginaLeiloes();
        boolean nome = leilaoPage.possuiNomeDoUsuario(LoginPage.user);
        boolean botaoSair = leilaoPage.possuiOpcaoSair();

        Assert.assertTrue(nome && botaoSair);
    }

    @Test
    public void deveriaConterTextoLeiloesCadastrados() {
        leilaoPage.acessaPaginaLeiloes();
        Assert.assertTrue(leilaoPage.containInPage("Leilões cadastrados"));
    }

}
