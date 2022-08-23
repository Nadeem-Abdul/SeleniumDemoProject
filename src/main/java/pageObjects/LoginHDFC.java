package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginHDFC {
	
	 WebDriver driver;
	
	 public LoginHDFC(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 
	By custId = By.id("liabiltyLoginCustId");
	By activeSessionError = By.cssSelector(".error-msg.ng-binding.ng-scope");
	By continueBtn = By.id("continuelogin");
	By password = By.id("keyboard");
	By loginBtn = By.id("loginBtn");
	By secureCheckBox = By.id("secureAccessID");
	
	By secureText= By.xpath("//label[text()='This is my Secure ID']");
	
	By sessionActiveError = By.cssSelector(".error-msg.ng-binding.ng-scope");
	
	public WebElement getCustomer_ID() 
	
	{
		return driver.findElement(custId);
	}
	
	public WebElement getActiveSessionError()
	{
		return driver.findElement(activeSessionError);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(loginBtn);
	}
	public WebElement getContinue()
	{
		return driver.findElement(continueBtn);
	}
	
	public WebElement getcheckBox()
	{
		return driver.findElement(secureCheckBox);
	}
	public WebElement getcheckText()
	{
		return driver.findElement(secureText);
	}
	public WebElement getSessionActiveError()
	{
		return driver.findElement(sessionActiveError);
	}
	
}
