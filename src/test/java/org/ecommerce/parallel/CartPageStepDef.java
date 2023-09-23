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

        String productName = (String)ScenarioContext.getData("productName");

        productName = productName.trim();

        Assert.assertTrue(cartPage.getCartProductName().contains(productName));
    }
    @Then("verify cart total price")
    public void verify_cart_total_price() {

        String price = cartPage.getCartTotalPrice();

        int quantity = Integer.parseInt((String)ScenarioContext.getData("quantitySelected"));

        int intPrice = (int) Math.floor((Double.parseDouble(price))/quantity);

        Assert.assertEquals(String.valueOf(intPrice),ScenarioContext.getData("productPrice"));

    }
}
