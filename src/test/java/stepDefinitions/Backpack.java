package stepDefinitions;

import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Map;
import java.util.HashMap;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class Backpack {
    WebDriver driver;

    @Given("browser is open for backpack test")
    @When("user is on the page")
    public void userIsOnthePage() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");

    }
    @And("user enters the username")
        public void userEntersValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }
    @And("user enters the password")
       public void userEntersPassword () {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    @And("user clicks the login button")
      public void userClicksLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should see all products")
    public void userShouldSeeAllProducts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        WebElement confirmText = driver.findElement(By.className("title"));
        boolean isDisplayed = confirmText.isDisplayed();
        assert isDisplayed;}

    @And ("user selects item backpack")
    public void userselectsitembackpack() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")). click();}

    @And ("user clicks shopping cart")
    public void userclicksshoppingcart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement verifytext = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        boolean isDisplayed = verifytext.isDisplayed();
        assert isDisplayed;
    }
    @Then ("user clicks on checkout")
    public void userclicksoncheckout ()  {
     driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    WebElement viewtext =driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
    boolean isdisplayed = viewtext.isDisplayed(); assert isdisplayed;
    }

    @And("user enters First Name")
    public void userentersFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Rebecca");
    }
    @And ("user enters Last Name")
        public void userenterslastName() {
        driver.findElement(By.id("last-name")).sendKeys("oturu");
    }
    @And("user enters Postal Code")
    public void userentersPostalCode (){
        driver.findElement(By.id("postal-code")).sendKeys("Dab56");
    }

    @And ("user clicks continue")
       public  void userclickscontinue () {
        driver.findElement(By.id("continue")).click();
    }
    @And ("user clicks finish")
    public void  userclicksfinish () {
      driver.findElement(By.id("finish")). click();


















    }











}

/*
        @Then("User should be redirected to the registration page")
        public void Usershouldberedirectedtotheregistrationpage() {
            String expectedUrl = "https://www.testamplify.com/signup";
            // Get the current URL from the browser
            String currentUrl = driver.getCurrentUrl();
            // Check if the redirection worked
            if (!currentUrl.equals(expectedUrl)) {
                throw new AssertionError("Redirection failed! Current URL: " + currentUrl);
            } else {
                System.out.println("Redirection successful! Current URL: " + currentUrl);
            }
        }

        @When("user goes back to the landing page")
        public void goBackToLandingPage(){
            driver.get("https://www.testamplify.com/"); // direct navigation
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Start here']")));
            System.out.println("Navigated back to landing page ✅");


        @Then("user should be back on the landing page")
        public void usershouldbebackonthelandingpage() {
            WebElement startButton = driver.findElement(By.xpath("//button[text()='Start here']"));
            if (startButton.isDisplayed()) {
                System.out.println("Landing page loaded successfully ✅");
            } else {
                System.out.println("Landing page did NOT load ❌");
            }
*/
