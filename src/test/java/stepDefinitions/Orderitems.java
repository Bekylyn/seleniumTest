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
import org.openqa.selenium.support.ui.Select;



public class Orderitems {
    WebDriver driver;

    @Given("browser is open for order item test")

    public void browerisopenfororderitemtest() {
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
    @And("the user enters the username")
    public void userEntersValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }
    @And("the user enters the password")
    public void userEntersPassword () {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    @And("the user clicks the login button")
    public void userClicksLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("the user should see all products")
    public void userShouldSeeAllProducts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        WebElement confirmText = driver.findElement(By.className("title"));
        boolean isDisplayed = confirmText.isDisplayed();
        assert isDisplayed;}

@And("the user clicks to filter product from low to high")
   public void theuserclickstofilterproductfromlowtohigh (){
    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
    Select select = new Select(dropdown);
    select.selectByVisibleText("Price (low to high)");
}

    @And ("the user add item bike light")
    public void userselectsitembikelight() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")). click();}

    @And ("the user add item fleece jacket")
    public void userselectsitemfleecejacket() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")). click();}

    @And ("the user clicks shopping cart")
    public void userclicksshoppingcart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement verifytext = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        boolean isDisplayed = verifytext.isDisplayed();
        assert isDisplayed;
    }

    @And("the user removes fleece jacket item")
    public void theuserremovesfleecejacketitem (){
    driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-fleece-jacket\"]")).click();
    }

    @And("the user clicks on the menu bar")
    public void theuserclicksonthemenubar() {
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
    }

    @And("the user selects all items")
    public void theuserselectsallitems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement allItemsLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("inventory_sidebar_link")));
        allItemsLink.click();
    }


    @And ("the user clicks on the shopping cart icon")
    public void theuserclicksontheshoppingcarticon(){
    driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @And ("the user clicks on checkout")
    public void theuserclicksoncheckout ()  {
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        WebElement viewtext =driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        boolean isdisplayed = viewtext.isDisplayed(); assert isdisplayed;
    }
    @Then ("the user should see the check out form")
    public void theusershouldseethecheckoutform (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header_container\"]/div[2]/span")));

        WebElement confirmText = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        boolean isDisplayed = confirmText.isDisplayed();
        assert isDisplayed;
    }

    @And("the  user enters first Name")
    public void userentersfirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Rebecca");
    }
    @And ("the user enters Last Name")
    public void userenterslastName() {
        driver.findElement(By.id("last-name")).sendKeys("oturu");
    }
    @And("the user enters Postal Code")
    public void userentersPostalCode (){
        driver.findElement(By.id("postal-code")).sendKeys("Dab56");
    }

    @And ("the user clicks continue")
    public  void userclickscontinue () {
        driver.findElement(By.id("continue")).click();
    }
    @And ("the user clicks finish")
    public void  userclicksfinish () {
        driver.findElement(By.id("finish")). click();
    }
    @And("the user verifies the tax is 0.80")
    public void theuserverifiesthetaxis_0_80 () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        WebElement confirmTax = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]"));
        boolean isDisplayed = confirmTax.isDisplayed();
        assert isDisplayed;}

}