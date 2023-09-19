package org.ecommerce.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private HeaderPage headerPage;

    public HomePage(WebDriver driver){

        super(driver);

        this.headerPage = new HeaderPage(driver);
    }

    public HeaderPage getHeaderPage(){

        return new HeaderPage(driver);
    }
}
