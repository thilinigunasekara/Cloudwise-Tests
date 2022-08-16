package com.cloudwise.functions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cloudwise.base.BasePage;
import com.cloudwise.base.UIDriver;
import com.cloudwise.pageobjects.CloudwiseAllCloudwisersPage;
import com.cloudwise.pageobjects.CloudwiseUsersPage;

public class CloudwiseAllCloudwisers extends BasePage{
	
	private CloudwiseAllCloudwisersPage allCldWiser = new CloudwiseAllCloudwisersPage();
	private CloudwiseUsersPage allUser = new CloudwiseUsersPage();

	public CloudwiseAllCloudwisers(UIDriver uiDriver) {
		super(uiDriver);
	}
	
	public String getDuplicateUsersInAllDepartments()
	{
		try {
			List<String> userNames = new ArrayList<>();
			
			//get all department elements first
			List<WebElement> allDepts = waitElementsToBeVisible(allCldWiser.getAllDepartmentsElements());
			
			for(int i=0; i < allDepts.size(); i++)
			{
				//get anchor element of each department and clickByJavaSript
				clickByJavascriptExecutor(allDepts.get(i).findElement(By.tagName("a")));
				
				waitUntilPageLoadCompleted();
				
				//get all User Elements for a given Department
				List<WebElement> allUsers = waitElementsToBeVisible(allUser.getUserElements());
				
				for(WebElement user : allUsers)
				{
					userNames.add(user.findElement(By.tagName("h3")).getText());
				}
				
				//navigate back for All Cloudwisers page
				navigateBack();
				
				//regenerating department list
				allDepts = waitElementsToBeVisible(allCldWiser.getAllDepartmentsElements());
				
			}
			
			logger("All Users " + userNames.toString());
			
			//finding duplicate values from a list
			Set<String> duplicates = new HashSet<>();
			
			for(String value : userNames)
			{
				if(Collections.frequency(userNames, value) > 1)
					duplicates.add(value);
			}
			
			logger("Duplicate Users " + duplicates.toString());
			
			return duplicates.toString();
			
		} catch (InterruptedException e) {
			logger("Error finding duplicate users with departments");
			Thread.currentThread().interrupt();
			return "";
		}
	}
	
	

}
