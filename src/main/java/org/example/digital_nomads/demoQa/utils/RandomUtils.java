package org.example.digital_nomads.demoQa.utils;

import com.github.javafaker.Faker;
import org.example.digital_nomads.demoQa.models.AddEmployee;
import org.example.digital_nomads.demoQa.models.UserPracticeForm;
import org.example.digital_nomads.demoQa.models.UserTextBox;

public class RandomUtils {

    public static Faker faker = new Faker();

    public static UserTextBox generateTexBoxUser(){
        UserTextBox userTextBox = new UserTextBox();
        userTextBox.setName(faker.name().firstName());
        userTextBox.setEmail(faker.internet().emailAddress());
        userTextBox.setCurrentAddress(faker.address().streetAddress());
        userTextBox.setPermanentAddress(faker.address().secondaryAddress());
        return userTextBox;
    }

    public static UserPracticeForm generatePracticeForm(){
        UserPracticeForm userPracticeForm = new UserPracticeForm();
        userPracticeForm.setFirstName(faker.name().firstName());
        userPracticeForm.setLastName(faker.name().lastName());
        userPracticeForm.setEmail(faker.internet().emailAddress());
        userPracticeForm.setMobileNumber(faker.phoneNumber().phoneNumber());
        userPracticeForm.setCurrentAddress(faker.address().streetAddress());
        return userPracticeForm;
    }

    public static AddEmployee generateWebTableEmployee() {
        AddEmployee addEmployee = new AddEmployee();
        addEmployee.setLastName(faker.name().firstName());
        addEmployee.setLastName(faker.name().lastName());
        addEmployee.setEmail(faker.internet().emailAddress());
        addEmployee.setAge(faker.number().numberBetween(18, 45));
        addEmployee.setSalary(faker.number().numberBetween(1000, 3500));
        addEmployee.setDepartment(faker.company().profession());
        return addEmployee;
    }

}
