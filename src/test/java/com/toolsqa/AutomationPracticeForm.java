package com.toolsqa;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.toolsqa.pageobject.automationpracticeform.AutomationPracticeFormPage;
import com.toolsqa.pageobject.automationpracticeform.LandingPage;
import com.toolsqa.utils.WebDriverUtils;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
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
	private WebElement partialLinkTest;
	private WebElement linkTest;
	private WebElement firstName;
	private WebElement lastName;
	private String sexRadioButtonValue;
	private String yearsOfExperienceRadioButtonValue;
	private WebElement date;
	private String dateValue;
	private Map<String,String> professionCheckBoxes;
	
	@After("@toolsQAAutomationPracticeForm") //Cucumber Scenario Hooks.  Close driver after each scenario.
	public void afterTest(Scenario scenario){
		if (scenario.isFailed()) {
			webDriverUtils.takeStreenShot(scenario);
		}
		landingPage.closeDriver();
	}
	
	//Cucumber Background Script:
	//The background script is ran before each of the scenarios, but after any of the Cucumber Scenario Before Hooks
	@Given("^On the ToolsQA Automation Practice Form page\\.$")
	public void onTheToolsQAAutomationPracticeFormPage() throws Throwable {
		landingPage = new LandingPage(driver).navigateToWebApp();
		automationPracticeFormPage = landingPage.navigateToTheAutomationPracticeFormPage();
	}
	
	@Then("^Verify on the Automation Practice Form page\\.$")
	public void verifyOnTheAutomationPracticeFormPage(DataTable table) throws Throwable {
		Assert.assertTrue(table.asMap(String.class, String.class).values().contains(automationPracticeFormPage.getAutomationPracticeFormCurrentUrl()));
	}	
	
	@When("^Select the Partial Link Test\\.$")
	public void selectThePartialLinkTest() throws Throwable {
		partialLinkTest = automationPracticeFormPage.getPartialLinkTest();
	}
	
	@Then("^Verify the Partial Link Test url\\.$")
	public void verifyThePartialLinkTestUrl(DataTable table) throws Throwable {
		Assert.assertTrue(table.raw().get(1).get(1).equals(partialLinkTest.getText()));
		partialLinkTest.click();
		Assert.assertTrue(table.raw().get(2).get(1).equals(driver.getCurrentUrl()));
		driver.navigate().back();
		Assert.assertTrue(table.raw().get(3).get(1).equals(driver.getCurrentUrl()));
	}
	
	@And("^Select the Link Test\\.$")
	public void selectTheLinkTest() throws Throwable {
		linkTest = automationPracticeFormPage.getLinkTest();
	}
	
	@Then("^Verify Link Test url\\.$")
	public void verifyLinkTestUrl(DataTable table) throws Throwable {		
		Assert.assertTrue(table.raw().get(1).get(1).equals(linkTest.getText()));
		linkTest.click();
		Assert.assertTrue(table.raw().get(2).get(1).equals(driver.getCurrentUrl()));
		driver.navigate().back();
		Assert.assertTrue(table.raw().get(3).get(1).equals(driver.getCurrentUrl()));
	}
	
	@And("^Enter a First Name and Last Name\\.$")
	public void enterAFirstNameAndLastName() throws Throwable {
		firstName = automationPracticeFormPage.getFirstName();
		lastName = automationPracticeFormPage.getLastName();
	}
	
	@Then("^Verify First Name and Last Name\\.$")
	public void verifyFirstNameAndLastName(DataTable table) throws Throwable {
		firstName.sendKeys(table.raw().get(1).get(1));
		lastName.sendKeys(table.raw().get(2).get(1));
		Assert.assertTrue(firstName.getAttribute("value").equals(table.raw().get(1).get(1)));
		Assert.assertTrue(lastName.getAttribute("value").equals(table.raw().get(2).get(1)));
	}
	
	@And("^Select the \"([^\"]*)\" Sex radio button\\.$")
	public void selectTheSexRadioButton(String sexRadioButtonValue) throws Throwable {
		this.sexRadioButtonValue = sexRadioButtonValue;
		automationPracticeFormPage.selectSexRadioButton(sexRadioButtonValue).click();
	}

	@Then("^Verify Sex radio button\\.$")
	public void verifySexRadioButton() throws Throwable {
		Assert.assertTrue(automationPracticeFormPage.getSexRadioButton().getAttribute("value").equals(sexRadioButtonValue));
	}
	
	@And("^Select the \"([^\"]*)\" Years of Experience radio button\\.$")
	public void selectTheYearsOfExperienceRadioButton(String yearsOfExperienceRadioButtonValue) throws Throwable {
		this.yearsOfExperienceRadioButtonValue = yearsOfExperienceRadioButtonValue;
		automationPracticeFormPage.selectYearsOfExperienceRadioButton(yearsOfExperienceRadioButtonValue).click();
	}
	
	@Then("^Verify Years of Experience radio button\\.$")
	public void verifyYearsOfExperienceRadioButton() throws Throwable {
		Assert.assertTrue(automationPracticeFormPage.getYearsOfExperienceRadioButton().getAttribute("value").equals(yearsOfExperienceRadioButtonValue));
	}
	
	@And("^Enter the date \"([^\"]*)\" in the Date field\\.$")
	public void enterTheDateInTheDateField(String dateValue) throws Throwable {
		this.dateValue = dateValue;
		date = automationPracticeFormPage.getDate();
		date.sendKeys(dateValue);
	}
	
	@Then("^Verify Date field\\.$")
	public void verifyDateField() throws Throwable {
		Assert.assertTrue(date.getAttribute("value").equals(dateValue));
	}
	
	@And("^Select the Profession check boxes\\.$")
	public void selectTheProfessionCheckBoxes(DataTable table) throws Throwable {
		professionCheckBoxes = table.asMap(String.class, String.class);
		automationPracticeFormPage.selectProfessionCheckboxes(professionCheckBoxes);
	}
	
	@Then("^Verify the selected Profession check boxes\\.$")
	public void verifyTheSelectedProfessionCheckBoxes() throws Throwable {
		List<WebElement> professionCheckboxesListSelected = automationPracticeFormPage.getProfessionCheckboxes();
		for(WebElement professionCheckbox : professionCheckboxesListSelected){
			Assert.assertTrue(professionCheckBoxes.containsKey(professionCheckbox.getAttribute("value")));
		}
	}
}
