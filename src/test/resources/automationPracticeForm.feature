Feature: To test the ToolsQA Automation Practice Form page.

  Background: 
    Given I am on the ToolsQA home page.

  @toolsQAAutomationPracticeForm
  Scenario: Test the ToolsQA Automation Practice Form page.
    When I select the Automation Practice Form menu option.
    Then Confirm I am on the Automation Practice Form page.
    	|Field			|	Value																					|
    	|Page Url	  |	http://toolsqa.com/automation-practice-form/	|
    And Select the Partial Link Test and confirm page values.
    	|Field							|	Value																									|
    	|Partial Link Test 	| Partial Link Test																			|
    	|Partial Link Url		| http://toolsqa.wpengine.com/automation-practice-form/	|
    	|Navigation Back Url| http://toolsqa.com/automation-practice-form/					|	
		Then Select the Link Test and confirm page values.
    	|Field							|	Value																										|
    	|Link Test 					| Link Test																								|
    	|Link Url						| http://toolsqa.wpengine.com/automation-practice-table/	|
    	|Navigation Back Url| http://toolsqa.com/automation-practice-form/						|
    And Enter a First Name and Last Name and confirm page values.
  		|Field								|	Value																									|
    	|First Name 					| Gregory																								|
    	|Last Name						| Dombchik																							|
    Then Select the "Male" Sex radio button.
    And Select the "3" Years of Experience radio button.
    Then Enter the date "10/24/2016" in the Date field.