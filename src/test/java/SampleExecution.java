    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.support.ui.Select;

    /**
     * Created by katragadaa on 3/11/17.
     */
    public class SampleExecution {
        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.gecko.driver","/Users/katragadaa/Downloads/geckodriver");

            WebDriver driver = new FirefoxDriver();
             String MobileNumber = "8186775055";
            String FirstName = "Prashanth";
            String LastName= "Katragadda";
            String AccPassword= "Dudecool";
            driver.get("https://www.facebook.com");
            //Object Identifiers
            WebElement username= driver.findElement(By.id("email"));
            WebElement password= driver.findElement(By.id("pass"));
            WebElement login= driver.findElement(By.id("loginbutton"));

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


            // Entering UserName and Password
            username.sendKeys("Saketh Kancharla");
            password.sendKeys("prashanth");

            // Creating a new Account in FaceBook
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

        }



    }
