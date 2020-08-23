package com.sf.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sf.qa.base.TestBase;

public class NewAccountPage extends TestBase {
	
	@FindBy(xpath = "//label/span[text()='Phone']/parent::label/following-sibling::input") WebElement phone;
	@FindBy(xpath = "//label/span[text()='Account Name']/following::input[1]") WebElement accName;
	@FindBy(xpath = "//label/span[text()='Billing State/Province']/parent::label/following-sibling::input") WebElement billingState;
	@FindBy(xpath = "//button[@title='Save']") WebElement save;
	@FindBy(xpath = "//h2[text()='New Account']") WebElement newAccHeader;
	
	public NewAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean getHeader()
	{
		return newAccHeader.isDisplayed();
	}
	
	public NewAccCreatedPage fillNewAccount(String pn, String an, String bs)
	{
		phone.sendKeys(pn);
		accName.sendKeys(an);
		jse.executeScript("scroll(0,600)");
		billingState.sendKeys(bs);
		//jse.executeAsyncScript("arguments[0].click();", save);
		save.click();
		return new NewAccCreatedPage();
		
	}
}
