package ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {


	ExtentReports extent;
	
	@BeforeTest
public void config() {
	//ExtentReport, //ExtentSparkReport
		
	String path= System.getProperty("user.dir")+"//Automation//mavensample//ExtentReportReserve//index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);	
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("TestResults");
	
	extent = new ExtentReports(); //attach all previouly built  report to the main class
	extent.attachReporter(reporter);//now the extent class will have knowledge of the spark report class.
	extent.setSystemInfo("Tester", "Sampriti Shome"); //tester details
	
	
	
	
	}
	@Test
	public void initialDemo() {
		
		ExtentTest test = extent.createTest("Initial Demo");
	//	System.setProperty("webdriver.chrome.driver","/Users/sampritishome/Downloads/chromedriver-mac-arm64");
		WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/");
			System.out.println(driver.getTitle());
			driver.close();
			test.fail("Result does not match");
			extent.flush();  //at the end of execution, flush stops the monitoring and updates the status with pass or fail.
			
		
	}

	

}
