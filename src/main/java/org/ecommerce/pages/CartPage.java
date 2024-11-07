package org.ecommerce.pages;

import org.ecommerce.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BrowserUtility {

    private By cartTotalPrice = By.xpath("//span[@id='sc-subtotal-amount-buybox']//span");
    private By cartPageProductName = By.xpath("//span[contains(@class,'a-truncate-cut')]");

    public CartPage(WebDriver driver) {

        super(driver);
    }

    public String getCartProductName(){

        return getTextValue(cartPageProductName);
    }

    public String getCartTotalPrice(){

        return getTextValue(cartTotalPrice);
    }
}
