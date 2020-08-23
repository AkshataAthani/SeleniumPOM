package com.sf.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sf.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Find web elements
	@FindBy(id = "username") WebElement username;
	@FindBy(id = "password") WebElement password;
	@FindBy(xpath = "//input[@id='Login']") WebElement login;
	@FindBy(linkText = "Forgot Your Password?") WebElement forgotPassword;
	
	//Init page object factory
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String getLoginTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage loginTo(String un, String pw)
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		login.click();
		
		return new HomePage();
	}

}
