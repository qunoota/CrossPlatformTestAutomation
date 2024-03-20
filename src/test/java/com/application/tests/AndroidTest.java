package com.application.tests;
import Base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AndroidTest extends TestBase {
    @BeforeMethod
    public void setup()  {
        initializeAndroidDriver();
    }

    @Test(description ="Sauce Labs page", priority = 1)
    public void loginTest()  {
    }

}
