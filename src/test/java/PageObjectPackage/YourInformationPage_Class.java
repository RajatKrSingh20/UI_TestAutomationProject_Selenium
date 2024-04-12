package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage_Class {

    WebDriver driver ;

    public YourInformationPage_Class(WebDriver driver){

        this.driver = driver ;
        PageFactory.initElements(this.driver,this);

    }

    @FindBy(xpath="//span[@class='title']")
    WebElement textPresentOn_YourInformationPage;

    @FindBy(xpath="//input[@id='first-name']")
    WebElement firstName_TextField;

    @FindBy(xpath="//input[@id='last-name']")
    WebElement lastName_TextField;

    @FindBy(xpath="//input[@id='postal-code']")
    WebElement postalCode_textField ;

    @FindBy(xpath="//input[@id='continue']")
    WebElement continueButton ;


    public String getTextPresentOnYourInformationPage(){

        return textPresentOn_YourInformationPage.getText();
    }

    public void enterFirstName(String firstName){

        firstName_TextField.sendKeys(firstName);
    }

    public void enterLastName(String lastName){

        lastName_TextField.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode){

        postalCode_textField.sendKeys(postalCode);
    }

    public void clickOnContinueButton(){

        continueButton.click();
    }







}
