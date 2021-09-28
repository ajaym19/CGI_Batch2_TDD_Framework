package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class LoginPage extends Base {
	
	//PageFactory
	@FindBy(id = "txtUsername")
	WebElement username;
	
	@FindBy(id = "txtPassword")
	WebElement password;
	
	@FindBy(id = "btnLogin")
	WebElement loginBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle() {
		return driver.getTitle();
	}

	public void validateLogin(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
	}

}
