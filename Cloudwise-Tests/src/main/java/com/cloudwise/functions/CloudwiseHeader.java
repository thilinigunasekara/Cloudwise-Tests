package com.cloudwise.functions;

import org.openqa.selenium.WebElement;

import com.cloudwise.base.BasePage;
import com.cloudwise.base.UIDriver;
import com.cloudwise.pageobjects.CloudwiseHeaderSection;

public class CloudwiseHeader extends BasePage{
	
	private CloudwiseHeaderSection header = new CloudwiseHeaderSection();

	public CloudwiseHeader(UIDriver uiDriver) {
		super(uiDriver);
	}

	public CloudwiseHeader selectLanguage(String language)
	{
		String langCookieVal = getCookie("pll_language");

		if(!langCookieVal.equalsIgnoreCase("en") && language.equalsIgnoreCase("english"))
		{
			WebElement engLanLink = waitElementToBeVisible(header.getLanguageFlagLink("en-US"));

			if(engLanLink.isDisplayed())
			{
				engLanLink.click();
				logger("Clicked English Flag Icon");
			}
		}

		if(!langCookieVal.equalsIgnoreCase("nl") && language.equalsIgnoreCase("netherland"))
		{
			WebElement nlLanLink = waitElementToBeVisible(header.getLanguageFlagLink("nl-NL"));

			if(nlLanLink.isDisplayed())
			{
				nlLanLink.click();
				logger("Clicked Netherland Flag Icon");
			}
		}

		waitUntilPageLoadCompleted();

		return this;

	}
	
	public CloudwiseHeader goToMenuOptions(String menuName, boolean isMobile)
	{
		try {
			WebElement menu = null;
			
			if(!isMobile)
				//very first element (skips mobile menu here)
				menu = waitElementsToBeVisible(header.getMenuOption(menuName)).get(0);
			else
				menu = waitElementsToBeVisible(header.getMenuOption(menuName)).get(1);
			
			getActions().moveToElement(menu).build().perform();
			logger("Moved to " + menuName + " Menu Option");
			
			return this;
		} catch (Exception e) {
			return this;
		}
		
	}
	
	public CloudwiseHeader clickToSubMenuOptions(String menuName, boolean isMobile)
	{
		try {
			WebElement subMenu = null;
					
			if(!isMobile)
				//very first element (skips mobile menu here)
				subMenu = waitElementsToBeVisible(header.getSubMenuOption(menuName)).get(0);
			else
				subMenu = waitElementsToBeVisible(header.getSubMenuOption(menuName)).get(1);
			
			getActions().moveToElement(subMenu).click().build().perform();
			
			waitUntilPageLoadCompleted();
			
			logger("Clicked " + menuName + " Sub Menu Option");
			
			return this;
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			return this;
		}
		
	}
}
