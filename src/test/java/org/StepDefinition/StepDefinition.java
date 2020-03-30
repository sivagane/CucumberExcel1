package org.StepDefinition;

import java.io.IOException;

import org.Cucumber.Excel1.LoginPage;
import org.Cucumber.Excel1.Utility;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends Utility{
	@Given("User enters the Login Page")
	public void user_enters_the_Login_Page() {
	    launch("https://www.facebook.com/");
	}

	@When("User enters the Username and Password")
	public void user_enters_the_Username_and_Password() throws IOException {
	    LoginPage l=new LoginPage();
	    fill(l.getUser(),read().get(0).get("UserName"));
	    fill(l.getPass(), read().get(1).get("PassWord"));
	}

	@When("User Clicks the LoginButton")
	public void user_Clicks_the_LoginButton() {
	    LoginPage l=new LoginPage();
	    klik(l.getLbtn());
	}

	@Then("User Navigates to Home Page")
	public void user_Navigates_to_Home_Page() {
	    Assert.assertTrue(Hooks.d.getTitle().contains("Facebook"));
	}
}
