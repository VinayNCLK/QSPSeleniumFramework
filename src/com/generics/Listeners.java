package com.generics;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

	WebDriver driver = null;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		this.driver = ((BaseTest)result.getInstance()).driver;
		System.out.println("listener");
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

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
