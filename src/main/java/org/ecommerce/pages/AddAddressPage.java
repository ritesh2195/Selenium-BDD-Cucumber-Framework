package org.ecommerce.pages;

import org.ecommerce.utilities.ScenarioContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class AddAddressPage extends BasePage{

    private By addAddressLink = By.xpath("//h2[contains(text(),'Add address')]");
    private By countryDropDown = By.xpath("//select[contains(@id,'countryCode-dropdown')]");
    private By fullName = By.id("address-ui-widgets-enterAddressFullName");
    private By mobileNumber = By.id("address-ui-widgets-enterAddressPhoneNumber");
    private By pinCode = By.id("address-ui-widgets-enterAddressPostalCode");
    private By flatHouse = By.id("address-ui-widgets-enterAddressLine1");
    private By streetAddress = By.id("address-ui-widgets-enterAddressLine2");
    private By townCity = By.id("address-ui-widgets-enterAddressCity");
    private By stateDropDown = By.xpath("//select[contains(@id,'address-ui-widgets-enterAddressStateOrRegion')]");
    private By addAddressButton = By.xpath("//span[text()='Add address']//preceding-sibling::input");
    private By confirmationMessage = By.xpath("//h4[@class='a-alert-heading']");
    private By yesButton = By.id("deleteAddressModal-2-submit-btn");

    public AddAddressPage(WebDriver driver) {

        super(driver);
    }

    public void clickAddAddressLink(){

        clickWebElement(addAddressLink);
    }

    public void enterFullName(String name){

        driver.findElement(fullName).sendKeys(name);
    }

    public void selectCountry(String country){

        Select select = new Select(driver.findElement(countryDropDown));

        select.selectByVisibleText(country);
    }

    public void enterMobileNumber(String mobile){

        driver.findElement(mobileNumber).sendKeys(mobile);
    }

    public void enterPinCode(String zipCode){

        driver.findElement(pinCode).sendKeys(zipCode);
    }

    public void enterHouseNo(String houseNo){

        driver.findElement(flatHouse).sendKeys(houseNo);
    }

    public void enterStreetAddress(String address){

        driver.findElement(streetAddress).sendKeys(address);
    }

    public void enterCityName(String city){

        driver.findElement(townCity).clear();

        driver.findElement(townCity).sendKeys(city);
    }

    public void selectState(String state){

        Select select = new Select(driver.findElement(stateDropDown));

        select.selectByVisibleText(state);
    }

    public void clickAddAddressButton(){

        clickWebElement(addAddressButton);
    }

    public String verifyConfirmationMessage(){

        return getTextValue(confirmationMessage);
    }

    public HashMap<String, Boolean> verifyNewlyAddedAddress(){

        HashMap<String,Boolean> map = new HashMap<>();

        String fullName = (String)ScenarioContext.getData("fullName");

        String address = (String)ScenarioContext.getData("fullName");

        map.put("isFullNameDisplayed",driver.findElement(By.xpath("//span[text()='"+fullName+"']")).isDisplayed());

        map.put("isAddressDisplayed",driver.findElement(By.xpath("//span[text()='"+address+"']")).isDisplayed());

        return map;
    }

    public void deleteAddress(){

        String fullName = (String)ScenarioContext.getData("fullName");

        clickWebElement(driver.findElement(By.xpath("//span[text()='"+fullName+"']//ancestor::div[contains(@class,'address-column')]//a[text()='Remove']")));

        clickWebElement(yesButton);
    }
}
