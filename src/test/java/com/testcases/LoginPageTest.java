package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base;
import com.pages.DashboardPage;
import com.pages.LoginPage;

public class LoginPageTest extends Base {
	
	LoginPage lp;
	DashboardPage dp;

	@BeforeTest
	public void reportSetup() {
		extentReportSetup();
	}
	
	@BeforeMethod
	public void browserSetup() {
		initialization();
		lp = new LoginPage();
	}
	
	@Test(priority = 1)
	public void validateTitleTest() {
		ExtentTest test = extent.createTest("OrangeHRM Title Test");
		logger.info("Starting with validateTitleTest TestCase ");
		String expectedTitle = "OrangeHRM";
		String actualTitle = lp.validateTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		test.log(Status.PASS, " Validate title TC Passed");
		logger.info("Completed with validateTitleTest TestCase ");
	}
	
	@Test(priority = 2)
	public void validateLoginTest() {
		ExtentTest test = extent.createTest("Validating Login TC");
		logger.info("Starting with validateLoginTest TestCase ");
		dp = lp.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		boolean bool = dp.validateDashboardTab();
		Assert.assertTrue(bool);
		logger.info("Completed with validateLoginTest TestCase ");
		test.log(Status.FAIL, "Validate Login TC is failed");
	}
	
	@AfterMethod
	public void closeBrowserSetup() {
		tearDown();
	}
	
	@AfterTest
	public void closeReportSetup() {
		closeExtentReportSetup();
	}
}
