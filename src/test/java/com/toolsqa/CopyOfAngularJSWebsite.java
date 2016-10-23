package com.toolsqa;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.toolsqa.pageobject.automationpracticeform.AddSomeControlPage;
import com.toolsqa.pageobject.automationpracticeform.CreateComponentsPage;
import com.toolsqa.pageobject.automationpracticeform.DownloadAngularJSOnePage;
import com.toolsqa.pageobject.automationpracticeform.LandingPage;
import com.toolsqa.pageobject.automationpracticeform.TheBasicsPage;
import com.toolsqa.pageobject.automationpracticeform.WireUpABackendPage;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CopyOfAngularJSWebsite extends AbstractPageStepDefinition{
	private WebDriver driver = getWebdriver();
	private LandingPage landingPage;
	
	@After("@angularJSWebsiteCopy") //Cucumber Scenario Hooks.  Close driver after each scenario.
	public void afterTest(){
		landingPage.closeDriver();
	}
	
	//Cucumber Background Script:
	//The background script is ran before each of the scenarios, but after any of the Cucumber Scenario Before Hooks
	@Given("^I am on the AngularJS website home page Copy\\.$")
	public void iAmOnTheAngularJSWebsiteHomePage() throws Throwable {
		landingPage = new LandingPage(driver).navigateToWebApp();
	}
	
	@When("^I confirm I am on the AngularJS website home page Copy\\.$")
	public void iConfirmIAmOnTheAngularJSWebsiteHomePage(DataTable table) throws Throwable {
		WebElement downLoadAngularJSOneButton = landingPage.getDownLoadAngularJSOneButton(); 
		Map<String,String> data = table.asMap(String.class,String.class);
		Assert.assertTrue(downLoadAngularJSOneButton.getText().equals(data.get("DownLoad Angular JS One Button"))); //Download AngularJS 1\n\n(1.5.8 / 1.2.30
	}

}
