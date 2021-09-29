package com.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.util.ExcelReader;

public class LoginPageTest extends Base {
	
	ExcelReader reader;
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
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
		test.log(Status.PASS, " Validate title TC Passed");
		logger.info("Completed with validateTitleTest TestCase ");
	}
	
	@Test(priority = 2)
	public void validateLoginTest() {
		ExtentTest test = extent.createTest("Validating Login TC");
		logger.info("Starting with validateLoginTest TestCase ");
		dp = lp.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		boolean bool = dp.validateDashboardTab();
		AssertJUnit.assertTrue(bool);
		logger.info("Completed with validateLoginTest TestCase ");
		test.log(Status.FAIL, "Validate Login TC is failed");
	}
	
	@Test (dataProvider = "getData")
	public void validateMultipleLogin(String userName, String password) {
		dp = lp.validateLogin(userName, password);
	}
	
	
	@DataProvider(name = "getData")
	public Object[][] getLoginData() {
		Object data[][] = null;
		String excelPath = "./src/test/resources/TestData/Auto (1).xlsx";
		String sheetName = "data";
		reader = new ExcelReader(excelPath, sheetName);
		data= reader.getTestData();
		return data;
		
	}
	
	
	@Test
	@Parameters({"username", "password"})
	public void getDataFromTestNGXMLFile(String username, String password) {
		System.out.println(username);
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
