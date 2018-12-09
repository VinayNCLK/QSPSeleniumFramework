package com.testscripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generics.BaseTest;
import com.generics.Generics;
import com.po.LoginPO;

public class TC_3 extends BaseTest {
	
	@DataProvider(name = "invalidCredentials")
	 
	  public static Object[][] credentials() {
	 
	        return new Object[][] { 
	        	{ "admin1", "pwd1" }, 
	        	{ "admin2", "pwd2" }
	        	};
	 
	  }

	@Test(dataProvider = "invalidCredentials")
	public void tc_3(String sUsername, String sPassword)
	{
	
	LoginPO lpo = new LoginPO(driver);
	
	lpo.login(sUsername, sPassword);
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(lpo.ErrorMsg()));
	String ExpectedErrorMsg = "Username or Password is invalid. Please try again.";
	Assert.assertEquals(lpo.getErrorMsg(), ExpectedErrorMsg);
	
	}
}
