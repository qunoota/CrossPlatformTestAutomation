package com.application.tests.web;

import Base.TestBase;
import com.application.api.FakeDataUtil;
import com.application.pages.web.Register;
import com.application.pages.web.RegisterPage;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ExtentManager;

public class RegisterPageTest extends TestBase {
    String fName = FakeDataUtil.getFirstName();
    String lName = FakeDataUtil.getLastName();
    int id = FakeDataUtil.getUniqueId();
    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);
    private ExtentTest test;

    @BeforeMethod
    public void setup() {
        ExtentManager.initReports();
        logger.info("Initializing web driver and launching the browser");
        webInitialization();
        test = ExtentManager.createTest("RegisterPageTest");
        logger.info("Navigate to the registration page");
        driver.get("https://demoqa.com/register");
    }

    @Test(description = "Registration Page", priority = 1)
    public void userRegistrationTest() {
        logger.info("Executing test: userRegistrationTest");
        test.info("Executing test: User Registration Test");
       Register register = new Register.RegisterBuilder()
                .setFirstName(fName)
                .setLastName(lName)
                .setUserName(String.valueOf(id))
                .setPassword("Test@1234")
                .build();

        RegisterPage registerPage = new RegisterPage();
        registerPage.userRegister(register);
        registerPage.clickRegisterBtn();
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Closing browser");
        test.info("Closing browser");
        driver.quit();
        ExtentManager.flushReports();
    }
}
