package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Util.TestUtil;

public class LoginPage extends TestBase 
{

	
	//Page Factory
	
	@FindBy(name="email")
	WebElement username;
	
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement forgotPassLink;
	
	
	public LoginPage() 
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String validatePageTitle() 
	{
		return driver.getTitle();
	}
	
	public boolean validateForgotPasswordLink()
	{
		return forgotPassLink.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		username.sendKeys(un);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		password.sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		loginButton.click();
		Thread.sleep(10000);
		return new HomePage();
		
	}
	
	
}
