package stepdefinations;
import pages.ButtonsPage;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.NavigatingBrowser;

public class ButtonsStep {
	 WebDriver driver = Setup.driver;
	    ButtonsPage buttonspage =new ButtonsPage(driver);
	    NavigatingBrowser navigatingBrowser;

	    @When("click on buttons page")
	    public void click_on_buttons_page() {
	       try {
	            buttonspage.buttonPage(); 
	            System.out.println("Clicked on buttons page.");
	        } catch (Exception e) {
	            System.err.println("Failed to click on buttons page: " + e.getMessage());
	        }
	    }

	    @And("click on goto button")
	    public void click_on_goto_button() {
	        try {
	            navigatingBrowser = buttonspage.gotoButton(); 
	            System.out.println("Clicked on goto button.");
	        } catch (Exception e) {
	            System.err.println("Failed to click on goto button: " + e.getMessage());
	        }
	    }

	    @And("find the location of button")
	    public void find_the_location_of_button() {
	        try {
	            navigatingBrowser.navigateBack();  
	            buttonspage.locationBtn();  
	            System.out.println("Found the button location coordinates.");
	        } catch (Exception e) {
	            System.err.println("Failed to find the button location: " + e.getMessage());
	        }
	    }

	    @And("find the button color")
	    public void fine_the_button_color() {
	        try {
	            buttonspage.colorBtn();  
	            System.out.println("Button color found.");
	        } catch (Exception e) {
	            System.err.println("Failed to find button color: " + e.getMessage());
	        }
	        System.out.println("Completed the buttons operations.");
	    }
}
