package com.Crossword.StepDefinition;

import java.io.IOException;

import com.Crossword.Pages.AuthorAward_Crossword_Page;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Definition_AuthorAward 
{
	AuthorAward_Crossword_Page MyAward = new AuthorAward_Crossword_Page();
	



@Given("^The User launch the Chrome application to see award$")
public void the_User_launch_the_Chrome_application_to_see_award() throws IOException
{
	  MyAward.LaunchBrowser();

}

@Then("^The user view the award details$")
public void the_user_view_the_award_details() throws IOException, InterruptedException 
{
	Thread.sleep(3000);
	MyAward.award_book();
	MyAward.screenshot("src/test/resources/Screenshot/author.png");

	
}

@Then("^Close the browser$")
public void close_the_browser() throws InterruptedException 
{
	MyAward.close_award();

}




}
