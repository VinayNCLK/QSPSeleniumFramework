package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPO {

	public LoginPO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameTxtBx;
	
	@FindBy(xpath="//input[@name='pwd' and @placeholder='Password']")
	private WebElement pwdTxtBx;
	
	@FindBy(xpath="//a[@id='loginButton']/div[contains(text(),'Login')]")
	private WebElement loginBtn;
	
	@FindBy(xpath="(//span[@class='errormsg'])[1]")
	private WebElement ErrorMsg;
			
			
	public void login(String userName, String pwd)
	{
		userNameTxtBx.sendKeys(userName);
		pwdTxtBx.sendKeys(pwd);
		loginBtn.click();
	}
	
	
	
	
	public WebElement userTxtBx()
	{
		return userNameTxtBx;
	}
	public WebElement ErrorMsg()
	{
		return ErrorMsg;
	}
	public String getErrorMsg()
	{
		return ErrorMsg.getText();
	}
	
}
