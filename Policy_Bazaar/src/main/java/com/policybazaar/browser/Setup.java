package com.policybazaar.browser;

import java.util.Scanner;
import org.openqa.selenium.WebDriver;

import com.policybazaar.secondary.ChromeDriverSetup;
import com.policybazaar.secondary.EdgeDriverSetup;

public class Setup {

	public WebDriver createWebDriver(){

		WebDriver driver=null;
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);

		int ch,flag=0;

		do {

			System.out.println("Choose a browser for automation:\n1. Google Chrome.\n2. Microsoft Edge.\n\nEnter your choice:\n");
			ch=sc.nextInt();

			if(ch==1){

				ChromeDriverSetup live1=new ChromeDriverSetup();
				driver=live1.getWebDriver();
				
				flag=0;
			}

			else if(ch==2){

				EdgeDriverSetup live2=new EdgeDriverSetup();
				driver=live2.getWebDriver();
				
				flag=0;
			}

			else{

				System.out.println("Invalid Choice.\nPlease try again.\n\nThank you.\n");
				flag=1;
			}

		}while(flag==1);
		
		return driver;
	}

}
