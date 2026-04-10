package org.example.digital_nomads.demoQa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeWebDriver {

    public static WebDriver driver;

    public static WebDriver loadChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
       // chromeOptions.addArguments("--headless=new");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-gpu");

        String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");

        if (remoteUrl != null && !remoteUrl.isEmpty()) {
            // Запуск через Docker / Selenium Grid
            try {
                driver = new RemoteWebDriver(new URL(remoteUrl), chromeOptions);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Неверный SELENIUM_REMOTE_URL: " + remoteUrl, e);
            }
        } else {
            // Локальный запуск
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        }

        driver.manage().window().maximize();
        return driver;
    }
}
