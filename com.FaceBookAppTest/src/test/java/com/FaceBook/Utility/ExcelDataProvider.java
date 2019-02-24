package com.FaceBook.Utility;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File src=new File("./TestData/TestData.xlsx");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) 
		{
			System.out.println("exception is->>>"+e.getMessage());
		} 
		
	}
	
	//example of overriding in realtime project
	
	public String getStringData(int sheetIndex,int row,int column)
	{
		String data=wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}
	
	public String getStringData(String sheetName,int row,int column)
	{
		String data=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
		
	}
	public double getNumericData(String sheetName,int row,int column)
	{
		double data1=wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		return data1;
		
	}
	
	

}
