package com.FaceBook.Utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Handler 
{
	//we used datetime method & also parameterised the screeshot name as default test name
	
	public void getScreenShot(WebDriver driver,String screenshotName)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File f=ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(f, new File("./ScreenShots/"+ getCurrentDateTime() + screenshotName +".png"));
			
			System.out.println("screenshot taken");
			
		  } catch (Exception e)
		
		  {
			System.out.println("Exception is---->>>>>"+e.getMessage());
		  }
		
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat format=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentdate=new Date();
		
		return format.format(currentdate);
		
		
	}
	
	

}
