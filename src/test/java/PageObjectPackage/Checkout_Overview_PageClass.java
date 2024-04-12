package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_Overview_PageClass {

    WebDriver driver ;

    public Checkout_Overview_PageClass(WebDriver driver){

        this.driver = driver ;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishButton ;

    @FindBy(xpath="//div[@class='inventory_item_name']")
    WebElement itemAdded_on_CheckoutOverviewPage ;

    @FindBy(xpath = "//span[@class='title']")
    WebElement textOnCheckoutOverviewPage;

    public void clickOnFinishButton(){

        finishButton.click();
    }

    public String getNameOfTheItemAddedOn_CheckoutOverviewPage(){

        return itemAdded_on_CheckoutOverviewPage.getText();
    }

    public String getTextPresentOnCheckoutOverviewPage(){

        return textOnCheckoutOverviewPage.getText();
    }




}
