package com.sf.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sf.qa.base.TestBase;

public class NewAccCreatedPage extends TestBase {
	
	@FindBy(xpath = "//a[text()='Details']") WebElement details;
	
	public NewAccCreatedPage()
	{
		PageFactory.initElements(driver, this);
	}
    
	
	public boolean getDetails()
	{
		return details.isDisplayed();
	}
}
