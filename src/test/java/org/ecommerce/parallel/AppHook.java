package org.ecommerce.parallel;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.ecommerce.manager.BrowserFactory;
import org.ecommerce.utility.ConfigReader;
import org.ecommerce.utility.ScenarioContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AppHook {

    private BrowserFactory browserFactory;
    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario){

        browserFactory = new BrowserFactory();

        driver = browserFactory.init_driver(ConfigReader.getInstance().getBrowserName());

        ScenarioContext.setContext(scenario);
    }

    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()) {

            String screenshotName = scenario.getName().replaceAll(" ", "_");

            byte[] sourcePath = ((TakesScreenshot) BrowserFactory.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(sourcePath, "image/png", screenshotName);

        }

        driver.quit();
    }
}
