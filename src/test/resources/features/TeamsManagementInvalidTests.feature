Feature: Teams Management Invalid Test Cases

  Background:
    Given user is on the login page
    And   Validate Login page is displayed


  @ScenarioOutline
  Scenario Outline: Internal Accountant can not create new team
    Given Login with API "invitationsEmail" and "validPassword"
    When  Send Invitation with API to memberEmail with access level "apiInternalAccountant"
    And   The member activate the invitation with "firstName", "lastName" and "password"
    And   User login with API email invitation and "validPassword"
    Then  Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  Admin Open Team Tab
    Then  Validate this user type can't create team
    Examples:
     |numsOfTeamLead|numsOfTeamMember|
     |              |                |

  @ScenarioOutline
  Scenario Outline: External Accountant can not create new team
    Given Login with API "invitationsEmail" and "validPassword"
    When  Send Invitation with API to memberEmail with access level "apiExternalAccountant"
    And   The member activate the invitation with "firstName", "lastName" and "password"
    And   User login with API email invitation and "validPassword"
    Then  Validate user is on "landingPage"
    When  User go to Teams and Members Page
    And  Admin Open Team Tab
    Then  Validate this user type can't create team
    Examples:
      |numsOfTeamLead|numsOfTeamMember|
      |              |                |


  @ScenarioOutline
  Scenario Outline: Team Member can not create new team
    Given Login with API "invitationsEmail" and "validPassword"
    When  Send Invitation with API to memberEmail with access level "apiTeamMember"
    And   The member activate the invitation with "firstName", "lastName" and "password"
    And   User login with API email invitation and "validPassword"
    Then  Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  Admin Open Team Tab
    Then  Validate this user type can't create team
    Examples:
      |numsOfTeamLead|numsOfTeamMember|
      |              |                |

  @ScenarioOutline
  Scenario Outline: Team Lead with Card Permission can not create new team
    When User login with credentials "teamLeadWithCardPermissionEmail" and "validPassword"
    Then  Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  Admin Open Team Tab
    Then  Validate this user type can't create team
    Examples:
      |numsOfTeamLead|numsOfTeamMember|
      |              |                |


  @ScenarioOutline
  Scenario Outline: Team Lead without Card Permission can not create new team
    When User login with credentials "teamLeadWithoutCardPermissionEmail" and "validPassword"
    Then  Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  Admin Open Team Tab
    Then  Validate this user type can't create team
    Examples:
      |numsOfTeamLead|numsOfTeamMember|
      |              |                |