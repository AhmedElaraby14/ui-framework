Feature: Forget Password tests
  Background:
    Given user is on the login page

  @ScenarioOutline
Scenario Outline: Reset Password and Validate user Can't login with old password but can login with new one
    Given Validate Login page is displayed
    When  User click reset password
    And   User enter registered "forgettenPasswordEmail" to set a new password
    And   User submit sending the email
    Then  Validate confirmation page for sending forgetten password email opened successfully
    When  Get the token of "forgettenPasswordEmail" using API
    And   Set the new password
    And   Save the password as old password
    And   Set the new password
    And   user is on the login page
    And   User login with credentials "forgettenPasswordEmail" and "oldPassword"
    Then  Validate user is on "loginPage"
    And   User login with credentials "forgettenPasswordEmail" and "newPassword"
    Then  Validate user is on "landingPage"
    Examples:
      | email                    | newPassword   | title       |
      | forgettenPasswordEmail   | validPassword | landingPage |

  @ScenarioOutline
  Scenario Outline: Un-Registered User can not reset password using Forget password from Sign-in page
    Given Validate Login page is displayed
    When  User click reset password
    And   User enter registered "unRegisteredEmail" to set a new password
    And   User submit sending the email
    Then  Validate confirmation page for sending forgetten password email opened successfully
    And   Validate the token of "unRegisteredEmail" will not send using API
    Examples:
      | email                    | newPassword   | title       |
      | forgettenPasswordEmail   | validPassword | landingPage |


  @ScenarioOutline
  Scenario Outline: Un-verified User can reset password using Forget password from Sign-in page
    Given Validate Login page is displayed
    When  User click reset password
    And   User enter registered "unVerifiedEmail" to set a new password
    And   User submit sending the email
    Then  Validate confirmation page for sending forgetten password email opened successfully
    When  Get the token of "unVerifiedEmail" using API
    And   Set the new password
    And   Save the password as old password
    And   Set the new password
    And   user is on the login page
    And   User login with credentials "unVerifiedEmail" and "oldPassword"
    Then  Validate user is on "loginPage"
    And   User login with credentials "unVerifiedEmail" and "newPassword"
    Then  Validate user is on "landingPage"
    Examples:
      | email                    | newPassword   | title       |
      | forgettenPasswordEmail   | validPassword | landingPage |


  @ScenarioOutline
  Scenario Outline: Registered User can not request to reset password more than 5 times in 10 minutes
    Given Validate Login page is displayed
    When  User click reset password
    And   User enter registered "blockedEmail" to set a new password
    And   User submit sending the email
    Then  Validate confirmation page for sending forgetten password email opened successfully
    When  User click on resend password email
    And   User enter registered "blockedEmail" to set a new password
    And   User submit sending the email
    Then  Validate confirmation page for sending forgetten password email opened successfully
    When  User click on resend password email
    And   User enter registered "blockedEmail" to set a new password
    And   User submit sending the email
    Then  Validate confirmation page for sending forgetten password email opened successfully
    When  User click on resend password email
    And   User enter registered "blockedEmail" to set a new password
    And   User submit sending the email
    Then  Validate confirmation page for sending forgetten password email opened successfully
    When  User click on resend password email
    And   User enter registered "blockedEmail" to set a new password
    And   User submit sending the email
    Then  Validate confirmation page for sending forgetten password email opened successfully
    When  User click on resend password email
    And   User enter registered "blockedEmail" to set a new password
    And   User submit sending the email
    Then  Validate confirmation page for sending forgetten password email opened successfully
    When  User click on resend password email
    And   User enter registered "blockedEmail" to set a new password
    And   User submit sending the email
    Then  Validate blocking message appeared successfully


    Examples:
      | email                    | newPassword   | title       |
      | forgettenPasswordEmail   | validPassword | landingPage |

