package rahulshettyacademy.TestComponents;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReports.ExtentReporterNG;

public class Listeners extends BaseTest  implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject(); // getting the data from the ExtentReporterNG CLASS.
	ThreadLocal<ExtentTest> extentTest  = new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		
		test = extent.createTest(result.getMethod().getMethodName()); //fetchs the method name and creates an entry in the extent report.
		
		extentTest.set(test); //assign a unique thread ID of error validation test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS,"Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		extentTest.get().fail(result.getThrowable());
		//Screenshot for only failed scenarios
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {  //parent of all exceptions
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		
		
		
		String filePath = null;
		extentTest.get().fail(result.getThrowable());
		//Screenshot for only failed scenarios
		
		
	
		 try {
			filePath= getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		 extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());  //must tell the target/directory  of the screenshot grabbed 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		
		ITestListener.super.onFinish(context);
		
		extent.flush();
	}
 
}
