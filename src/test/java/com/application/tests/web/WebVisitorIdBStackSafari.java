package com.application.tests.web;

import Base.TestBase;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebVisitorIdBStackSafari extends TestBase {
    private FileWriter csvWriter;
    private RemoteWebDriver driver;
    private final String[] urls = {
            "https://topcontext-401d2.web.app",
            "https://topcontext-401d2.firebaseapp.com",
            "https://anothertopcontext.web.app",
            "https://anothertopcontext.firebaseapp.com"
    };

    @BeforeMethod
    public void setup() {
        driver = (RemoteWebDriver) initializeBrowserStack();
    }

    @Test(description = "Visit Website", priority = 1)
    public void browserStackTest() throws InterruptedException {
        try {
            for (String url : urls) {
                driver.get(url);
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Get visitorId from the main window
                String mainVisitorId = (String) driver.executeScript("return window.visitorId;");
                System.out.println("Retrieved main visitorId: " + mainVisitorId);
                Thread.sleep(10000);
                // Get visitorId_iframe from the iframe context
                String iframeVisitorId = (String) driver.executeScript("return window.visitorId_iframe;");
                System.out.println("Retrieved iframe visitorId: " + iframeVisitorId);

                // Get browser name and version
                Capabilities caps = driver.getCapabilities();
                String browserName = caps.getBrowserName();
                String browserVersion = caps.getBrowserVersion();

                // Get current date and time
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
                String currentDateTime = dateFormat.format(new Date());

                // Write data to CSV file
                try {
                    File file = new File("scenario_1.csv");

                    // Check if file exists
                    if (file.exists()) {
                        csvWriter = new FileWriter(file, true);
                    } else {
                        csvWriter = new FileWriter(file);
                        // Print file header if the file is created
                        csvWriter.append("top context");
                        csvWriter.append(",");
                        csvWriter.append("iframe context");
                        csvWriter.append(",");
                        csvWriter.append("main visitorId");
                        csvWriter.append(",");
                        csvWriter.append("iframe visitorId");
                        csvWriter.append(",");
                        csvWriter.append("browser name");
                        csvWriter.append(",");
                        csvWriter.append("browser version");
                        csvWriter.append(",");
                        csvWriter.append("date and time of test");
                        csvWriter.append("\n");
                    }

                    // Append data to CSV
                    csvWriter.append(url);
                    csvWriter.append(",");
                    csvWriter.append("https://iframecontext.web.app"); // iframe context URL
                    csvWriter.append(",");
                    csvWriter.append(mainVisitorId);
                    csvWriter.append(",");
                    csvWriter.append(iframeVisitorId);
                    csvWriter.append(",");
                    csvWriter.append(browserName);
                    csvWriter.append(",");
                    csvWriter.append(browserVersion);
                    csvWriter.append(",");
                    csvWriter.append(currentDateTime);
                    csvWriter.append("\n");

                    csvWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // Close the browser after processing each URL
                driver.quit();
                // Reopen the browser for the next URL
                driver = (RemoteWebDriver) initializeBrowserStack();
            }
        } finally {
            // Close the FileWriter
            try {
                if (csvWriter != null) {
                    csvWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after all URLs have been processed
        if (driver != null) {
            driver.quit();
        }
    }
}