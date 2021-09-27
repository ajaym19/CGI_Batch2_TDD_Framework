package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	WebDriver driver;
	
	public void browserSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	public String validateTitle() {
		return driver.getTitle();
		
	}
	
	public void validateLogin() {
		
	}
	
	public void closeSetup() {
		driver.quit();
	}
}
