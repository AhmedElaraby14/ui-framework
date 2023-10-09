Feature: SignUp tests
Happy Scenario
  Background:
    Given user is on the login page

  @ScenarioOutline
Scenario Outline: Sign-Up to Pemo Website
    Given Go to Sign-Up page
    And   Validate Sign-Up page is displayed
    When  User enter valid information email, "<firstname>", "<lastname>" and "<password>"
    And   User submit these data
    Then  Validate user is on customize account page "customizePage"
    When  User enter valid customize account information "<businessLegalName>" and "<phoneNumber>"
    And   User Agree on pemo policy
    And   User submit these data
    Then  Validate User is on verifying page
    When  User verify  the email
    Then  Validate the email is verified
    When  user is on the login page
    And   User login with credentials "<email>" and "<password>"
    Then Validate user is on "landingPage"
    And  Validate user full name "<firstname>" and "<lastname>" is correct
    And  Validate the role of user is Admin

    Examples:
      | email           | firstname | lastname | password      | businessLegalName | phoneNumber | title         |
      | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber | customizePage |


