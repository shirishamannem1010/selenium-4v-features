package stepdefinations;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WindowsHandlingPage;

public class WindowsHandlingStep {

	WebDriver driver = Setup.driver; 
    WindowsHandlingPage windowsPage = new WindowsHandlingPage(driver);

    @When("Navigate to Windows handling page")
    public void navigateToWindowsPage() {
        windowsPage.navigateToWindowsPage();
    }

    @Then("Open Home page Window, switch, and close windows")
    public void openHomePageAndCloseWindows() {
        // Save the current window handle (parent window)
        String parentWindow = driver.getWindowHandle();

        // Open the home page (new window)
        windowsPage.openHomePage();

        // Wait for all windows to open and get window handles
        Set<String> allWindows = driver.getWindowHandles();

        // Switch to the newly opened tab (which is not the parent window)
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Print the title of the new window/tab
        System.out.println("Child Window Title: " + driver.getTitle());
        // Perform operations in both windows before closing them
        // Switch back to parent window to complete operations
        driver.switchTo().window(parentWindow);
        // Close all windows at the end
        for (String windowHandle : allWindows) {
            driver.switchTo().window(windowHandle);
            System.out.println("completed open home page in windows handling");
            driver.close();
        }
    }

    @Then("Handle Multiple Windows and close all windows")
    public void handleMultipleWindowsAndClose() {
        // Step 1: Click on the "Multiple Windows" button
    	
    	 Setup.driver.get("https://letcode.in/test");
    	 windowsPage.navigateToWindowsPage();
        windowsPage.handleMultipleWindows();
        System.out.println("handling mutliple window functions");
        // Step 2: Wait for all windows to open and get all window handles
        Set<String> allWindows = driver.getWindowHandles();

        // Step 3: Print the titles of all windows
        for (String windowHandle : allWindows) {
            driver.switchTo().window(windowHandle);
            System.out.println("Window Title: " + driver.getTitle());
        }

        // Step 4: Close all windows
        for (String windowHandle : allWindows) {
            driver.switchTo().window(windowHandle);
            System.out.println("before closing all the windows in multi windows");
            driver.close();
        }
    }
}