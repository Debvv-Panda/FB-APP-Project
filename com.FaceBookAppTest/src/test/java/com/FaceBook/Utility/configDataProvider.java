package com.FaceBook.Utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class configDataProvider 
{
	Properties pro;
	
	public configDataProvider()
	
	{
	   File src=new File("./Configurations/config.property");
	
	   try {
		FileInputStream fis=new FileInputStream(src);
		   
		   pro=new Properties();
		   
		   pro.load(fis);
	} catch (Exception e) 
	   {
		System.out.println("Exception is--->>>>"+e.getMessage());
	   } 
	}
	
	public String getDataFromConfig(String keyToSearch)
	{
		return pro.getProperty(keyToSearch);
	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String getStagingUrl()
	{
		return pro.getProperty("qaUrl");
	}
	

}
