package org.example.digital_nomads.demoQa.alertFrameWindow;

import org.example.digital_nomads.demoQa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AlertsPage extends BasePage {

    @FindBy(css = "#alertButton")
    private WebElement alertBtn;

    @FindBy(css = "#timerAlertButton")
    private WebElement timerAlertBtn;

    @FindBy(css = "#confirmButton")
    private WebElement confirmBtn;

    @FindBy(css = "#promtButton")
    private WebElement promtBtn;

    public AlertsPage clickAlertButton(){
        elementActions.clickBtn(alertBtn);
        return this;
    }

    public AlertsPage clickTimerButton(){
        elementActions.clickBtn(timerAlertBtn);
        return this;
    }

    public AlertsPage clickConfirmButton(){
        elementActions.clickBtn(confirmBtn);
        return this;
    }

    public AlertsPage clickPromptButton(){
        elementActions.clickBtn(promtBtn);
        return this;
    }


}
