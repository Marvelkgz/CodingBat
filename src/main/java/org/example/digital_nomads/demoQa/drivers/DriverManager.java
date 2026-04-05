package org.example.digital_nomads.demoQa.drivers;

import org.example.digital_nomads.demoQa.utils.FileReader;
import org.openqa.selenium.WebDriver;


public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            switch (FileReader.getValue("browser").toLowerCase()){
                case "chrome" : driver = ChromeWebDriver.loadChromeDriver();
                break;
                case  "edge" : driver = EdgeWebDriver.loadEdgeDriver();
                break;
                case "firefox" : driver = FireFoxWebDriver.loadFireFoxDriver();
                break;
                default: throw new IllegalArgumentException("Wrong driver name");
            }
        }
        return driver;
    }

    public static void closeDriver(){
        try{
            if (driver != null){
                driver.close();
                driver.quit();
                driver = null;
            }
        }catch (Exception e){
            System.out.println("Error while closing driver");
        }
    }
}
