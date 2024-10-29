package com.application.tests.web;

import Base.TestBase;
import com.application.pages.web.LoginPage;
import com.application.pages.web.ProfilePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.ExtentManager;
import util.TestData;
import com.aventstack.extentreports.ExtentTest;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    ProfilePage profilePage;
    private static final Logger logger = LogManager.getLogger(LoginPageTest.class); // Initialize the Log4j logger
    private ExtentTest test; // Declare ExtentTest instance

    @BeforeMethod
    public void setup() {
        ExtentManager.initReports(); // Initialize the reports
        test = ExtentManager.createTest("LoginPageTest"); // Create test instance for ExtentReports
        logger.info("Initializing web driver and launching the browser");
        webInitialization();
        loginPage = new LoginPage();
    }

    @Test(description = "Login Title", priority = 1)
    public void loginPageTitleTest() {
        logger.info("Executing test: loginPageTitleTest");
        test.info("Executing test: loginPageTitleTest"); // Log to ExtentReport

        String title = loginPage.validateLoginPageTitle();
        logger.info("Login page title: " + title);
        test.info("Login page title: " + title);

        Assert.assertEquals(title, "DEMOQA");
        logger.info("Title validation passed");
        test.pass("Title validation passed"); // Mark as passed in ExtentReport
    }

    @Test(description = "Login to Application", priority = 2)
    public void loginTest() {
        logger.info("Executing test: loginTest");
        test.info("Executing test: loginTest");

        Dimension dimension = new Dimension(1080, 750);
        driver.manage().window().setSize(dimension);
        logger.info("Browser window size set to: " + dimension);
        test.info("Browser window size set to: " + dimension);

        TestData testData = new TestData();
        String email = testData.getUsername();
        String password = testData.getPassword();
        logger.info("Logging in with email: " + email);
        test.info("Logging in with email: " + email);

        profilePage = loginPage.login(email, password);
        logger.info("Login successful, navigated to profile page");
        test.pass("Login successful, navigated to profile page");
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Closing browser");
        test.info("Closing browser");
        driver.quit();
        ExtentManager.flushReports(); // Flush reports after tests
    }
}
