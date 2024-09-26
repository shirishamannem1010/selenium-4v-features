package pages;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.RequestId;
import org.openqa.selenium.chrome.ChromeDriver;
public class chromeCDPPage {
    private WebDriver driver;
    private DevTools devTools;

    public chromeCDPPage(WebDriver driver) {
        this.driver = driver;
        this.devTools = ((ChromeDriver) driver).getDevTools();
        this.devTools.createSession();
    }

    public void enableNetworkMonitoring() {
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
    }

    public void captureNetworkRequests() {
        AtomicReference<RequestId> capturedRequestId = new AtomicReference<>();
        devTools.addListener(Network.requestWillBeSent(), request -> {
            System.out.println("Intercepted request URL: " + request.getRequest().getUrl());
            capturedRequestId.set(request.getRequestId());
        });
    }

    public void setNetworkConditions() {
        devTools.send(Network.emulateNetworkConditions(
                false,
                100,  // Latency in ms
                20000, // Download speed (bytes/s)
                10000, // Upload speed (bytes/s)
                Optional.of(org.openqa.selenium.devtools.v85.network.model.ConnectionType.CELLULAR3G)
        ));
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
