package lib;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by katragadaa on 3/15/17.
 */
public class Utility {
    public static String CaptureScreen(WebDriver driver, String ScreenShotName) throws IOException {

        TakesScreenshot takesScreenshot= (TakesScreenshot)driver;
        File Source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String dest= System.getProperty("user.dir")+"/screens/"+ScreenShotName+".png";
        File Destination= new File(dest);
        FileUtils.copyFile(Source,Destination);
        return dest;

    }



}
