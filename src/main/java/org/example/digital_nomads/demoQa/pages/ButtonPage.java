package org.example.digital_nomads.demoQa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ButtonPage extends BasePage {

    @FindBy(css = "#doubleClickBtn")
    private WebElement doubleClickBtn;

    @FindBy(css = "#rightClickBtn")
    private WebElement rightClickBtn;

    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement clickMeBtn;

    @FindBy(css = "#doubleClickMessage")
    private WebElement doubleClickMessage;

    @FindBy(css = "#rightClickMessage")
    private WebElement rightClickMessage;

    @FindBy(css = "#dynamicClickMessage")
    private WebElement dynamicClickMessage;

    public ButtonPage doubleClick() {
        elementActions.doubleClick(doubleClickBtn);
        return this;
    }

    public ButtonPage rightClick() {
        elementActions.rightClick(rightClickBtn);
        return this;
    }

    public ButtonPage сlickMe() {
        elementActions.clickBtn(clickMeBtn);
        return this;
    }

    public String getDoubleClickMessage() {
        return doubleClickMessage.getText();
    }

    public String getRightClickMessage() {
        return rightClickMessage.getText();
    }

    public String getDynamicClickMessage() {
        return dynamicClickMessage.getText();
    }

//    public ButtonPage assertionsButton() {
//        assertEquals("You have done a double click", getDoubleClickMessage());
//        assertEquals("You have done a right click", getRightClickMessage());
//        assertEquals("You have done a dynamic click", getDynamicClickMessage());
//        return this;
//    }
}
