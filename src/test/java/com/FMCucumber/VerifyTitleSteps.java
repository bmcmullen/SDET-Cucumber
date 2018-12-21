package com.FMCucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class VerifyTitleSteps {
	WebDriver driver = null;
	String url = "https://www.facebook.com/";
	String actualPageTitle = "";
	
	@Given("^User is on the langing page$")
	public void user_is_on_the_langing_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}

	@When("^User checks the title$")
	public void user_checks_the_title() throws Throwable {
		actualPageTitle = driver.getTitle();
		System.out.println("Page Title: " + actualPageTitle);
	}

	@Then("^It must say \"([^\"]*)\"$")
	public void it_must_say(String expectedPageTitle) throws Throwable {
		Assert.assertEquals(expectedPageTitle, actualPageTitle);
		driver.close();
		driver.quit();		
	}
}
