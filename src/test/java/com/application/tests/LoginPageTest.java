package com.application.tests;
import Base.TestBase;
import com.application.pages.LoginPage;
import com.application.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;

public class LoginPageTest extends TestBase {
LoginPage loginPage;
ProfilePage profilePage;
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        webInitialization();
        loginPage = new LoginPage();
    }

    @Test(description ="Login Title", priority = 1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "DEMOQA");
    }

    @Test(description ="Login to Application", priority = 2)
    public void loginTest(){
        Dimension dimension = new Dimension(800, 600);
        driver.manage().window().setSize(dimension);
        profilePage = loginPage.login("John.alan98", "Test*123");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
