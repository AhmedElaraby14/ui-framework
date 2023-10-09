package Utilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
        public static void takeScreenShot(WebDriver webdriver,String fileWithPath) throws Exception{
// Create object of SimpleDateFormat class and decide the format
            DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy__HH_mm_ss");
            Date date = new Date();
            String date1= dateFormat.format(date);
            File src = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File(fileWithPath+date1+".png"));
        }
        }



