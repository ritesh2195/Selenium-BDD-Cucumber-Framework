package org.ecommerce.parallel;

import io.cucumber.java.en.Then;
import org.ecommerce.pages.CartPage;
import org.ecommerce.utilities.BrowserFactory;
import org.ecommerce.utilities.ScenarioContext;
import org.junit.Assert;

public class CartPageStepDef {

    private CartPage cartPage;

    public CartPageStepDef(){

        cartPage = new CartPage(BrowserFactory.getDriver());
    }

    @Then("user should see the product in my cart")
    public void user_should_see_the_product_in_my_cart() {

        System.out.println(cartPage.getCartProductName());

        String productName = (String)ScenarioContext.getData("productName");

        productName = productName.trim();

        System.out.println(productName);

        Assert.assertTrue(cartPage.getCartProductName().contains(productName));
    }
    @Then("verify cart total price")
    public void verify_cart_total_price() {

        String price = cartPage.getCartTotalPrice();

        System.out.println(price);
    }
}
