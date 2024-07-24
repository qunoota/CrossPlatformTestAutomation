package Base;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.configReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static configReader confReader;

    public static void webInitialization() {
        confReader = new configReader();
        prop = confReader.prop;
        String browserName = prop.getProperty("BROWSER");

//        if (browserName.equals("CHROME")) {
//            driver = new ChromeDriver();
//        }
//        else if (browserName.equals("EDGE")) {
//            driver = new EdgeDriver();
//        }
        switch (browserName.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "EDGE":
                driver = new EdgeDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demoqa.com/login");
    }

    public static WebDriver initializeAndroidDriver() {
        confReader = new configReader();
        prop = confReader.prop;
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName(confReader.getPlatformName());
            options.setAutomationName(confReader.getAutomationName());
            options.setDeviceName(confReader.getDeviceName());
            options.setApp(confReader.getAppURL());
            return new RemoteWebDriver(new URL(confReader.getLocalAppiumServerURL()), options);
        } catch (Exception exp) {
            exp.printStackTrace();
            return null;
        }
    }

    public static WebDriver initializeBrowserStack() {
        confReader = new configReader();
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability("browserName", "Safari");
        options.setCapability("platformName", "MAC");
        options.setCapability("deviceName", "iPhone 11 Pro");
        try {
            return new RemoteWebDriver(new URL(confReader.getBrowserStackURL()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}