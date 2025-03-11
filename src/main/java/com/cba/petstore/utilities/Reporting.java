package com.cba.petstore.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting {

	public static ExtentReports extent;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	public static ExtentReports initReport() {
		//Path to save the report
		String reportPath = System.getProperty("user.dir")+"/reports/ExtentReport.html";
		
		//
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setDocumentTitle("Test Execution Report");
		sparkReporter.config().setReportName("API Automation Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Tester", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		return extent;
		
	}
	
	//create a test in the report
	public static void createTest(String testname) {
		ExtentTest test = extent.createTest(testname);
		extentTest.set(test);
		
	}
	
	//get the current test
	public static ExtentTest  getTest() {
		
		 if (extentTest.get() == null) {
	            throw new IllegalStateException("ExtentTest is not initialized. Did you forget to call createTest()?");
	        }
		return extentTest.get();
	}
	
	public static void flushReport() {
		if(extent!=null) {
			extent.flush();
		}
	}
}
