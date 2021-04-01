package br.com.alura.leilao.leilao;

import br.com.alura.leilao.PageBasic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class CadastroLeilaoPage extends PageBasic {


    public String URL_CADASTRO_LEILAO =  getBaseUrl()+"/leiloes/new";

    public static String nomeLeilao = "novo leilao";
    public static String valorLeilao = "50";
    public static String dataAberturaLeilao = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    public CadastroLeilaoPage(WebDriver browser) {
        super(browser);

    }

    public CadastroLeilaoPage() {
        super();
    }

    public void acessaPaginaCadastroLeilao() {
        navigateTo(URL_CADASTRO_LEILAO);
    }

    public LeilaoPage preencheCadastroESubmete(String nome, String valorInicial, LocalDateTime dataAbertura) {
        browser.findElement(By.id("nome")).sendKeys(nome);
        browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
        browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        browser.findElement(By.id("adicionar-leilao")).submit();
        return new LeilaoPage(browser);
    }
}
