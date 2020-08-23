package com.sf.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.sf.qa.base.TestBase;
import com.sf.qa.pages.AccountsPage;
import com.sf.qa.pages.ContactsPage;
import com.sf.qa.pages.HomePage;
import com.sf.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	AccountsPage accountsPage;
	ContactsPage contactsPage;

	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		homePage= loginPage.loginTo(prop.getProperty("sfUserName"), prop.getProperty("sfPassword"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		test.log(LogStatus.PASS, "Browser got closed");
	}
	
	@Test(priority = 1)
	public void clickOnAccounts()
	{
		accountsPage= homePage.clickOnAccounts();
		
		System.out.println(accountsPage.getTitleForAccounts());
		
		if (accountsPage.getTitleForAccounts().contains("Accounts")) {
			test.log(LogStatus.PASS, "Landed on Accounts Page");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(toTakeScreenshot("SFLandAccountPageFaliure", driver)), "Landing on accounts page failed");
		}
		
	}
	
//	@Test(priority = 2)
//	public void clickOnContacts()
//	{
//		contactsPage= homePage.clickOnContacts();
//		
//	}
	
	@BeforeClass
	public void getTestReport()
	{
		test = report.startTest("HomePageTest");	
	}
	
	@AfterClass
	public void endTestReport()
	{
		report.endTest(test);
	}
}
