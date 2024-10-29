package com.application.tests.mobile;

import Base.TestBase;
import com.application.tests.web.LoginPageTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reporting.ExtentManager;
import com.aventstack.extentreports.ExtentTest;

public class iOSTest extends TestBase {
    private static final Logger logger = LogManager.getLogger(LoginPageTest.class);
    private ExtentTest test;

    @BeforeMethod
    public void setup() {
        ExtentManager.initReports();
        test = ExtentManager.createTest("iOS BrowserStack Test");

        logger.info("Initializing Browserstack Driver");
        initializeBrowserStack();
    }

    @Test(description = "Visit Website", priority = 1)
    public void browserStackTest() {
        logger.info("Visiting website on BrowserStack for iOS");

        driver = initializeBrowserStack();
        driver.get("https://demoqa.com/");

        // Log success to the report
        test.pass("Website opened successfully on BrowserStack for iOS.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
            test.info("Browser session ended");
        }
        ExtentManager.flushReports();
    }
}
