package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws Exception {
		
		
		
		
		LoginPage lp = new LoginPage(driver);
		
		logger.info("Enter UserName");
		lp.setUserName(username);
		logger.info("Enter password");
		lp.setPassword(password);
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
}
