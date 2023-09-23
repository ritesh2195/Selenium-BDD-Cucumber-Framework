package org.ecommerce.pages;

import org.ecommerce.utilities.ScenarioContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class ProductDetailsPage extends BasePage {

    private By productNameOnDetailsPage = By.xpath("//span[@id='productTitle']");
    private By productPriceOnDetailsPage = By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']//span[contains(@class,'a-price-whole')]");
    private By addToCartButton = By.id("add-to-cart-button");
    private By buyNowButton = By.id("buy-now-button");
    private By quantityDropDown = By.id("quantity");
    private By cartLink = By.id("nav-cart-count-container");
    private By productCountInCartIcon = By.xpath("(//div[@id='nav-cart-count-container']//span)[1]");

    public ProductDetailsPage(WebDriver driver){

        super(driver);

    }

    public HashMap<String, String> getProductDetailsOnDetailsPage(){

        HashMap<String,String> map = new HashMap<>();

        map.put("productNameOnDetailsPage",driver.findElement(productNameOnDetailsPage).getText());

        map.put("productPriceOnDetailsPage",driver.findElement(productPriceOnDetailsPage).getText());

        return map;
    }

    public String addProductToCard(){

        Select select = new Select(driver.findElement(quantityDropDown));

        ScenarioContext.setData("quantitySelected",select.getFirstSelectedOption().getText());

        clickWebElement(addToCartButton);

        return getTextValue(productCountInCartIcon);
    }

    public void navigateToCartPage(){

        clickWebElement(cartLink);
    }
}
