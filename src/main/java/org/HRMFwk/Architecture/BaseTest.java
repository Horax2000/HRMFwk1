package org.HRMFwk.Architecture;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.LocalDateTime;

public class BaseTest {
    protected WebDriver driver;

    protected static ThreadLocal<ExtentTest> testLogger = new ThreadLocal<>();

    public  static ExtentReports reports;

    @BeforeTest
    public void setupTest(@Optional String browserName, ITestResult iTestResult) {
        String reportPath = System.getProperty("user.dir") + "/reports/extentReport.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, YYYY, hh:mm a `(`zzzz`)`");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("HRM Automation Results");
        sparkReporter.config().setDocumentTitle("Test Results");
        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        reports.setSystemInfo("Tester is :", "USER");
    }

    @AfterTest
    public void flushReport() {
        reports.flush();
    }

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.createDriver("chromium"); // Change based on your needs
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {

        if(iTestResult.isSuccess()){
            testLogger.get().log(Status.PASS, MarkupHelper.createLabel(iTestResult.getMethod().getMethodName()+" is successful.", ExtentColor.GREEN));

        } else {
            String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

            testLogger.get().log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getMethod().getMethodName()+" is failed.", ExtentColor.RED));
            testLogger.get().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
        }

        testLogger.get().log(Status.INFO, "Driver ended at " + LocalDateTime.now());


        if (driver != null) {
            driver.quit();
        }
    }
}