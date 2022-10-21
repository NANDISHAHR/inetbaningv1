package com.inetbanking.testCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.ExcelUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username is provided");
		lp.setPassword(pwd);
		logger.info("password is provided");
		lp.clickSubmit();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent(); //focus on the main page
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();//close the logout alert
			driver.switchTo().defaultContent();
			
		}
	}
	
	public boolean isAlertPresent() { //user defined method created to check alert is present or not, we can also add this method in base Class
		
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name = "LoginData")
	String [][] getdata() throws Exception {
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int rownum = ExcelUtils.getRowCount(path, "Sheet1");
		int cocount = ExcelUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][cocount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<cocount;j++) {
				logindata[i-1][j]=ExcelUtils.getCellData(path, "Sheet1", i, j);//1 and 0
			}
		}
	return logindata;
	}
}
