package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class utility {

	static String ProjectRootpath = System.getProperty("user.dir");

	
	private static Properties defaultProps = new Properties();
	static {
		try {
			FileInputStream in = new FileInputStream(ProjectRootpath
					+ "/src/main/java/config/config.property");
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

	public static ResultSet connectToDataBase() throws Exception {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String userName = "dev";
		String password = "p@ssw0rd1";
		String url = "jdbc:sqlserver://192.168.1.210" + ";DatabaseName=TestDB";
		Connection con = DriverManager.getConnection(url, userName, password);

		String query = "SELECT * FROM cityname";
		Statement s1 = con.createStatement();

		ResultSet ResultSet = s1.executeQuery(query);

		while (ResultSet.next()) {
			System.out.println(ResultSet.getString(1) + "\t "
					+ ResultSet.getString(2) + "\t " + ResultSet.getString(3)
					+ "\t" + ResultSet.getString(4));

		}

		return ResultSet;

	}

}
