package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public abstract class PageBasic {

    // Default Chrome Web Driver
    protected WebDriver browser = null;
    protected String PORT = "8080";
    protected String HOST = "http://localhost";

    public PageBasic(WebDriver browser) {
        this.browser = browser;
        this.browser
                .manage()
                .timeouts().implicitlyWait(5, TimeUnit.SECONDS)
                .pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public PageBasic() {
        this(Utils.getChromeWebDriver());
    }


    public boolean containInPage(String text) {
        return browser.getPageSource().contains(text);
    }

    public String getPageContent() {
        return browser.getPageSource();
    }

    public boolean isInUrl(String url) {
        return browser.getCurrentUrl().equals(url);
    }

    public void navigateTo(String url) {
        browser.navigate().to(url);
    }

    public void closeBrowser() {
        browser.quit();
    }

    public WebDriver getBrowser() {
        return browser;
    }

    public String getBaseUrl() {
        return HOST + ":" + PORT;
    }


}
