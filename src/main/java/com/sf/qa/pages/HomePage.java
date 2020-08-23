package com.sf.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sf.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//a[@title='Accounts']") WebElement accounts;
	@FindBy(xpath = "//a[@title='Contacts']") WebElement contacts;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String getHomePagetitle()
	{
		return driver.getTitle();
	}
	
	public AccountsPage clickOnAccounts()
	{
		jse.executeScript("arguments[0].click();", accounts);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new AccountsPage();
	}
	
	public ContactsPage clickOnContacts()
	{
		jse.executeScript("arguments[0].click();", contacts);
		return new ContactsPage();
	}
}
