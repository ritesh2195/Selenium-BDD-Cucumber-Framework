package org.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage{

    private By productName = By.xpath("//span[contains(@class,'a-size-base-plus')]");
    private By productPrice = By.xpath("//span[@class='a-price']//child::span//child::span[2]");

    public SearchResultPage(WebDriver driver) {

        super(driver);
    }

    public int getFirstProductPrice(){

        String stringPrice = driver.findElements(productPrice).get(0).getText();

        String strPrice = stringPrice.split(",")[0]+stringPrice.split(",")[1];

        return Integer.parseInt(strPrice);
    }

    public String clickOnFirstProduct(){

        String firstProductName = driver.findElements(productName).get(0).getText();

        driver.findElements(productName).get(0).click();

        return firstProductName;
    }
}
