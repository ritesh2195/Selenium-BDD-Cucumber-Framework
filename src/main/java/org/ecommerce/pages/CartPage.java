package org.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By cartTotalPrice = By.xpath("//span[@id='sc-subtotal-amount-buybox']//span");
    private By cartPageProductName = By.xpath("//span[contains(@class,'item-product-title')]//span");

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
