package Base;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.configReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static configReader confReader;
    private static final Logger logger = LogManager.getLogger(TestBase.class);

    public static void webInitialization() {
        confReader = new configReader();
        prop = confReader.prop;
        String browserName = confReader.getBrowserName();

        switch (browserName.toUpperCase()) {
            case "CHROME":
                logger.info("Browser = Chrome");
                driver = new ChromeDriver();
                break;
            case "EDGE":
                logger.info("Browser = Edge");
                driver = new EdgeDriver();
                break;
            case "FIREFOX":
                logger.info("Browser = Firefox");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://demoqa.com/login");
    }

    public static void webReservation() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://reserve-today.web.app/");
        driver.findElement(By.id("reserve-navbar")).click();
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
            logger.info("Driver initialization successful");
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
            WebDriver driver = new RemoteWebDriver(new URL(confReader.getBrowserStackURL()), options);
            return driver;
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Failed to initialize BrowserStack driver due to malformed URL", e);
        }
    }
}