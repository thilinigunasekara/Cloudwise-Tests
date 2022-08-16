package com.cloudwise.steps;

import com.cloudwise.base.BaseTest;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Common extends BaseTest{
	
	@Before
	public static void beforeScenario(Scenario currentScenario)
	{
		scenario = currentScenario;
	}
}
