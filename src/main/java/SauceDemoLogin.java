import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SauceDemoLogin {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/"); // This means access this website//
// Enter username
        WebElement usernamefield = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernamefield.sendKeys("standard_user");

        // Enter password
        WebElement passwordfield = driver.findElement(By.xpath("//input[@id='password']"));
        passwordfield.sendKeys("secret_sauce");

        // Click login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
//*[@id="user-name"] //*[@id="password"]

        // Find all elements with tag <button>
        //List<WebElement> inputFields = driver.findElements(By.tagName("input"));
       // System.out.println("number of input fields: " + inputFields.size());

        //List<WebElement> buttons = driver.findElements(By.tagName("button"));

// Loop through and print each button's text
        //for (WebElement button : buttons) {
          //  System.out.println("Button text: " + button.getText());





        // locate Element by ID and interact with them

       //WebElement usernameField = driver.findElement(By.cssSelector("#user-name"));
        //WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        //WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));

        // 'send keys' are for input field//

        // login first
        //usernameField. sendKeys("standard_user");
       // passwordField. sendKeys("secret_sauce");
        //loginButton.click();//

     // locate Element by Name and interact with them//
        //WebElement inventoryItem = driver.findElement(By.className("inventory_item"));
        //inventoryItem.click();

        // Find the cart icon by its class name and click on it//
       // WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        //cartIcon.click();

        //click on the burger menu//
        //WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
       //menu.click();
        //WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
        //logout.click();//



        // find inventory image//
       // WebElement inventoryimg = driver.findElement(By.id("item_0_img_link"));
       //inventoryimg.click();//

        //WebElement continuebutton = driver.findElement(By.className("btn btn_secondary back btn_medium"));
        //continuebutton.click();

        //WebElement checkout = driver.findElement(By.id("checkout"));
       // checkout.click();

       // WebElement firstnamefield = driver.findElement(By.id("first-name"));
       // WebElement lastnamefield = driver. findElement(By.id("last-name"));
       // WebElement zipcodefield = driver.findElement(By.id("postal-code"));
       // WebElement continuebuton = driver.findElement(By.id("continue"));

        //firstnamefield.sendKeys("Rebecca");
       //lastnamefield.sendKeys("Oturu");
       //zipcodefield.sendKeys("123456");
       //continuebuton.click();


    }
}


