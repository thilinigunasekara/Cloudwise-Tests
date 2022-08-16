package com.cloudwise.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;


public class BaseTest{

	private static UIDriver uiDriver = new UIDriver();

	public static Scenario scenario;

	/**
	 * Initializes UIDriver instance
	 */
	public void setUIDriver() {
		uiDriver.initUIDriver();
		uiDriver.setConsoleLogger();
	}

	/**
	 * Get UIDriver instance
	 */
	public UIDriver getUIDriver() {
		return uiDriver;
	}

	/**
	 * Navigates to URL
	 */
	public void navigateToUrl(String url)
	{
		uiDriver.getWebDriver().navigate().to(url);
		logger("Navigates to " + url);
	}

	/**
	 * Returns Site Properties.
	 * @return properties
	 */
	public Properties getSiteProp() {

		Properties prop = new Properties();
		FileReader reader = null;
		File file = null;

		try {

			file = new File("Site_Properties" + File.separator + "Cloudwise.properties");

			if(file.exists())
			{
				reader = new FileReader(file.getAbsolutePath());
				prop.load(reader);
			}

			return prop;

		} catch (IOException e) {
			return prop;
		}
		}


	/**
	 * Writes the log
	 */
	public void logger(String logString)
	{
		//Log4j Logging
		uiDriver.getLog4jLogger().info(logString);
	}
	@AfterClass
	public static void closeBrowserAfterTest() {
		//close driver
		uiDriver.getWebDriver().close();
		//quitting driver
		uiDriver.getDriver().quit();
	}
}
