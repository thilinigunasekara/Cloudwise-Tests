package com.cloudwise.base;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private WebDriver driver;
	private Logger logger;

	private int elementTimeOut = 10;
	private int pageLoadTimeOut = 20;

	public BasePage(UIDriver uiDriver)
	{
		driver = uiDriver.getWebDriver();
		logger = uiDriver.getLog4jLogger();
	}
	
	/**
	 * Returns specific cookie value
	 * @param cookieName
	 * @return cookie value
	 */
	protected String getCookie(String cookieName)
	{
		String cookieVal = driver.manage().getCookieNamed(cookieName).getValue();
		logger.info("Extracted Cookie Value for "+ cookieName +" as " + cookieVal + " - Completed");
		return cookieVal;
	}
	
	/**
	 * Navigate to back on browser
	 */
	protected void navigateBack()  {
		driver.navigate().back();
		waitUntilPageLoadCompleted();
	}
	
	/**
	 * Waits until the element to be visible and returns the WebElement created
	 * @return a WebElement
	 */
	protected WebElement waitElementToBeVisible(By locator)
	{
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(elementTimeOut));
		return waitElement.until(
				ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * Waits until the element to be invisible
	 * @return a WebElement
	 */
	protected void waitElementToBeInvisible(By locator)
	{
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(elementTimeOut));
		waitElement.until(
				ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	/**
	 * Waits until the elements to be visible and returns the List of WebElement created
	 * @return a List<WebElement>
	 */
	protected List<WebElement> waitElementsToBeVisible(By locator)
	{
		WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(elementTimeOut));
		return waitElement.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	/**
	 * Waits until the page is loaded
	 */
	protected void waitUntilPageLoadCompleted() {
		JavascriptExecutor js = (JavascriptExecutor)driver;

		WebDriverWait waitPgLoad = new WebDriverWait(driver, Duration.ofSeconds(pageLoadTimeOut));
		waitPgLoad.until(
				webDriver -> js.executeScript("return document.readyState")
				.equals("complete"));

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			logger("Page load is not completed");
			Thread.currentThread().interrupt();

		}
	}

	/**
	 * Clicks by Javascript
	 */
	protected void clickByJavascriptExecutor(WebElement webElement) throws InterruptedException
	{

			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript(
					"arguments[0].click();", webElement);
			Thread.sleep(300);

	}
	
	/**
	 * Returns a Actions class.
	 * Do build() and perform() sequentially after using action methods.
	 * @return a Actions instance
	 */
	protected Actions getActions()
	{
		return new Actions(driver);
	}
	
	/**
	 * Get Logger
	 */
	public void logger(String message)
	{
		logger.info(message);
	}
}
