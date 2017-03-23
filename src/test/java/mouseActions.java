import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by katragadaa on 3/11/17.
 */
public class mouseActions {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver","/Users/katragadaa/Downloads/geckodriver");
        WebDriver driver= new FirefoxDriver();
        driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-perform-mouse-hover-in-selenium.html");
        Actions actions= new Actions(driver);
        WebElement targetButton = driver.findElement(By.xpath("//button[text()='Automation Tools']"));
        List<WebElement> links= driver.findElements(By.xpath("//div[@class='dropdown-content']//a"));
        int totalLinks = links.size();

        for (int i=0; i<totalLinks;i++){

            WebElement element = links.get(i);
            String text =element.getAttribute("innerHTML");
            System.out.println(text);

            if (text.equalsIgnoreCase("Appium")){
                element.click();
                break;
            }
        }

        Thread.sleep(6000);
        driver.quit();



       // WebElement targetoption= driver.findElement(By.xpath("//div[@class='dropdown-content']//a[text()='Selenium']"));


//  div[@class='dropdown-content']//a[text()='Selenium']

    }
}
