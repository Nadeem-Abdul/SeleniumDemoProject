package hdfcAutomation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
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
import resources.base;

public class ValidateHDFCLoginFunctionality2 extends base {

	public WebDriver driver;
	static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		System.out.println("Starting Chrome Driver");
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		System.out.println("Driver Initialized");
	}

	@Test(dataProvider = "getData")
	public void validateHDFCLoginPage(String custID, String password) throws IOException, InterruptedException {

		//driver.manage().deleteAllCookies();

		System.out.println("333");
		LoginHDFC hdfcLogin = new LoginHDFC(driver);
		hdfcLogin.getCustomer_ID().sendKeys(custID);
		hdfcLogin.getContinue().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("keyboard")));

		hdfcLogin.getPassword().sendKeys(password);
		System.out.println("444");

		// check if its a RSA cust id then Checkbooks will come
		/*
		 * if(hdfcLogin.getcheckText().isDisplayed()) { hdfcLogin.getcheckBox().click();
		 * hdfcLogin.getLogin().click(); System.out.println("555"); }else
		 */

		hdfcLogin.getLogin().click();
		Thread.sleep(10000);
		// Creating Object of Dashborad HDFC class
		DashboardHDFC dhdfc = new DashboardHDFC(driver);

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Logout']")));

		Actions act = new Actions(driver);

		act.moveToElement(dhdfc.getSaveMenu()).clickAndHold().build().perform();
		act.moveToElement(dhdfc.getSaveEpic()).click().build().perform();

		Thread.sleep(5);

		DepositLPageHDFC dLp = new DepositLPageHDFC(driver);
		dLp.getOpenFDlink().click();
		Thread.sleep(5);

		OpenFDPage openFD = new OpenFDPage(driver);

		String openFDHeading = openFD.getOpenFDHeading().getText();
		System.out.println(openFDHeading);

		// Soft Assert
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(openFDHeading, "Open Fixed Deposit");

		// Validating Step1 Heading
		String step1Heading = openFD.getStep1Heading().getText();
		System.out.println(step1Heading);
		softAssert.assertEquals(step1Heading, "Step 1 - Set-up Deposit");

		// Step1 Amount field
		openFD.getAmountField().sendKeys("20000");

		Thread.sleep(2000);

		// selecting no. of years for FD
		driver.findElement(By.xpath("//fieldset[@id='yearsIdMD']//div[@placeholder='Years']")).click();
		List<WebElement> options = driver.findElements(
				By.cssSelector("li[class='ui-select-choices-group'] div[class='ui-select-choices-row ng-scope']"));

		System.out.println(options.size());
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().contains("2")) {
				options.get(i).click();
				break;
			}

		}

		/*
		 * openFD.getYearDropDwon().click(); List<WebElement> options=
		 * driver.findElements(By.
		 * xpath("//fieldset[@id='yearsIdMD']//span[@aria-label='Select box activate']")
		 * ); System.out.println(options.size()); for(WebElement opt : options) {
		 * if("2".equals(opt.getText())) opt.click(); System.out.println(opt); }
		 */
		// Thread.sleep(2000);
		// openFD.getYearDropDwon().sendKeys("2");

		Thread.sleep(10000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,2000)", "");
		Thread.sleep(5000);

		// Step1 continue
		openFD.getStep1Continue().click();

		System.out.println("Step 1 Continue Clicked");
		Thread.sleep(2000);

		// Validating Step2 Heading
		String step2Heading = openFD.getStep2Heading().getText();
		System.out.println(step2Heading);

		softAssert.assertEquals(step2Heading, "Step 2 - Select Branch");

		// Step 2 continue
		openFD.getStep2Continue().click();
		System.out.println("Step 2 Continue Clicked");

		Thread.sleep(2000);

		// Step3 validations
		String step3Heading = openFD.getStep3Heading().getText();
		System.out.println(step3Heading);
		softAssert.assertEquals(step3Heading, "Step 3 - Add Nominee");
		Thread.sleep(10000);

		// sending name
		openFD.getNomineeName().sendKeys("abcd");

		// Click on CalnderImage
		openFD.getCalenderImage().click();
		WebElement calenderYear = openFD.getCalenderYearDropDown();

		// Select Year
		Select select = new Select(calenderYear);
		select.selectByValue("2000");

		// Select Date
		openFD.getFirstDate().click();

		// select Relationship
		openFD.getRelationShipdropdwon().click();

		List<WebElement> relatioshipDropdowns = driver
				.findElements(By.cssSelector("div[class='ui-select-choices-row ng-scope'] span span"));

		for (int i = 0; i <= relatioshipDropdowns.size(); i++) {
			if (relatioshipDropdowns.get(i).getText().equalsIgnoreCase("BROTHER")) {
				relatioshipDropdowns.get(i).click();
				break;
			}
		}

		Thread.sleep(2000);

		// insert Address
		openFD.getAddressLine1().sendKeys("afsvs");
		openFD.getAddressLine2().sendKeys("ccc");
		openFD.getAddressLine3().sendKeys("aacac");

		openFD.getCity().sendKeys("Bombay");
		openFD.getState().sendKeys("MH");
		openFD.getPinCode().sendKeys("123321");
		openFD.getnomineeCheckBox().click();

		js.executeScript("window.scrollBy(0,2000)", "");
		Thread.sleep(5000);

		// Step 3 Continue
		Thread.sleep(5000);
		openFD.getStep3Continue().click();

		System.out.println("Step 3 Continue Clicked");

		Thread.sleep(5000);

		// Confirm Page

		OpenFDConfirm openFDconfirm = new OpenFDConfirm(driver);

		// Heading validated
		String heading = openFDconfirm.getHeading().getText();
		System.out.println("Confirm Screen Heading " + heading);
		softAssert.assertEquals(heading, "Open Fixed Deposit");

		openFDconfirm.getTermsAndCondition().click();

		openFDconfirm.getConfirmButton3().click();

		softAssert.assertAll();

		Actions s = new Actions(driver);

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];

		data[0][0] = "900005301";
		data[0][1] = "hdfcbank1";

		return data;
	}

	@AfterTest
	public void teardown() throws InterruptedException {
		System.out.println("tear Down Block");

		// Logout click
		OpenFDPage openFD1 = new OpenFDPage(driver);
		openFD1.getLogout().click();
		Thread.sleep(5000);
		openFD1.getLogoutYes().click();
		Thread.sleep(5000);
		driver.quit();

	}

}
