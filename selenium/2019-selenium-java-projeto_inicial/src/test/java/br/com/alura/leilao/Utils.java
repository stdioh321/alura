package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {


    public static WebDriver getChromeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        return new ChromeDriver();
    }
}
