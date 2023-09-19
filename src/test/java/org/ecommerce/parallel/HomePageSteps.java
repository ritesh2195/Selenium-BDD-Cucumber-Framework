package org.ecommerce.parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ecommerce.pages.HomePage;
import org.ecommerce.utilities.BrowserFactory;
import org.junit.Assert;

import java.util.LinkedList;

public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps(){

        homePage = new HomePage(BrowserFactory.getDriver());
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {

        homePage.getHeaderPage().navigateToLoginPage();
    }

    @When("user enters {string} in search text box")
    public void user_enters_in_search_text_box(String product) {

        homePage.getHeaderPage().searchProduct(product);
    }

    @Then("verify auto populated list contains {string}")
    public void verify_auto_populated_list_contains_searched_product(String product) {

        LinkedList<String> allAutoPopulatedList = homePage.getHeaderPage().getAllAutoPopulatedList();

        for (String autoPopulatedProduct: allAutoPopulatedList){

            Assert.assertTrue(autoPopulatedProduct.contains(product));
        }
    }

    @When("user selects {string} from auto populated list")
    public void user_selects_from_auto_populated_list(String productToSelect) {

        homePage.getHeaderPage().selectProduct(productToSelect);

    }
    @Then("user should navigate to product details page")
    public void user_should_navigate_to_product_details_page() {

        Assert.assertTrue(homePage.getPageTitle().contains("badminton"));

    }
}
