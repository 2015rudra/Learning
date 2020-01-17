package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Util.TestUtil;

public class ContactPage extends TestBase
{


	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContactButton;


	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;

	@FindBy(xpath="//input[@name='last_name']")
	WebElement lasttName;

	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveButton;

	@FindBy(xpath="//tbody//tr[1]//button[@class='ui icon inverted button']")
	WebElement deleteContactButton;

	@FindBy(xpath="//div[@class='actions']//button[@class='ui button']")
	WebElement deleteContactConfirmButton;


	TestUtil testutil;
	JavascriptExecutor js;


	public ContactPage() 
	{
		PageFactory.initElements(driver, this);
		testutil = new TestUtil();
		js = (JavascriptExecutor)driver;
	}


	public void clickAddNewContactButton() throws InterruptedException 
	{
		TestUtil.waitForAnObject(driver, newContactButton, 10);
		newContactButton.click();
		Thread.sleep(5000);
	}



	public void createNewContact(String fname, String lname ) throws InterruptedException 
	{
		TestUtil.waitForAnObject(driver, firstName, 10);
		firstName.sendKeys(fname);
		lasttName.sendKeys(lname);		
		js.executeScript("arguments[0].click();", saveButton);
		Thread.sleep(7000);
	}

	public int getContactCount() 
	{
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='ui celled sortable striped table custom-grid table-scroll']//tbody//tr"));
		int a = list.size();
		System.out.println(a);
		return a;
	}

	public void deleteAllContacts() 
	{

		int totalCount = getContactCount();

		for(int i=0; i<=totalCount; i--) 
		{
			TestUtil.waitForAnObject(driver, deleteContactButton, 10);
			if(deleteContactButton.isDisplayed() && deleteContactButton.isEnabled()) 
			{
				deleteContactButton.click();
				deleteContactConfirmButton.click();
			}
			else 
			{
				System.out.println("Deleted all Contacts");
			}
		}
	}



}
