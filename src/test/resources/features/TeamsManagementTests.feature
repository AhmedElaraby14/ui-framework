Feature: Teams Management UI Automation Test Cases

   Background:
    Given user is on the login page
    And   Validate Login page is displayed
    And   User login with credentials "invitationsEmail" and "validPassword"
    And   Login with API "invitationsEmail" and "validPassword"
    And   Send Invitation with API to memberEmail with access level "apiTeamMember"
    And   The member activate the invitation with "firstName", "lastName" and "password"


  @ScenarioOutline
  Scenario Outline: Create Team With team lead and team member
    Given Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  Admin Open Team Tab
    And   Admin Open Creation Team Form
    And   Admin create the team with team name and descreption
    And   Admin assign team lead "<numsOfTeamLead>"
    And   Admin assign team member "<numsOfTeamMember>"
    Then  Validate nums of team members equals "<numsOfTeamLead>" plus "<numsOfTeamMember>"
    When  Admin submit the creation
    Then  Validate creation of the team with correct name and desc

    Examples:
     |numsOfTeamLead|numsOfTeamMember|
     |numsOfTeamLead|numsOfTeamMember|

  @ScenarioOutline
  Scenario Outline: Edit existing team
    Given Validate user is on "landingPage"
    And   Login with API "invitationsEmail" and "validPassword"
    And   Send Invitation with API to memberEmail with access level "apiTeamMember"
    And   The member activate the invitation with "firstName", "lastName" and "password"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  Admin Open Team Tab
    And   Admin Open Creation Team Form
    And   Admin create the team with team name and descreption
    And   Admin assign team lead "<numsOfTeamLead>"
    And   Admin assign team member "<numsOfTeamMember>"
    Then  Validate nums of team members equals "<numsOfTeamLead>" plus "<numsOfTeamMember>"
    When  Admin submit the creation
    Then  Validate creation of the team with correct name and desc
    Given Admin open the created team
    When  Admin edit the team name
    And   Admin edit the team desc
    And   Admin assign team lead "<numsOfTeamLead>"
    And   Admin assign team member "<numsOfTeamMember>"
    Then  Validate nums of team members "<numsOfTeamLead>" plus "<numsOfTeamMember>" changed successfully
    When  Admin close team creation tab
    Then  Validate team name and desc edited successfully
    Examples:
      |numsOfTeamLead|numsOfTeamMember|
      |numsOfTeamLead|numsOfTeamMember|



  @ScenarioOutline
  Scenario Outline: Add team lead to existing team
    Given Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  Admin Open Team Tab
    And   Admin Open Creation Team Form
    And   Admin create the team with team name and descreption
    When  Admin submit the creation
    Then  Validate creation of the team with correct name and desc
    Given Admin open the created team
    And   Admin assign team lead "<numsOfTeamLead>"
    Then  Validate nums of team members equals "<numsOfTeamLead>" plus "<numsOfTeamMember>"
    And   Validate role of team member "<type>"
    And   Validate card toggle is off
    When  Admin close team creation tab
    Then  Validate creation of the team with correct name and desc
    Examples:
      |numsOfTeamLead|numsOfTeamMember| type      |
      |numsOfTeamLead|zeroMembers     | teamLeadType  |

  @ScenarioOutline
  Scenario Outline: Add team member to existing team
    Given Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  Admin Open Team Tab
    And   Admin Open Creation Team Form
    And   Admin create the team with team name and descreption
    When  Admin submit the creation
    Then  Validate creation of the team with correct name and desc
    Given Admin open the created team
    And   Admin assign team member "<numsOfTeamMember>"
    Then  Validate nums of team members equals "<numsOfTeamLead>" plus "<numsOfTeamMember>"
    And   Validate role of team member "<type>"
    When  Admin close team creation tab
    Then  Validate creation of the team with correct name and desc
    Examples:
      |numsOfTeamLead|numsOfTeamMember|    type       |
      | zeroMembers  |numsOfTeamMember| teamMemberType|


  @ScenarioOutline
  Scenario Outline: Admin can grant card permission for a team lead
    Given Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  Admin Open Team Tab
    And   Admin Open Creation Team Form
    And   Admin create the team with team name and descreption
    When  Admin submit the creation
    Then  Validate creation of the team with correct name and desc
    Given Admin open the created team
    And   Admin assign team lead "<numsOfTeamLead>"
    Then  Validate nums of team members equals "<numsOfTeamLead>" plus "<numsOfTeamMember>"
    And   Validate role of team member "<type>"
    And   Validate card toggle is off
    When  Admin change card permission for a team lead
    Then  Validate card toggle is on
    When  Admin close team creation tab
    Then  Validate creation of the team with correct name and desc
    Examples:
      |numsOfTeamLead|numsOfTeamMember| type      |
      |numsOfTeamLead|zeroMembers     | teamLeadType  |

  @ScenarioOutline
  Scenario Outline: Admin can revoke card permission from a team lead
    Given Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  Admin Open Team Tab
    And   Admin Open Creation Team Form
    And   Admin create the team with team name and descreption
    When  Admin submit the creation
    Then  Validate creation of the team with correct name and desc
    Given Admin open the created team
    And   Admin assign team lead "<numsOfTeamLead>"
    Then  Validate nums of team members equals "<numsOfTeamLead>" plus "<numsOfTeamMember>"
    And   Validate role of team member "<type>"
    And   Validate card toggle is off
    When  Admin change card permission for a team lead
    Then  Validate card toggle is on
    When  Admin change card permission for a team lead
    Then  Validate card toggle is off
    When  Admin close team creation tab
    Then  Validate creation of the team with correct name and desc
    Examples:
      |numsOfTeamLead|numsOfTeamMember| type      |
      |numsOfTeamLead|zeroMembers     | teamLeadType  |

  @ScenarioOutline
  Scenario Outline: Admin can promote a team member to be team lead
    Given Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  Admin Open Team Tab
    And   Admin Open Creation Team Form
    And   Admin create the team with team name and descreption
    When  Admin submit the creation
    Then  Validate creation of the team with correct name and desc
    Given Admin open the created team
    And   Admin assign team member "<numsOfTeamMember>"
    Then  Validate nums of team members equals "<numsOfTeamLead>" plus "<numsOfTeamMember>"
    And   Validate role of team member "<type>"
    When  Admin Promote a team member
    Then  Validate role of team member "<type2>"
    When  Admin close team creation tab
    Then  Validate creation of the team with correct name and desc
    Examples:
      |numsOfTeamLead|numsOfTeamMember|    type       |   type2      |
      | zeroMembers  |numsOfTeamMember| teamMemberType| teamLeadType |

  @ScenarioOutline
  Scenario Outline: Admin can downgrade a team lead to be team member
    Given Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  Admin Open Team Tab
    And   Admin Open Creation Team Form
    And   Admin create the team with team name and descreption
    When  Admin submit the creation
    Then  Validate creation of the team with correct name and desc
    Given Admin open the created team
    And   Admin assign team lead "<numsOfTeamLead>"
    Then  Validate nums of team members equals "<numsOfTeamLead>" plus "<numsOfTeamMember>"
    And   Validate role of team member "<type>"
    When  Admin Downgrade a team lead
    Then  Validate role of team member "<type2>"
    When  Admin close team creation tab
    Then  Validate creation of the team with correct name and desc
    Examples:
      |numsOfTeamLead|numsOfTeamMember|    type       |     type2    |
      |numsOfTeamLead|zeroMembers     | teamLeadType  |teamMemberType|

  @ScenarioOutline
  Scenario Outline: Admin can assign a member to any team from members page
    Given Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    Given Teams and Members Page views forty five items
    When  Admin select member without a team
    And   Admin open the team list
    And   Admin choose the team for this member
    And   Admin close member edit tab
    When  Admin Open Team Tab
    And   Admin open the created team
    Then  Validate the member is added to the team members

    Examples:
      |numsOfTeamLead|numsOfTeamMember|    type       |     type2    |
      |numsOfTeamLead|zeroMembers     | teamLeadType  |teamMemberType|


  @ScenarioOutline
  Scenario Outline: Admin can un-assign a member from any team from members page
    Given Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    Given Teams and Members Page views forty five items
    When  Admin select member who in a team
    And   Admin open the team list
    And   Admin remove member from the team
    Then  Validate the member is not in a team
    And   Admin close member edit tab

    Examples:
      |numsOfTeamLead|numsOfTeamMember|    type       |     type2    |
      |numsOfTeamLead|zeroMembers     | teamLeadType  |teamMemberType|