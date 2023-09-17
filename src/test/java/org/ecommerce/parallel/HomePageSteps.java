package org.ecommerce.parallel;

import io.cucumber.java.en.Given;
import org.ecommerce.pages.HomePage;
import org.ecommerce.utilities.BrowserFactory;

public class HomePageSteps {

    private HomePage homePage;

    @Given("user is launching amazon application url")
    public void user_is_launching_amazon_application_url() {

    }
    @Given("User clicks on the SignIn link")
    public void user_clicks_on_the_sign_in_link() {

        homePage = new HomePage(BrowserFactory.getDriver());

        homePage.clickSignInLink();

    }

}
