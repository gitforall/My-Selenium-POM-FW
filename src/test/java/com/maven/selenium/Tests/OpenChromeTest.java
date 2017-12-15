package com.maven.selenium.Tests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OpenChromeTest {

	WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	@BeforeSuite
	public void beforesuite() {
		extent = new ExtentReports(
				"D://Hari//Selenium//ws//MavenJenkins//target//extent-reports//test1.html");
		extent.loadConfig(new File(
				"D://Hari//Selenium//ws//MavenJenkins//extentReport//extent-config.xml"));
	}

	@Test
	public void chrome() {

		
		System.setProperty("webdriver.chrome.driver",
				"D:/Hari/Selenium/work/chromedriver.exe");
		
		test = extent.startTest((this.getClass().getSimpleName() ));
		test.assignAuthor("harinath");
		test.assignCategory("smoke test");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		test.log(LogStatus.PASS, "open google chrome");
	}
}
