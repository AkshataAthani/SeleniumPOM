package com.sf.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.sf.qa.base.TestBase;
import com.sf.qa.pages.AccountsPage;
import com.sf.qa.pages.HomePage;
import com.sf.qa.pages.LoginPage;
import com.sf.qa.pages.NewAccCreatedPage;
import com.sf.qa.pages.NewAccountPage;
import com.sf.qa.util.ReadExcel;

public class NewAccountPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	AccountsPage accountsPage;
	NewAccountPage newAccountsPage;
	NewAccCreatedPage newAccCreatedPage;

	public NewAccountPageTest()
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
		newAccountsPage= accountsPage.clickOnNewAccount();
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		test.log(LogStatus.PASS, "Browser got closed");
		report.endTest(test);
		report.flush();
	}
	
	@DataProvider
	public String[][] getAccountDetails() throws InvalidFormatException, IOException
	{
		ReadExcel readData = new ReadExcel();
		return readData.getCellData("C:\\Users\\athan\\eclipse-workspace\\DemoPOMFramework\\Resources\\AccountDetails.xlsx", "AccountDetails");
	}

	@Test(dataProvider = "getAccountDetails")
	public void fillNewAccountInfo(String phone, String name, String billingState)
	{
		newAccCreatedPage= newAccountsPage.fillNewAccount(phone, name, billingState);
		if (newAccCreatedPage.getDetails() == true) 
		{
			test.log(LogStatus.PASS, "Landed on Newely Created Account Page");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(toTakeScreenshot("SFNewAccountCreationFailure", driver)), "New account creation failed");
		}
	}
	@BeforeClass
	public void getTestReport()
	{
		test = report.startTest("NewAccountPageTest");	
	}

	@AfterClass
	public void endTestReport()
	{
		report.endTest(test);
	}
}
