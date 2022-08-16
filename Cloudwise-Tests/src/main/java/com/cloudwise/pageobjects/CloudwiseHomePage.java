package com.cloudwise.pageobjects;

import org.openqa.selenium.By;

public class CloudwiseHomePage {
	
	public By getAcceptCookieElement()
	{
		return By.id("CybotCookiebotDialogBodyButtonAccept");
	}

	public By getPopUpCloseButtonElement()
	{
		return By.className("leadinModal-close");
	}

}
