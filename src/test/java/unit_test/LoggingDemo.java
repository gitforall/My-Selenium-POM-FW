package unit_test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggingDemo {

	static Logger log = Logger.getLogger(LoggingDemo.class.getName());

	public static void main(String[] args) {

		/*
		 * String log4jConfigFile = System.getProperty("user.dir") +
		 * File.separator + "src\\test\\java\\config\\log4j.properties";
		 * PropertyConfigurator.configure(log4jConfigFile);
		 */
        PropertyConfigurator.configure("log4j.properties");

		log.debug("this is a debug log message");
		log.info("this is a information log message");
		log.warn("this is a warning log message");
		System.out.println("Hari");

	}

}
