package com.policybazaar.primary;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.policybazaar.input.Input;
import com.policybazaar.secondary.Home_Page;
import com.policybazaar.secondary.Read_Data;

import reoirt.Report;

public class Car_Insurance {
	ExtentReports report = Report.getInstance();
	ExtentTest logger;
	


	public static WebDriver driver;
	public static String[] readExcelData() throws Exception{
		String[] data = Input.readExcelDataForCar();
		return data;
		
	}
	
	
	@Test(priority=2)
	public void travelInsurance() throws Exception {
		 logger = report.createTest("Car Test Report");
		String[] data = readExcelData();
		System.out.println("\nCar Insurance\n");
		
		Home_Page ob=new Home_Page();
		driver=ob.setup();
		
		Read_Data read=new Read_Data();
		Properties prop=read.getData();
		
		//click on car Insurance
		driver.findElement(By.xpath(prop.getProperty("carXpath"))).click();
		
		//click on proceed without car number
		driver.findElement(By.xpath(prop.getProperty("carXpath2"))).click();
		
		//select the city & Rto

		driver.findElement(By.xpath("//span[contains(@id,'spn4')]")).click();
		driver.findElement(By.xpath(prop.getProperty("Rto"))).click();

		//select the car Brand
		driver.findElement(By.xpath(prop.getProperty("brand"))).click();
		
		//select the car Model
		driver.findElement(By.xpath(prop.getProperty("model"))).click();
		
		//select the car fuel type
		driver.findElement(By.xpath(prop.getProperty("fuel"))).click();
		
		//select the car variant
		driver.findElement(By.xpath(prop.getProperty("variant"))).click();
		
		//select the car registration year
		driver.findElement(By.xpath(prop.getProperty("year"))).click();
		
		//enter the full name
		driver.findElement(By.xpath(prop.getProperty("fullName"))).sendKeys(data[0]);
		
		//Enter the email
		driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(data[2]);
		
		//Enter the phonenumber
		driver.findElement(By.xpath(prop.getProperty("number"))).sendKeys(data[1]);
		
		//click on view prices
		driver.findElement(By.xpath(prop.getProperty("prices"))).click();


		//Capturing Screenshot of the webpage results 
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);

		try {
		
			//screenshot will be stored in project folder as error.png
			FileUtils.copyFile(file, new File("./screenshots/error.png"));
			System.out.println("\nScreenshot Captured Successfully.\n"
					+ "Please refresh the project and find the screenshot in the 'screenshots' folder.\n\nThank you.");
	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		

		driver.quit();
		

	}	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail(result.getName());
			logger.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass(result.getName());
		}
		
	}
	/*@AfterTest
	public void stop() {
		report.flush();
	}*/
	
	
	
}




