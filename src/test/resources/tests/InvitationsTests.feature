Feature: Invitations tests

   Background:
    Given user is on the login page
    And   Validate Login page is displayed
    And   User login with credentials "invitationsEmail" and "validPassword"


  @ScenarioOutline
  Scenario Outline: Send invitations to Pemo Website
    Given Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  User click invite user
    And   Enter Member's email "<memberEmail>"
    And   Select Account access level "<accountType>"
    And   User submit the invitation
    Then  Validate invitation sent successfully
    When  Teams and Members Page views forty five items
    Then   Validate member with memberEmail and "<accountType>" is active status

    Examples:
      | accountType        | memberEmail |
      | externalAccountant | memberEmail |

