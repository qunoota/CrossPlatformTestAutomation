package com.application.pages.web;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends TestBase {
    @FindBy(id="firstname")
    WebElement firstName;

    @FindBy(id="lastname")
    WebElement lastName;

    @FindBy(id="userName")
    WebElement userName;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="register")
    WebElement registerBtn;

    public RegisterPage(){
        PageFactory.initElements(driver, this);
    }

    public void userRegister(Register register){
        firstName.sendKeys(register.getFirstName());
        lastName.sendKeys(register.getLastName());
        userName.sendKeys(register.getUserName());
        password.sendKeys(register.getPassword());
    }

    public void clickRegisterBtn(){
        registerBtn.click();
    }
}
