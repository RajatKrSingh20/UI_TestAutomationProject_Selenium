package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Class {

   WebDriver driver;

   public LoginPage_Class(WebDriver driver){

       this.driver = driver;
       PageFactory.initElements(this.driver,this);
   }

   @FindBy(xpath="//div[@class='login_logo']")
   @CacheLookup
   WebElement textOnLoginPage ;

   @FindBy(xpath="//input[@id='user-name']")
    WebElement usernameField ;

    @FindBy(xpath="//input[@id='password']")
    WebElement passwordField ;

    @FindBy(xpath="//input[@id='login-button']")
    WebElement loginButton ;


    public void enterUsername(String Username){

        usernameField.sendKeys(Username);
    }

    public void enterPassword(String Password){

        passwordField.sendKeys(Password);
    }

    public void clickOnLoginButton(){

        loginButton.click();
    }

    public String getTextOnLoginPage(){

        return textOnLoginPage.getText();
    }

    public String getCurrentUrl(){

        return driver.getCurrentUrl();
    }





}
