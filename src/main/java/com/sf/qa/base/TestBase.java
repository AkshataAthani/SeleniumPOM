package com.sf.qa.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sf.qa.common.CommonUtil;
import com.sf.qa.util.TestUtil;

public class TestBase extends CommonUtil{

	public static WebDriver driver;
	public static Properties prop;
	public static ChromeOptions options;
	public static JavascriptExecutor jse;
	public static ExtentTest test;
	public static ExtentReports report;
	
	public TestBase() 
	{
		prop= new Properties();
		FileReader reader = null;
		try {
			reader = new FileReader("C:\\Users\\athan\\eclipse-workspace\\DemoPOMFramework\\Resources\\config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initialization()
	{
		String drivername = prop.getProperty("browser");
		if(drivername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\athan\\eclipse-workspace\\DemoPOMFramework\\Drivers\\chromedriver.exe");
			options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
			jse = ((JavascriptExecutor)driver);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		
		/*
		 * if (driver.getTitle().equalsIgnoreCase("Login | Salesforce")) {
		 * test.log(LogStatus.FAIL,test.addScreenCapture(toTakeScreenshot(
		 * "SFLoginPageLaunch", driver)), "Launching of SF page failure"); } else {
		 * test.log(LogStatus.PASS, "Launched the SF login page"); }
		 */
	}
	
	@BeforeSuite
	public void getReport()
	{
		report = new ExtentReports("C:\\Users\\athan\\eclipse-workspace\\DemoPOMFramework\\src\\main\\screenshots\\ExtentReportResults.html");
	}
	
	@AfterSuite
	public void flushRepost()
	{
		report.flush();
	}
}
