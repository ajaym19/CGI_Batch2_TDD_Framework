package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.DashboardPage;
import com.pages.LoginPage;

public class LoginPageTest extends Base {
	
	LoginPage lp;
	DashboardPage dp;

	@BeforeMethod
	public void browserSetup() {
		initialization();
		lp = new LoginPage();
	}
	
	@Test(priority = 1)
	public void validateTitleTest() {
		logger.info("Starting with validateTitleTest TestCase ");
		String expectedTitle = "OrangeHRM";
		String actualTitle = lp.validateTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		logger.info("Completed with validateTitleTest TestCase ");
	}
	
	@Test(priority = 2)
	public void validateLoginTest() {
		logger.info("Starting with validateLoginTest TestCase ");
		dp = lp.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		boolean bool = dp.validateDashboardTab();
		Assert.assertTrue(bool);
		logger.info("Completed with validateLoginTest TestCase ");

	}
	
	@AfterMethod
	public void closeBrowserSetup() {
		tearDown();
	}
}
