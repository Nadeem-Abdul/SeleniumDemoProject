package resources;

import java.awt.desktop.SystemSleepEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class base {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream("D:\\Softwares\\Automation Testing\\AutomationTestingProjects\\HDFC_E2EAutomation\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		String broswerName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		System.out.println(broswerName);
		System.out.println(url);
		
		if(broswerName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.get(url);
		}
		else if (broswerName.equalsIgnoreCase("firefox"))
		
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\Automation Testing\\WebDrivers\\geckodriver-v0.31.0-win32\\geckodriver.exe");
			 driver = new FirefoxDriver();
			 driver.manage().window().maximize();
		}
		else if (broswerName.equalsIgnoreCase("ie"))
			
		{
			System.setProperty("webdriver.ie.driver", "D:\\Automation Testing\\WebDrivers\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			 driver.manage().window().maximize();
		}
		else if(broswerName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "D:\\Automation Testing\\WebDrivers\\msedgedriver.exe");

			// Start Edge Session
			 driver = new EdgeDriver();
			 driver.manage().window().maximize();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	
	}
	
	public void getScreenshot(WebDriver driver,String methodName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String  SSpath= System.getProperty("user.dir")+"\\reports\\"+methodName+".png";
		System.out.println("SS Path"+SSpath);
		File DestFile = new File(SSpath);
		
		FileUtils.copyFile(srcFile, DestFile);
		System.out.println("SS taken");
		//System s = new System();
		
File screenshotFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshotFile, new File(""+".png"));
		
			
			
	}
	

}
