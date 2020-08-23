package com.sf.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.sf.qa.base.TestBase;
import com.sf.qa.pages.HomePage;
import com.sf.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	//creator constructor
	public LoginPageTest()
	{
		super();//props are initialization
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		test.log(LogStatus.PASS, "Browser got closed");
	}
	
	@Test
	public void loginToSF()
	{
		homePage= loginPage.loginTo(prop.getProperty("sfUserName"), prop.getProperty("sfPassword"));
		
		if (driver.getTitle().equalsIgnoreCase("Login | Salesforce")) {
			
			test.log(LogStatus.FAIL,test.addScreenCapture(toTakeScreenshot("SFLoginFailure", driver)), "Wrong credentials for login");
		}
		else {
			
			test.log(LogStatus.PASS, "Landed on homepage");
		}
	}
	
	@BeforeClass
	public void getTestReport()
	{
		test = report.startTest("LoginPageTest");	
	}
	
	@AfterClass
	public void endTestReport()
	{
		report.endTest(test);
	}
}
