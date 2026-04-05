package org.example.digital_nomads.demoQa.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage extends BasePage {

    public CheckBoxPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
//    @FindBy(id="userName")
//    public WebElement userName;
//
//    @FindBy(id="userEmail")
//    public WebElement userEmail;
//
//    @FindBy(id="currentAddress")
//    public WebElement currentAddress;
//
//    @FindBy(id="permanentAddress")
//    public WebElement permanentAddress;
//
//    @FindBy(id="submit")
//    public WebElement submit;
}
