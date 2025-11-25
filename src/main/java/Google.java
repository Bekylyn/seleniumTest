
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
    public static void main(String[] args) {
        // 1. Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // 2. Navigate to Google
        driver.get("https://www.google.com");

        // 3. Locate the search input field by its name attribute
        WebElement searchField = driver.findElement(By.id("APjFqb"));

        // 4. Enter the search term
        searchField.sendKeys("Selenium WebDriver");

        // 5. Submit the search form
        searchField.submit();

        // 6. Verify that the search results page is displayed
        String title = driver.getTitle();
        if (title.contains("Selenium WebDriver")) {
            System.out.println("Test Passed ✅");
        } else {
            System.out.println("Test Failed ❌");
        }

        // 7. Close the browser
        driver.quit();
    }
}











