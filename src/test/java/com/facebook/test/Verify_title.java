package com.facebook.test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by katragadaa on 3/12/17.
 */
public class Verify_title {
    ExtentReports extent;
    ExtentTest test;
    @BeforeTest
    public void startReport()
    {
        extent = new ExtentReports(System.getProperty("user.dir") +"/report/new.html", true);
        extent
                .addSystemInfo("Host Name", "Prashanth")
                .addSystemInfo("Environment", "DEV")
                .addSystemInfo("User Name", "prashanth bank of america");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
    }
    @Test
    public void demoReportPass()
    {
        test=extent.startTest("demoReportPass");
        Assert.assertTrue(true);
        test.log(LogStatus.PASS, "Assert Pass as condition is True");
    }
    @Test
    public void demoReportFail()
    {
        test=extent.startTest("demoReportFail");
        Assert.assertTrue(false);
        test.log(LogStatus.FAIL, "Assert Fail as condition is False");
    }

    @AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus()== ITestResult.FAILURE)
        {
            test.log(LogStatus.FAIL, result.getThrowable());

        }
        extent.endTest(test);
    }
    @AfterTest
    public void endreport()
    {
        extent.flush();
        extent.close();
    }




}