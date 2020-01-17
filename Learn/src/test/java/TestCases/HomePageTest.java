package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;

public class HomePageTest extends TestBase
{
	
	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() 
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		Initilization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void clickContactLinkTest() throws InterruptedException 
	{
		homePage.clickOnContactPage();
	}
	
	
	@AfterMethod
	public void cleanUp() 
	{
		driver.quit();
	}
}
