package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;

public class LoginPageTest extends TestBase
{

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() 
	{
		super();
	}

	@BeforeMethod
	public void setUp() 
	{
		Initilization();
		loginPage = new LoginPage();
	}



	@Test(priority=1) public void loginPageTitleTest() 
	{ 
		String pageTitle = loginPage.validatePageTitle(); Assert.assertEquals(pageTitle,"Cogmento CRM");
	}

	@Test(priority=2) public void verifyImage() 
	{ 
		boolean forPassLink = loginPage.validateForgotPasswordLink(); Assert.assertTrue(forPassLink,"Link not present"); 
	}


	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}


	@AfterMethod
	public void cleanUp() 
	{
		driver.quit();
	}

}
