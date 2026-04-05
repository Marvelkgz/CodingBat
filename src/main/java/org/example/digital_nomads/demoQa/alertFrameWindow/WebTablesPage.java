package org.example.digital_nomads.demoQa.alertFrameWindow;

import org.example.digital_nomads.demoQa.models.AddEmployee;
import org.example.digital_nomads.demoQa.models.Employee;
import org.example.digital_nomads.demoQa.pages.BasePage;
import org.example.digital_nomads.demoQa.utils.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WebTablesPage extends BasePage {

    @FindBy(css = ".rt-tr-group")
    private List<WebElement> rowsList;

    @FindBy(css = "button[id='addNewRecordButton']")
    private WebElement addNewEmployee;

    @FindBy(css = "input[id='firstName']")
    private WebElement writeFirstName;

    @FindBy(css = "button[id='submit']")
    private WebElement submitAddEmployee;

    public WebTablesPage addNewEmployee() {
        elementActions.clickBtn(addNewEmployee);
        AddEmployee addEmployee = RandomUtils.generateWebTableEmployee();
        elementActions.clickBtn(submitAddEmployee);
        return this;
    }
    //нужно добавить метод чтобы добавить нового сотрудника
    //проверка если пользователь есть выдать ошибку
    //создать метод для обнавлении существуюшего сотрудника
    //метод удалить сотрудника

    public ArrayList<Employee> getEmployeeFromTable() {
        ArrayList<Employee> employees = new ArrayList<>();
        for (WebElement row : rowsList) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));

            String firstName = cells.getFirst().getText();
            String lastName = cells.get(1).getText();
            String ageTxt = cells.get(2).getText().replaceAll("[^0-9]", "");//replaceAll()
            String email = cells.get(3).getText();
            String salaryTxt = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageTxt.isEmpty() || email.isEmpty()
                    || salaryTxt.isEmpty() || department.isEmpty()) {
                continue;
            }

            int age = Integer.parseInt(ageTxt.trim());
            int salary = Integer.parseInt(salaryTxt.trim());

            employees.add(new Employee(firstName, lastName, age, email, salary, department));
        }
        return employees;
    }
}
