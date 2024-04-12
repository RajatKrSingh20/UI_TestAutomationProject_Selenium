package TestCasePackage;

import PageObjectPackage.HomePage_Class;
import PageObjectPackage.LoginPage_Class;
import PageObjectPackage.YourCartPage_Class;
import UtilityPackage.CaptureScreenshot;
import UtilityPackage.ExtentListenerClass;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(ExtentListenerClass.class)
public class TestScript_03 extends BaseClass  {

    LoginPage_Class loginPageClass;
    HomePage_Class homePageClass ;

    YourCartPage_Class yourCartPageClass ;

    @Test(dataProvider = "TestData_02",description = "This test is to verify if the user is able to add items to the Shopping-Cart.")
    public void addItemsToCart_Test(String textOnLoginPage, String textOnHomePage, String urlOfLoginPage, String urlOfHomePage, String itemName, String textOnYourCartPage, String urlOfYourCartPage){

        // Configuring extent report for logging testcase related information into it at compile-time.
        configureExtentReport("addItemsToCart_Test");

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
        String expectedTextOnLoginPage = textOnLoginPage; // dataProvider_02


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

//The username has been fetched from the config.properties file.
        loginPageClass.enterUsername(username);
        test.log(Status.INFO, "The driver has entered the username into the text field meant for entering the Username");
        Reporter.log("The driver has entered the username into the text field meant for entering the Username");

//The password has been fetched from the config.properties file.
        loginPageClass.enterPassword(password);
        test.log(Status.INFO, "The driver has entered the password into the text field meant for entering the Password");
        Reporter.log("The driver has entered the password into the text field meant for entering the Password");

        loginPageClass.clickOnLoginButton();
        test.log(Status.INFO, "The driver has clicked on the Login-Button");
        Reporter.log("The driver has clicked on the Login-Button");

        driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
        test.log(Status.INFO, "driver has waited due to ImplicitWait after clicking on the Login-Button");
        Reporter.log("driver has waited due to ImplicitWait after clicking on the Login-Button");

        String actualCurrentUrl = loginPageClass.getCurrentUrl();
        String expectedCurrentUrlForHomePage = urlOfHomePage ; //dataProvider_02

        if(actualCurrentUrl.equalsIgnoreCase(expectedCurrentUrlForHomePage)){

            test.log(Status.INFO,"The driver has now reached the HomePage hence it is clear that Login was successful");
            Reporter.log("The driver has now reached the HomePage hence it is clear that Login was successful");
            Assert.assertTrue(true);
        }
        else{

            test.log(Status.INFO,"The driver has not reached to the HomePage yet hence it is clear that Login was un-successful");
            Reporter.log("The driver has not reached to the HomePage yet hence it is clear that Login was un-successful");

            String path = captureScreenshot.captureScreenShot("addItemsToCart_Test");
            test.addScreenCaptureFromPath(path);
            test.log(Status.INFO,"Screenshot of the bug has been attached to this report");
            Assert.assertTrue(false);
        }

        // Instantiating HomePage_class of PageObjectPackage
        homePageClass = new HomePage_Class(driver);

        String actualTextPresentOnHomePage = homePageClass.getTextPresentOnHomePage();
        String expectedTextPresentOnHomePage = textOnHomePage; // dataProvider_02

        if (actualTextPresentOnHomePage.equalsIgnoreCase(expectedTextPresentOnHomePage)) {

            test.log(Status.INFO,"The text present on the HomePage is as same as the Expected_text i.e. : "+actualTextPresentOnHomePage);
            Reporter.log("The text present on the HomePage is as same as the Expected_text i.e. : "+actualTextPresentOnHomePage);
            Assert.assertTrue(true);

        } else {

            test.log(Status.INFO, "The Actual_text present on the HomePage is not as same as the Expected_text,  Actual_Text is : "+actualTextPresentOnHomePage+" & the Expected_text was : "+expectedTextPresentOnHomePage);
            Reporter.log("The Actual_text present on the HomePage is not as same as the Expected_text,  Actual_Text is : "+actualTextPresentOnHomePage+" & the Expected_text was : "+expectedTextPresentOnHomePage);
            Assert.assertTrue(false);
        }

        //Getting the List of all the items available to buy on this page are :
        System.out.println(homePageClass.getListOfItems());
        test.log(Status.INFO,"List of all the items available on the HomePage to buy are : "+homePageClass.getListOfItems());
        Reporter.log("List of all the items available on the HomePage to buy are : "+homePageClass.getListOfItems());

        String actualNameOfTheItem   = homePageClass.getNameOfTheItem();
       String expectedNameOfTheItem = itemName; //dataProvider_02


        if(actualNameOfTheItem.equalsIgnoreCase(expectedNameOfTheItem)){

            test.log(Status.INFO,"The actual_name of the item to be buy is same as the expected_name i.e. "+actualNameOfTheItem);
            Reporter.log("The actual_name of the item to be buy is same as the expected_name i.e. "+actualNameOfTheItem);

            homePageClass.clickOnAddToCart();
            test.log(Status.INFO,"driver clicked on the addToCart button.");
            Reporter.log("driver clicked on the addToCart button.");
        }
        else{

            test.log(Status.INFO,"The actual_name of the item to be buy is not as same as the expected_name i.e. Actual_Name is : "+actualNameOfTheItem+" whereas the Expected_Name was "+expectedNameOfTheItem);
            Reporter.log("The actual_name of the item to be buy is not as same as the expected_name i.e. Actual_Name is : "+actualNameOfTheItem+" whereas the Expected_Name was "+expectedNameOfTheItem);
            Assert.assertTrue(false);
        }

//Instantiating YourCartPage_Class of PageObjectPackage
         yourCartPageClass = new YourCartPage_Class(driver);

        yourCartPageClass.clickOnShoppingCartIcon();

        driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
        test.log(Status.INFO, "driver has waited due to ImplicitWait after clicking on the Shopping cart icon");
        Reporter.log("driver has waited due to ImplicitWait after clicking on the Shopping cart icon");

       // Validating the Actual url of the YOurCart_page with the expected Url.
        String actualUrlOfYourCartPage = loginPageClass.getCurrentUrl();
        String expectedUrlOfYourCartPage = urlOfYourCartPage ; //dataProvider_02

        if(actualUrlOfYourCartPage.equalsIgnoreCase(expectedUrlOfYourCartPage)){

            test.log(Status.INFO,"The driver has now reached to the YourCart page after clicking on the add_To_Cart_Icon.");
            Reporter.log("The driver has now reached to the YourCart page after clicking on the add_To_Cart_Icon.");
        }
        else{
            test.log(Status.INFO,"The driver has not reached to the YourCart page yet after clicking on the add_To_Cart_Icon hence something went wrong.");
            Reporter.log("The driver has not reached to the YourCart page yet after clicking on the add_To_Cart_Icon hence something went wrong.");
            Assert.assertTrue(false);
        }

//Validating the Actual text present on the YourCart_page with the expected text.
        String actualText_PresentOn_YourCartPage = yourCartPageClass.getTextOnYourCartPage();
        String expectedText_PresentOn_YourCartPage = textOnYourCartPage ; //dataProvider_02

        if(actualText_PresentOn_YourCartPage.equalsIgnoreCase(expectedText_PresentOn_YourCartPage)){

            test.log(Status.INFO,"The text present on the YourCart page is exactly same as the Expected Text that should be present i.e : "+actualText_PresentOn_YourCartPage);
            Reporter.log("The text present on the YourCart page is exactly same as the Expected Text that should be present i.e : "+actualText_PresentOn_YourCartPage);
        }
        else{

            test.log(Status.INFO,"The text present on the YourCart page is not same as the Expected Text that should be present i.e Actual_Text : "+actualText_PresentOn_YourCartPage+" whereas the Expected_Text was : "+expectedText_PresentOn_YourCartPage);
            Reporter.log("The text present on the YourCart page is not same as the Expected Text that should be present i.e Actual_Text : "+actualText_PresentOn_YourCartPage+" whereas the Expected_Text was : "+expectedText_PresentOn_YourCartPage);
            Assert.assertTrue(false);
        }

        //Getting the name of the item being added in the Shopping-Cart
        String actualNameOfTheItemInShoppingCart = yourCartPageClass.getNameOfTheItemOnYourCartPage();
        String expectedNameOfTheItemInShoppingCart = itemName ; //dataProvider_02

        if(actualNameOfTheItemInShoppingCart.equalsIgnoreCase(expectedNameOfTheItemInShoppingCart)){

            test.log(Status.INFO,"The item that was selected is successfully added to the Shopping-Cart : "+actualNameOfTheItemInShoppingCart);
            Reporter.log("The item that was selected is successfully added to the Shopping-Cart : "+actualNameOfTheItemInShoppingCart);
            test.log(Status.PASS,"The TestCase : addItemsToCart_Test has been passed successfully");
            Assert.assertTrue(true);
        }

        else{

            test.log(Status.INFO,"The item that was selected is not present in the Shopping-Cart hence something went wrong.");
            Reporter.log("The item that was selected is not present in the Shopping-Cart hence something went wrong.");
            test.log(Status.FAIL,"The TestCase : addItemsToCart_Test has been failed !!");

            String pathOfScreenShot = captureScreenshot.captureScreenShot("addItemsToCart_Test");

            test.addScreenCaptureFromPath(pathOfScreenShot);
            test.log(Status.INFO,"The Screenshot of the bug has been attached to this report.");
            Assert.assertTrue(false);

        }



        //Navigating to MenuBar in order to find the Logout Button.
        homePageClass.clickOnMenuBar();
        test.log(Status.INFO, "The driver has navigated to the Menu_Bar and clicked over it");
        Reporter.log("The driver has navigated to the Menu_Bar and clicked over it");

        homePageClass.clickOnLogout();
        test.log(Status.INFO, "The driver has clicked on the Logout-Button.");
        Reporter.log("The driver has clicked on the Logout-Button.");

        driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
        test.log(Status.INFO, "driver has waited due to ImplicitWait after clicking on the Logout-Button");
        Reporter.log("driver has waited due to ImplicitWait after clicking on the Logout-Button");


        String actualCurrentUrl_LoginPage = loginPageClass.getCurrentUrl();
        String expectedCurrentUrl_LoginPage = urlOfLoginPage ; //dataProvider_02

        if(actualCurrentUrl_LoginPage.equalsIgnoreCase(expectedCurrentUrl_LoginPage)){

            test.log(Status.INFO,"The driver has now reached back to the LoginPage, hence it is clear that the Logout was successful");
            Reporter.log("The driver has now reached back to the LoginPage, hence it is clear that the Logout was successful");
            Assert.assertTrue(true);
        }
        else{

            test.log(Status.INFO,"The driver has not reached to the LoginPage yet hence it is clear that the Logout was un-successful");
            Reporter.log("The driver has not reached to the LoginPage yet hence it is clear that the Logout was un-successful");
            Assert.assertTrue(false);
        }
    }
}




