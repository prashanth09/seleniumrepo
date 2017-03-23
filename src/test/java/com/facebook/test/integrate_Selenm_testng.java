package com.facebook.test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by katragadaa on 3/15/17.
 */
public class integrate_Selenm_testng {


    ExtentReports extentReports;
    ExtentTest extentTest;
    WebDriver driver;
    String MobileNumber ;
    String FirstName ;
    String LastName;
    String AccPassword;
    String user ;
    String pass ;





    @Test
    public void login_facebook(){
       extentReports= new ExtentReports(System.getProperty("user.dir") +"/report/Login_Facebook.html", true);
        extentTest =extentReports.startTest("Log into Facebook");
        user = "prashanth";
        pass = "1234";
        System.setProperty("webdriver.gecko.driver", "/Users/katragadaa/Downloads/geckodriver");
        driver = new FirefoxDriver();
        // Opens WebPage
        driver.get("https://www.facebook.com/");
        extentTest.log(LogStatus.INFO,"Browser Launched");
        WebElement usernameField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("pass"));

        extentTest.log(LogStatus.INFO,"UserName and password Entered");
        extentTest.addScreenCapture(System.getProperty("user.dir") +"/report/screens/");
        WebElement login = driver.findElement(By.id("loginbutton"));

        usernameField.sendKeys(user);
        passwordField.sendKeys(pass);
        login.click();
        extentTest.log(LogStatus.PASS,"clicked on login button");

        extentReports.endTest(extentTest);
        extentReports.flush();

    }
    @Test
    public void createAccount() throws InterruptedException {

        extentReports= new ExtentReports(System.getProperty("user.dir") +"/report/CreateAccount in Facebook.html", true);
        extentTest =extentReports.startTest("Create Account Facebook");



        MobileNumber = "8186775055";
        FirstName = "Prashanth";
        LastName= "Katragadda";
        AccPassword= "Dudecool";

        System.setProperty("webdriver.gecko.driver", "/Users/katragadaa/Downloads/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        extentTest.log(LogStatus.INFO,"Browser Launched");
        WebElement monthlist= driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthlist);

        WebElement date= driver.findElement(By.id("day"));
        Select selectDate=  new Select(date);

        WebElement year= driver.findElement(By.id("year"));
        Select selectYear= new Select(year);


        WebElement Malegender = driver.findElement(By.id("u_0_l"));
        WebElement firstname= driver.findElement(By.id("u_0_1"));

        WebElement lastName= driver.findElement(By.id("u_0_3"));
        WebElement mobile = driver.findElement(By.id("u_0_6"));
        WebElement reEnterMobile= driver.findElement(By.id("u_0_9"));
        WebElement AccountPassword = driver.findElement(By.id("u_0_d"));
        firstname.sendKeys(FirstName);
        lastName.sendKeys(LastName);
        mobile.sendKeys(MobileNumber);
        reEnterMobile.sendKeys(MobileNumber);
        AccountPassword.sendKeys(AccPassword);
        Malegender.click();
        selectMonth.selectByIndex(3);
        selectDate.selectByIndex(5);
        selectYear.selectByValue("1991");
        Thread.sleep(5000);
        driver.quit();
        extentTest.log(LogStatus.PASS,"New Account info Entered");
        extentReports.endTest(extentTest);
        extentReports.flush();



    }

    @AfterMethod
    public void tearBrowser(){
        driver.quit();

    }





}
