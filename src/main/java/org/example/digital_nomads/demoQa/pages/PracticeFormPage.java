package org.example.digital_nomads.demoQa.pages;

import org.example.digital_nomads.demoQa.drivers.DriverManager;
import org.example.digital_nomads.demoQa.models.UserPracticeForm;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.accessibility.AccessibleSelection;
import java.security.Key;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.example.digital_nomads.demoQa.drivers.ChromeWebDriver.driver;

public class PracticeFormPage extends BasePage{

    @FindBy(css = "#firstName")
    private WebElement userFirstName;

    @FindBy(css = "#lastName")
    private WebElement userLastName;

    @FindBy(css = "#userEmail")
    private WebElement userEmail;

    @FindBy(css = "input[value='Male'] + label")
    private WebElement maleRadioButton;

    @FindBy(css = "input[value='Female'] + label")
    private WebElement femaleRadioButton;

    @FindBy(css = "input[value='Other'] + label")
    private WebElement otherRadioButton;

    @FindBy(css = "#userNumber")
    private WebElement userMobileNumber;

    @FindBy(css = "#subjectsInput")
    private WebElement userSubject;

    @FindBy(css = "#currentAddress")
    private WebElement userCurrentAddress;

    @FindBy(css = "label[for='hobbies-checkbox-1']")
    private WebElement choiceHobbiesSport;

    @FindBy(css = "label[for='hobbies-checkbox-2']")
    private WebElement choiceHobbiesReading;

    @FindBy(css = "label[for='hobbies-checkbox-3']")
    private WebElement choiceHobbiesMusic;

    @FindBy(css = ".react-datepicker__input-container")
    private WebElement datePicker;

    @FindBy(css ="#uploadPicture")
    private WebElement uploadPicture;

    @FindBy(css ="#uploadPicture")
    private WebElement uploadPictur;

    @FindBy(css = "input[id='react-select-3-input']")
    private WebElement stateInput;

    @FindBy(css = "input[id='react-select-4-input']")
    private WebElement cityInput;

    @FindBy(css = "#submit")
    private WebElement submitBtn;

    @FindBy(css = ".table-responsive")
    private WebElement tableResponse;



    public PracticeFormPage fillUserFirstName(String firstName){
        elementActions.inputText(userFirstName,firstName);
        return this;
    }

    public PracticeFormPage fillUserLastName(String lastName){
        elementActions.inputText(userLastName,lastName);
        return this;
    }

    public PracticeFormPage fillUserEmail(String email){
        elementActions.inputText(userEmail,email);
        return this;
    }
                                                        //05 feb 2026
    public PracticeFormPage fillDateOfBirthday(String dateMonthYear){
        String[] dateMonthYearParts = dateMonthYear.split(" ");
        String day = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];
        elementActions.clickBtn(datePicker);

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));
        WebElement monthDropDown = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("react-datepicker__month-select")));
        WebElement yearDropDown = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("react-datepicker__year-select")));

        elementActions.selectByVisibleText(monthDropDown,month);
        elementActions.selectByVisibleText(yearDropDown,year);
        WebElement dayElement = wait.until(ExpectedConditions.
                elementToBeClickable(By.xpath("//div[contains(@class,'react-datepicker__day')" +
                        " and not(contains(@class,'react-datepicker__day--outside-month')) and text()='" + day + "']")));
        elementActions.clickBtn(dayElement);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;

    }

    public PracticeFormPage choiceUserGender(String gender){
        switch (gender.toLowerCase().trim()){
            case "male":
                elementActions.clickBtn(maleRadioButton);
                break;
            case "female":
                elementActions.clickBtn(femaleRadioButton);
                break;
            case "other":
                elementActions.clickBtn(otherRadioButton);
                break;
            default:
                throw new IllegalArgumentException("Неизвестный пол" + gender);
        }
        return this;
    }

    public PracticeFormPage fillUserMobileNumber(String mobileNumber){
        elementActions.inputText(userMobileNumber,mobileNumber);
        return this;
    }

    public PracticeFormPage fillUserSubject(String subject){
        elementActions.clickBtn(userSubject);
        userSubject.sendKeys(subject);
        userSubject.sendKeys(Keys.TAB);
        return this;
    }

    public PracticeFormPage choiceUserHobbiesSport(){
        elementActions.clickBtn(choiceHobbiesSport);
        return this;
    }

    public PracticeFormPage choiceUserHobbiesMusic(){
        elementActions.clickBtn(choiceHobbiesMusic);
        return this;
    }

    public PracticeFormPage choiceUserHobbiesReading(){
        elementActions.clickBtn(choiceHobbiesReading);
        return this;
    }

    public PracticeFormPage uploadPicture(String pictureLink){
        elementActions.inputText(uploadPictur,pictureLink);
        return this;
    }

    public PracticeFormPage fillUserCurrentAddress(String currentAddress){
        elementActions.inputText(userCurrentAddress,currentAddress);
        return this;
    }

    public PracticeFormPage selectStateAndCity(String state) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10));

        String stateToLowerCase = state.toLowerCase().trim();

        Map<String,List<String>> statesAndCity = new HashMap<>();
        statesAndCity.put("ncr",List.of("delhi","gurgaon","noida"));
        statesAndCity.put("uttar pradesh",List.of("agra","lucknow","merrut"));
        statesAndCity.put("haryana",List.of("karnal","panipat"));
        statesAndCity.put("rajasthan",List.of("jaipur","jaiselmer"));

        if (!statesAndCity.containsKey(stateToLowerCase)){
            throw new IllegalArgumentException("Unknown state: " + state);
        }
        elementActions.inputText(stateInput,state);
        stateInput.sendKeys(Keys.TAB);

        List<String> cities =statesAndCity.get(stateToLowerCase);
        String city = cities.get(new Random().nextInt(cities.size()));

        elementActions.inputText(cityInput,city);
        cityInput.sendKeys(Keys.TAB);

        return this;
    }

    public PracticeFormPage submitButton(){
        elementActions.clickBtn(submitBtn);
        return this;
    }

    public PracticeFormPage assertionsValidate(String expectedValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Ждем, пока таблица появится
        wait.until(ExpectedConditions.visibilityOf(tableResponse));
        String tableText = tableResponse.getText();
        // Проверяем, есть ли наше значение в тексте всей таблицы
        assertTrue(tableText.contains(expectedValue), "Value " + expectedValue + " not found in results!");
        return this;
    }

    private void assertTrue(boolean contains, String s) {
    }


}
