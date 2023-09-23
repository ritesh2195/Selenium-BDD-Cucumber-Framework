package org.ecommerce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

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

        } catch (NoSuchElementException | StaleElementReferenceException e){

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
        }
    }

    @Override
    public void clickWebElement(WebElement element) {

        try {

            element.click();

        } catch (NoSuchElementException | StaleElementReferenceException e){

            wait.until(ExpectedConditions.visibilityOf(element));

            element.click();
        }

        catch (ElementClickInterceptedException e){

            JavascriptExecutor javascriptExecutor = ((JavascriptExecutor)driver);

            javascriptExecutor.executeScript("argument[0].click()",element);
        }

        catch (ElementNotInteractableException e){

            wait.until(ExpectedConditions.elementToBeClickable(element));

            element.click();

        } catch (Exception e){

            e.printStackTrace();
        }
    }

    public String getParentWindowId(){

        return driver.getWindowHandle();
    }

    @Override
    public void switchToParentWindow(String parentWindowId){

        driver.switchTo().window(parentWindowId);
    }

    @Override
    public void switchToChildWindow(String parentWindowId){

        Set<String> childWindowsId = driver.getWindowHandles();

        for (String childWindowId:childWindowsId){

            if (!childWindowId.equalsIgnoreCase(parentWindowId)){

                driver.switchTo().window(childWindowId);
            }
        }
    }

    public String getTextValue(By locator){

        try {

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));

            return driver.findElement(locator).getText();

        } catch (Exception e){

            e.printStackTrace();
        }

        return "Exception occurred while retrieving the text";

        }
    }
