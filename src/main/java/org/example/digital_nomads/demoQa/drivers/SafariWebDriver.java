package org.example.digital_nomads.demoQa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class SafariWebDriver {

    public static WebDriver driver;

    public static WebDriver loadSafariDriver() {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
