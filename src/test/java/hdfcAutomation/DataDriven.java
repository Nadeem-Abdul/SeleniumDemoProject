package hdfcAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import resources.Xls_Reader;

public class DataDriven {
	
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver","D:\\Automation Testing\\WebDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.linkedin.com/login");
	
		Xls_Reader reader = new Xls_Reader("F:\\Eclipse\\NewjobE2EProject\\src\\main\\java\\resources\\Book1.xlsx");
		int size=reader.getRowCount("Sheet1");
		
		for(int rowNum=2;rowNum<=size;rowNum++)
		{System.out.println("=============");
		
		driver.findElement(By.xpath("//input[@id='username']")).clear();
			String username= reader.getCellData("Sheet1", "UserName", rowNum);
			System.out.println(username);
			
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
			
			
			driver.findElement(By.xpath("//input[@id='password']")).clear();
			String password= reader.getCellData("Sheet1", "Password", rowNum);
			System.out.println(password);
			
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			
			reader.setCellData("Sheet1", "Status", rowNum, "Pass");
		}
		Thread.sleep(10000);
		driver.quit();
		
	}
	
		
	
	
	
	
}
