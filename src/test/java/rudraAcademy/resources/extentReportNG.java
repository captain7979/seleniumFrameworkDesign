package rudraAcademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportNG {
	
	public static ExtentReports getreportObject()
	{
		  String path= System.getProperty("user.dir")+"\\reports\\index.html";
		    
			ExtentSparkReporter reporter=new ExtentSparkReporter(path);
			reporter.config().setReportName("Captain DashBoard");
			reporter.config().setDocumentTitle("Test Results");
			ExtentReports repo=new ExtentReports();
			repo.attachReporter(reporter);
			repo.setSystemInfo("Tester", "Captain Testing World");
			return repo;
		
	}

}
