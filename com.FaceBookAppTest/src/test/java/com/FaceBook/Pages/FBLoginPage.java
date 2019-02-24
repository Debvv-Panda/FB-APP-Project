package com.FaceBook.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FBLoginPage 
{
	WebDriver driver;
	
	public FBLoginPage(WebDriver localdriver)
	{
		this.driver=localdriver;
	}
	
	@FindBy(name="email")WebElement uname;
	
	@FindBy(name="pass")WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")WebElement loginButton;
	
	public void LoginToFacebook(String usernameApplication,String passwordApplication)
	{
		uname.sendKeys(usernameApplication);
		password.sendKeys(passwordApplication);
		loginButton.click();
	}

}
