package org.ecommerce.parallel;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ecommerce.manager.PageManager;
import org.ecommerce.pages.HomePage;
import org.ecommerce.pages.LoginPage;
import org.ecommerce.manager.BrowserFactory;
import org.ecommerce.utility.ConfigReader;
import org.junit.Assert;

import java.util.HashMap;

public class LoginPageStepDef {

    private final LoginPage loginPage;
    private final HomePage homePage;
    private PageManager pageManager;

    public LoginPageStepDef(){

        pageManager = new PageManager(BrowserFactory.getDriver());

        homePage = pageManager.getHomePage();

        loginPage = pageManager.getLoginPage();
    }

    @When("user enters email {string} and click on continue button")
    public void user_enters_and_click_on_continue_button(String email) {

        Assert.assertEquals("Amazon Sign In", loginPage.getPageTitle());

        loginPage.enterUserName(email);

        loginPage.clickContinueButton();
    }

    @When("User enters password {string}")
    public void user_enters(String password) {

        loginPage.enterPassword(password);

    }
    @When("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() {

        loginPage.clickSignInButton();

    }
    @Then("user should be able to login in the application")
    public void user_should_be_able_to_login_in_the_application() {

        String firstName = ConfigReader.getInstance().getFirstName();

        Assert.assertEquals("Hello, "+firstName,homePage.getHeaderPage().getUserName());

    }

    @When("user enters wrong email {string} and click on the continue button")
    public void user_enters_wrong_email_id_and_click_on_the_continue_button(String email) {

        Assert.assertEquals("Amazon Sign In", loginPage.getPageTitle());

        loginPage.enterUserName(email);

        loginPage.clickContinueButton();

    }
    @Then("user should get alert message with alert icon")
    public void user_should_get_alert_message_with_alert_icon() {

        HashMap<String, Boolean> map = loginPage.verifyOnUnSuccessfulLoginAlert();

        Assert.assertTrue(map.get("alertIcon"));

        Assert.assertTrue(map.get("alertHeader"));

        Assert.assertTrue(map.get("alertText"));

    }

}
