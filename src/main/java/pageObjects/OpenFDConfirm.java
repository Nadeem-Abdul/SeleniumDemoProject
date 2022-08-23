package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenFDConfirm {
	WebDriver driver;
	
	public OpenFDConfirm(WebDriver driver)
	{
		this.driver=driver;
	}

	By heading =By.cssSelector("p[class='f22 c4 margin-bottom10 ng-binding']");
	By termsConditios = By.id("acceptTerms");
	By confirmButton =By.xpath("//a[text()='confirm']");
	
	public WebElement getHeading()
	{
		return driver.findElement(heading);
	}
	
	public WebElement getTermsAndCondition()
	{
		return driver.findElement(termsConditios);
	}
	
	public WebElement getConfirmButton3()
	{
		return driver.findElement(confirmButton);
	}
	
}
