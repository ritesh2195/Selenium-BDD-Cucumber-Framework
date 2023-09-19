package org.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

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

    public void selectProductWithLeastPrice(){

        List<WebElement> productsPrice = driver.findElements(productPrice);

        LinkedList<Integer> list = new LinkedList<>();

        for (WebElement productPrice:productsPrice){

            String stringPrice = productPrice.getText();

            if (stringPrice.length()>3){

                String strPrice = stringPrice.split(",")[0]+stringPrice.split(",")[1];

                list.add(Integer.parseInt(strPrice));
            }

            else {

                if (!stringPrice.isEmpty()){

                    int price = Integer.parseInt(stringPrice);

                    list.add(price);
                }
            }

        }

        Collections.sort(list);

        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);

        String leastPrice = formatter.format(list.get(0));

        //String xpathValue = "//span[text()='"+leastPrice+"']";

        clickWebElement(By.xpath("//span[text()='"+leastPrice+"']"));

    }
}
