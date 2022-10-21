package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;



public class PracticeListeners {

	@Test
	public void loginemai() {
		System.out.println("Login By email");
		Assert.assertEquals("Nandi", "Nandi");
	}
	
	@Test
	public void loginwithfacebook() {
		System.out.println("login with facebook");
		Assert.assertEquals("Abcd", "mkov");
	}
}
