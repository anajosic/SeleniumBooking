package selenium;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.grid.Main;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.time.Duration;
//https://github.com/SeleniumHQ/seleniumhq.github.io/blob/trunk/examples/java/src/test/java/dev/selenium/BaseTest.java
public class BaseTest {
     protected WebDriver driver;
    protected WebDriverWait wait;
    protected File driverPath;
    protected File browserPath;

    public WebElement getLocatedElement(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(d -> driver.findElement(by));
    }

    protected ChromeDriver startChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setImplicitWaitTimeout(Duration.ofSeconds(1));
        return startChromeDriver(options);
    }

    protected ChromeDriver startChromeDriver(ChromeOptions options) {
        driver = new ChromeDriver(options);
        return (ChromeDriver) driver;
    }

    protected URL startStandaloneGrid() {
        int port = PortProber.findFreePort();
        try {
            Main.main(
                    new String[] {
                            "standalone",
                            "--port",
                            String.valueOf(port),
                            "--selenium-manager",
                            "true",
                            "--enable-managed-downloads",
                            "true",
                            "--log-level",
                            "WARNING"
                    });
            return new URL("http://localhost:" + port);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
