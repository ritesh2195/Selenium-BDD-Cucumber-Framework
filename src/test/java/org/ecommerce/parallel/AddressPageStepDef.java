package org.ecommerce.parallel;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ecommerce.pages.AccountPage;
import org.ecommerce.pages.AddAddressPage;
import org.ecommerce.pages.HomePage;
import org.ecommerce.pages.LoginPage;
import org.ecommerce.utilities.BrowserFactory;
import org.ecommerce.utilities.ConfigReader;
import org.ecommerce.utilities.ScenarioContext;
import org.junit.Assert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressPageStepDef {

    private HomePage homePage;
    private LoginPage loginPage;
    private AddAddressPage addAddressPage;
    private AccountPage accountPage;

    public AddressPageStepDef(){

        homePage = new HomePage(BrowserFactory.getDriver());

        loginPage = new LoginPage(BrowserFactory.getDriver());

        addAddressPage = new AddAddressPage(BrowserFactory.getDriver());

        accountPage = new AccountPage(BrowserFactory.getDriver());
    }

    @Given("user logged in amazon account")
    public void user_logged_in_amazon_account() {

        homePage.getHeaderPage().navigateToLoginPage();

        loginPage.enterUserName(ConfigReader.getInstance().getEmailId());

        loginPage.clickContinueButton();

        loginPage.enterPassword(ConfigReader.getInstance().getPassword());

        loginPage.clickSignInButton();

    }
    @Given("user navigate to your address page")
    public void user_navigate_to_your_address_page() {

        homePage.getHeaderPage().navigateToAccountPage();

        accountPage.navigateToAddressPage();
    }
    @When("user clicks on add address")
    public void user_clicks_on_add_address() {

        addAddressPage.clickAddAddressLink();

    }
    @When("user enters following details")
    public void user_enters_following_details(DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        Thread.sleep(1000);

        addAddressPage.selectCountry(rows.get(0).get("Value"));

        addAddressPage.enterFullName(rows.get(1).get("Value"));

        ScenarioContext.setData("fullName",rows.get(1).get("Value"));

        addAddressPage.enterMobileNumber(rows.get(2).get("Value"));

        addAddressPage.enterPinCode(rows.get(3).get("Value"));

        addAddressPage.enterHouseNo(rows.get(4).get("Value"));

        addAddressPage.enterStreetAddress(rows.get(5).get("Value"));

        ScenarioContext.setData("address",rows.get(5).get("Value"));

        addAddressPage.enterCityName(rows.get(6).get("Value"));

        addAddressPage.selectState(rows.get(7).get("Value"));

    }
    @When("user clicks on add address button")
    public void user_clicks_on_add_address_button() {

        addAddressPage.clickAddAddressButton();

    }
    @Then("user should see confirmation message")
    public void user_should_see_confirmation_message() {

        Assert.assertEquals(addAddressPage.verifyConfirmationMessage(),"Address saved");
    }

    @Then("address should be added in your address section")
    public void address_should_be_added_in_your_address_section() {

        HashMap<String,Boolean> map = addAddressPage.verifyNewlyAddedAddress();

        Assert.assertTrue(map.get("isFullNameDisplayed"));

        Assert.assertTrue(map.get("isAddressDisplayed"));
    }

}
