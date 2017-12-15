package testCase;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataProvider.DataProviderClass;
import pages.AbmisLoginPage;
import utility.utility;

public class LoginTest {

	static WebDriver driver;
	static String browser = "chrome";

	@BeforeTest
	public void Setup() throws IOException

	{
		driver = utility.browserFactory(driver, browser);
	}

	@Test(dataProvider = "LoginFunctionality", dataProviderClass = DataProviderClass.class)
	public void suceslogin(String uname, String pwd)
			throws InterruptedException {

		AbmisLoginPage lg = new AbmisLoginPage(driver);
		lg.loginIntoApplication(uname, pwd);

	}

}
