package stepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;

    public class Testamplify {
        WebDriver driver;

        @Before
        public void setup() {
            driver = new ChromeDriver(); // initialize driver before scenario
            driver.manage().window().maximize();
        }

        @Given("User is on the landing page")
        public void userIsOnLandingPage() {
            driver.get("https://www.testamplify.com/");
        }

        @When("user click on get started")
        public void clicksgetstarted() {
           driver.findElement(By.xpath("//button[text()='Get started']")).click();
        }
        @Then("User should be redirected to the registration page")
        public void Usershouldberedirectedtotheregistrationpage() {
            String expectedUrl = "https://www.testamplify.com/signup";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait until the URL becomes the expected one
            wait.until(ExpectedConditions.urlToBe(expectedUrl));

            System.out.println("Redirection successful! Current URL: " + driver.getCurrentUrl());
        }
        @And("user enters first name {string}")
        public void userEntersFirstName(String firstName) {
            driver.findElement(By.id("firstname")).sendKeys(firstName);
        }

        @And("user enters last name {string}")
        public void userEntersLastName(String lastName) {
            driver.findElement(By.id("lastname")).sendKeys(lastName);
        }
       @And("User selects country and enters contact number \"8023456789\"")
       public void userselectscountryandenterscontactnumber(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           // 1. Click the flag dropdown (default flag doesn't matter)
           WebElement dropdown = wait.until(
                   ExpectedConditions.elementToBeClickable(By.cssSelector(".selected-flag"))
           );
           dropdown.click();

           // 2. Select the country you want (example: Nigeria)
           wait.until(
                   ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-country-code='ng']"))
           ).click();

           // 3. Enter phone number
           wait.until(ExpectedConditions.visibilityOfElementLocated(
                   By.cssSelector("input[placeholder='Enter your phone number']")
           )).sendKeys("8123456789");}

        @And("user enters email address {string}")
        public void userentersemailaddress(String email) {
            driver.findElement(By.id("email")).sendKeys(email);}
        @And("user enters password {string}")
        public void userEntersPassword(String password) {
            driver.findElement(By.id("password")).sendKeys(password);
        }
        @And("user confirms password {string}")
        public void userConfirmsPassword(String password) {
            driver.findElement(By.id("confirmPassword")).sendKeys(password);
        }
       @And ("user clicks on signup")
       public void Clicksonsignup(){
        driver.findElement(By .xpath("//button[text()='Sign up']")).click();}

        @Then("user should be able to verify email")
        public void usershouldbeabletoverifyemail(){

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe("https://www.testamplify.com/confirm-account"));

            String expectedUrl = "https://www.testamplify.com/confirm-account";
                // Get the current URL from the browser
                String currentUrl = driver.getCurrentUrl();
                // Check if the redirection worked
                if (!currentUrl.equals(expectedUrl)) {
                    throw new AssertionError("Redirection failed! Current URL: " + currentUrl);
                } else {
                    System.out.println("Redirection successful! Current URL: " + currentUrl);
                }
            }
         @And("user should enter otp")
        public void enterOtpFromYopmail() {
                 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

                 // Wait for "You’ve got mail" message to appear
                 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'You’ve got mail')]")));

                 // Open Yopmail in new tab
                 ((JavascriptExecutor) driver).executeScript("window.open();");
                 ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                 driver.switchTo().window(tabs.get(1));
                 driver.get("https://yopmail.com/wm");

                 // Switch to inbox iframe and click latest email
                 driver.switchTo().frame("ifinbox");
                 wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.m"))).click();

                 // Switch to email body iframe and get OTP
                 driver.switchTo().defaultContent();
                 driver.switchTo().frame("ifmail");
                 String emailText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body"))).getText();
                 String otp = emailText.replaceAll("\\D+", "").substring(0, 4); // adjust length if needed
                 System.out.println("OTP fetched: " + otp);

                 // Switch back to main app tab and enter OTP
                 driver.switchTo().window(tabs.get(0));
                 WebElement otpInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("otp"))); // replace with actual OTP field locator
                 otpInput.sendKeys(otp);
                 driver.findElement(By.xpath("//button[text()='Continue']")).click();

                 // Now wait for URL after OTP submission
                 wait.until(ExpectedConditions.urlToBe("https://www.testamplify.com/confirm-account"));
                 System.out.println("OTP verified, redirected to confirm account page!");
             }





         }























