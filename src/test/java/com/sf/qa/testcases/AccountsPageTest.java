package com.sf.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.sf.qa.base.TestBase;
import com.sf.qa.pages.AccountsPage;
import com.sf.qa.pages.HomePage;
import com.sf.qa.pages.LoginPage;
import com.sf.qa.pages.NewAccountPage;

public class AccountsPageTest extends TestBase{
	//test
	LoginPage loginPage;
	HomePage homePage;
	AccountsPage accountsPage;
	NewAccountPage newAccountsPage;
	
	public AccountsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		homePage= loginPage.loginTo(prop.getProperty("sfUserName"), prop.getProperty("sfPassword"));
		accountsPage= homePage.clickOnAccounts();
	}
	
	@Test
	public void clickOnNewAccount()
	{
		newAccountsPage= accountsPage.clickOnNewAccount();
		if (newAccountsPage.getHeader()== true)
		{
			test.log(LogStatus.PASS, "Landed on New Accounts Page");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(toTakeScreenshot("SFLandNewAccountPageFaliure", driver)), "Landing on new accounts page failed");
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		test.log(LogStatus.PASS, "Browser got closed");
		report.endTest(test);
		report.flush();
	}
	
	@BeforeClass
	public void getTestReport()
	{
		test = report.startTest("AccountsPageTest");	
	}
	
	@AfterClass
	public void endTestReport()
	{
		report.endTest(test);
	}

}
