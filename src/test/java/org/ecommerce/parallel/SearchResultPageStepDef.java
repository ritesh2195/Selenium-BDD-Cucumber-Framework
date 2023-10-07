package org.ecommerce.parallel;

import io.cucumber.java.en.When;
import org.ecommerce.pages.ProductDetailsPage;
import org.ecommerce.pages.SearchResultPage;
import org.ecommerce.utilities.BrowserFactory;
import org.ecommerce.utilities.ScenarioContext;
import org.junit.Assert;

import java.util.HashMap;

public class SearchResultPageStepDef {

    private SearchResultPage resultPage;
    private ProductDetailsPage detailsPage;

    public SearchResultPageStepDef(){

        resultPage = new SearchResultPage(BrowserFactory.getDriver());

        detailsPage = new ProductDetailsPage(BrowserFactory.getDriver());
    }

    @When("user clicks on first product in search result page")
    public void user_clicks_on_first_product_in_search_result_page() {

        HashMap<String,String> listPriceProductDetails = resultPage.selectProductWithLeastPrice();

        String parentId = resultPage.getParentWindowId();

        resultPage.switchToChildWindow(parentId);

        HashMap<String,String> productDetails =  detailsPage.getProductDetailsOnDetailsPage();

        String price = productDetails.get("productPriceOnDetailsPage");

        Assert.assertEquals(productDetails.get("productPriceOnDetailsPage"),listPriceProductDetails.get("leastPriceOfProduct"));

        ScenarioContext.setData("productName",productDetails.get("productNameOnDetailsPage"));

        ScenarioContext.setData("productPrice",productDetails.get("productPriceOnDetailsPage"));

    }

    @When("user adds product in the cart")
    public void user_adds_product_in_the_cart() throws InterruptedException {

        String productCountInCartIcon = detailsPage.addProductToCard();

        Assert.assertEquals((String)ScenarioContext.getData("quantitySelected"),productCountInCartIcon);

        detailsPage.navigateToCartPage();
    }

}
