Feature: After Finishing the Sign-up UI Automation Test Case and login from the same email that we did
  the Sign-up with, we will do the invitation test procedures
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
    And  Validate businessName "<businessLegalName>" is correct
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  User click invite user
    And   Enter Member's email "<twoMembersEmail>"
    And   Select Account access level "<adminType>"
    And   User submit the invitation
    Then  Validate invitation sent successfully
    Given Wait until successfull message disappeared
      When  User click invite user
      And   Enter Member's email "<threeMembersEmail>"
      And   Select Account access level "<internalType>"
      And   User submit the invitation
      Then  Validate invitation sent successfully
    Given Wait until successfull message disappeared
      When  User click invite user
      And   Enter Member's email "<fourMembersEmail>"
      And   Select Account access level "<externalType>"
      And   User submit the invitation
      Then  Validate invitation sent successfully
    Given Wait until successfull message disappeared
     When  User click invite user
      And   Enter Member's email "<fiveMembersEmail>"
      And   Select Account access level "<teamMemberType>"
      And   User submit the invitation
      Then  Validate invitation sent successfully


    Examples:
        | email           | firstname | lastname | password      | businessLegalName | phoneNumber | twoMembersEmail | adminType | threeMembersEmail | internalType       | fourMembersEmail | externalType       | fiveMembersEmail | teamMemberType |
        | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber | twoMembersEmail | admin     | threeMembersEmail | internalAccountant | fourMembersEmail | externalAccountant | fiveMembersEmail | teamMember     |


