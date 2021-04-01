package br.com.alura.leilao.leilao;

import br.com.alura.leilao.PageBasic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.validation.constraints.NotNull;

public class LeilaoPage extends PageBasic {
    private String URL_LEILAO = getBaseUrl() + "/leiloes";


    public LeilaoPage(WebDriver browser) {
        super(browser);
    }

    public LeilaoPage() {
        super();
    }

    public void acessaPaginaLeiloes() {
        navigateTo(URL_LEILAO);
    }

    public boolean possuiNomeDoUsuario(String nomeUsuario) {
        return browser.findElement(By.className("logo-container")).findElements(By.tagName("span"))
                .stream().anyMatch(webElement -> webElement.getText().contains(nomeUsuario));

    }

    public boolean possuiOpcaoSair() {
        return browser.findElement(By.className("logo-container"))
                .findElements(By.tagName("a")).stream().anyMatch(webElement ->
                        webElement.getText().contains("Sair")
                );

    }

    public boolean isLeilaoCadastrado( String nome,  String valor,  String dataAbertura,  String usuario) {

        var linhasTabela = browser.findElements(By.cssSelector(".container table > tbody > tr"));

        boolean isPresente = linhasTabela.stream()
                .anyMatch(wEl ->
                        {
                            String elNome = wEl.findElement(By.cssSelector("td:nth-child(1)")).getText().trim();
                            String elDataAbertura = wEl.findElement(By.cssSelector("td:nth-child(2)")).getText().trim();
                            String elValor = wEl.findElement(By.cssSelector("td:nth-child(3)")).getText().trim();
                            String elUsuario = wEl.findElement(By.cssSelector("td:nth-child(4)")).getText().trim();

                            System.out.println("Nome: " + nome.equals(elNome));
                            System.out.println("Data: " + dataAbertura.equals(elDataAbertura));
                            System.out.println("Valor: " + valor.equals(elValor));
                            System.out.println("Usuario: " + usuario.equals(elUsuario));

                            return nome.equals(elNome)
                                    && dataAbertura.equals(elDataAbertura)
                                    && valor.equals(elValor)
                                    && usuario.equals(elUsuario);
                        }

                );

        return isPresente;
    }
}
