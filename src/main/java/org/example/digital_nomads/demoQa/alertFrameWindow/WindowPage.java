package org.example.digital_nomads.demoQa.alertFrameWindow;

import org.example.digital_nomads.demoQa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowPage extends BasePage {

    @FindBy(css = "#tabButton")
    private WebElement tabButton;

    @FindBy(css = "#windowButton")
    private WebElement windowButton;

    @FindBy(css = "#messageWindowButton")
    private WebElement massageWindowButton;

    public WindowPage clickTabButton(){
        elementActions.clickBtn(tabButton);
        return this;
    }

    public WindowPage clickWindowButton(){
        elementActions.clickBtn(windowButton);
        return this;
    }

    public WindowPage clickMessageWindowButton(){
        elementActions.clickBtn(massageWindowButton);
        return this;
    }
}
