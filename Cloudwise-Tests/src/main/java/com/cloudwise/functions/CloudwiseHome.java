package com.cloudwise.functions;

import org.openqa.selenium.WebElement;

import com.cloudwise.base.BasePage;
import com.cloudwise.base.UIDriver;
import com.cloudwise.pageobjects.CloudwiseHomePage;

public class CloudwiseHome extends BasePage{

	private CloudwiseHomePage home = new CloudwiseHomePage();

	public CloudwiseHome(UIDriver uiDriver) {
		super(uiDriver);
	}

	public CloudwiseHome clickAcceptCookiesButton()
	{
		try {
			WebElement cookieAcceptBtn = waitElementToBeVisible(home.getAcceptCookieElement());

			if(cookieAcceptBtn.isDisplayed())
			{
				cookieAcceptBtn.click();
				waitElementToBeInvisible(home.getAcceptCookieElement());
				logger("Clicked Accept Cookies Button");
			}			

			return this;
		} catch (Exception e) {
			logger("Failed to Click Accept Cookies Button");
			return this;
		}

	}

	public CloudwiseHome waitHomePageReady()
	{
		try {
			waitUntilPageLoadCompleted();
			logger("Stayed Home Page to be ready");

			return this;
		}
		catch (Exception e) {
			Thread.currentThread().interrupt();
			return this;
		}

	}

}
