package com.crm.qa.testcases;


import java.time.Duration;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CrmDashboardPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class CrmDashboardPageTest extends TestBase{
	
	LoginPage loginPage;
	CrmDashboardPage crmDashboardpage;
	HomePage homepage;
	ContactsPage contact;
	
	public CrmDashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		homepage = new HomePage();
		loginPage = homepage.loginbtn();
		crmDashboardpage = loginPage.login(prop.getProperty("usr"), prop.getProperty("pass"));
	}
	
	@Test(priority = 1)
	public void verifyDashboardTitleTest() {
		Assert.assertEquals(crmDashboardpage.verifyPageTitle(), "Cogmento CRM");
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest() {
		new WebDriverWait(driver, Duration.ofSeconds(5));
		Assert.assertTrue(crmDashboardpage.verifyUserName());
	}
	
	@Test(priority = 3)
	public void clickOnContactsTest() {
		crmDashboardpage.moveMouse("menu");
		contact = crmDashboardpage.clickOnContacts();
		//crmDashboardpage.moveMouse("dashtoolbar");
		
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	
	

}
