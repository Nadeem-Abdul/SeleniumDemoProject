package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenFDPage {
	
	WebDriver driver;
	
	public OpenFDPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	By openFDpageHeading = By.xpath("//p[text()='Open Fixed Deposit']");
	
	By step1Heading = By.xpath("(//h4[@class='panel-title f9'])[1]");
	
	By amountfield = By.xpath("//div[@class='col-md-6 col-lg-6']//input[@id='amount']");
	
	By yearDropdown = By.xpath("//fieldset[@id='yearsIdMD']//span[@aria-label='Select box activate']");
	
	By step1Continue = By.xpath("//div[@class='two-btn clearfix']//a[@class='btn center-block btn-primary ng-isolate-scope']");
	
	By step2Heading = By.xpath("(//h4[@class='panel-title f9'])[2]");
	
	//By  step2Continue = By.xpath("//div[@class='two-btn clearfix ng-scope']//a[1]");
	
	By  step2Continue = By.xpath("//a[contains(text(),'continue')]");
	
	//By step3Heading = By.xpath("(//h4[@class='panel-title f9'])[3]"); //It is working Xpath
	By step3Heading = By.xpath("//a[@class='accordion-toggle']");

	
	By nomineeName = By.cssSelector("#nameControl");
	By calenderImage = By.cssSelector("img[title='Select date']");
	//By calenderPick = By.cssSelector("div[id='ui-datepicker-div']");
	By calenderYearDropdown = By.xpath("//div[@id='ui-datepicker-div']//div//div//select[2]");
	By selectFirstDate = By.xpath("//div[@id='ui-datepicker-div']//table//tbody//tr//td//a");
	By relationShipDropDown = By.xpath("//div[@class='ui-select-container ui-select-bootstrap dropdown ng-pristine ng-untouched ng-valid ng-scope ng-empty']//span[@aria-label='Select box activate']");
	By firstRelationship = By.xpath("//li[@id='ui-select-choices-12']//div[2]");
	By addressLine1 = By.id("add1Control");
	By addressLine2 = By.id("add2Control");
	By addressLine3 = By.id("add3Control");
	By city = By.id("cityControl");
	By state = By.id("stateControl");
	By pinCode = By.id("pinControl");
	By nomineeCheckBox = By.id("showNom");
	By step3Continue= By.xpath("//a[contains(text(),'Continue')]");
	
	
	
			By logout = By.xpath("(//button[text()='Logout'])[2]");
			
			By logoutYes = By.cssSelector(".btn.btn-primary.nb-logout.yes-btn");
	
public WebElement getOpenFDHeading()
{
	return driver.findElement(openFDpageHeading);
	}
	
	public WebElement getStep1Heading()
	{
		return driver.findElement(step1Heading);
	}
	
	
	public WebElement getYearDropDwon()
	{
		return driver.findElement(yearDropdown);
	}
	
	public WebElement getAmountField()
	{
		return driver.findElement(amountfield);
	}
	
	
	public WebElement getStep1Continue()
	{
		return driver.findElement(step1Continue);
	}

	public WebElement getStep2Heading()
	{
		return driver.findElement(step2Heading);
	}
	
	public WebElement getStep2Continue()
	{
		return driver.findElement(step2Continue);
	}
	
	public WebElement getStep3Heading()
	{
		return driver.findElement(step3Heading);
	}
	
	
	public WebElement getNomineeName()
	{
		return driver.findElement(nomineeName);
	}
	
	public WebElement getCalenderImage()
	{
		return driver.findElement(calenderImage);
	}
	
	public WebElement getCalenderYearDropDown()
	{
		return driver.findElement(calenderYearDropdown);
	}
	public WebElement getFirstDate()
	{
		return driver.findElement(selectFirstDate);
	}
	
	public WebElement getRelationShipdropdwon()
	{
		return driver.findElement(relationShipDropDown);
	}
	public WebElement getFirstRelationshipn()
	{
		return driver.findElement(firstRelationship);
	}
	public WebElement getAddressLine1()
	{
		return driver.findElement(addressLine1);
	}
	public WebElement getAddressLine2()
	{
		return driver.findElement(addressLine2);
	}
	public WebElement getAddressLine3()
	{
		return driver.findElement(addressLine3);
	}
	public WebElement getCity()
	{
		return driver.findElement(city);
	}
	public WebElement getState()
	{
		return driver.findElement(state);
	}
	
	public WebElement getPinCode()
	{
		return driver.findElement(pinCode);
	}
	public WebElement getnomineeCheckBox()
	{
		return driver.findElement(nomineeCheckBox);
	}
	public WebElement getStep3Continue()
	{
		return driver.findElement(step3Continue);
	}
	
	public WebElement getLogout()
	{
		return driver.findElement(logout);
	}
	
	public WebElement getLogoutYes()
	{
		return driver.findElement(logoutYes);
	}
}
