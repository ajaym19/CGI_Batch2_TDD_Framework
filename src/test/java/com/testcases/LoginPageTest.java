package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.LoginPage;

public class LoginPageTest extends Base {
	
	LoginPage lp;

	@BeforeMethod
	public void browserSetup() {
		initialization();
		lp = new LoginPage();
	}
	
	@Test(priority = 1)
	public void validateTitleTest() {
		String expectedTitle = "OrangeHRM";
		String actualTitle = lp.validateTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 2)
	public void validateLoginTest() {
		lp.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void closeBrowserSetup() {
		tearDown();
	}
}
