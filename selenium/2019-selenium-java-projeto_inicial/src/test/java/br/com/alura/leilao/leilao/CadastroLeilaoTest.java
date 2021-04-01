package br.com.alura.leilao.leilao;

import br.com.alura.leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CadastroLeilaoTest {

    private CadastroLeilaoPage cadastroLeilaoPage;


    @BeforeEach
    public void beforeEach() {
        var loginPage = new LoginPage();
        loginPage.accesaPaginaLogin();
        loginPage.preencheESubmeteLogin(LoginPage.user, LoginPage.pass);
        cadastroLeilaoPage = new CadastroLeilaoPage(loginPage.getBrowser());
    }

    @AfterEach
    public void afterEach() {
        cadastroLeilaoPage.closeBrowser();
    }

    @Test
    public void deveCadastrarUmLeilaoValido() {
        cadastroLeilaoPage.acessaPaginaCadastroLeilao();
        var nome = "Novo leilao - " + Instant.now().getEpochSecond();
        var valor = "1234.00";
        var dataAbertura = LocalDateTime.now();
        var leilaoPage = cadastroLeilaoPage.preencheCadastroESubmete(nome, valor, dataAbertura);

        Assert.assertTrue(leilaoPage.isLeilaoCadastrado(nome, valor, dataAbertura.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), LoginPage.user));
        Assert.assertTrue(!cadastroLeilaoPage.isInUrl(cadastroLeilaoPage.URL_CADASTRO_LEILAO));
    }

    @Test
    public void deveCadastrarUmLeilaoInvalido() {
        cadastroLeilaoPage.acessaPaginaCadastroLeilao();
        String nome = "super novo leilao";
        String valorInicial = "abc";
        var dataAbertura = LocalDateTime.now();
        var leilaoPage = cadastroLeilaoPage.preencheCadastroESubmete(nome, valorInicial, dataAbertura);
        Assert.assertFalse(leilaoPage.isLeilaoCadastrado(nome, valorInicial, dataAbertura.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), LoginPage.user));
        Assert.assertFalse(cadastroLeilaoPage.containInPage("Leilão salvo com sucesso"));
        //Assert.assertTrue(cadastroLeilaoPage.isInUrl(cadastroLeilaoPage.URL_CADASTRO_LEILAO));
    }

}
