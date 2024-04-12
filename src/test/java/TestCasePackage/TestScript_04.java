package TestCasePackage;


import PageObjectPackage.*;
import UtilityPackage.CaptureScreenshot;
import UtilityPackage.ExtentListenerClass;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(ExtentListenerClass.class)
public class TestScript_04 extends BaseClass {

    LoginPage_Class loginPageClass;
    HomePage_Class homePageClass;
    YourCartPage_Class yourCartPageClass;
    YourInformationPage_Class yourInformationPageClass;
    Checkout_Overview_PageClass checkoutOverviewPageClass;
    CheckoutCompletePage checkoutCompletePage;


    @Test(dataProvider = "TestData_03", description = "This test is to verify if the user is able to place the order for item/items after adding them to shopping cart.")
    public void placeOrderTest(String textOnLoginPage, String textOnHomePage, String urlOfLoginPage, String urlOfHomePage, String itemName, String textOnYourCartPage, String urlOfYourCartPage, String urlOfYourInformationPage, String urlOfCheckoutOverviewPage, String urlOfCheckoutCompletePage, String textOnYourInformationPage, String textOnCheckoutOverviewPage, String textOnCheckoutCompletePage) {

        // Configuring extent report for logging testcase related information into it at compile-time.
        configureExtentReport("placeOrderTest");

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
        String expectedTextOnLoginPage = textOnLoginPage; // dataProvider_03


        if (actualTextOnLoginPage.equalsIgnoreCase(expectedTextOnLoginPage)) {

            test.log(Status.INFO, "The text present on the LoginPage is as same as the expected_text : " + actualTextOnLoginPage);
            Reporter.log("The text present on the LoginPage is as same as the expected_text : " + actualTextOnLoginPage);
            Assert.assertTrue(true);
        } else {
            test.log(Status.INFO, "The actual_text present on the loginPage is not as same as the expected_text,  Actual_Text : " + actualTextOnLoginPage + " & the Expected_text : " + expectedTextOnLoginPage);
            Reporter.log("The actual_text present on the loginPage is not as same as the expected_text,  Actual_Text : " + actualTextOnLoginPage + " & the Expected_text : " + expectedTextOnLoginPage);
            String pathOfScreenShot_07 = captureScreenshot.captureScreenShot("placeOrderTest");

            test.addScreenCaptureFromPath(pathOfScreenShot_07);
            test.log(Status.INFO, "The Screenshot of the bug has been attached to this report.");
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
        String expectedCurrentUrlForHomePage = urlOfHomePage; //dataProvider_03

        if (actualCurrentUrl.equalsIgnoreCase(expectedCurrentUrlForHomePage)) {

            test.log(Status.INFO, "The driver has now reached the HomePage hence it is clear that Login was successful");
            Reporter.log("The driver has now reached the HomePage hence it is clear that Login was successful");
            Assert.assertTrue(true);
        } else {

            test.log(Status.INFO, "The driver has not reached to the HomePage yet hence it is clear that Login was un-successful");
            Reporter.log("The driver has not reached to the HomePage yet hence it is clear that Login was un-successful");

            String path = captureScreenshot.captureScreenShot("placeOrderTest");
            test.addScreenCaptureFromPath(path);
            test.log(Status.INFO, "Screenshot of the bug has been attached to this report");
            Assert.assertTrue(false);
        }

        // Instantiating HomePage_class of PageObjectPackage
        homePageClass = new HomePage_Class(driver);

        String actualTextPresentOnHomePage = homePageClass.getTextPresentOnHomePage();
        String expectedTextPresentOnHomePage = textOnHomePage; // dataProvider_03

        if (actualTextPresentOnHomePage.equalsIgnoreCase(expectedTextPresentOnHomePage)) {

            test.log(Status.INFO, "The text present on the HomePage is as same as the Expected_text i.e. : " + actualTextPresentOnHomePage);
            Reporter.log("The text present on the HomePage is as same as the Expected_text i.e. : " + actualTextPresentOnHomePage);
            Assert.assertTrue(true);

        } else {

            test.log(Status.INFO, "The Actual_text present on the HomePage is not as same as the Expected_text,  Actual_Text is : " + actualTextPresentOnHomePage + " & the Expected_text was : " + expectedTextPresentOnHomePage);
            Reporter.log("The Actual_text present on the HomePage is not as same as the Expected_text,  Actual_Text is : " + actualTextPresentOnHomePage + " & the Expected_text was : " + expectedTextPresentOnHomePage);
            String pathOfScreenShot_06 = captureScreenshot.captureScreenShot("placeOrderTest");

            test.addScreenCaptureFromPath(pathOfScreenShot_06);
            test.log(Status.INFO, "The Screenshot of the bug has been attached to this report.");
            Assert.assertTrue(false);
        }

        //Getting the List of all the items available to buy on this page are :
        System.out.println(homePageClass.getListOfItems());
        test.log(Status.INFO, "List of all the items available on the HomePage to buy are : " + homePageClass.getListOfItems());
        Reporter.log("List of all the items available on the HomePage to buy are : " + homePageClass.getListOfItems());

        String actualNameOfTheItem = homePageClass.getNameOfTheItem();
        String expectedNameOfTheItem = itemName; //dataProvider_03


        if (actualNameOfTheItem.equalsIgnoreCase(expectedNameOfTheItem)) {

            test.log(Status.INFO, "The actual_name of the item to be buy is same as the expected_name i.e. " + actualNameOfTheItem);
            Reporter.log("The actual_name of the item to be buy is same as the expected_name i.e. " + actualNameOfTheItem);

            homePageClass.clickOnAddToCart();
            test.log(Status.INFO, "driver clicked on the addToCart button.");
            Reporter.log("driver clicked on the addToCart button.");
        } else {

            test.log(Status.INFO, "The actual_name of the item to be buy is not as same as the expected_name i.e. Actual_Name is : " + actualNameOfTheItem + " whereas the Expected_Name was " + expectedNameOfTheItem);
            Reporter.log("The actual_name of the item to be buy is not as same as the expected_name i.e. Actual_Name is : " + actualNameOfTheItem + " whereas the Expected_Name was " + expectedNameOfTheItem);
            String pathOfScreenShot_05 = captureScreenshot.captureScreenShot("placeOrderTest");

            test.addScreenCaptureFromPath(pathOfScreenShot_05);
            test.log(Status.INFO, "The Screenshot of the bug has been attached to this report.");
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
        String expectedUrlOfYourCartPage = urlOfYourCartPage; //dataProvider_03

        if (actualUrlOfYourCartPage.equalsIgnoreCase(expectedUrlOfYourCartPage)) {

            test.log(Status.INFO, "The driver has now reached to the YourCart page after clicking on the add_To_Cart_Icon.");
            Reporter.log("The driver has now reached to the YourCart page after clicking on the add_To_Cart_Icon.");
        } else {
            test.log(Status.INFO, "The driver has not reached to the YourCart page yet after clicking on the add_To_Cart_Icon hence something went wrong.");
            Reporter.log("The driver has not reached to the YourCart page yet after clicking on the add_To_Cart_Icon hence something went wrong.");
            String pathOfScreenShot_04 = captureScreenshot.captureScreenShot("placeOrderTest");

            test.addScreenCaptureFromPath(pathOfScreenShot_04);
            test.log(Status.INFO, "The Screenshot of the bug has been attached to this report.");
            Assert.assertTrue(false);
        }

//Validating the Actual text present on the YourCart_page with the expected text.
        String actualText_PresentOn_YourCartPage = yourCartPageClass.getTextOnYourCartPage();
        String expectedText_PresentOn_YourCartPage = textOnYourCartPage; //dataProvider_03

        if (actualText_PresentOn_YourCartPage.equalsIgnoreCase(expectedText_PresentOn_YourCartPage)) {

            test.log(Status.INFO, "The text present on the YourCart page is exactly same as the Expected Text that should be present i.e : " + actualText_PresentOn_YourCartPage);
            Reporter.log("The text present on the YourCart page is exactly same as the Expected Text that should be present i.e : " + actualText_PresentOn_YourCartPage);
        } else {

            test.log(Status.INFO, "The text present on the YourCart page is not same as the Expected Text that should be present i.e Actual_Text : " + actualText_PresentOn_YourCartPage + " whereas the Expected_Text was : " + expectedText_PresentOn_YourCartPage);
            Reporter.log("The text present on the YourCart page is not same as the Expected Text that should be present i.e Actual_Text : " + actualText_PresentOn_YourCartPage + " whereas the Expected_Text was : " + expectedText_PresentOn_YourCartPage);
            String pathOfScreenShot_03 = captureScreenshot.captureScreenShot("placeOrderTest");

            test.addScreenCaptureFromPath(pathOfScreenShot_03);
            test.log(Status.INFO, "The Screenshot of the bug has been attached to this report.");
            Assert.assertTrue(false);
        }

        //Getting the name of the item being added in the Shopping-Cart
        String actualNameOfTheItemInShoppingCart = yourCartPageClass.getNameOfTheItemOnYourCartPage();
        String expectedNameOfTheItemInShoppingCart = itemName; //dataProvider_03

        if (actualNameOfTheItemInShoppingCart.equalsIgnoreCase(expectedNameOfTheItemInShoppingCart)) {

            test.log(Status.INFO, "The item that was selected previously is successfully added to the Shopping-Cart : " + actualNameOfTheItemInShoppingCart);
            Reporter.log("The item that was selected previously is successfully added to the Shopping-Cart : " + actualNameOfTheItemInShoppingCart);
            Assert.assertTrue(true);
        } else {

            test.log(Status.INFO, "The item that was selected is not present in the Shopping-Cart hence something went wrong.");
            Reporter.log("The item that was selected is not present in the Shopping-Cart hence something went wrong.");

            String pathOfScreenShot = captureScreenshot.captureScreenShot("placeOrderTest");

            test.addScreenCaptureFromPath(pathOfScreenShot);
            test.log(Status.INFO, "The Screenshot of the bug has been attached to this report.");
            Assert.assertTrue(false);

        }

        yourCartPageClass.clickOnCheckoutButton();

        test.log(Status.INFO, "driver has clicked on checkout button present on YourCartPage");
        Reporter.log("driver has clicked on checkout button present on YourCartPage");

        driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
        test.log(Status.INFO, "driver has waited due to ImplicitWait after clicking on the checkout button");
        Reporter.log("driver has waited due to ImplicitWait after clicking on the checkout button");

        //Instantiating YourInformationPage_Class
        yourInformationPageClass = new YourInformationPage_Class(driver);


        String actualUrlOfYourInformationPage = loginPageClass.getCurrentUrl();
        String expectedUrlOfYourInformationPage = urlOfYourInformationPage;

        if (actualUrlOfYourInformationPage.equalsIgnoreCase(expectedUrlOfYourInformationPage)) {

            test.log(Status.INFO, "The driver has now reached to the YourInformationPage after clicking on the checkout button previously.");
            Reporter.log("The driver has now reached to the YourInformationPage after clicking on the checkout button previously.");
        } else {

            test.log(Status.INFO, "The driver has not reached to the YourInformationPage yet after clicking on checkout button hence something went wrong.");
            Reporter.log("The driver has not reached to the YourInformationPage yet after clicking on checkout button hence something went wrong.");
            String pathOfScreenShot_02 = captureScreenshot.captureScreenShot("placeOrderTest");

            test.addScreenCaptureFromPath(pathOfScreenShot_02);
            test.log(Status.INFO, "The Screenshot of the bug has been attached to this report.");
            Assert.assertTrue(false);
        }

        String actualTextOnYourInformationPage = yourInformationPageClass.getTextPresentOnYourInformationPage();
        String expectedTextOnYourInformationPage = textOnYourInformationPage;

        if (actualTextOnYourInformationPage.equalsIgnoreCase(expectedTextOnYourInformationPage)) {

            test.log(Status.INFO, "The ActualText present on the YourInformationPage is exactly same as the ExpectedText i.e : " + actualTextOnYourInformationPage);
            Reporter.log("The ActualText present on the YourInformationPage is exactly same as the ExpectedText i.e : " + actualTextOnYourInformationPage);
        } else {

            test.log(Status.INFO, "The ActualText present on the YourInformationPage is not same as the ExpectedText i.e ActualText is : " + actualTextOnYourInformationPage + " whereas the ExpectedText was : " + expectedTextOnYourInformationPage);
            Reporter.log("The ActualText present on the YourInformationPage is not same as the ExpectedText i.e ActualText is : " + actualTextOnYourInformationPage + " whereas the ExpectedText was : " + expectedTextOnYourInformationPage);

            // capturing Screenshot of the bug.
            String path2 = captureScreenshot.captureScreenShot("placeOrderTest");
            test.addScreenCaptureFromPath(path2);
            test.log(Status.INFO, "The Screenshot of the bug has been attached to this report");
            Assert.assertTrue(false);
        }

        yourInformationPageClass.enterFirstName("Rajat Kumar");
        test.log(Status.INFO, "The driver has entered the first name of the user");
        Reporter.log("The driver has entered the first name of the user");

        yourInformationPageClass.enterLastName("Singh");
        test.log(Status.INFO, "The driver has entered the last name of the user");
        Reporter.log("The driver has entered the last name of the user");

        yourInformationPageClass.enterPostalCode("212546");
        test.log(Status.INFO, "The driver has entered the postal code for address of the user");
        Reporter.log("The driver has entered the postal code for address of the user");


        yourInformationPageClass.clickOnContinueButton();
        test.log(Status.INFO, "The driver has clicked on the continue button present on YourInformationPage");
        Reporter.log("The driver has clicked on the continue button present on YourInformationPage");

        driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
        test.log(Status.INFO, "driver has waited due to ImplicitWait after clicking on the continue button");
        Reporter.log("driver has waited due to ImplicitWait after clicking on the continue button");


        checkoutOverviewPageClass = new Checkout_Overview_PageClass(driver);

        String actualUrlOfCheckoutOverviewPage = loginPageClass.getCurrentUrl();
        String expectedUrlOfCheckoutOverviewPage = urlOfCheckoutOverviewPage; //dataProvider_03

        if (actualUrlOfCheckoutOverviewPage.equalsIgnoreCase(expectedUrlOfCheckoutOverviewPage)) {

            test.log(Status.INFO, "The driver has now reached to the CheckoutOverviewPage after clicking on the continue button previously.");
            Reporter.log("The driver has now reached to the CheckoutOverviewPage after clicking on the continue button previously.");
        } else {

            test.log(Status.INFO, "The driver has not reached to the CheckoutOverviewPage yet after clicking on continue button hence something went wrong.");
            Reporter.log("The driver has not reached to the CheckoutOverviewPage yet after clicking on continue button hence something went wrong.");

            //Capturing Screenshot of the bug
            String path3 = captureScreenshot.captureScreenShot("placeOrderTest");
            test.addScreenCaptureFromPath(path3);
            test.log(Status.INFO, "Screenshot of the bug has been attached to this report");
            Assert.assertTrue(false);
        }

        String actualTextPresentOnCheckoutOverviewPage = checkoutOverviewPageClass.getTextPresentOnCheckoutOverviewPage();
        String expectedTextPresentOnCheckoutOverviewPage = textOnCheckoutOverviewPage; //dataProvide_03

        if (actualTextPresentOnCheckoutOverviewPage.equalsIgnoreCase(expectedTextPresentOnCheckoutOverviewPage)) {

            test.log(Status.INFO, "The ActualText present on the CheckoutOverviewPage is exactly same as the ExpectedText i.e : " + actualTextPresentOnCheckoutOverviewPage);
            Reporter.log("The ActualText present on the CheckoutOverviewPage is exactly same as the ExpectedText i.e : " + actualTextPresentOnCheckoutOverviewPage);
        } else {

            test.log(Status.INFO, "The ActualText present on the CheckoutOverviewPage is not same as the ExpectedText i.e ActualText is : " + actualTextPresentOnCheckoutOverviewPage + " whereas the ExpectedText was : " + expectedTextPresentOnCheckoutOverviewPage);
            Reporter.log("The ActualText present on the CheckoutOverviewPage is not same as the ExpectedText i.e ActualText is : " + actualTextPresentOnCheckoutOverviewPage + " whereas the ExpectedText was : " + expectedTextPresentOnCheckoutOverviewPage);

            // capturing Screenshot of the bug.
            String path3 = captureScreenshot.captureScreenShot("placeOrderTest");
            test.addScreenCaptureFromPath(path3);
            test.log(Status.INFO, "The Screenshot of the bug has been attached to this report");
            Assert.assertTrue(false);
        }

        String actualNameOfTheItemOnCheckoutOverviewPage = checkoutOverviewPageClass.getNameOfTheItemAddedOn_CheckoutOverviewPage();
        String expectedNameOfTheItemOnCheckoutOverviewPage = itemName; //dataProvider_03

        if (actualNameOfTheItemOnCheckoutOverviewPage.equalsIgnoreCase(expectedNameOfTheItemOnCheckoutOverviewPage)) {

            test.log(Status.INFO, "The name of the item which is present on CheckoutOverviewPage is exactly same as the Expected nameOfTheItem i.e. : " + actualNameOfTheItemOnCheckoutOverviewPage);
            Reporter.log("The name of the item which is present on CheckoutOverviewPage is exactly same as the Expected nameOfTheItem i.e. : " + actualNameOfTheItemOnCheckoutOverviewPage);
        } else {

            test.log(Status.INFO, "The name of the item which is present on CheckoutOverviewPage is not as same as the Expected nameOfTheItem i.e. ActualNameOfItem is : " + actualNameOfTheItemOnCheckoutOverviewPage + " whereas the ExpectedName of the item is : " + expectedNameOfTheItemOnCheckoutOverviewPage);
            Reporter.log("The name of the item which is present on CheckoutOverviewPage is not as same as the Expected nameOfTheItem i.e. ActualNameOfItem is : " + actualNameOfTheItemOnCheckoutOverviewPage + " whereas the ExpectedName of the item is : " + expectedNameOfTheItemOnCheckoutOverviewPage);

            // capturing Screenshot of the bug.
            String path4 = captureScreenshot.captureScreenShot("placeOrderTest");
            test.addScreenCaptureFromPath(path4);
            test.log(Status.INFO, "The Screenshot of the bug has been attached to this report");
            Assert.assertTrue(false);

        }

        checkoutOverviewPageClass.clickOnFinishButton();
        test.log(Status.INFO, "The driver has clicked on the Finish Button present on CheckoutOverviewPage.");
        Reporter.log("The driver has clicked on the Finish Button present on CheckoutOverviewPage.");


        driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
        test.log(Status.INFO, "driver has waited due to ImplicitWait after clicking on the Finish button");
        Reporter.log("driver has waited due to ImplicitWait after clicking on the Finish button");


        //Instantiating the CheckoutCompletePage_Class
        checkoutCompletePage = new CheckoutCompletePage(driver);


        String actualUrlOfTheCheckoutCompletePage = loginPageClass.getCurrentUrl();
        String expectedUrlOfTheCheckoutCompletePage = urlOfCheckoutCompletePage;

        if (actualUrlOfTheCheckoutCompletePage.equalsIgnoreCase(expectedUrlOfTheCheckoutCompletePage)) {

            test.log(Status.INFO, "The driver has now reached to the CheckoutComplete_Page after clicking on the Finish-Button previously.");
            Reporter.log("The driver has now reached to the CheckoutComplete_Page after clicking on the Finish-Button previously.");
        } else {

            test.log(Status.INFO, "The driver has not reached to the CheckoutComplete_Page yet after clicking on Finish-Button button hence something went wrong.");
            Reporter.log("The driver has not reached to the CheckoutComplete_Page yet after clicking on Finish-Button hence something went wrong.");

            //Capturing Screenshot of the bug
            String path4 = captureScreenshot.captureScreenShot("placeOrderTest");
            test.addScreenCaptureFromPath(path4);
            test.log(Status.INFO, "Screenshot of the bug has been attached to this report");
            Assert.assertTrue(false);

        }

        String actualTextPresentOnCheckoutCompletePage = checkoutCompletePage.getTextPresentOnCheckoutCompletePage();
        String expectedTextPresentOnCheckoutCompletePage = textOnCheckoutCompletePage; //dataProvider_03

        if (actualTextPresentOnCheckoutCompletePage.equalsIgnoreCase(expectedTextPresentOnCheckoutCompletePage)) {
            test.log(Status.INFO, "The order has been placed successfully : "+actualTextPresentOnCheckoutCompletePage);
            Reporter.log("The order has been placed successfully : "+actualTextPresentOnCheckoutCompletePage);
            test.log(Status.PASS, "The TestCase : placeOrderTest has been passed.");
            Assert.assertTrue(true);
        } else {

            test.log(Status.INFO, "The order has not been placed successfully, something went wrong i.e. ActualTextThatShouldBePresent : "+actualTextPresentOnCheckoutCompletePage+" whereas the ExpectedText that should be present on the Checkout-complete page "+expectedTextPresentOnCheckoutCompletePage);
            Reporter.log("The order has not been placed successfully, something went wrong i.e. ActualTextThatShouldBePresent : "+actualTextPresentOnCheckoutCompletePage + " whereas the ExpectedText that should be present on the Checkout-complete page "+expectedTextPresentOnCheckoutCompletePage);
            //Capturing Screenshot of the bug
            String path_08 = captureScreenshot.captureScreenShot("placeOrderTest");
            test.addScreenCaptureFromPath(path_08);
            test.log(Status.INFO, "Screenshot of the bug has been attached to this report");
            test.log(Status.FAIL, "The TestCase : placeOrderTest has been failed.");
            Assert.assertTrue(false);

        }
    }

}









