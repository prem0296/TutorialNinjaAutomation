package utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	ExtentTest test;
	String reportname;
	
	public void onStart(ITestContext context) {
		
		LocalDateTime currentDateTime = LocalDateTime.now();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
	    reportname = "Test-Report_" + currentDateTime.format(formatter) + ".html";
		 

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/" + reportname);
		extent = new ExtentReports();
		
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Prem");
		sparkReporter.config().setTheme(Theme.STANDARD);
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "OpenKart");
		extent.setSystemInfo("QA name", System.getProperty("user.name"));
		
//		String os = context.getCurrentXmlTest().getParameter("os");
//		extent.setSystemInfo("operating system" , os);
//		
//		String browser = context.getCurrentXmlTest().getParameter("browser");
//		extent.setSystemInfo("Browser" , browser);
		

	}
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test passed is : " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test FAILED is : " + result.getName());
		test.log(Status.FAIL, "failure reason is  : " + result.getThrowable());
		test.log(Status.INFO, "failure reason is  : " + result.getThrowable().getMessage());
		
		try {
			
		//	BaseClass b = new BaseClass();
		//	String imgPath =  b.captureScreenShot(result.getName());
			
			String imgPath = new BaseClass().captureScreenShot(result.getName());
			
			test.addScreenCaptureFromPath(imgPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test SKIPPED is : " + result.getName());
	}
	
	public void onFinish(ITestContext context) {

		extent.flush();
		String pathofthereport = System.getProperty("user.dir") + "\\Reports\\" + reportname;
		File extentreport = new File(pathofthereport);
		
		try {
			Desktop.getDesktop().browse(extentreport.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	
	public void onTestStart(ITestResult result) {


	}

	

	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

}
