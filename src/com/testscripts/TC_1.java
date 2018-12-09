package com.testscripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.generics.BaseTest;
import com.generics.Generics;
import com.po.DashboardPO;
import com.po.LoginPO;

public class TC_1 extends BaseTest{

	@Test
	public void tc_1()
	{
		
		LoginPO lpo = new LoginPO(driver);
		//lpo.login("admin", "manager");
		lpo.login(Generics.getPropertiesValue(propFilePath, "valid_userName"), 
				Generics.getPropertiesValue(propFilePath, "valid_password"));
		
		Reporter.log("Login successfull", true);
		
		String expectedTitle = "actiTIME - Enter Time-Track";
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(expectedTitle));
				
		String actualTitle = driver.getTitle();
	
		Assert.assertEquals(actualTitle, expectedTitle, "Wrong page");
		
		Reporter.log("Title Verified", true);
		
		String expectedURL= "http://127.0.0.1/user/submit_tt.do";
		String actualURL = driver.getCurrentUrl();
		
		Assert.assertEquals(actualURL, expectedURL, "Wrong url page");
		
		Reporter.log("url Verified", true);
		
		DashboardPO dpo = new DashboardPO(driver);
		dpo.logout();
		
		Reporter.log("Logout successfull", true);
		
		
	}
	
	
}
