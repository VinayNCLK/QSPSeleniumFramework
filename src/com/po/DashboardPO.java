package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPO {

	public DashboardPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Logout")
	private WebElement logoutLink;
	
	
	
	
	public void logout()
	{
		logoutLink.click();
	}
	
	
	
}
