package hdfcAutomation;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.DashboardHDFC;
import pageObjects.DepositLPageHDFC;
import pageObjects.LoginHDFC;
import pageObjects.OpenFDConfirm;
import pageObjects.OpenFDPage;
import resources.TestUtility;
import resources.base;

public class ValidateHDFCLoginNew extends base{
	
	public WebDriver driver;
	static Logger log = LogManager.getLogger(TC001_ValidateHDFCLoginFunctionality.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{		
		driver = initializeDriver();
        driver.get(prop.getProperty("url"));
	
		System.out.println("Browser Launched");
	}
	
	@Test(dataProvider="getHDFCLoginData")
	public void validateHDFCLoginPage(String custID,String password) throws IOException, InterruptedException
	{	
		
		driver.manage().deleteAllCookies();
		LoginHDFC loginhdfc= new LoginHDFC(driver);
		loginhdfc.getCustomer_ID().sendKeys(custID);
		Thread.sleep(5000);
		loginhdfc.getContinue().click();
		loginhdfc.getPassword().sendKeys(password);
		Thread.sleep(5000);
		
		loginhdfc.getLogin().click();
		
					
		}
	
	 @DataProvider
	public Iterator<Object[]> getHDFCLoginData()
	{
		
	ArrayList<Object[]> loginTestData=TestUtility.getLoginTestDataFromExcel();
	return loginTestData.iterator();
	}
	 
	
	  @AfterTest public void teardown() throws InterruptedException 
	  { 
			System.out.println("Tear Down Block");
			
			//Logout  click
			OpenFDPage openFD1 = new OpenFDPage(driver);
			openFD1.getLogout().click();
			Thread.sleep(5000);
			openFD1.getLogoutYes().click();
			Thread.sleep(5000);
		driver.quit(); 
	  
	  }
	

}
