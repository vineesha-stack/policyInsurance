package reoirt;



import java.io.File;

import org.apache.http.client.utils.DateUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

	public class Report {
		 
		 public static ExtentHtmlReporter htmlReporter;
		 public static ExtentReports report;
		 
		 public static ExtentReports getInstance() {
			 
			 if( report ==null) {
				  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-output//report.html");
				 
				 report = new ExtentReports();
				 
				 report.attachReporter(htmlReporter);
				 
				 report.setSystemInfo("OS", "Windows-64Bit");
				 report.setSystemInfo("OS-Version", "10.0.0");
				 report.setSystemInfo("Browser", "Chrome");
				 report.setSystemInfo("Browser-Version", "88.0.0.1");
				 
				 htmlReporter.config().setDocumentTitle("Hckathon project");
				 htmlReporter.config().setReportName("Final Report");
				 htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
				 htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
				 
			 }
			 
			 return report;
		 }
		
	}

