package TestCasePackage;

import UtilityPackage.ReadConfigFile;
import UtilityPackage.ReadExcelFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class BaseClass {

// This class will act as Parent Class for all the TestScript classes.
// This class will contain all the commonly used functions and Instance variables which will be used in the respective Child classes a.k.a  TestScript classes.
    ReadConfigFile readConfigFile = new ReadConfigFile();
    ReadExcelFile readExcelFile ;
    WebDriver driver;

    ExtentSparkReporter extentSparkReporter;
    ExtentReports reports;
    ExtentTest test;

    String browser = readConfigFile.getValueFromConfigFile("browser");
    long implicitWaitTime = Long.parseLong(readConfigFile.getValueFromConfigFile("implicitWaitTime"));
    long explicitWaitTime = Long.parseLong(readConfigFile.getValueFromConfigFile("explicitWaitTime"));

    String url = readConfigFile.getValueFromConfigFile("url");
    String username = readConfigFile.getValueFromConfigFile("username");
    String password = readConfigFile.getValueFromConfigFile("password");


    @BeforeClass
    public void setup(){

        //Cross-Browser Testing
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            System.out.println("Launched ChromeBrowser");
        }
        if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            System.out.println("Launched Firefox_Browser");
        }
        if(browser.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
            System.out.println("Launched Safari_Browser");
        }
        if(browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
            System.out.println("Launched MSEdge_Browser");
        }

    }

    @DataProvider(name="TestData_01")
    public Object[][] dataProviders(){

        readExcelFile = new ReadExcelFile("TestData_01");
        Object[][] data_01 = readExcelFile.getExcelData(0);

        return data_01 ;
    }

    @DataProvider(name="TestData_02")
    public Object[][] dataProviders_02(){

        readExcelFile = new ReadExcelFile("TestData_02");
        Object[][] data_02 = readExcelFile.getExcelData(0);

        return data_02 ;
    }

    @DataProvider(name="TestData_03")
    public Object[][] dataProviders_03(){

        readExcelFile = new ReadExcelFile("TestData_03");
        Object[][] data_03 = readExcelFile.getExcelData(0);

        return data_03 ;
    }




    public void configureExtentReport(String testCaseName){

        extentSparkReporter = new ExtentSparkReporter("C:\\Users\\rajat\\IdeaProjects\\UI_TestAutomationProject_Selenium\\src\\test\\ExtentReport\\"+testCaseName+".html");
        reports = new ExtentReports();
        reports.attachReporter(extentSparkReporter);
        test = reports.createTest(testCaseName);
    }

    @AfterClass
    public void tearDown() {

        reports.flush();
        driver.close();
        driver.quit();


    }









}
