package com.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Generics {
	
	//Returns the value from the properties file
	
	public static String getPropertiesValue(String propfilepath, String key)
	{
		String value = null;		
		try {
			FileInputStream fis = new FileInputStream(propfilepath);
			Properties prop = new Properties();
			prop.load(fis);
			
			value = prop.getProperty(key);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
		
	}
	
	//To read the data from the Excel sheet ****
	public static String getCellValue(String path, String tc_name, int row_num, int cell_num)
	{
		String value = null;
		try
		{
		FileInputStream fis = new FileInputStream(path);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(tc_name);
		Row row = sheet.getRow(row_num);
		value = row.getCell(cell_num).getStringCellValue();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;	
	}
	
	
	//To write the data into the Excel sheet
	public static void setCellValue(String path, String tc_name, int row_num, int cell_num, String value)
	{
		try
		{
		FileInputStream fis = new FileInputStream(path);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(tc_name);
		Row row = sheet.getRow(row_num);
		row.createCell(cell_num).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//To get number of columns present in the sheet
	public static int getColumnsCount(String path, String tc_name, int row_num)
	{
		int value = 0;
		try
		{
		FileInputStream fis = new FileInputStream(path);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(tc_name);
		Row row = sheet.getRow(row_num);
		value = row.getLastCellNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
		
	}
	
	//To get number of rows present in the sheet
	public static int getRowsCount(String path, String tc_name)
	{
		int value = 0;
		try
		{
		FileInputStream fis = new FileInputStream(path);
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(tc_name);
		value = sheet.getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
		
	}
	
	public static void TakeSS(WebDriver driver)
	{
		Date date = new Date();
		System.out.println(date);
		String currentDate = date.toString().replaceAll(" ", "_").replaceAll(":", "_");
		System.out.println(currentDate);
		
				
		TakesScreenshot tak = (TakesScreenshot)driver;
		File src = tak.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+currentDate+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		/*try
		{
		FileInputStream fis = new FileInputStream("E:\\Programming\\FW\\testData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("TC_4");
		int value  = sheet.getLastRowNum();
		System.out.println(value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/

		
		int value = Generics.getRowsCount("E:\\Programming\\FW\\testData.xlsx", "TC_5");
	System.out.println(value);
	}
	


}
