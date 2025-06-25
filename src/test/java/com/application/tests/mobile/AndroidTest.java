package com.application.tests.mobile;

import Base.TestBase;
import com.application.pages.android.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reporting.ExtentManager;
import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;

public class AndroidTest extends TestBase {
    ProductsPage productsPage;
    private static final Logger logger = LogManager.getLogger(AndroidTest.class);
    private ExtentTest test; // Declare ExtentTest instance

    @BeforeMethod
    public void setup() {
        test = ExtentManager.createTest("AndroidTest");
        logger.info("Initializing Android Driver");
        driver = initializeAndroidDriver();
        if (driver == null) {
            logger.error("Driver initialization failed");
            test.fail("Driver initialization failed"); // Log failure in ExtentReport
            throw new RuntimeException("Driver initialization failed");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("Pass the initialized driver to the ProductsPage constructor");
        productsPage = new ProductsPage(driver);
    }

    @Test(description = "My Demo App - Products", priority = 1)
    public void validatePageHeading() {
        logger.info("Validating product page heading");
        test.info("Validating product page heading");

        String heading = productsPage.validateProductPageHeading();
        Assert.assertEquals(heading, "Products");
        logger.info("Heading validation passed");
        test.pass("Heading validation passed");
    }

    @Test(description = "Navigate to the first product", priority = 2)
    public void validateFirstItem() throws InterruptedException {
        logger.info("Navigating to the first product on the page");
        test.info("Navigating to the first product on the page");

        String firstItem = productsPage.navigateToFirstStoreItem();
        Assert.assertEquals(firstItem, "Sauce Labs Backpack");
        logger.info("Item validation passed");
        test.pass("Item validation passed");
    }
}
