package testrunners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinations"},
        plugin = {    "pretty",
                 "html:target/cucumber-html-report/cucumber.html",     
                 "json:target/cucumber-report/cucumber.json"},
        monochrome = true
)
public class RunCucumberTest {

}
