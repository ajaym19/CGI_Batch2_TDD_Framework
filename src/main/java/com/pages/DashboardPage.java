package com.pages;

import org.openqa.selenium.By;

import com.base.Base;

public class DashboardPage extends Base {

	public boolean validateDashboardTab() {
		return driver.findElement(By.xpath("//b[text()='Dashboard']")).isDisplayed();
	}
}
