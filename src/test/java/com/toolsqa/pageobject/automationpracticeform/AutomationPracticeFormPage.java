package com.toolsqa.pageobject.automationpracticeform;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.Predicate;
import com.toolsqa.AutomationPracticeForm;
import com.toolsqa.utils.WebDriverUtils;

public class AutomationPracticeFormPage extends AbstractPage{
	private static final Logger logger = LogManager.getLogger(AutomationPracticeForm.class.getName());
	WebDriverUtils webDriverUtils = new WebDriverUtils(driver);

	public AutomationPracticeFormPage(WebDriver driver) {
		super(driver);
	}
	
	public void getAutomationPracticeFormMenuOption(){
		//return driver.findElement(By.partialLinkText("Automation Practice Form"));
		//return webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("a"),"href","http://toolsqa.com/automation-practice-form/");
		//webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("a"),"class","ripple");
		//webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.xpath("//a/span[1]/span/span"),"class","ripple");
		//List<WebElement> webElements = driver.findElements(By.xpath("//a/span[1]/span/span"));
		//List<WebElement> webElements = driver.findElements(By.xpath("//ul[@id='primary-menu']/li[9]/a/span[1]/span/span"));
		//List<WebElement> webElements = driver.findElements(By.xpath("//ul[@id='primary-menu']/li[9]"));
			
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		wait.withTimeout(2, TimeUnit.MINUTES);
		wait.ignoring(NoSuchElementException.class); //make sure that this exception is ignored
		Predicate<WebDriver> predicate = new Predicate<WebDriver>()
				{
					public boolean apply(WebDriver arg0) {
						WebElement demoSitesMenuOption = driver.findElement(By.partialLinkText("DEMO SITES"));
						if(demoSitesMenuOption != null)
						{
							Actions action = new Actions(driver); 
					        action.moveToElement(demoSitesMenuOption).build().perform(); 
					        WebElement subElement = driver.findElement(By.linkText("Automation Practice Form"));
					        action.moveToElement(subElement);
					        action.click();
					        action.perform();
					        return true;
						}
						return false;
					}
				};

		wait.until(predicate);
		
		/*WebElement demoSitesMenuOption = driver.findElement(By.partialLinkText("DEMO SITES"));
		Actions action = new Actions(driver); 
        action.moveToElement(demoSitesMenuOption).build().perform(); 
        WebElement subElement = driver.findElement(By.linkText("Automation Practice Form"));
        action.moveToElement(subElement);
        action.click();
        action.perform();*/
	}
	
	public String getAutomationPracticeFormCurrentUrl(){
		logger.trace("getAutomationPracticeFormCurrentUrl-----> " + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
	
	public WebElement getPartialLinkTest(){
		return driver.findElement(By.partialLinkText("Partial Link Test"));
	}
	
	public WebElement getLinkTest(){
		return driver.findElement(By.linkText("Link Test"));
	}
	
	public WebElement getFirstName(){
		return driver.findElement(By.name("firstname"));
	}
	
	public WebElement getLastName(){
		return driver.findElement(By.name("lastname"));
	}
	
	public WebElement selectSexRadioButton(String sexRadioButtonValue){
		String value="";
		if(sexRadioButtonValue.equals("Male")){
			value = "0";
		}else if(sexRadioButtonValue.equals("Female")){
			value = "1";
		}	
		return driver.findElement(By.id("sex-" + value));
		
	}
	
	public WebElement getSexRadioButton(){
		List<WebElement> sexRadioButtons = driver.findElements(By.name("sex"));
		WebElement sexRadioButtonValue = null;
		
		for(WebElement webElement : sexRadioButtons){
			if(webElement.isSelected()){
				sexRadioButtonValue = webElement;
				break;
			}
		}
		return sexRadioButtonValue;
	}
	
	public WebElement selectYearsOfExperienceRadioButton(String yearsOfExperienceRadioButtonValue){
		String value = new Integer(new Integer(yearsOfExperienceRadioButtonValue).intValue() - 1).toString();
		return driver.findElement(By.id("exp-" + value));
	}

	public WebElement getYearsOfExperienceRadioButton(){
		List<WebElement> YearsOfExperienceRadioButtons = driver.findElements(By.name("exp"));
		WebElement yearsOfExperienceRadioButtonValue = null;
		
		for(WebElement webElement : YearsOfExperienceRadioButtons){
			if(webElement.isSelected()){
				yearsOfExperienceRadioButtonValue = webElement;
				break;
			}
		}
		return yearsOfExperienceRadioButtonValue;
	}
	
	public WebElement getDate(){
		return driver.findElement(By.id("datepicker"));
	}
	
	public List<WebElement> selectProfessionCheckboxes(Map<String,String> professionCheckBoxes){
		List<WebElement> professionCheckboxesListSelected = new ArrayList<WebElement>();
		List<WebElement> professionCheckboxesList = driver.findElements(By.name("profession"));
		
		for(int i=0;i<professionCheckboxesList.size();i++){
			if(professionCheckBoxes.containsKey(professionCheckboxesList.get(i).getAttribute("value"))){
				professionCheckboxesList.get(i).click();
				professionCheckboxesListSelected.add(professionCheckboxesList.get(i));
			}
		}
		
		return professionCheckboxesListSelected;
	}
	
	public List<WebElement> getProfessionCheckboxes(){
		List<WebElement> professionCheckboxesListSelected = new ArrayList<WebElement>();
		List<WebElement> professionCheckboxesList = driver.findElements(By.name("profession"));
		
		for(WebElement webElement : professionCheckboxesList){
			if(webElement.isSelected()){
				professionCheckboxesListSelected.add(webElement);
			}
		}
		
		return professionCheckboxesListSelected;
	}
	
	public WebElement getTheSeleniumAutomationHybridFrameworkLink(String linkText){
		return driver.findElement(By.linkText(linkText));
	}
	
	public Select getContinentsDropDown(){
		return new Select(driver.findElement(By.id("continents")));
	}
	
	public Select getSeleniumCommandsMultiSelectDropDown(){
		return new Select(driver.findElement(By.id("selenium_commands")));
	}
	
	public List<WebElement> getSeleniumCommandsMultiselectDropdownOptions(){
		List<WebElement> seleniumCommandsMultiselectDropdownListSelected = new ArrayList<WebElement>();
		List<WebElement> seleniumCommandsMultiselectDropdownList = new Select(driver.findElement(By.id("selenium_commands"))).getAllSelectedOptions();
		
		for(WebElement webElement : seleniumCommandsMultiselectDropdownList){
			if(webElement.isSelected()){
				seleniumCommandsMultiselectDropdownListSelected.add(webElement);
			}
		}
		
		return seleniumCommandsMultiselectDropdownListSelected;
	}
	
	public WebElement getSubmitButton(){
		return driver.findElement(By.id("submit"));
	}
	
	public List<WebElement> getTextLabels(){
		return driver.findElements(By.xpath("id('NextedText')"));
	}
}
