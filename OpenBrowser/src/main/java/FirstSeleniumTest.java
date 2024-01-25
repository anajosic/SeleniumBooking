import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bee-Beep User\\Downloads\\selenium-java-4.16.1 (1)\\chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Launch the browser and navigate to a website
        driver.get("https://www.example.com");

        // Close the browser window
        driver.quit();
    }
}
