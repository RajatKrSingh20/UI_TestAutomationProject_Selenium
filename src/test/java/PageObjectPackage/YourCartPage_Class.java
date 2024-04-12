package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage_Class {

    WebDriver driver ;

    public YourCartPage_Class(WebDriver driver){

        this.driver = driver ;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath="//a[@class='shopping_cart_link']")
    WebElement shoppingCartIcon ;

    @FindBy(xpath ="//span[@class='title']")
    WebElement textOnYourCartPage;

    @FindBy(xpath="//div[@class='inventory_item_name']")
    WebElement itemNameOnYourCartPage;

    @FindBy(xpath="//button[@id='checkout']")
    WebElement checkoutButton ;

    public void clickOnShoppingCartIcon(){

        shoppingCartIcon.click();
    }

    public String getTextOnYourCartPage(){

        return textOnYourCartPage.getText();
    }

    public String getNameOfTheItemOnYourCartPage(){

        return itemNameOnYourCartPage.getText();
    }

    public void clickOnCheckoutButton(){

        checkoutButton.click();
    }


}
