package com.GenricUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener_Implimentation implements ITestListener{

	
	ExtentReports Reports;
	ExtentTest Test;
	@Override
	public void onTestStart(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		Test = Reports.createTest(MethodName);
		Reporter.log(MethodName+"---------------->Execution Starts Here----");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		
		Test.log(Status.PASS, "PASS");
		Reporter.log(MethodName+"--------TestScript is PASS");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		String FScript  = result.getMethod().getMethodName();
		String FS = FScript+new JavaUtilities().systemDateFormt();
		Test.addScreenCaptureFromPath(FS);
		try {
			WebdriverUtilities.captureScreenShot(Admin_Bass_Class.sdriver,FS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		Test.log(Status.FAIL, "TestScript is FAIL");
		Test.log(Status.FAIL, result.getThrowable());
		Reporter.log(FScript+"-----------TestScript is FAIL");
		
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		String SScript = MethodName+new JavaUtilities().systemDateFormt();
		
		try {
			WebdriverUtilities.captureScreenShot(Admin_Bass_Class.sdriver, SScript);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Test.addScreenCaptureFromPath(SScript);
		Test.log(Status.SKIP, "TestScript is SKIPPED");
		Test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"--------TestScript is SKIPPED");
	}

	@Override
	public void onStart(ITestContext context) {
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./Extent Report/Report.html");
		htmlReport.config().setDocumentTitle("ONLINE FOOD ORDERING SYSTEM");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("Hunger Mantra");
		
		Reports = new ExtentReports();
		Reports.attachReporter(htmlReport);
		Reports.setSystemInfo("Base Browser", "Chrome");
		Reports.setSystemInfo("Base URL", "https://");
		Reports.setSystemInfo("Repoter Name", "Rakesh");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
		Reports.flush();
	}
	
	

}
