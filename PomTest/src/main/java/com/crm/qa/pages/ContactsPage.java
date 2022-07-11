package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	//Page Factory - OR:
	@FindBy(xpath="//div[contains(@class, 'ui header item mb5 light-black')]")
	WebElement contactLable;
	
	@FindBy(xpath="//div[@class='item']//a//button[contains(text(), 'Create')]")
	WebElement createContactBtn;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//div[contains(@class, 'ui right corner labeled input')]//input[contains(@placeholder, 'Email address')]")
	WebElement emailAddress;
	
	@FindBy(xpath="//div[@name='category']")
	WebElement categoryDD;
	
	@FindBy(xpath="//div[@name='status']")
	WebElement statusDD;

	@FindBy(xpath="//div[@class='ui input']//input[@name='state']")
	WebElement address;
	
	@FindBy(xpath="//div[@name='hint']//input")
	WebElement phoneCountryDD;
	
	@FindBy(xpath="//div[@class='ui input']//input[@placeholder='Number']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//div[@class='item']//button[text()='Save']")
	WebElement saveBtn;
	
	//initialize Page Object
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactPageLabel() {
		return contactLable.isDisplayed();
	}
	
	public void createNewContactsBtn(String ftName, String ltName, String email, String categoryName, String status, String addressName, String phonedd, String phoneNum) {
		createContactBtn.click();
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		emailAddress.sendKeys(email);
		
		driver.findElement(By.xpath("//div[@name='category']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='visible menu transition']//div"));
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getText().contains(categoryName)) {
				list.get(i).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//div[@name='status']")).click();
		List<WebElement> stlist = driver.findElements(By.xpath("//div[@class='visible menu transition']//div"));
		for(int i=0; i<stlist.size(); i++) {
			if(stlist.get(i).getText().contains(status)) {
				stlist.get(i).click();
				break;
			}
		}
		
		address.sendKeys(addressName);
		phoneCountryDD.sendKeys(phonedd);
		driver.findElement(By.xpath("//div[@name='hint']//div[@role='listbox']//div//span[text()='"+phonedd+"']")).click();
		phoneNumber.sendKeys(phoneNum);
		saveBtn.click();

	}






}
