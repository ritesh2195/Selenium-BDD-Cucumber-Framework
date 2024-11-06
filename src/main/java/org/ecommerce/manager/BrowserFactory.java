package org.ecommerce.manager;

import org.ecommerce.utility.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {


    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the thradlocal driver on the basis of given
     * browser
     *
     * @param browser
     * @return this will return tldriver.
     */
    public WebDriver init_driver(String browser) {

        if (browser.equals("chrome")) {

            tlDriver.set(new ChromeDriver());

        } else if (browser.equals("firefox")) {

            tlDriver.set(new FirefoxDriver());

        } else if (browser.equals("safari")) {

            tlDriver.set(new SafariDriver());

        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();

        getDriver().manage().window().maximize();

        getDriver().get(ConfigReader.getInstance().getURL());
        try {

            Thread.sleep(2000);

            getDriver().navigate().refresh();

        }catch (Exception e){

            e.printStackTrace();
        }
        return getDriver();

    }

    /**
     * this is used to get the driver with ThreadLocal
     *
     * @return
     */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
