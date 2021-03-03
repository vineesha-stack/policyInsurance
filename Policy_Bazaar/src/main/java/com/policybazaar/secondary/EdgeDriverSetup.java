package com.policybazaar.secondary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverSetup {

public WebDriver getWebDriver(){
		
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\webDrivers\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		
		return driver;
	}
}
