package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNGG {
	 static ExtentReports extent;
	public static  ExtentReports getReportObject() {
	String path = System.getProperty("user.dir")+"\\reports\\ExtentReports.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	
	
	reporter.config().setReportName("HDFC NET BANKING");
	reporter.config().setDocumentTitle("HDFC NET BANKING Results");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	return extent;
	}
}
