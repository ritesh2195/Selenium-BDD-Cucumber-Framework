package org.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {

    private By signInLink = By.id("nav-link-accountList");
    private By accountListLine1 = By.id("nav-link-accountList-nav-line-1");

    public HeaderPage(WebDriver driver){

        super(driver);

        this.driver = driver;
    }

    public void navigateToLoginPage(){

        clickWebElement(signInLink);
    }

    public String getUserName(){

        return driver.findElement(accountListLine1).getText();
    }

}
