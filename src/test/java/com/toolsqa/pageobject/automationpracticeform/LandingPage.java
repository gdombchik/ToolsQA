package com.toolsqa.pageobject.automationpracticeform;

import org.openqa.selenium.WebDriver;

public class LandingPage extends AbstractPage{	
	public LandingPage(WebDriver driver){
		super(driver);
	}
	
	public AutomationPracticeFormPage navigateToTheAutomationPracticeFormPage(){
		return new AutomationPracticeFormPage(driver);
	}
}
