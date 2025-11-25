import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Facebook {
    public static void main(String[] args) {
        // 1. Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // 2. Navigate to Facebook login page
        driver.get("https://www.facebook.com/login");

        // 3. Locate the email input field by its ID attribute
        WebElement emailField = driver.findElement(By.id("email"));

        // 4. Locate the password input field by its ID attribute
        WebElement passwordField = driver.findElement(By.id("pass"));

        // 5. Locate the login button by its name attribute
        WebElement loginButton = driver.findElement(By.name("login"));

        // 6. Enter the email
        emailField.sendKeys("08147728906");

        // 7. Enter the password
        passwordField.sendKeys("Becky@24");

        // 8. Click the login button
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 9. Locate the error message by its CSS selector
        WebElement errorMessage = driver.findElement(By.cssSelector("div._9ay7"));

        // 10. Print the error message displayed
        System.out.println("Error Message: " + errorMessage.getText());

        // 11. Close the browser
        driver.quit();
    }
}