Feature: Login tests
Happy & Negative Scenarios
  Background:
    Given user is on the login page

  @ScenarioOutline
Scenario Outline: Login to Pemo Website
    Given Validate Login page is displayed
    When User login with credentials "<email>" and "<password>"
    Then Validate user is on "<title>"
    Examples:
      | email           | password      | title       |
      | validUsername   | validPassword | landingPage |
      | invalidUsername | validPassword | loginPage   |

