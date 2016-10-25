	Feature: To test the ToolsQA Automation Practice Form page.

  Background: 
    Given On the ToolsQA Automation Practice Form page.
    Then Verify on the Automation Practice Form page.
    |Field			|	Value																					|
    |Page Url	  |	http://toolsqa.com/automation-practice-form/	|

  @toolsQAAutomationPracticeForm
  Scenario: Test the ToolsQA Automation Practice Form page.
    When Select the Partial Link Test.
    Then Verify the Partial Link Test url.
    	|Field							|	Value																									|
    	|Partial Link Test 	| Partial Link Test																			|
    	|Partial Link Url		| http://toolsqa.wpengine.com/automation-practice-form/	|
    	|Navigation Back Url| http://toolsqa.com/automation-practice-form/					|
    And Select the Link Test.
    Then Verify Link Test url.	
    	|Field							|	Value																										|
    	|Link Test 					| Link Test																								|
    	|Link Url						| http://toolsqa.wpengine.com/automation-practice-table/	|
    	|Navigation Back Url| http://toolsqa.com/automation-practice-form/						|
    And Enter a First Name and Last Name.
    Then Verify First Name and Last Name.
  		|Field								|	Value																									|
    	|First Name 					| Gregory																								|
    	|Last Name						| Dombchik																							|
    And Select the "Male" Sex radio button.
    Then Verify Sex radio button.
    And Select the "3" Years of Experience radio button.
    Then Verify Years of Experience radio button.
    And Enter the date "10/24/2016" in the Date field.
    Then Verify Date field.
    And Select the Profession check boxes.
      |Field									|	Value								|
    	|Manual Tester 					| Manual Tester				|
    	|Automation Tester 			| Automation Tester		|
    Then Verify the selected Profession check boxes.	