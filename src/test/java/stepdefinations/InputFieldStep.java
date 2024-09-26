package stepdefinations;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.InputFieldPage;

public class InputFieldStep {
	WebDriver driver=Setup.driver;
	InputFieldPage inputFieldPage= new InputFieldPage(driver);
	
	@Given("Navigate to letcode application")
	public  void navigate_to_letcode_application() {
		 System.out.println("let code opened successfully==========");
		 Setup.driver.get("https://letcode.in/test");
		 Setup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@And("Navigate to Input field page")
	public void navigate_to_input_field_page() {
		inputFieldPage.inputFieldsPage();
		Setup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	}
	@When("Enter the details in input fields")
	public void enter_the_details_in_input_fields() {
		inputFieldPage.fullName();
		Setup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		inputFieldPage.clearText();
	}
	
}
