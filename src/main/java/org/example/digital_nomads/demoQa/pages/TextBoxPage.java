package org.example.digital_nomads.demoQa.pages;
import org.example.digital_nomads.demoQa.helpers.ElementActions;
import org.example.digital_nomads.demoQa.models.UserTextBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BasePage{

    
    @FindBy(id="userName")
   private WebElement userNameInput;

    @FindBy(id="userEmail")
   private WebElement userEmailInput;

    @FindBy(id="currentAddress")
   private WebElement currentAddressInput;

    @FindBy(id="permanentAddress")
   private WebElement permanentAddressInput;

    @FindBy(id="submit")
   private WebElement submitBtn;

    public TextBoxPage fillUserName(String userName) {
        elementActions.inputText(userNameInput, userName);
        return this;
    }

    public TextBoxPage fillUserEmail(String userEmail) {
        elementActions.inputText(userEmailInput, userEmail);
        return this;
    }

    public TextBoxPage fillUserCurrentAddress(String currentAddress) {
        elementActions.inputText(currentAddressInput, currentAddress);
        return this;
    }

    public TextBoxPage fillPermanentAddress(String permanentAddress) {
        elementActions.inputText(permanentAddressInput, permanentAddress);
        return this;
    }

    public TextBoxPage submit() {
        elementActions.clickBtn(submitBtn);
        return this;
    }

    public TextBoxPage fillUpTextBoxForm(UserTextBox userTextBox){
        fillUserName(userTextBox.getName()).fillUserEmail(userTextBox.getEmail())
                .fillUserCurrentAddress(userTextBox.getCurrentAddress())
                .fillPermanentAddress(userTextBox.getPermanentAddress()).submit();
        return this;
    }
}
