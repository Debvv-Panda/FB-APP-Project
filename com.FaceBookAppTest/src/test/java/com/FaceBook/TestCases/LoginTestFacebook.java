package com.FaceBook.TestCases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.FaceBook.Pages.BaseClass;
import com.FaceBook.Pages.FBLoginPage;
import com.FaceBook.Utility.BrowserFactory;
import com.FaceBook.Utility.ExcelDataProvider;

public class LoginTestFacebook extends BaseClass
{
	
	@Test
	public void login()
	{
		
		//dataprovider.getNumericData("FBLogIN", 0, 0);	
		
		logger=reports.createTest("Login to FB");
		
		FBLoginPage fbloginpage=PageFactory.initElements(driver, FBLoginPage.class);
		
		logger.info("App Strating");
		
		fbloginpage.LoginToFacebook(dataprovider.getStringData("FBLogIN", 0, 0), dataprovider.getStringData("FBLogIN", 0, 1));
		
		logger.pass("Test Pass");
		
		handler.getScreenShot(driver, "FBlogIn");
		
	
		
	}

}
