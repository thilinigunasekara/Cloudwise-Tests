package com.cloudwise.steps;

import com.cloudwise.base.BaseTest;
import com.cloudwise.functions.CloudwiseAllCloudwisers;
import com.cloudwise.functions.CloudwiseHeader;
import com.cloudwise.functions.CloudwiseHome;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserListSteps extends BaseTest{

	@Given("User clicks {string} as the language")
	public void userClicksAsTheLanguage(String lang) {
		CloudwiseHeader header = new CloudwiseHeader(getUIDriver());

		header.selectLanguage(lang);
		
		scenario.log("Selected Language as " + lang);

		CloudwiseHome cldHome = new CloudwiseHome(getUIDriver());

		cldHome.clickAcceptCookiesButton();
		
		scenario.log("Clicked Allow All Cookies Button");
	}

	@When("User goes to {string} menu")
	public void userGoesToMenu(String menuOption) {
		CloudwiseHeader header = new CloudwiseHeader(getUIDriver());

		header.goToMenuOptions(menuOption, false);
		
		scenario.log("Selected Menu " + menuOption);
	}

	@When("User selects {string} sub-menu")
	public void userSelectsSubMenu(String subMenuOption) {
		CloudwiseHeader header = new CloudwiseHeader(getUIDriver());

		header.clickToSubMenuOptions(subMenuOption, false);
		
		scenario.log("Selected Sub-menu " + subMenuOption);
	}

	@Then("Print all duplicate users exist in all departments")
	public void printAllDuplicateUsersExistInAllDepartments() {
		CloudwiseAllCloudwisers allCloudwisers = new CloudwiseAllCloudwisers(getUIDriver());
		
		scenario.log("Duplicate Users : " + 
				allCloudwisers.getDuplicateUsersInAllDepartments());
		
	}
}
