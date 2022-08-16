package com.cloudwise.tests;

import com.cloudwise.base.BaseTest;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features/User_List.feature",
		glue = {"com.cloudwise.steps"},
		plugin = { "pretty", "html:target/cucumber-reports" }
		)

public class TestRunner extends BaseTest {

}
