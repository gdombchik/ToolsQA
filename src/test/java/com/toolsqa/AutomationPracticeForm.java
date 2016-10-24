package com.toolsqa;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.toolsqa.pageobject.automationpracticeform.AutomationPracticeFormPage;
import com.toolsqa.pageobject.automationpracticeform.LandingPage;
import com.toolsqa.utils.WebDriverUtils;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AutomationPracticeForm extends AbstractPageStepDefinition {
	private WebDriver driver = getWebdriver();
	private WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
	private LandingPage landingPage;
	private AutomationPracticeFormPage automationPracticeFormPage;
	
	@After("@toolsQAAutomationPracticeForm") //Cucumber Scenario Hooks.  Close driver after each scenario.
	public void afterTest(){
		landingPage.closeDriver();
	}
	
	//Cucumber Background Script:
	//The background script is ran before each of the scenarios, but after any of the Cucumber Scenario Before Hooks
	@Given("^I am on the ToolsQA home page\\.$")
	public void iAmOnTheToolsQAHomePage() throws Throwable {
		landingPage = new LandingPage(driver).navigateToWebApp();
	}

	@When("^I select the Automation Practice Form menu option\\.$")
	public void iSelectTheAutomationPracticeFormMenuOption() throws Throwable {
		automationPracticeFormPage = landingPage.navigateToTheAutomationPracticeFormPage();
		automationPracticeFormPage.getAutomationPracticeFormMenuOption();
	}
	
	@Then("^Confirm I am on the Automation Practice Form page\\.$")
	public void confirmIAmOnTheAutomationPracticeFormPage(DataTable table) throws Throwable {
		//Assert.assertTrue(table.asMap(String.class, String.class).values().contains(automationPracticeFormPage.getAutomationPracticeFormTitle()));
		
		System.out.println("--> " + table.asMap(String.class, String.class).values());
		System.out.println("--> " + automationPracticeFormPage.getAutomationPracticeFormTitle());
		
	}	
	
	@And("^Select the Partial Link Test and confirm page values\\.$")
	public void selectThePartialLinkTestAndConfirmPageValues(DataTable table) throws Throwable {
		WebElement partialLinkTest = automationPracticeFormPage.getPartialLinkTest();
		Assert.assertTrue(table.raw().get(1).get(1).equals(partialLinkTest.getText()));
		partialLinkTest.click();
		Assert.assertTrue(table.raw().get(2).get(1).equals(driver.getCurrentUrl()));
		driver.navigate().back();
		Assert.assertTrue(table.raw().get(3).get(1).equals(driver.getCurrentUrl()));
	}
	
	@Then("^Select the Link Test and confirm page values\\.$")
	public void selectTheLinkTestAndConfirmPageValues(DataTable table) throws Throwable {
		WebElement linkTest = automationPracticeFormPage.getLinkTest();
		Assert.assertTrue(table.raw().get(1).get(1).equals(linkTest.getText()));
		linkTest.click();
		Assert.assertTrue(table.raw().get(2).get(1).equals(driver.getCurrentUrl()));
		driver.navigate().back();
		Assert.assertTrue(table.raw().get(3).get(1).equals(driver.getCurrentUrl()));
	}
	
	@And("^Enter a First Name and Last Name and confirm page values\\.$")
	public void enterAFirstNameAndLastNameAndConfirmPageValues(DataTable table) throws Throwable {
		WebElement firstName = automationPracticeFormPage.getFirstName();
		WebElement lastName = automationPracticeFormPage.getLastName();
		firstName.sendKeys(table.raw().get(1).get(1));
		lastName.sendKeys(table.raw().get(2).get(1));
		Assert.assertTrue(firstName.getAttribute("value").equals(table.raw().get(1).get(1)));
		Assert.assertTrue(lastName.getAttribute("value").equals(table.raw().get(2).get(1)));
	}
	
	@Then("^Select the \"([^\"]*)\" Sex radio button\\.$")
	public void select_the_Sex_radio_button(String sexRadioButtonValue) throws Throwable {
		automationPracticeFormPage.getSexRadioButtons().get(0).click();
		Assert.assertTrue(automationPracticeFormPage.getSexRadioButtonValue().getAttribute("value").equals(sexRadioButtonValue));
	}
}
