package stepdefinations;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Setup {
    static WebDriver driver;
    @Before
    public void browserSetUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:/Program Files/Google/Chrome/Application/chrome.exe");
        chromeOptions.addArguments("--remote-debugging-port=61358");
        chromeOptions.addArguments("--whitelisted-ips=");
        chromeOptions.addArguments("--disable-gpu");
        // Initialize ChromeDriver
        driver = new ChromeDriver(chromeOptions);
        System.out.println("Browser Launched successfully==========");

        //Selenium 4's `Duration` for timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();  
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully==========");
        }
    }
}