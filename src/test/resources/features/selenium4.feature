Feature: Selenium 4 features 
	Background:
		Given Navigate to letcode application
  
  Scenario: 1 Input Field Functionalities
    And Navigate to Input field page
    Then Enter the details in input fields
  Scenario: 2 Buttons Page functions
    When click on buttons page
    And click on goto button
    And find the location of button
    And find the button color
  Scenario: 3 Windows handlings operations
  	When Navigate to Windows handling page
  	Then Open Home page Window, switch, and close windows
  Scenario: 4 multiple windows handling
  	When Navigate to Windows handling page
  	Then Handle Multiple Windows and close all windows

