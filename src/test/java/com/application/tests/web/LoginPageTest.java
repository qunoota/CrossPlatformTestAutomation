package com.application.tests.web;

import Base.TestBase;
import com.application.pages.web.LoginPage;
import com.application.pages.web.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;
import util.excelReader;
import util.TestData;

public class LoginPageTest extends TestBase {
    excelReader excReader;
    LoginPage loginPage;
    ProfilePage profilePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        webInitialization();
        loginPage = new LoginPage();
    }

    @Test(description = "Login Title", priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "DEMOQA");
    }

    @Test(description = "Login to Application", priority = 2)
    public void loginTest() {
        Dimension dimension = new Dimension(1080, 750);
        driver.manage().window().setSize(dimension);
 //       profilePage = loginPage.login("John.alan98", "Test*123");
//        excReader = new excelReader();
//        excReader.readExcelFile();
//        String email = excReader.GetCellValue(1, 0);
//        String password = excReader.GetCellValue(1, 1);
//        profilePage = loginPage.login(email, password);
        TestData testData = new TestData();
        String email = testData.getUsername();
        String password = testData.getPassword();
        profilePage = loginPage.login(email, password);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
