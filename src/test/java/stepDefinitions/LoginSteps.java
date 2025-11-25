package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    WebDriver driver;

    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enters valid username and password")
    public void userEntersValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User clicks the login button")
    public void userClicksLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User should be redirected to the home page")
    public void userShouldBeRedirectedToProductsPage() {
        boolean isProductsDisplayed = driver.findElement(By.className("title")).isDisplayed();
        assert isProductsDisplayed;
        driver.quit();
    }
}