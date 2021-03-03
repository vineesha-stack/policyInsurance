package com.policybazaar.primary;

import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.policybazaar.input.Input;
import com.policybazaar.secondary.Home_Page;
import com.policybazaar.secondary.Read_Data;

import reoirt.Report;

public class Health_Insurance {
	ExtentReports report = Report.getInstance();
	ExtentTest logger;
	

	public static WebDriver driver;
	public static String[] readExcelData() throws Exception{
		String[] data = Input.readExcelDataForHealth();
	
		return data;
		
	}

	@Test(priority=3)
	public void healthInsurance() throws Exception {
		logger = report.createTest("Health Insurance Report");
		String[] data = readExcelData();
	
		System.out.println("\nHealth Insurance\n");
		Home_Page ob=new Home_Page();
		driver=ob.setup();
		
		Read_Data read=new Read_Data();
		Properties prop=read.getData();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		//Click on health insurance button
		driver.findElement(By.xpath(prop.getProperty("x"))).click();

		//Male or Female
		driver.findElement(By.xpath(prop.getProperty("Male"))).click();
	
		//Enter Full name
		driver.findElement(By.xpath(prop.getProperty("Full"))).sendKeys(data[0]);
		
		//Enter Mobile number
		
		driver.findElement(By.xpath(prop.getProperty("y"))).sendKeys(data[1]);
		driver.findElement(By.xpath(prop.getProperty("input"))).click();
		
		//Click on "My Parents"
		driver.findElement(By.xpath(prop.getProperty("parents"))).click();
		
		//Click onAge
		
		Select select = new Select(driver.findElement(By.xpath(prop.getProperty("sel"))));
		select.selectByValue("50");
		
		driver.findElement(By.xpath(prop.getProperty("submit"))).click();
		
		//Enter the city
		
		driver.findElement(By.id("txtcity")).sendKeys(data[2]);
		
		driver.findElement(By.xpath(prop.getProperty("z"))).click();
		driver.findElement(By.xpath(prop.getProperty("w"))).click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);

		//Click on NO

		driver.findElement(By.xpath(prop.getProperty("No"))).click();

		/*try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("wait"))));

		//Retrieve all health insurance menu items and store in a list

		//js.executeScript("window.scrollBy(0,700)");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		/*try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(prop.getProperty("top")))));
		List<WebElement> MenuLists = driver.findElements(By.xpath(prop.getProperty("top")));

		//List<WebElement> li = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(driver.findElements(By.xpath("//div[@class='top_quotes_content']"))));


		//js.executeScript("arguments[0].scrollIntoView(true);", MenuLists);

		//ListIterator<WebElement> ListOfMenuLists = MenuLists.listIterator();

		/*if (MenuLists.size() > 0) {
			    		//Displaying the menu buttons
			    		System.out.println("The List of Menus are:");

			    		while (ListOfMenuLists.hasNext()) {
			    		String elem = ListOfMenuLists.next().getText();
			    		System.out.println(elem + '\n');
			    		}
			    	}
			    	else {
			    		System.out.println("No menu lists are available now");
			    		}
			    	}*/
		
		int count = MenuLists.size();
		System.out.println("\nTotal number of links: "+count+"\n");
		
		for(int i=0;i<count;i++)
		{
			System.out.println("\nLink "+(i+1)+": "+MenuLists.get(i).getText());
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

