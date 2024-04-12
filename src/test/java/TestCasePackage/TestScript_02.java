package TestCasePackage;

import PageObjectPackage.HomePage_Class;
import PageObjectPackage.LoginPage_Class;
import UtilityPackage.CaptureScreenshot;
import UtilityPackage.ExtentListenerClass;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(ExtentListenerClass.class)
public class TestScript_02 extends BaseClass{

    LoginPage_Class loginPageClass;
    HomePage_Class homePageClass ;

    @Test(dataProvider = "TestData_01",description = "This test is to verify if the user is able to login with Invalid-loginCredentials ")
    public void loginTest_With_Invalid_LoginCredentials(String textOnLoginPage, String textOnHomePage, String urlOfLoginPage, String urlOfHomePage){

        // Configuring extent report for logging testcase related information into it at compile-time.
        configureExtentReport("loginTest_With_Invalid_LoginCredentials");

        // Instantiating CaptureScreenshot class for taking Screenshots when required in this programme.
        CaptureScreenshot captureScreenshot = new CaptureScreenshot(driver);

        //Launched the website using the url
        driver.get(url);
        test.log(Status.INFO, "The driver has launched the website using url : " + url);
        Reporter.log("The driver has launched the website using url : " + url);

        driver.manage().window().maximize();

        //The time duration for ImplicitWait has been fetched from the config.properties file.
        driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);


        // Instantiating LoginPage_class of PageObjectPackage
        loginPageClass = new LoginPage_Class(driver);

        String actualTextOnLoginPage = loginPageClass.getTextOnLoginPage();
        String expectedTextOnLoginPage = textOnLoginPage; // dataProvider


        if(actualTextOnLoginPage.equalsIgnoreCase(expectedTextOnLoginPage)) {

            test.log(Status.INFO,"The text present on the LoginPage is as same as the expected_text : "+actualTextOnLoginPage);
            Reporter.log("The text present on the LoginPage is as same as the expected_text : "+actualTextOnLoginPage);
            Assert.assertTrue(true);
        }

        else{
            test.log(Status.INFO, "The actual_text present on the loginPage is not as same as the expected_text,  Actual_Text : "+actualTextOnLoginPage+" & the Expected_text : "+expectedTextOnLoginPage);
            Reporter.log("The actual_text present on the loginPage is not as same as the expected_text,  Actual_Text : "+actualTextOnLoginPage+" & the Expected_text : "+expectedTextOnLoginPage);
            Assert.assertTrue(false);
        }

//Here we will enter the wrong username.
        loginPageClass.enterUsername(username+"123");
        test.log(Status.INFO, "The driver has entered a wrong username into the text field meant for entering the Username");
        Reporter.log("The driver has entered a wrong username into the text field meant for entering the Username");

//Here we will enter the wrong password.
        loginPageClass.enterPassword(password+"123");
        test.log(Status.INFO, "The driver has entered a wrong password into the text field meant for entering the Password");
        Reporter.log("The driver has entered a wrong password into the text field meant for entering the Password");

        loginPageClass.clickOnLoginButton();
        test.log(Status.INFO, "The driver has clicked on the Login-Button");
        Reporter.log("The driver has clicked on the Login-Button");

        driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
        test.log(Status.INFO, "driver has waited due to ImplicitWait after clicking on the Login-Button");
        Reporter.log("driver has waited due to ImplicitWait after clicking on the Login-Button");

        String actualCurrentUrl = loginPageClass.getCurrentUrl();
        String expectedCurrentUrlForHomePage = urlOfHomePage ; //dataProvider

        if(actualCurrentUrl.equalsIgnoreCase(expectedCurrentUrlForHomePage)){

            test.log(Status.INFO,"The driver has now reached the HomePage hence it is clear that Login was successful with invalid login credentials");
            Reporter.log("The driver has now reached the HomePage hence it is clear that Login was successful with invalid login credentials");
            test.log(Status.PASS,"The Test Case : loginTest_With_Invalid_LoginCredentials has been passed");
            Assert.assertTrue(true);
        }
        else{

            test.log(Status.INFO,"The driver has not reached to the HomePage yet hence it is clear that Login was un-successful with invalid login credentials");
            Reporter.log("The driver has not reached to the HomePage yet hence it is clear that Login was un-successful with invalid login credentials");
            test.log(Status.FAIL,"The Test Case : loginTest_With_Invalid_LoginCredentials has been failed");
            String path = captureScreenshot.captureScreenShot("loginTest_With_Invalid_LoginCredentials");
            test.addScreenCaptureFromPath(path);
            test.log(Status.INFO,"Screenshot of the bug has been attached to this report");
            Assert.assertTrue(false);
        }


    }





}
