package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage_Class {

    WebDriver driver ;

    public HomePage_Class(WebDriver driver){

        this.driver = driver ;
        PageFactory.initElements(this.driver,this);

    }

    @FindBy(xpath = "//span[@class='title']")
    WebElement textOnHomePage;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement menuBar;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement logoutButton;

    @FindBy(xpath = "//div[@data-test=\"inventory-item-name\"]")
    List<WebElement> list;

    @FindBy(xpath="//div[normalize-space()='Sauce Labs Backpack']")
    WebElement item ;

    @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement addToCartButton;

    public String getTextPresentOnHomePage(){

        return textOnHomePage.getText();
    }

    public void clickOnMenuBar(){

        menuBar.click();
    }

    public void clickOnLogout(){

        logoutButton.click();
    }

    public ArrayList<String> getListOfItems(){

       ArrayList<String>listOfItems = new ArrayList<>();

       for(int i = 0; i< list.size(); i++){

           String itemName = list.get(i).getText();
           listOfItems.add(itemName);
       }

       return listOfItems;

    }

    public String getNameOfTheItem(){

        return item.getText();
    }

    public void clickOnAddToCart(){

        addToCartButton.click();
    }





}
