package com.generics;

public interface Constants {

	public static final String ChromeBrowserKey = "webdriver.chrome.driver";
	
	public static final String ChromeBrowserValue = System.getProperty("user.dir")+"\\api\\chromedriver.exe";
	
	
	public static final String FfBrowserKey = "webdriver.gecko.driver";
	
	public static final String FfBrowserValue = System.getProperty("user.dir")+"\\api\\geckodriver.exe";
	
	public static final String propFilePath = System.getProperty("user.dir")+"\\appConfigurations.properties";

	public static final String testDataFilePath = System.getProperty("user.dir")+"\\testData.xlsx";
}
