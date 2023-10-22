package saucedemo.cucumber.stepDef;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.invoke.StringConcatFactory;
import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl ="https://www.saucedemo.com/";

    @Given("Halaman login Sauce Demo")
    public void halaman_login_sauce_demo(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // set timeout for web on waiting element
        driver.manage().window().maximize(); // mazimeze window
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
    }

    @When("Input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.className("submit-button")).click();
    }

    @Then("User in on dashboard page")
    public void userInOnDashboardPage() {
        driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String DashboardPage = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals(DashboardPage,"Products");
        driver.close();
    }

    @And("Input Invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("12345");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String ErrorLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(ErrorLogin,"Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

    @Given("Catalog Sauce Demo")
    public void catalogSauceDemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // set timeout for web on waiting element
        driver.manage().window().maximize(); // mazimeze window
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");

        //input email
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click login
        driver.findElement(By.className("submit-button")).click();
    }

    @When("User add product to cart")
    public void user_add_product_to_cart() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }

    @Then("Product added to cart")
    public void product_added_to_cart() {
        String ErrorLogin = driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).getText();
        Assert.assertEquals(ErrorLogin,"Remove");
        driver.close();
    }


}
