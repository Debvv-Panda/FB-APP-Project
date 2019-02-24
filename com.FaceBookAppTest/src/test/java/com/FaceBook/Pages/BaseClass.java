package com.FaceBook.Pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.FaceBook.Utility.BrowserFactory;
import com.FaceBook.Utility.ExcelDataProvider;
import com.FaceBook.Utility.Handler;
import com.FaceBook.Utility.configDataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass 
{
	public WebDriver driver;
	
	public ExcelDataProvider dataprovider;
	 
	public configDataProvider dataprovider1;
	
	public Handler handler;
	
	public ExtentReports reports;
	
	public ExtentTest logger;
	 
 
	
	@BeforeSuite
	public void setupSuite()
	{
	   dataprovider=new ExcelDataProvider();
	   
	   dataprovider1=new configDataProvider();
	   
	   // extent report
	   reports=new ExtentReports();
	   
	   ExtentHtmlReporter reporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FBlogIn+" + handler.getCurrentDateTime() +".html"));
	   
	   reports.attachReporter(reporter);
		
	}
	
	@BeforeClass
	public void setUp()
	{
		driver=BrowserFactory.StartApplication(driver, dataprovider1.getBrowser(),dataprovider1.getStagingUrl());
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
			
	}
	
	@AfterMethod
	public void getscreenShot(ITestResult result)
	{
		if(result.FAILURE==result.getStatus())
		{
			handler.getScreenShot(driver, result.getTestName());
		}
		
		reports.flush();
	}

}
