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
    When  Login with API "invitationsEmail" and "validPassword"
    And   Send Invitation with API to memberEmail with access level "<accountType>"
    Given  Teams and Members Page views forty five items
    Then   Validate member is added with the same email and "<accountType>"
    When   The member activate the invitation with "<firstname>", "<lastname>" and "<password>"
    Then   Validate member with memberEmail and "<accountType>" is active status

    Examples:
      | accountType           | memberEmail | firstname | lastname | password      |
      | apiAdmin              | memberEmail | firstName | lastName | validPassword |
      | apiInternalAccountant | memberEmail | firstName | lastName | validPassword |
      | apiTeamMember         | memberEmail | firstName | lastName | validPassword |
      | apiExternalAccountant | memberEmail | firstName | lastName | validPassword |
