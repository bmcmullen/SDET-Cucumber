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

public class LoginSteps {
	WebDriver driver = null;
	String url = "https://sdettraining.litmos.com/";
	String actualPageTitle = "";

	@Given("^A User is on the website$")
	public void a_User_is_on_the_website() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}

	@When("^User types UserName$")
	public void user_types_UserName() throws Throwable {
		driver.findElement(By.id("Username")).sendKeys("brian_h_mcmullen@fanniemae.com");
	}

	@When("^Usertypes Password$")
	public void usertypes_Password() throws Throwable {
		driver.findElement(By.id("Password")).sendKeys("Fannie27!");
	}

	@When("^User clicks on the submit button$")
	public void user_clicks_on_the_submit_button() throws Throwable {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("^User must log in successfully$")
	public void user_must_log_in_successfully() throws Throwable {
		System.out.println("Confirm Welcom Text Greating on Litmos Home");

		String actualValue = driver.findElement(By.xpath("//*[@id=\"learner-dashboard\"]/ul/li/h1")).getText();
		Assert.assertEquals("Welcome, Brian McMullen", actualValue);
		driver.close();
		driver.quit();
	}

}
