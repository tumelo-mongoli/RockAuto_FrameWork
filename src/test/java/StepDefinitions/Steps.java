package StepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.LoginPage;
import io.cucumber.java.en.*;

public class Steps {
	
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("User Launch chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver =new ChromeDriver();
		
		lp=new LoginPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);

	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		lp.setUserName(email);
		lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		
		lp.clickLogin();
		Thread.sleep(1000);
		if (driver.getPageSource().contains("Your store. Login")) 
		{
			lp.clickLogin();
			Assert.assertTrue(false);
		}
		else 
		{
			lp.clickDashboard();
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
	}

	/*
	 * @Then("Then There should be a Log out link ") public void
	 * page_should_have_link() throws InterruptedException {
	 * 
	 * if (driver.getPageSource().contains("Login was unsuccessful")) {
	 * driver.close(); Assert.assertTrue(false); } else {
	 * Assert.assertTrue(driver.getPageSource().contains("Logout"));
	 * //Assert.assertEquals(lp.LogoutLink(), driver); }
	 * 
	 * Thread.sleep(3000); }
	 */
	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		lp.clickLogout();

	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();

	}

}
