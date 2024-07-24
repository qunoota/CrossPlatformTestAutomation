package util;

import java.io.*;
import java.util.Properties;

public class configReader {
    public final Properties prop;

    public configReader() {
        BufferedReader reader;
        // Current working directory
        String currentDir = System.getProperty("user.dir");
        String relativePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config.properties";
        String fullPath = currentDir + File.separator + relativePath;

        // Full path of property file
        File propertyFilePath = new File(fullPath);

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            prop = new Properties();
            try {
                prop.load(reader);
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBrowserName() {
        String browserName = prop.getProperty("BROWSER");
        if (browserName != null)
            return browserName;
        else throw new RuntimeException("Browser name not found");
    }

    public String getPlatformName() {
        String platformName = prop.getProperty("PLATFORM_NAME");
        if (platformName != null)
            return platformName;
        else throw new RuntimeException("Platform name not found");
    }

    public String getAutomationName() {
        String automationName = prop.getProperty("AUTOMATION_NAME");
        if (automationName != null)
            return automationName;
        else throw new RuntimeException("Automation name not found");
    }

    public String getDeviceName() {
        String deviceName = prop.getProperty("DEVICE_NAME");
        if (deviceName != null)
            return deviceName;
        else throw new RuntimeException("Device name not found");
    }

    public String getAppURL() {
        String appURL = prop.getProperty("app");
        if (appURL != null)
            return appURL;
        else throw new RuntimeException("App URL not found");
    }

    public String getExcelPath() {
        String excelPath = prop.getProperty("EXCEL_PATH");
        if (excelPath != null)
            return excelPath;
        else throw new RuntimeException("Excel path not found");
    }

    public String getTestDataPath() {
        String excelPath = prop.getProperty("TEST_DATA_JSON");
        if (excelPath != null)
            return excelPath;
        else throw new RuntimeException("Test data json file not found");
    }

    public String getBrowserStackURL() {
        String bsURL = prop.getProperty("BROWSERSTACK_URL");
        if (bsURL != null)
            return bsURL;
        else throw new RuntimeException("Browserstack URL not found");
    }

    public String getLocalAppiumServerURL() {
        String appiumURL = prop.getProperty("LOCAL_APPIUM_SERVER_URL");
        if (appiumURL != null)
            return appiumURL;
        else throw new RuntimeException("Appium Server URL not found");
    }
}
