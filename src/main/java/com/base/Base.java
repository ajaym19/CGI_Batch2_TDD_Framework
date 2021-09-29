package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static String reportPath;
	
	public Base() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("./src/main/java/com/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!!!");
		} catch (IOException e) {
			System.out.println("Unable to read the file!!!");
		}
	}
	
	public void initialization() {
		logger = Logger.getLogger(Base.class);
		logger.info("Trying to read browser name");
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			logger.info("Identified the browser as "+ browser);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			logger.info("Identified the browser as "+ browser);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			logger.info("Identified the browser as "+ browser);
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		logger.info("Trying to launch the appplication");
		driver.get(prop.getProperty("url"));
		logger.info("Appplication launched successfully");
	}
	
	public void tearDown() {
		driver.quit();
		logger.info("Closing the browser");
	}
	
	public void extentReportSetup() {
		reportPath = System.getProperty("user.dir") + "/ExtentReport/index.html";
		reporter = new ExtentSparkReporter(reportPath);
		//extent spark reported can be used for some configurations
		reporter.config().setDocumentTitle("CGI Web Automation Report");
		reporter.config().setReportName("CGI Web Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		//we can use extent also to define some configs
		extent.setSystemInfo("Tester", "Ajay");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Sprint", "CGI Sprint 2");
	}
	
	public void closeExtentReportSetup() {
		extent.flush();
	}
}
