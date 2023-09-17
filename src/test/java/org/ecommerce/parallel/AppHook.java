package org.ecommerce.parallel;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.ecommerce.utilities.BrowserFactory;
import org.ecommerce.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;

public class AppHook {

    private BrowserFactory browserFactory;
    private WebDriver driver;

    @Before("@login")
    public void setUp(){

        browserFactory = new BrowserFactory();

        driver = browserFactory.init_driver(ConfigReader.getInstance().getBrowserName());
    }

    @After("@login")
    public void tearDown(){

        driver.quit();
    }
}
