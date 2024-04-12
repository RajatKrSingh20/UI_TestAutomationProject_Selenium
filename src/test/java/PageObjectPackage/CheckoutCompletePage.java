package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {

    WebDriver driver;

    public CheckoutCompletePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath="//h2[normalize-space()='Thank you for your order!']")
    WebElement textOnCheckoutCompletePage;


    public String getTextPresentOnCheckoutCompletePage(){

        return textOnCheckoutCompletePage.getText();
    }



}
