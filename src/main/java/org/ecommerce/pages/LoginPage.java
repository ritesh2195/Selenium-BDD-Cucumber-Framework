package org.ecommerce.pages;

import org.ecommerce.utility.BrowserUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class LoginPage extends BrowserUtility {

    private By userNameTextBox = By.id("ap_email");
    private By continueButton = By.id("continue");
    private By passwordTextBox = By.id("ap_password");
    private By signInButton = By.id("signInSubmit");
    private By alertIcon = By.xpath("//i[contains(@class,'a-icon-alert')]");
    private By alertHeaderText = By.xpath("//h4[contains(text(),'There was a problem')]");
    private By alertMessage = By.xpath("//span[contains(text(),'We cannot find an account with that email address')]");

    public LoginPage(WebDriver driver){

        super(driver);

        this.driver = driver;
    }

    public void enterUserName(String email){

        driver.findElement(userNameTextBox).sendKeys(email);

    }

    public void clickContinueButton(){

        clickWebElement(continueButton);
    }

    public void enterPassword(String password){

        driver.findElement(passwordTextBox).sendKeys(password);

    }

    public void clickSignInButton(){

        clickWebElement(signInButton);
    }

    public HashMap<String, Boolean> verifyOnUnSuccessfulLoginAlert(){

        HashMap<String, Boolean> map = new HashMap<>();

        map.put("alertIcon", driver.findElement(alertIcon).isDisplayed());

        map.put("alertHeader", driver.findElement(alertHeaderText).isDisplayed());

        map.put("alertText",driver.findElement(alertMessage).isDisplayed());

        return map;
    }

}
