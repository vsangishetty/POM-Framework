package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CrmDashboardPage extends TestBase{
	
		//Page Factory - OR:
		@FindBy(xpath="//span[contains(text(), 'Vinod Sangishetty')]")
		WebElement userNameLable;
		
		@FindBy(id="main-nav")
		WebElement menuTab;
		
		@FindBy(xpath="//span[contains(text(), 'Contacts')]")
		WebElement Contacts;
		
		@FindBy(xpath="//span[contains(text(), 'Contacts')]/parent::a//following-sibling::button")
		WebElement addContactBtn;
		
		@FindBy(xpath="//span[contains(text(), 'Calendar')]")
		WebElement Calendar;
		
		@FindBy(xpath = "//span[contains(text(), 'Deals')]")
		WebElement Deals;
		
		@FindBy(id="dashboard-toolbar")
		WebElement DashboardToolbar;
		
		
		//initialize Page Object
		public CrmDashboardPage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyPageTitle() {
			return driver.getTitle();
		}
		
		public boolean verifyUserName() {
			return userNameLable.isDisplayed();
		}
		
		
		public void moveMouse(String element) {
			Actions mov = new Actions(driver);
						
			if(element.contains("dashtoolbar")) {
				mov.moveToElement(DashboardToolbar).build().perform();
			}
			else if(element.contains("menu")) {
				mov.moveToElement(menuTab).build().perform();
			}
		}
		
		public ContactsPage clickOnContacts() {
			Contacts.click();
			return new ContactsPage();
		}
		
		public ContactsPage clickOnAddContactsBtn() {
			addContactBtn.click();
			return new ContactsPage();
		}
		
		public CalendarPage clickOnCalendar() {
			Calendar.click();
			return new CalendarPage();
		}
		
		public DealsPage clickOnDeals() {
			Deals.click();
			return new DealsPage();
		}
		
	
	

}
