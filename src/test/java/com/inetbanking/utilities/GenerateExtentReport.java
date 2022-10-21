package com.inetbanking.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class GenerateExtentReport {

	ExtentReports extent;
	ExtentTest test;
	ExtentHtmlReporter htmlreporter;
	
	@BeforeTest
	public void startReport() {
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+timestamp+".html";
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlreporter.loadConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host name", "local host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Nandish");
			
	}
	
	@Test
	public void demoReportpass() {
		
		test = extent.createTest("DemoReportPass");
		Assert.assertTrue(true);
		test.log(Status.PASS, "Assert pass as condition is true");
	}
	
	@Test
	public void  demoReportFail() {
		test = extent.createTest("DemoReportFail");
		Assert.assertTrue(false);
		test.log(Status.FAIL, "Assert fail as condition is false");
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		}		
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
}
