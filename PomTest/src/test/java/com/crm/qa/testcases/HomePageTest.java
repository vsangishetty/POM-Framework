package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginPage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialize();
		homepage = new HomePage();
	}
	
	@Test(priority = 1)
	public void validatePageTileTest() {
		String title = homepage.validatePageTile();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, marketing campaigns and support.");
	}
	
	@Test(priority = 2)
	public void imgLogoTest() {
		boolean img = homepage.imageLogo();
		Assert.assertTrue(img);
	}
	
	@Test(priority = 3)
	public void clickLoginBtnTest() throws InterruptedException {
		loginPage = homepage.loginbtn();
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	
	
	

}
