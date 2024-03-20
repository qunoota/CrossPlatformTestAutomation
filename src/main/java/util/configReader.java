package util;
import java.io.BufferedReader;
import java.util.Properties;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class configReader {
    public final Properties prop;
    public configReader() {
        BufferedReader reader;
        String propertyFilePath = "C:/Users/qunoot.ahmed/IdeaProjects/CrossPlatformAutomation/src/main/resources/config.properties";

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
        String browserName = prop.getProperty("browser");
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
}
