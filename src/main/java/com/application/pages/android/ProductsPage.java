package com.application.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Base.TestBase.initializeAndroidDriver;

public class ProductsPage {
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='container header']/android.widget.TextView")
    WebElement productPageHeading;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"store item\"])[1]/android.view.ViewGroup[1]/android.widget.ImageView")
    WebElement firstStoreItemImageView;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
    WebElement backpack;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String validateProductPageHeading() {
        return productPageHeading.getText();
    }

    public String navigateToFirstStoreItem() throws InterruptedException {
        firstStoreItemImageView.click();
        Thread.sleep(5000);
        return backpack.getText();
    }
}
