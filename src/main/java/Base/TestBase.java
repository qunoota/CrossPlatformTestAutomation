package Base;
import com.application.config.configFactory;
import converters.BrowserStackConfigFactory;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.configReader;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static configReader confReader;

    public static void webInitialization() {
        confReader = new configReader();
        prop = confReader.prop;
        String browserName = prop.getProperty("browser");
        if (browserName.equals("CHROME")) {
            driver = new ChromeDriver();
        }
        else if (browserName.equals("EDGE")) {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demoqa.com/login");
    }

    public static WebDriver initializeAndroidDriver() {
        try {
            confReader = new configReader();
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName(confReader.getPlatformName());
            options.setAutomationName(confReader.getAutomationName());
            options.setDeviceName(confReader.getDeviceName());
            options.setApp(confReader.getAppURL());
            return new RemoteWebDriver(configFactory.getConfig().localAppiumServerURL(), options);
        } catch (Exception exp) {
            exp.printStackTrace();
            return null;
        }
    }

    public static WebDriver initializeBrowserStack() {
        System.out.println("Browserstack URL: " + BrowserStackConfigFactory.getConfig().browserStackURL());
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability("browserName", "Safari");
        options.setCapability("platformName", "MAC");
        options.setCapability("deviceName", "iPhone 11 Pro");
        return new RemoteWebDriver(BrowserStackConfigFactory.getConfig().browserStackURL(), options);
    }
}

