package com.testscripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generics.BaseTest;
import com.generics.Generics;
import com.po.LoginPO;

public class TC_4 extends BaseTest {
	


	@Test
	public void tc_4() throws InterruptedException
	{
	
	LoginPO lpo = new LoginPO(driver);
	
	int rowCount = Generics.getRowsCount(testDataFilePath, "TC_4");
	for(int i=1;i<=rowCount;i++)
	{	
		driver.navigate().refresh();
		Thread.sleep(5000);
		String sUsername = Generics.getCellValue(testDataFilePath, "TC_4", i, 1);
		String sPassword = Generics.getCellValue(testDataFilePath, "TC_4", i, 2);
		System.out.println(sUsername + " "+ sPassword);
		lpo.login(sUsername, sPassword);
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(lpo.ErrorMsg()));
		String ExpectedErrorMsg = "Username or Password is invalid. Please";
		Assert.assertEquals(lpo.getErrorMsg(), ExpectedErrorMsg);
		Generics.setCellValue(testDataFilePath, "TC_4", i, 3, "pass");
	}
	
	}
}
