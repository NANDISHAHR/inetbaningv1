package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws Exception {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		logger.info("Providing customer details");
		
		addcust.clickAddNewCustomer();
		addcust.custName("Nandish");
		addcust.custgender("male");
		addcust.custdob("10", "12", "1997");
		
		Thread.sleep(3000);
		
		addcust.custaddress("INDIA");
		addcust.custcity("Bengaluru");
		addcust.custstate("KA");
		addcust.custpinno("500074");
		addcust.custtelephoneno("9870349333");
		
		String email = radndomstring()+"@gmail.com";
		addcust.custemailid(email);
		
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation started..........");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("test case is passed");
		}
		else {
			logger.info("test case is failed");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			
		}
	}
	
	
	
}
