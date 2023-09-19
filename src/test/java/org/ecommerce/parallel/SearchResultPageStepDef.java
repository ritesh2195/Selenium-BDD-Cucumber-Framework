package org.ecommerce.parallel;

import io.cucumber.java.en.When;
import org.ecommerce.pages.SearchResultPage;
import org.ecommerce.utilities.BrowserFactory;

public class SearchResultPageStepDef {

    private SearchResultPage resultPage;

    public SearchResultPageStepDef(){

        resultPage = new SearchResultPage(BrowserFactory.getDriver());
    }

    @When("user clicks on first product in search result page")
    public void user_clicks_on_first_product_in_search_result_page() {

        //resultPage.clickOnFirstProduct();

        resultPage.selectProductWithLeastPrice();

        String parentId = resultPage.getParentWindowId();

        resultPage.switchToChildWindow(parentId);

        BrowserFactory.getDriver().close();

        resultPage.switchToParentWindow(parentId);
    }
}
