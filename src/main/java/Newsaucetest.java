
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Newsaucetest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // Navigate to the site
        driver.get("https://www.saucedemo.com/");
        // Set a global implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Locate and interact with elements
        WebElement usernamefield = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernamefield.sendKeys("standard_user");

        WebElement passwordfield = driver.findElement(By.xpath("//input[@id='password']"));
        passwordfield.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
// Explicit wait for Products page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productsTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("title"))
        );
        System.out.println("Page loaded: " + productsTitle.getText());

        // Fluent wait for shopping cart
       Wait<WebDriver> fluentWait = new FluentWait<>(driver)
               .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement cartIcon = fluentWait.until(d ->
                d.findElement(By.className("shopping_cart_link"))
        );
        cartIcon.click();

         //Close browser
        //driver.quit();
    }
}
