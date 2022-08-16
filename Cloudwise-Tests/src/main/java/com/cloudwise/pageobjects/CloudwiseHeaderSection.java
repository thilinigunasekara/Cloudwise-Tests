package com.cloudwise.pageobjects;

import org.openqa.selenium.By;

public class CloudwiseHeaderSection {

	public By getLanguageFlagLink(String language)
	{
		return By.xpath("//li[contains(@id,'menu-item')]/a[@lang='"+ language +"']");
	}
		
	public By getMenuOption(String menuName)
	{
		return By.linkText(menuName);
	}
	
	public By getSubMenuOption(String subMenuName)
	{
		return By.linkText(subMenuName);
	}
	
}
