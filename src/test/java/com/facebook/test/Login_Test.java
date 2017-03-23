package com.facebook.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by katragadaa on 3/11/17.
 */
public class Login_Test {
    public WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setup(){
        System.setProperty("webdriver.gecko.driver","/Users/katragadaa/Downloads/geckodriver");
        this.driver= new FirefoxDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
       this.driver.quit();

    }
    @Test(groups = {"p1","pageLoads"})
    public void loadPage(){
        System.setProperty("webdriver.gecko.driver","/Users/katragadaa/Downloads/geckodriver");
        driver.get("https://www.facebook.com");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
       Assert.assertEquals(pageTitle,"Facebook - Log In or Sign Up");
    }

    @Test(groups = {"p2","field"},dependsOnMethods = "loadPage")
    public void filloutEmail(){
        String FirstName = "Prashanth";
        String LastName= "Katragadda";
        WebElement username= driver.findElement(By.id("email"));
        username.sendKeys(FirstName);
        WebElement password= driver.findElement(By.id("pass"));
        password.sendKeys(LastName);


    }





}
