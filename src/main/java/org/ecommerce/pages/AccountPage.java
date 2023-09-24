package org.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

    private By addressLink = By.xpath("//h2[contains(text(),'Your Addresses')]");

    public AccountPage(WebDriver driver) {

        super(driver);
    }

    public void navigateToAddressPage(){

        clickWebElement(addressLink);
    }
}
