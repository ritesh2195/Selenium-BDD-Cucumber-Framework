package org.ecommerce.testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/resources/parallel"},
        glue = {"org.ecommerce.parallel"},
        tags = "@login"
)
public class JunitRunnerTest {


}
