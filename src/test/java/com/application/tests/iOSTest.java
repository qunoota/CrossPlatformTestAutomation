package com.application.tests;
import Base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iOSTest extends TestBase {
    @BeforeMethod
    public void setup() {
        initializeBrowserStack();
    }

    @Test(description = "Visit Website", priority = 1)
    public void browserStackTest() {
        driver = initializeBrowserStack();
            driver.get("https://demoqa.com/");
    }
}