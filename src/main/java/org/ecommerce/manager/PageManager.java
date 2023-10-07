package org.ecommerce.manager;

import org.ecommerce.pages.*;
import org.openqa.selenium.WebDriver;

public class PageManager {

    WebDriver driver;
    private AccountPage accountPage;
    private AddAddressPage addAddressPage;
    private CartPage cartPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private ProductDetailsPage detailsPage;
    private SearchResultPage resultPage;

    public PageManager(WebDriver driver){

        this.driver=driver;
    }

    public AccountPage getAccountPage(){

        return (accountPage==null) ? accountPage = new AccountPage(driver) : accountPage;
    }

    public AddAddressPage getAddAddressPage(){

        return (addAddressPage==null) ? addAddressPage = new AddAddressPage(driver) : addAddressPage;
    }

    public CartPage getCartPage(){

        return (cartPage==null) ? cartPage = new CartPage(driver) : cartPage;
    }

    public HomePage getHomePage(){

        return (homePage==null) ? homePage = new HomePage(driver) : homePage;
    }

    public LoginPage getLoginPage(){

        return (loginPage==null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public ProductDetailsPage getDetailsPage(){

        return (detailsPage==null) ? detailsPage = new ProductDetailsPage(driver) : detailsPage;
    }

    public SearchResultPage getSearchResultPage(){

        return (resultPage==null) ? resultPage = new SearchResultPage(driver) : resultPage;
    }
}
