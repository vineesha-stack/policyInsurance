package com.policybazaar.primary;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.policybazaar.input.Input;
import com.policybazaar.secondary.Home_Page;
import com.policybazaar.secondary.Read_Data;

import reoirt.Report;

public class Travel_Insurance {
	ExtentReports report = Report.getInstance();
	ExtentTest logger;
	

	public static WebDriver driver;
	public static String[] readExcelData() throws Exception{
		String[] data = Input.readExcelDataForTravel();
	
		return data;
		
	}


	@Test(priority=1)
	public void travelInsurance() throws Exception {
		 logger = report.createTest("Travel Test Report");
		String[] data = readExcelData();

		System.out.println("\nTravel Insurance\n");
		
		Home_Page ob=new Home_Page();
		driver=ob.setup();

		Read_Data read=new Read_Data();
		Properties prop=read.getData();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		// click on travel insurance
		driver.findElement(By.xpath(prop.getProperty("xpath1"))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		// click on know more link
		driver.findElement(By.linkText(prop.getProperty("know"))).click();

		// click on student
		driver.findElement(By.xpath(prop.getProperty("studentXpath"))).click();

		// click on X to delete USA
		driver.findElement(By.xpath(prop.getProperty("USA"))).click();

		// selecting destination
		//driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Russian Federation");
		driver.findElement(By.xpath(prop.getProperty("russiaXpath"))).sendKeys(data[0]);
		
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("xpath2"))));
		driver.findElement(By.xpath(prop.getProperty("xpath2"))).click();

		// selecting the age of the students
		driver.findElement(By.id("memage1")).sendKeys(data[1]);
		driver.findElement(By.id("memage2")).sendKeys(data[2]);

		// Selecting the start date

		JavascriptExecutor js = (JavascriptExecutor) driver;

		
		driver.findElement(By.id("startdate")).click();

		js.executeScript("window.scrollBy(0,150)");
		WebElement el=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/div[9]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[3]/span[1]")));
		el.click();
		WebElement ele= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("cal1"))));
		ele.click();

		driver.findElement(By.id("enddate")).click();
		

		WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("cal2"))));
		ele1.click();

		// proceed Button
		
		driver.findElement(By.xpath(prop.getProperty("proceed"))).click();
		
		
		// select gender
		
		WebElement sortbydrop = driver.findElement(By.id(prop.getProperty("gender")));
		sortbydrop.click();
		
		Select gender = new Select(sortbydrop);
		gender.selectByIndex(1);

		// enter the name
		driver.findElement(By.id(prop.getProperty("trName"))).sendKeys(data[3]);

		// enter the phone number
		driver.findElement(By.id(prop.getProperty("trMobile"))).sendKeys(data[4]);

		// enter the mail
		driver.findElement(By.id(prop.getProperty("trEmail"))).sendKeys(data[5]);

		// click on proceed
		driver.findElement(By.xpath(prop.getProperty("proceed2"))).click();
		
		// select by sorting
		
		WebElement sortbydrop1 = driver.findElement(By.xpath(prop.getProperty("xpath3")));
		
		Select sort = new Select(sortbydrop1);
		sort.selectByIndex(1);

		driver.findElement(By.xpath(prop.getProperty("xpath4"))).click();
		
		// extracting list and printing to console

		List<WebElement> MenuLists = driver.findElements(By.xpath(prop.getProperty("xpath5")));
		int i=0;
		
		for (WebElement menu : MenuLists) {
			if(i<3) {
				System.out.println(menu.getText());
				i++;
			}

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
	@AfterSuite
	public void stop() {
		report.flush();
	}
	
}
