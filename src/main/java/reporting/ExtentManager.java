package reporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentTest test;
    public static void initReports() {
        if (extent == null) { // Ensure extent is initialized only once
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Spark.html"); // Create Spark reporter

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            sparkReporter.config().setReportName("My Project Test Report");
            sparkReporter.config().setDocumentTitle("Test Results");
            sparkReporter.config().setTheme(Theme.STANDARD); // Change the theme if needed
        }
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        if (extent == null) {
            initReports(); // Initialize reports if not done
        }
        test = extent.createTest(testName);
        return test;
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush(); // Ensure extent is not null before flushing
        }
    }
}
