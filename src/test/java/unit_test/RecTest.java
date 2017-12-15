package unit_test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RecTest {

	public static void main(String[] args) {

		Logger log = Logger.getLogger("devpinoyLogger");
		System.setProperty("webdriver.chrome.driver",
				"D:/Hari/Selenium/work/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.in/2016/08/bootstrap-dropdown-example-for-selenium.html");
		log.debug("opening webiste");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElement(By.id("//button[@id='menu1']")).click();
		driver.findElement(By.xpath(".//*[@id='menu1']")).click();
		List<WebElement> language = driver.findElements(By
				.xpath("//*[@class='dropdown open']/ul/li/a"));

		for (WebElement ele : language) {

			String a = ele.getAttribute("innerHTML");
			System.out.println(a);

			if (a.equalsIgnoreCase("JavaScript")) {
				ele.click();
				log.debug("entring JavaScript");
				break;
			}

		}

	}

}
