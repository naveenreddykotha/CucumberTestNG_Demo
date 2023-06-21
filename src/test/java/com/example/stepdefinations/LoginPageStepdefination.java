package com.example.stepdefinations;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageStepdefination {
	
	WebDriver driver;
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Given("User is on HRMLogin page {string}")
	public void user_is_on_hrm_login_page(String url) {
	    driver.get(url);
	}
	
	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[class*='login-button']")).click();
	}
	
	@When("user signup with following details")
	public void user_signup_with_following_details(DataTable dataTable) {
	   List<List<String>> obj= dataTable.asLists();
	   System.out.println(obj.size());
	   System.out.println(obj.get(0).get(0));
	   System.out.println(obj.get(0).get(1));
	   System.out.println(obj.get(0).get(2));
	}
	@Then("User should be able to login sucessfully and new page open")
	public void user_should_be_able_to_login_sucessfully_and_new_page_open() {
	    String heading= driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).getText();
	    Assert.assertEquals(heading, "Dashboard");
	}
	
	@Then("User should be able to see error message {string}")
	public void verifyErrMsg(String errMsg) {
	   String actualMsg= driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
	   Assert.assertEquals(actualMsg, errMsg);
	}
	@After
	public void tearDown() {
		driver.close();
	}

}
