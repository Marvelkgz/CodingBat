package org.example.digital_nomads.demoQa.helpers;

import org.example.digital_nomads.demoQa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.swing.*;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class ElementActions {

    Actions actions = new Actions(DriverManager.getDriver());

    public ElementActions waitElementToBeClickable(WebElement webElement) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15)).
                until(ExpectedConditions.elementToBeClickable(webElement));
        return this;
    }

    public ElementActions waitElementToBeVisible(WebElement webElement) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15)).
                until(ExpectedConditions.visibilityOf(webElement));
        return this;
    }

    public ElementActions clickBtn(WebElement element) {
        waitElementToBeClickable(element);
        waitElementToBeVisible(element);
        scrollToElement(element);
        element.click();
        return this;
    }

    public ElementActions inputText(WebElement webElement,String text){
        waitElementToBeVisible(webElement);
        scrollToElement(webElement);
        webElement.sendKeys(text);
        return this;
    }

    public ElementActions scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        return this;
    }

    public ElementActions selectByVisibleText(WebElement element,String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
        return this;
    }

    public ElementActions selectByIndex(WebElement element,int index){
        Select select = new Select(element);
        select.selectByIndex(index);
        return this;
    }

    public ElementActions doubleClick(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        actions.doubleClick(element).perform();
        return  this;
    }

    public ElementActions rightClick(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        actions.contextClick(element).perform();
        return this;
    }

//    Wait<WebDriver> wait = new FluentWait<>(DriverManager.getDriver())
//            .withTimeout(Duration.ofSeconds(30)) // Максимальное время ожидания
//            .pollingEvery(Duration.ofSeconds(3))  // Частота опроса
//            .ignoring(NoSuchElementException.class); // Игнорируемые исключения
//
//    // Ожидание элемента
//    WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//        public WebElement apply(WebDriver driver) {
//            return driver.findElement(By.id("dynamicElement"));
//        }
//    });



}
