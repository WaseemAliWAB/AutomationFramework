package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of TestNG
 * Example for Abstraction
 * 
 * @author WASEEM ALI BHAT
 *
 */
public class ListenerImplementationClass implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("---- Execution started ----"+methodName);
		
		test = report.createTest(methodName);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		//System.out.println("---- PASS ----"+methodName);
		
		test.log(Status.PASS, "---- PASS ----"+methodName);
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		//System.out.println("---- FAIL ----"+methodName);
		
		test.log(Status.FAIL, "---- FAIL ----"+methodName);
		
		//System.out.println(result.getThrowable());
		
		test.log(Status.INFO, result.getThrowable());
		
		WebDriverUtility wu = new WebDriverUtility();
		JavaUtility ju = new JavaUtility();
		
		 String screenshotName = methodName+ju.getSystemDateInFormat();
		
		 try {
			 
			String path = wu.takeScreenShot(BaseClass.sdriver, screenshotName);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		//System.out.println("---- SKIP ----"+methodName);
		
		test.log(Status.SKIP, "---- SKIP ----"+methodName);
		
		//System.out.println(result.getThrowable());
		
		test.log(Status.INFO, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// start of <suite> - @BeforeSuite
		
		System.out.println("---- suite execution started ----");
		
		//Configure the extent report
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("vtiger Execution Report");
		htmlReport.config().setReportName("Build 3 vtiger Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		//Report Generation
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Base Platform", "Testing -Env");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base OS", "windows");
		report.setSystemInfo("Reporter", "Waseem");
		
		
	}

	public void onFinish(ITestContext context) {
		// end of <suite> - @AfterSuite
		
		System.out.println("---- suite execution ended ----");
		
		//Report Generation
		report.flush();
	}
	
}
