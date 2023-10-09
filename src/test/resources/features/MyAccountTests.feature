Feature:  My Account UI Automation Test Cases
  Background:
    Given user is on the login page

  @ScenarioOutline
Scenario Outline: Admin can change First & Last Name from ‘My Account’ page
    Given Validate Login page is displayed
    When User login with credentials "adminEmail" and "validPassword"
    Then Validate user is on "landingPage"
    When User open setting list
    And  User open my account setting
    And  User change first name
    When User change last name
    And  Validate full name label on top right page updated successfully
    Examples:
      | email           | password      | title       |
      | validUsername   | validPassword | landingPage |



  @ScenarioOutline
  Scenario Outline: Admin can not change First & Last Name from ‘My Account’ page to invalid syntax
    Given Validate Login page is displayed
    When User login with credentials "adminEmail" and "validPassword"
    Then Validate user is on "landingPage"
    When User open setting list
    And  User open my account setting
    And  User change first name to empty
    Then Validate empty error message appeared
    When User change last name  to invalid syntax
    Then Validate invalid syntax error message appeared
    Examples:
      | email           | password      | title       |
      | validUsername   | validPassword | landingPage |


  @ScenarioOutline
  Scenario Outline: Admin can change password from ‘My Account’ page
    Given Validate Login page is displayed
    When User login with credentials "adminEmail" and "validPassword"
    Then Validate user is on "landingPage"
    When User open setting list
    And  User open my account setting
    And  User change password "oPassword" to "nPassword"
    Then Validate the successful toast appeared
    When User logout
    When User login with credentials "adminEmail" and "nPassword"
    Then Validate user is on "landingPage"
    And   User open setting list
    And  User open my account setting
    And  User change password "nPassword" to "oPassword"
    Examples:
      | email           | password      | title       |
      | validUsername   | validPassword | landingPage |

  @ScenarioOutline
  Scenario Outline: Admin can not change password from ‘My Account’ page in case old password is incorrect
    Given Validate Login page is displayed
    When User login with credentials "adminEmail" and "validPassword"
    Then Validate user is on "landingPage"
    When User open setting list
    And  User open my account setting
    And  User change password "nPassword" to "oPassword"
    Then Validate the error toast appeared
    When User close change password tab
    And User logout
    And User login with credentials "adminEmail" and "validPassword"
    Then Validate user is on "landingPage"
    Examples:
      | email           | password      | title       |
      | validUsername   | validPassword | landingPage |

  @ScenarioOutline
  Scenario Outline: Admin can not change password from ‘My Account’ in case ‘New Password’ and ‘Repeat Password’ doesn’t match
    Given Validate Login page is displayed
    When User login with credentials "adminEmail" and "validPassword"
    Then Validate user is on "landingPage"
    When User open setting list
    And  User open my account setting
    And  User change password by enter old password "oPassword"
    And  User enter new password "nPassword"
    And  User repeated new password "oPassword"
    And  User click on save password
    Then Validate the error message appeared
    When User close change password tab
    And User logout
    And User login with credentials "adminEmail" and "validPassword"
    Then Validate user is on "landingPage"
    Examples:
      | email           | password      | title       |
      | validUsername   | validPassword | landingPage |


  @ScenarioOutline
  Scenario Outline: Admin can not change email & automated email addresses
    Given Validate Login page is displayed
    When User login with credentials "adminEmail" and "validPassword"
    Then Validate user is on "landingPage"
    When User open setting list
    And  User open my account setting
    Then Validate User cannot change email or automated email

    Examples:
      | email           | password      | title       |
      | validUsername   | validPassword | landingPage |


