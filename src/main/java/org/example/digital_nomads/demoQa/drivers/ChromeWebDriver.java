package org.example.digital_nomads.demoQa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeWebDriver {

   public static WebDriver driver;

    public static WebDriver loadChromeDriver() {
        WebDriverManager.chromedriver().setup();                   //NORMAL как обычно работает
        ChromeOptions chromeOptions = new ChromeOptions();         //EAGER быстрее работает
      // chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);//NONE не будет ждать автоматом работает
      //  chromeOptions.addArguments("--headless=new"); //браузер не видим но тесты проходить очень удобно
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        return driver;
    }
}
