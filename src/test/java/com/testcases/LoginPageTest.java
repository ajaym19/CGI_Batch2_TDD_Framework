package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginPageTest {
	
	LoginPage lp = new LoginPage();

	@BeforeMethod
	public void browserSetup() {
		lp.browserSetup();
	}
	
	@Test
	public void validateTitleTest() {
		String expectedTitle = "OrangeHRM";
		String actualTitle = lp.validateTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void validateLoginTest() {
		//write all the code here
	}
	
	@AfterMethod
	public void closeBrowserSetup() {
		lp.closeSetup();
	}
}
