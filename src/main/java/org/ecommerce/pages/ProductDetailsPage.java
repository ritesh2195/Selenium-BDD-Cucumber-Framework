package org.ecommerce.pages;

import org.ecommerce.utility.BrowserUtility;
import org.ecommerce.utility.ScenarioContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class ProductDetailsPage extends BrowserUtility {

    private final By productNameOnDetailsPage = By.xpath("//span[@id='productTitle']");
    private final By productPriceOnDetailsPage = By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']//span[contains(@class,'a-price-whole')]");
    private final By addToCartButton = By.id("add-to-cart-button");
    private final By buyNowButton = By.id("buy-now-button");
    private final By quantityDropDown = By.id("quantity");
    private final By cartLink = By.id("nav-cart-count-container");
    private final By productCountInCartIcon = By.xpath("(//div[@id='nav-cart-count-container']//span)[1]");

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
