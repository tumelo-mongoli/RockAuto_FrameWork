package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.CacheLookup;



public class LoginPage {
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(id = "Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@class='button-1 login-button']")	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText=" Dashboard")
	@CacheLookup
	WebElement lnkDashboard;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	
	public void setUserName(String uname)
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
		
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
		
	}
	
	public void clickLogin()
	{
		btnLogin.click();
		
	}


	public void clickDashboard()
	{
		lnkDashboard.click();
		
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
		
	}
	
	public void LogoutLink()
	{
		lnkLogout.isDisplayed();
	}

}
