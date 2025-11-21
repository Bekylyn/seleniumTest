package stepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
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

        @When("user sees the start here button")
        public void startherebuttonisvisible() {
           driver.findElement(By.xpath("//button[text()='Start here']")).click();
        }

        @When("user clicks on see how it works button")
        public void userclicksonseehowitworksbutton() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'See How It Works')]"))).click();
            System.out.println("Clicked on 'See How It Works' button ✅");
        }

        @Then("video pop up should appear")
        public void videoPopupShouldAppear() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Wait for the popup to be visible and store it
            WebElement videoPopup = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='movie_player']/div[5]/div"))
            );

            // Now you can interact with it
            if (videoPopup.isDisplayed()) {
                System.out.println("Video popup is visible ✅");
            } else {
                System.out.println("Video popup is NOT visible ❌");
            }
        }


















        }




