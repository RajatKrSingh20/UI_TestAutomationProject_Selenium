package UtilityPackage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class CaptureScreenshot {

    TakesScreenshot takesScreenshot;

    WebDriver driver;

    File srcFile ;

    File dstFile ;

    public CaptureScreenshot(WebDriver driver){
        this.driver = driver;
    }

    public String captureScreenShot(String testCaseName){
        takesScreenshot = (TakesScreenshot)driver;
        try{
             srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
             dstFile = new File("C:\\Users\\rajat\\IdeaProjects\\UI_TestAutomationProject_Selenium\\src\\test\\Screenshot\\"+testCaseName+".png");
            FileHandler.copy(srcFile,dstFile);
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }

        return dstFile.getAbsolutePath();
    }

}
