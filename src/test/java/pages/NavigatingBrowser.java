package pages;

import org.openqa.selenium.WebDriver;

public class NavigatingBrowser {
    private final WebDriver driver;
    private final String originalUrl;

    public NavigatingBrowser(WebDriver driver, String originalUrl) {
        this.driver = driver;
        this.originalUrl = originalUrl;
    }
    public String getOriginalUrl() {
        return originalUrl;
    }
    public void navigateBack() {
        driver.navigate().to(originalUrl);
    }

    // You can add more methods as needed
}
