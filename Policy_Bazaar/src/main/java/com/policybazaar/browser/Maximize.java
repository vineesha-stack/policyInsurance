package com.policybazaar.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Maximize {

	public void fullScreen(WebDriver driver) {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}
}
