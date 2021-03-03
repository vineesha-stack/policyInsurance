package com.policybazaar.browser;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.policybazaar.secondary.Read_Data;

public class Navigate {
	Read_Data read=new Read_Data();
	Properties prop=read.getData();
	
	public void goTo(WebDriver driver) {
		
		driver.navigate().to(prop.getProperty("website"));
	}

}

