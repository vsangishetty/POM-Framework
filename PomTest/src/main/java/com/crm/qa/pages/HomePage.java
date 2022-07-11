package com.crm.qa.pages;

import java.time.Duration;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//PageFactory 
//	@FindBy(xpath = "//div[@id='navbar-collapse']//ul//li//a[text()='Login']")
//	WebElement LoginBtn;
	
//	@FindBy(xpath = "//div[contains(@class, 'container')]//descendant::a[contains(text(),'Login')]")
//	WebElement LoginBtn;
	
	@FindBy(xpath = "//body//div[contains(@class, 'navbar-fixed-top')]//div[contains(@class, 'container')]//descendant::a[contains(text(),'Login')]")
	WebElement LoginBtn;
	
	@FindBy(linkText = "Sign Up")
	WebElement SignUp;
	
	@FindBy(linkText = "Pricing")
	WebElement Pricing;
	
	@FindBy(linkText = "Features")
	WebElement Features;
	
	@FindBy(linkText = "Customers")
	WebElement Customers;
	
	@FindBy(xpath = "//img[contains(@class, 'img-responsive')]")
	WebElement Imaglogo;
	
	
	//Initializing Page Object 
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String validatePageTile() {
		return driver.getTitle();
	}
	
	public boolean imageLogo() {
		return Imaglogo.isDisplayed();
		
	}
	
	
	public LoginPage loginbtn() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(LoginBtn)).click();
		//LoginBtn.click();
		//driver.execute_script("arguments[0].click();", LoginBtn);
		//webdriver.ActionChains(driver).move_to_element(element ).click(element ).perform()
		return new LoginPage();
	}

}
	