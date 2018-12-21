package com.FMCucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class InvalidLoginDDT {
	WebDriver driver = null;
	String url = "https://sdettraining.litmos.com/";
	String actualPageTitle = "";

	@Given("^A User is on the Login Page$")
	public void a_User_is_on_the_Login_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}

	@When("^User enters an invalid \"([^\"]*)\"$")
	public void user_enters_an_invalid(String username) throws Throwable {
		driver.findElement(By.id("Username")).sendKeys(username);
	}

	@When("^enters an invalid \"([^\"]*)\"$")
	public void enters_an_invalid(String password) throws Throwable {
		driver.findElement(By.id("Password")).sendKeys(password);
	}

	@When("^User clicks on the Sign in button$")
	public void user_clicks_on_the_Sign_in_button() throws Throwable {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("^User must not be able to log in to the application$")
	public void user_must_not_be_able_to_log_in_to_the_application() throws Throwable {
		System.out.println("Confirm Login Failed.");
		String actualValue = driver.findElement(By.xpath("//*[@id=\"loginContainer\"]/div/div[1]")).getText();
		Assert.assertEquals("Login failed, please try again", actualValue);
		driver.close();
		driver.quit();
	}
}
