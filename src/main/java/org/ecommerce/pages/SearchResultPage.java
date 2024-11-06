package org.ecommerce.pages;

import org.ecommerce.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.util.*;

public class SearchResultPage extends BrowserUtility {

    private final By productName = By.xpath("//span[contains(@class,'a-size-base-plus')]");
    private final By productPrice = By.xpath("//span[@class='a-price']//child::span//child::span[2]");

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

    public HashMap<String, String> selectProductWithLeastPrice(){

        List<WebElement> productsPrice = driver.findElements(productPrice);

        LinkedList<Integer> list = new LinkedList<>();

        for (WebElement productPrice:productsPrice){

            String stringPrice = productPrice.getText();

            if (stringPrice.length()>3){

                String strPrice = stringPrice.replace(",","");

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

        clickWebElement(By.xpath("//span[text()='"+leastPrice+"']"));

        String leastPriceProductName = driver.findElement(By.xpath("//span[text()='"+leastPrice+"']//ancestor::div[contains(@class,'a-spacing')]//span[contains(@class,'a-size-base-plus')]")).getText();

        HashMap<String,String> map = new HashMap<>();

        map.put("productName",leastPriceProductName);

        map.put("leastPriceOfProduct",leastPrice);

        return map;

    }
}
