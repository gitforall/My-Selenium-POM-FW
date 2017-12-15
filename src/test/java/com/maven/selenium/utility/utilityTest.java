package com.maven.selenium.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class utilityTest {

	static String ProjectRootpath = System.getProperty("user.dir");
	private static Properties defaultProps = new Properties();
	static {
		try {
			FileInputStream in = new FileInputStream(ProjectRootpath
					+ "/src/config/config.property");
			defaultProps.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getDataRepoFilePath() throws IOException {

		String DataRepoFilePath = defaultProps.getProperty("Excelpath");
		System.out.println(defaultProps.getProperty("Excelpath"));
		System.out.println(defaultProps.getProperty("ApplicationUrl"));
		return DataRepoFilePath;
	}

	public static WebDriver browserFactory(WebDriver driver, String BrowserName) {

		if (BrowserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					"D:/Hari/Selenium/work/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		} else if (BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:/Hari/Selenium/work/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(defaultProps.getProperty("ApplicationUrl"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (BrowserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.ie.driver",
					"D:/Hari/Selenium/work/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}

		return driver;

	}

	public static void log4jconfig() {

		String log4jConfigFile = System.getProperty("user.dir")
				+ File.separator + "src\\test\\java\\config\\log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
	}

}
