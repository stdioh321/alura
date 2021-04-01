package br.com.alura.leilao.login;

import br.com.alura.leilao.PageBasic;
import org.openqa.selenium.By;

public class LoginPage extends PageBasic {

    public String URL_LOGIN = getBaseUrl() + "/login";
    public static String user = "fulano";
    public static String pass = "123456";

    public LoginPage() {
        super();
    }

    public void accesaPaginaLogin() {
        navigateTo(URL_LOGIN);
    }

    public void preencheESubmeteLogin(String usuario, String senha) {
        browser.findElement(By.id("username")).sendKeys(usuario);
        browser.findElement(By.id("password")).sendKeys(senha);
        browser.findElement(By.id("login-form")).submit();
    }

    public boolean isUsuarioLogado() {
        return browser.findElement(By.className("logo-container")).getText().contains(LoginPage.user);
    }

    public boolean isUrlLogin() {
        return isInUrl(URL_LOGIN);
    }


    public void fechaBrowser() {
        closeBrowser();
    }

}
