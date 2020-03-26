package com.Crossword.TestRunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/feature/Testcase.feature",
		plugin = {"pretty","html:reports/cucumber-html-report","json:reports/cucumber-html-report/jsonreport","com.cucumber.listener.ExtentCucumberFormatter:reports/Extentreports/Extentreport.html"},

		tags = {"@TC1_Updating_the_profile_details, @TC2_Adding_new_address, @TC3_Scrolling_Functionality, @TC4_Slider_Functionality, @TC5_To_view_the_details_of_Award_winner"},
		glue = {"com.Crossword.StepDefinition"},
		monochrome = true
		)


public class Crossword_Runner 
{
	@AfterClass
	  public static void extendReport()
	{
		Reporter.loadXMLConfig("src/test/resources/extent-config.xml");
	    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.141.59");
	    Reporter.setSystemInfo("Maven", "4.0.0");
	    Reporter.setSystemInfo("Java Version", "1.8.0_131");
	}
}
