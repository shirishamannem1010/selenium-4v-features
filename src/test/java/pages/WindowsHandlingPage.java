package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WindowsHandlingPage {

	WebDriver driver;
	
	public WindowsHandlingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	By tabsBtn=By.xpath("//a[text()='Tabs']");
	By openHomePage=By.id("home");
	By multipleWindowsBtn=By.id("multi");
	
	public void navigateToWindowsPage() {
		driver.findElement(tabsBtn).click();
	}
	public void openHomePage() {
		driver.findElement(openHomePage).click();
	}
	public void handleMultipleWindows() {
		driver.findElement(multipleWindowsBtn).click();
	}
}
