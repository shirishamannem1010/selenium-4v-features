package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputFieldPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Updated locators using By API
    private By editBtnLocator = By.xpath("//a[text()='Edit']");
    private By fullNameLocator = By.id("fullName");
    private By textLocator = By.id("join");
    private By appendTextLocator = By.id("getMe");
    private By readOnlyLocator = By.id("dontwrite");

    public InputFieldPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void inputFieldsPage() {
        WebElement editBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(editBtnLocator));
        editBtn.click();
        System.out.println("Button clicked: " + editBtn);
    }

    public void fullName() {
        WebElement fullNameField = driver.findElement(fullNameLocator);
        fullNameField.sendKeys("ShirishaMannem");
    }

    public void clearText() {
        WebElement textField = driver.findElement(textLocator);
        textField.clear();
        
        // Selenium 4's Duration-based timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        textField.sendKeys("I'm fantastic");

        WebElement appendTextField = driver.findElement(appendTextLocator);
        appendTextField.sendKeys(" I'm adding new text to existing text");

        String currentText = appendTextField.getAttribute("value");
        System.out.println("Input field value: " + currentText);

        WebElement readOnlyField = driver.findElement(readOnlyLocator);
        System.out.println("It is for readonly: " + !readOnlyField.isEnabled());
    }
}
