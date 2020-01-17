package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Util.TestUtil;

public class HomePage extends TestBase 
{

	@FindBy(xpath="//span[@class='user-display']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[contains(@href,'contact')]")
	WebElement contactLink;
	
	
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public ContactPage clickOnContactPage() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Thread.sleep(5000);
		contactLink.click();
		Thread.sleep(15000);
		return new ContactPage();
	}
	
}
