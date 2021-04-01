package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    private LoginPage loginPage;

    @BeforeEach
    public void beforeEach() {
        loginPage = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
        loginPage.fechaBrowser();
    }


    @Test
    public void deveriaEfetuarLoginComDadosValidos() throws InterruptedException {
        loginPage.accesaPaginaLogin();
        loginPage.preencheESubmeteLogin(LoginPage.user, LoginPage.pass);
        Assert.assertTrue(loginPage.isUsuarioLogado());
        Assert.assertFalse(loginPage.isUrlLogin());


    }

    @Test
    public void deveriaEfetuarLoginComDadosInvalidos() throws InterruptedException {
        loginPage.accesaPaginaLogin();
        loginPage.preencheESubmeteLogin("invalido", "invalido");

        Assert.assertTrue(loginPage.getBrowser().getCurrentUrl().startsWith(loginPage.URL_LOGIN));
        Assert.assertTrue(loginPage.getPageContent().contains("Usuário e senha inválidos."));
        Assert.assertFalse(loginPage.isUsuarioLogado());
    }
}
