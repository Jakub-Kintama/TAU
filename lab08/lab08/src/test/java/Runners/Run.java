package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/org.example/test1.feature",
        glue = {"org.example"}
)
public class Run extends AbstractTestNGCucumberTests {

}
