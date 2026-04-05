package org.example.digital_nomads.demoQa.utils;

import org.example.digital_nomads.demoQa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Task extends BasePage {

    @FindBy(xpath = "(//div[@class='header-text'])[1]")
    private WebElement tapElements;

    @FindBy(xpath = "(//span[@class='text'])[1]")
    private WebElement tapTextBox;

    @FindBy(xpath = "(//span[@class='text'])[2]")
    private WebElement tapCheckBox;

    @FindBy(xpath = "(//span[@class='text'])[3]")
    private WebElement tapRadioButton;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    private WebElement tapWebTables;

    @FindBy(xpath = "(//span[@class='text'])[5]")
    private WebElement tapButtons;

    @FindBy(xpath = "(//span[@class='text'])[6]")
    private WebElement tapLinks;

    public Task clickElements(){
        elementActions.clickBtn(tapElements);
        return this;
    }

    public Task clickTexBox(){
        elementActions.clickBtn(tapTextBox);
        return this;
    }

    public Task clickCheckBox(){
        elementActions.clickBtn(tapCheckBox);
        return this;
    }

    public Task clickRadioButton(){
        elementActions.clickBtn(tapRadioButton);
        return this;
    }

    public Task clickWebTables(){
        elementActions.clickBtn(tapWebTables);
        return this;
    }

    public Task clickButtons(){
        elementActions.clickBtn(tapButtons);
        return this;
    }

    public Task clickLinks(){
        elementActions.clickBtn(tapLinks);
        return this;
    }

}
