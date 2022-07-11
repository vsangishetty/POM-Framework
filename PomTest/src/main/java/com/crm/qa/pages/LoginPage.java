package com.crm.qa.pages;

import java.time.Duration;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//div[contains(@class, 'column')]//descendant::input[@name='email']")
	WebElement username;
	
	@FindBy(xpath="//div[@id='ui']//descendant::input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//div[@id='ui']//descendant::div[text()='Login']")
	WebElement LoginBtn;
	
	@FindBy(linkText = "Sign Up")
	WebElement SignUp;
	
	@FindBy(linkText = "Forgot your password?")
	WebElement Forgotpassword;
	
	@FindBy(linkText = "Classic CRM")
	WebElement ClassicCRM;
	
	
	//Initializing Page Object 
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public CrmDashboardPage login(String un, String pwd) {
		username.sendKeys(un);
		new WebDriverWait(driver, Duration.ofSeconds(5));
		password.sendKeys(pwd);
		new WebDriverWait(driver, Duration.ofSeconds(5));
		LoginBtn.click();
		return new CrmDashboardPage();
	}
		
		
		
		
		
		
		
		
		
		

}
