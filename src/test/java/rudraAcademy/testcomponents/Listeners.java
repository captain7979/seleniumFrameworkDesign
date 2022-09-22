package rudraAcademy.testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rudraAcademy.resources.extentReportNG;


public class Listeners extends baseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent=extentReportNG.getreportObject();
	ThreadLocal<ExtentTest>extenttest=new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
	test=extent.createTest(result.getMethod().getMethodName()); 
	extenttest.set(test);
	    // not implemented
	  }

	@Override
	  public void onTestSuccess(ITestResult result) {
	    // not implemented
		extenttest.get().log(Status.PASS, "PASSED");
	  }

	@Override
	  public void onTestFailure(ITestResult result) {
	    // not implemented
		extenttest.get().fail(result.getThrowable());
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		String filePath=null;
		try {
			filePath=takeScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenttest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	  }

	@Override
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	@Override
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	@Override
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	@Override
	  public void onStart(ITestContext context) {
	    // not implemented
	  }

	@Override
	  public void onFinish(ITestContext context) {
	    // not implemented
		extent.flush();
	  }
}
