package org.ecommerce.pages;

import org.ecommerce.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class HeaderPage extends BrowserUtility {

    private By signInLink = By.id("nav-link-accountList");
    private By accountListLine1 = By.id("nav-link-accountList-nav-line-1");
    private By searchTextBox = By.xpath("//input[@placeholder='Search Amazon.in']");
    private By searchAutoListOption = By.xpath("//div[@class='s-suggestion-container']//div");

    public HeaderPage(WebDriver driver){

        super(driver);

        this.driver = driver;
    }

    public void navigateToLoginPage(){

        clickWebElement(signInLink);
    }

    public void navigateToAccountPage(){

        clickWebElement(accountListLine1);
    }

    public String getUserName(){

        return driver.findElement(accountListLine1).getText();
    }

    public void searchProduct(String product){

        driver.findElement(searchTextBox).sendKeys(product);

        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public LinkedList<String> getAllAutoPopulatedList(){

        LinkedList<String> list = new LinkedList<>();

        List<WebElement> productOptions = driver.findElements(searchAutoListOption);

        for (WebElement productOption: productOptions){

            list.add(productOption.getAttribute("aria-label"));
        }

        return list;
    }

    public void selectProduct(String productToSelect){

        List<WebElement> productOptions = driver.findElements(searchAutoListOption);

        for (WebElement productOption: productOptions){

            if (productOption.getAttribute("aria-label").equalsIgnoreCase(productToSelect)){

                clickWebElement(productOption);

                break;
            }
        }
    }

}
