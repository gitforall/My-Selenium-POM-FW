package com.maven.selenium.Tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class PhantomJSTest {

	WebDriver driver;

	@Test
	public void login() throws IOException {

		File file = new File(
				"D:\\Hari\\Selenium\\PhantomJS\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		//System.setProperty("phantomjs.binary.path", file.getAbsolutePath());

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setCapability("takesScreenshot", true);
		caps.setCapability(
				PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				file.getAbsolutePath());
		driver = new PhantomJSDriver(caps);

		driver.get("http://www.google.com");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println(driver.getTitle());

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("D://sample.png"));

		// driver.save_screenshot("D://sample.png");

	}

}
