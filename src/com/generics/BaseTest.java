package com.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest  implements Constants{

	protected WebDriver driver = null;
	
	static
	{
		System.setProperty(ChromeBrowserKey,ChromeBrowserValue);
		System.setProperty(FfBrowserKey, FfBrowserValue);
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void lauchingBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			Reporter.log("Chrome Browser Launched", true);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			Reporter.log("Firefox Browser Launched", true);
		}
		else
		{
			System.out.println("Please check configurations");
		}
		driver.get(Generics.getPropertiesValue(propFilePath, "appUrl"));
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		Reporter.log("Url loaded", true);
	}
	
	@AfterMethod
	public void closingBrowser()
	{
		driver.quit();
	}
	
	
}
