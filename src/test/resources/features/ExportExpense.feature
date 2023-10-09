Feature: Export Expenses

  Background:
    Given user is on the login page
    And Validate Login page is displayed
    
  Scenario Outline: User can export expense
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    And   User go to Export pocket expenses Page
    And   User go to history tab
    And   User export expenses
    Then  User check exported file

    Examples:
      | email             | password  |   
      | validUsername     | validPassword |    
