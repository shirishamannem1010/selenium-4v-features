package stepdefinations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.chromeCDPPage;

public class chromeCDPStep {
	    private WebDriver driver;
	    private chromeCDPPage chromeCDPPage;

	    @Given("I launch the browser")
	    public void iLaunchTheBrowser() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        chromeCDPPage = new chromeCDPPage(driver);
	    }

	    @When("I enable network monitoring")
	    public void iEnableNetworkMonitoring() {
	        chromeCDPPage.enableNetworkMonitoring();
	    }

	    @Then("I should capture the network requests")
	    public void iShouldCaptureTheNetworkRequests() {
	        chromeCDPPage.captureNetworkRequests();
	    }
}