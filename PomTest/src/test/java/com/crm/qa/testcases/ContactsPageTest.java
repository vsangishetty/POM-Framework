package com.crm.qa.testcases;



import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CrmDashboardPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;


public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	CrmDashboardPage crmDashboardpage;
	HomePage homepage;
	ContactsPage contact;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		homepage = new HomePage();
		loginPage = homepage.loginbtn();
		crmDashboardpage = loginPage.login(prop.getProperty("usr"), prop.getProperty("pass"));
		crmDashboardpage.moveMouse("menu");
		contact = crmDashboardpage.clickOnContacts();
		crmDashboardpage.moveMouse("dashtoolbar");
	}
	
	@Test(priority = 1)
	public void verifyContactPageLabelTest() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(contact.verifyContactPageLabel());
	}
	
	@Test(priority = 2)
	public void selectContact() {
		
		String before_xpath = "//*[@id='main-content']/div/div[2]/div/table/tbody/tr[";
		String after_xpath = "]/td[2]/a";
	
		List<WebElement> pagecnt = driver.findElements(By.xpath("//tfoot/descendant::div[contains(@class, 'custom-pagination')]//a"));
		//System.out.println(pagecnt.size());
		
		boolean flag = false;
		for(int j=1; j<pagecnt.size()-1;j++) {
			List<WebElement> rowcnt = driver.findElements(By.cssSelector("div.table-wrapper>table>tbody>tr>td:nth-child(2)>a"));
			//System.out.println(rowcnt.size());
			for(int i=1; i<=rowcnt.size(); i++) {
				String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
				if(name.contains("Akash Mui")) {
				driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr["+i+"]/td[1]/div")).click();
				flag = true;
				//break;
				}
			
			}
			if(flag) {
				break;
			}
			String nextpg = driver.findElement(By.xpath("//tfoot/descendant::div[contains(@class, 'custom-pagination')]//a[@class='item active']//following::a[1]")).getAttribute("class");
			
			if(nextpg.equals("item")) {
				driver.findElement(By.xpath("//tfoot/descendant::div[contains(@class, 'custom-pagination')]//a[@class='item active']//following::a[1]")).click();
			}
						
		}
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 3, dataProvider="getCRMTestData")
	public void createNewContactTest(String firstName, String lastName, String emailID, String catName, String statusName, String address, String phonecountry, String phoneNumber) throws InterruptedException {

		contact.createNewContactsBtn(firstName,lastName , emailID, catName, statusName, address, phonecountry, phoneNumber);
		Thread.sleep(3000);
		String ftltname = driver.findElement(By.xpath("//div[@id='dashboard-toolbar']//div")).getText();
		Assert.assertEquals(ftltname, firstName+" "+lastName);
		
	}
	
	
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	
	
	

}
