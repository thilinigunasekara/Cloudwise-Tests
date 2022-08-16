package com.cloudwise.base;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UIDriver {

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	private Logger log;

	/**
	 * Initializing WebDriver requested
	 * @return Initialized WebDriver instance
	 */
	public void initUIDriver()
	{
		if(driver == null) {
			//setting up chrome browser
			System.setProperty("webdriver.chrome.driver", 
					new File("Drivers" + File.separator + "chromedriver.exe").getAbsolutePath());
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			//other browsers can come here if needed with if condition checking which browser required
		}
		
	}

	/**
	 * Returns the initialized WebDriver instance
	 * @return WebDriver instance
	 */
	public WebDriver getWebDriver()
	{
		if(driver != null)
			return driver;
		else
			return null;
	}

	/**
	 * Sets and initialize the Log4j Console Logger
	 */
	public void setConsoleLogger()
	{
		if(log == null)
		{
			log = Logger.getLogger("Automated Tests");
			PropertyConfigurator.configure(new File("Reporter" + File.separator 
					+ "log4j.properties").getAbsolutePath());
		}
	}

	/**
	 * Returns the initialized Log4j instance
	 * @return Initialized Log4j instance
	 */
	public Logger getLog4jLogger()
	{
		return log;
	}
}

