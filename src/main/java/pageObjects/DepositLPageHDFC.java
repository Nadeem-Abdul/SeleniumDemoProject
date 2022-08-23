package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DepositLPageHDFC {
	
	WebDriver driver;
	
	public DepositLPageHDFC(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By openFDLink = By.xpath("//p[text()='Open Fixed Deposit']");
	
	
	public WebElement getOpenFDlink()
	{
		return driver.findElement(openFDLink);
	}
	




}
