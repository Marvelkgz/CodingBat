package org.example.digital_nomads.demoQa.pages;
import org.example.digital_nomads.demoQa.drivers.DriverManager;
import org.example.digital_nomads.demoQa.helpers.ElementActions;
import org.example.digital_nomads.demoQa.models.UserPracticeForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public ElementActions elementActions = new ElementActions();

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}
