package com.application.pages.web;
import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory
    @FindBy(id="userName")
    WebElement username;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="login")
    WebElement loginBtn;

    //Initializing page objects
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public ProfilePage login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new ProfilePage();
    }
}
