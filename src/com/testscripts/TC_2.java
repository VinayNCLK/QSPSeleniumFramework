package com.testscripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.generics.BaseTest;
import com.generics.Generics;
import com.po.LoginPO;

public class TC_2 extends BaseTest {
	
	@Test
	public void tc_2()
	{
	
	LoginPO lpo = new LoginPO(driver);
	
	lpo.login(Generics.getPropertiesValue(propFilePath, "invalid_userName"), 
			Generics.getPropertiesValue(propFilePath, "invalid_password"));
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(lpo.ErrorMsg()));
	String ExpectedErrorMsg = "Username or Password is invalid. Please .";
	Assert.assertEquals(lpo.getErrorMsg(), ExpectedErrorMsg);
	
	}
}
