package org.example;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Steps {
    private final WebDriver driver = new ChromeDriver();

    @Given("the user is on page")
    public void the_user_is_on_page() {
        driver.get("https://www.saucedemo.com");
    }
    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        WebElement temp = driver.findElement(By.id("user-name"));
        temp.click();
        temp.sendKeys("standard_user");

        temp = driver.findElement(By.id("password"));
        temp.click();
        temp.sendKeys("secret_sauce");
    }
    @When("hits submit")
    public void hits_submit() {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        boolean good = true;
        try {
            driver.findElement(By.id("inventory_container"));
        }catch (Exception e) {
            good = false;
        }
        Assert.assertTrue(good);
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
