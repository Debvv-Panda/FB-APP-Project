package com.FaceBook.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory 
{
	public static WebDriver StartApplication(WebDriver driver,String browserName,String AppUrl)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("WebDriver.Chrome.driver","./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("WebDriver.gecko.driver","./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}	
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			System.setProperty("WebDriver.edge.driver","./Drivers/MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
		}	
		else
		{
			System.out.println("didnot find the proper browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(AppUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
