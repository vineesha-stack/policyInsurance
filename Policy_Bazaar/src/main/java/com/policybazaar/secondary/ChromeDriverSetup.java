package com.policybazaar.secondary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverSetup {
	
	public WebDriver getWebDriver() {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\webDrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		return driver;
	}
}
