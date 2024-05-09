package com.application.tests.mobile;

import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.application.pages.android.ProductsPage;

public class AndroidTest extends TestBase {
    ProductsPage productsPage;
    @BeforeMethod
    public void setup() {
     //   initializeAndroidDriver();
        productsPage = new ProductsPage();
    }

    @Test(description ="My Demo App - Products", priority = 1)
    public void validatePageHeading()  {
        String heading = productsPage.validateProductPageHeading();
        Assert.assertEquals(heading, "Products");
    }

    @Test(description ="Navigate to the first product", priority = 2)
    public void validateFirstItem() throws InterruptedException {
        String firstItem = productsPage.navigateToFirstStoreItem();
        Assert.assertEquals(firstItem, "Sauce Labs Backpack");
    }
}
