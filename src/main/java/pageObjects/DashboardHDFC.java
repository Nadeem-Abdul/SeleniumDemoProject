package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardHDFC {
WebDriver driver;
	
public DashboardHDFC(WebDriver driver)
{
	this.driver=driver;
}

	By logoutButton = By.xpath("//button[text()='Logout']");
	By saveMenu = By.xpath("//li[@id='webSave']");
	By saveEpic = By.xpath("//li[@id='webSave']/ul/li[2]/a");
	
	public WebElement getLogoutButton()
	{
		
		return driver.findElement(logoutButton);
		
	}
	
	public  WebElement getSaveMenu()
	{
		return driver.findElement(saveMenu);
	}
	
	public WebElement getSaveEpic()
	{
		return driver.findElement(saveEpic);
	}
	
}
