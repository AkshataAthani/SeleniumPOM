package com.sf.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sf.qa.base.TestBase;

public class AccountsPage extends TestBase {

	@FindBy(xpath = "//a[@title='New']") WebElement newAccount;
	
	public AccountsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getTitleForAccounts()
	{
		return driver.getTitle();
	}
	
	public NewAccountPage clickOnNewAccount()
	{
		jse.executeScript("arguments[0].click();", newAccount);
		return new NewAccountPage();
	} 
}
