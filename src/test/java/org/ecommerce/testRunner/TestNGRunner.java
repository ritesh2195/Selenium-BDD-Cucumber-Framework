package org.ecommerce.testRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src//test//resources//parallel"},
        glue = {"org.ecommerce.parallel"},
        tags = "@login"
)
public class TestNGRunner extends AbstractTestNGCucumberTests {


}
