import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class LogInToJira {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Fix for - The path to the driver executable must be set by the webdriver.chrome.driver system property
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\LoginToJira\\chromedriver.exe");
        // Create a new instance of the Chrome driver
        this.driver = new ChromeDriver();
    }


    By userNameInput = By.id("login-form-username");
    By passwordInput = By.id("login-form-password");
    By LoginButton = By.id("login");
    By Useravatar = By.id("header-details-user-fullname");
    String userName = "Victoria_Gornostaeva";
    String password = "Victoria_Gornostaeva";

    @Test
    public void firstTest() throws InterruptedException {
        this.driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
        this.driver.findElement(userNameInput).sendKeys(userName);
        this.driver.findElement(passwordInput).sendKeys(password);
        this.driver.findElement(LoginButton).click();

        Thread.sleep(5000);
        assertTrue(this.driver.findElement(Useravatar).isDisplayed());
    }

    private void clickOnElement(By loginButton) {
        driver.findElement(LoginButton).click();
    }

    @AfterTest
    public void tearDown() {
        // Close the driver
        this.driver.quit();
    };


}





