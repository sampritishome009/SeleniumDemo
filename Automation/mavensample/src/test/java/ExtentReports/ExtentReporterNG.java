package ExtentReports;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	ExtentReports extent;
	
	@BeforeTest
public static ExtentReports getReportObject() {
	//ExtentReport, //ExtentSparkReport
		
	String path= System.getProperty("user.dir")+"//Automation//mavensample//ExtentReportReserve//index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);	
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("TestResults");
	
	ExtentReports extent = new ExtentReports(); //attach all previouly built  report to the main class
	extent.attachReporter(reporter);//now the extent class will have knowledge of the spark report class.
	extent.setSystemInfo("Tester", "Sampriti Shome"); //tester details
	return extent;
	}
	
	
}
