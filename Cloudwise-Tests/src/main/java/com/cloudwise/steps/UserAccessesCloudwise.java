package com.cloudwise.steps;

import com.cloudwise.base.BaseTest;
import com.cloudwise.functions.CloudwiseHome;

import io.cucumber.java.en.Given;


public class UserAccessesCloudwise extends BaseTest{

	@Given("User access the Cloudwise page")
	public void userAccessTheCloudwisePage() {
		setUIDriver();
	    navigateToUrl(getSiteProp().getProperty("url"));
	    
	    new CloudwiseHome(getUIDriver()).waitHomePageReady();
	    
	    scenario.log("User accessed Cloudwise");
	}

}
