package com.policybazaar.secondary;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.policybazaar.browser.Maximize;
import com.policybazaar.browser.Navigate;
import com.policybazaar.browser.Setup;

public class Home_Page {
	
	@BeforeSuite
	public WebDriver setup() {
		
		Setup ob=new Setup();
		WebDriver driver=ob.createWebDriver();

		Maximize fullscreen=new Maximize();
		fullscreen.fullScreen(driver);

		Navigate url=new Navigate();
		url.goTo(driver);
		
		return driver;
	}

}
