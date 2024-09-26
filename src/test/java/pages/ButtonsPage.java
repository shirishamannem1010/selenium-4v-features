package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.locators.RelativeLocator;
import java.time.Duration;
public class ButtonsPage {
    WebDriver driver;

    @FindBy(xpath = "//a[text()='Click']")
    WebElement clickBtn;

    @FindBy(id = "home")
    WebElement gotoHome;

    @FindBy(xpath = "//a[text()='New Course!']")
    WebElement newCourse;

    @FindBy(xpath = "(//a[text()='Enroll to the free course'])[2]")
    WebElement enrollNew;

    @FindBy(id = "position")
    WebElement findLocation;

    @FindBy(id = "color")
    WebElement findBtnColor;

    @FindBy(id = "property")
    WebElement findPropertyBtn;

    @FindBy(id = "isDisabled")
    WebElement btnisDisable;

    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Opens the Buttons page
    public void buttonPage() {
    	System.out.println("entered to buttonspage");
        this.clickBtn.click();
        System.out.println("---------Buttons page opened--------");
    }

    // Navigates to another page and returns the original URL
    public NavigatingBrowser gotoButton() {
        String originalUrl = driver.getCurrentUrl();
        this.gotoHome.click();
        this.newCourse.click();
        return new NavigatingBrowser(driver, originalUrl);
    }

    // Finds the position of the button using explicit wait with Selenium 4's Duration
    public void locationBtn() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("=================Current URL: " + currentUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("position")));

        // Get the coordinates
        int xCoordinate = element.getLocation().getX();
        int yCoordinate = element.getLocation().getY();

        System.out.println("X coordinate : " + xCoordinate);
        System.out.println("Y coordinate : " + yCoordinate);
    }

    // Retrieves the color of the button
    public void colorBtn() {
        String buttonColor = findBtnColor.getCssValue("background-color");
        System.out.println("Button Color: " + buttonColor);
    }

    public void useRelativeLocators() {
        // Find an element near another element
        WebElement nearbyElement = driver.findElement(
            RelativeLocator.with(By.tagName("button")).near(findBtnColor)
        );
        nearbyElement.click();  
        WebElement rightOfElement = driver.findElement(
            RelativeLocator.with(By.tagName("button")).toRightOf(findLocation)
        );
        rightOfElement.click();
    }
}
