package org.ecommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends AbstractPage{

    public BasePage(WebDriver driver) {

        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    @Override
    public void clickWebElement(By locator) {

        try {

            driver.findElement(locator).click();

        } catch (NoSuchElementException e){

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));

            driver.findElement(locator).click();
        }

        catch (ElementClickInterceptedException e){

            JavascriptExecutor javascriptExecutor = ((JavascriptExecutor)driver);

            javascriptExecutor.executeScript("argument[0].click()",driver.findElement(locator));
        }

        catch (ElementNotInteractableException e){

            wait.until(ExpectedConditions.elementToBeClickable(locator));

            driver.findElement(locator).click();

        } catch (Exception e){

            e.printStackTrace();

            System.out.println("Exception occurred");
        }
    }
}
