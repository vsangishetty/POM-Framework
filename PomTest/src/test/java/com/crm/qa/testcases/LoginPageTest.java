package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.crm.qa.pages.CrmDashboardPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends HomePage{
	
	LoginPage loginPage;
	CrmDashboardPage crmDashboardpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialize();
		homepage = new HomePage();
		loginPage = homepage.loginbtn();
	}
	
	@Test(priority = 1)
	public void validateLoginPgTest() {
		String loginpg = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginpg, "Cogmento CRM");
	}
	
	@Test(priority = 2)
	public void loginTest() {
		
		crmDashboardpage = loginPage.login(prop.getProperty("usr"), prop.getProperty("pass"));
//		String crmdashtitle = loginpage.validatePageTile();
//		Assert.assertEquals(crmdashtitle, "Cogmento CRM");
//		Thread.sleep(5000);
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	

}
