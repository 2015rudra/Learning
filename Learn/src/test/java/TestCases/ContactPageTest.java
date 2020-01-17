package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.ContactPage;
import Pages.HomePage;
import Pages.LoginPage;
import Util.TestUtil;

public class ContactPageTest extends TestBase
{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	TestUtil testUtil;
	
	String sheetName = "Contacts";

	public ContactPageTest() 
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		Initilization();
		loginPage = new LoginPage();
		contactPage = new ContactPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnContactPage();
		
	}
	
	
	/*
	 * @DataProvider(name="AddContact") public Object[][] insertDataForAddCustomer()
	 * { return new Object[][] { { "Vivek", "Saraf" }, { "Rupesh", "Kadam" }, {
	 * "Karisma", "Ray" } };
	 * 
	 * }
	 */
	
	@DataProvider
	public Object[][] getTestData() 
	{
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
	}
	
	
//	  @Test public void clickOnAddNewButtonTest() throws InterruptedException 
//	  {
//		  contactPage.clickAddNewContactButton(); 
//	  }
	 
	
	
	
	
	  @Test(dataProvider="getTestData") public void createNewContactTest(String
	  fname, String lname) throws InterruptedException {
	  contactPage.clickAddNewContactButton();
	  contactPage.createNewContact(fname,lname); }
	 
	 
	
	
	  @Test public void getContactCountTest() { contactPage.getContactCount(); }
	 
	
	@Test
	public void deleteAllContactTest() 
	{
		contactPage.deleteAllContacts();
	}
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	

}
