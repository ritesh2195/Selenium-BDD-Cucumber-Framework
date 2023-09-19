package org.ecommerce.pages;

import org.ecommerce.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    public WebDriver driver;
    WebDriverWait wait;

    public AbstractPage(WebDriver driver){

        this.driver = driver;

        wait = new WebDriverWait(driver,Duration.ofSeconds(ConfigReader.getInstance().getTimeOut()));
    }

    public abstract String getPageTitle();

    public abstract String getCurrentURL();

    public abstract void clickWebElement(By locator);

    public abstract void clickWebElement(WebElement element);
}
