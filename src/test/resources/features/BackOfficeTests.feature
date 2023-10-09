Feature: BackOffice tests

  @ScenarioOutline
  Scenario Outline: BackOffice User can decline KYB for a company
    Given user is on the login page
    And   Validate Login page is displayed
    And Go to Sign-Up page
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
    And   Validate user is on "landingPage"
    And   Get Domain Name
    And   User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When  User fill the orgnization information
    Then  The orgnization information stored
    And   User upload the orgnization documents
    When  User agree on KYB Pemo policy
    And   User submit KYB form
    When  User open back office website
    And   User login with credentials "backOfficeEmail" and "backOfficePassword"
    Then  Validate user is on "backOfficeKybPage"
    When  User search for organization by domain name
    Then  Validate organization has vendor user id
    And   Validate status of organization
    When  User open the organization on back office
    And   User decline the form
    Then  Validate the organization status is declined
    When  user is on the login page
    And   User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    Then  Validate “Company verification has been declined“ button appeared successfully
    When  User go to Setting Page
    Then  Validate In the KYB box this text “Company Verification is declined” is appeared
    And   Validate KYB Button is disabled

    Examples:
      | email           | firstname | lastname | password      | businessLegalName | phoneNumber | title         |
      | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber | customizePage |



  @ScenarioOutline
  Scenario Outline: BackOffice User can approve entry
    Given user is on the login page
    And   Validate Login page is displayed
    And   User login with credentials "backOfficeEmailTests" and "validPassword"
    And   Validate user is on "landingPage"
    And   Get Domain Name
    When   User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When  The orgnization information stored
    And   User click on open and close tab "one" button
    And   User click on open and close tab "two" button
    And   User Add another member
    And   User check director individual type
    And   User enter director adress "approved"
    And   User click on open and close tab "three" button
    And  User agree on KYB Pemo policy
    And   User submit KYB form
    Then  Validate successful message appeared
    And  User open back office website
    And   User login with credentials "backOfficeEmail" and "backOfficePassword"
    Then  Validate user is on "backOfficeKybPage"
    When  User search for organization by domain name
    Then  Validate organization has vendor user id
    And   Validate status of organization
    When  User open the organization on back office
    And   User click on open and close tab "one" button
    And   User click on open and close tab "two" button
    And   Click on Approve entry for address
    Then  Validate Toast message appeared successfully "approveEntry"
    And  Remove director UBO in back office to can run the scenario again

    Examples:
      | email           | firstname | lastname | password      | businessLegalName | phoneNumber | title         |
      | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber | customizePage |



  @ScenarioOutline
  Scenario Outline: BackOffice User can reject entry
    Given user is on the login page
    And   Validate Login page is displayed
    And   User login with credentials "backOfficeEmailTests" and "validPassword"
    And   Validate user is on "landingPage"
    And   Get Domain Name
    When   User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When  The orgnization information stored
    And   User click on open and close tab "one" button
    And   User click on open and close tab "two" button
    And   User Add another member
    And   User check director individual type
    And   User enter director adress "rejected"
    And   User click on open and close tab "three" button
    And  User agree on KYB Pemo policy
    And   User submit KYB form
    Then  Validate successful message appeared
    And  User open back office website
    And   User login with credentials "backOfficeEmail" and "backOfficePassword"
    Then  Validate user is on "backOfficeKybPage"
    When  User search for organization by domain name
    Then  Validate organization has vendor user id
    And   Validate status of organization
    When  User open the organization on back office
    And   Click on Reject entry for address
    And   Enter the rejection reason
    And   Change KYB status to user action needed
    Then  Validate the organization status is User action required
    And   Validate rejection reason appeared under the rejected field in back office
    Given user is on the login page
    And   User login with credentials "backOfficeEmailTests" and "validPassword"
    And   Validate user is on "landingPage"
    And   User go to Setting Page
    Then  Validate In the KYB box this text “One more thing!” is appeared
    Given User click on lets go button
    Then  Validate user is on "verificationCompany"
    And   Validate rejection reason appeared under the rejected field in pemo
    And  Remove director UBO to can run the scenario again

    Examples:
      | email           | firstname | lastname | password      | businessLegalName | phoneNumber | title         |
      | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber | customizePage |



  @ScenarioOutline
  Scenario Outline: BackOffice User can update user info for a new added UBO via BackOffice that is ‘Shareholder’, ‘Director’ and ‘Signature’ in the same time
    Given User open back office website
    When  User login with credentials "backOfficeEmail" and "backOfficePassword"
    Then  Validate user is on "backOfficeKybPage"
    When  User search for organization by domain name
    Then  Validate organization has vendor user id
    And   Validate status of organization
    When  User open the organization on back office
    And   User Add another member in back office
    And   User check on all shareholder types in Back office
    And   User sync the new users
    Then  Validate Toast message appeared successfully "syncUser"
    When  User Update User Info
    Then  Validate Toast message appeared successfully "updateUserInfo"
    And   Remove user to can run the scenario again

    Examples:
      | email           | firstname | lastname | password      | businessLegalName | phoneNumber | title         |
      | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber | customizePage |




  @ScenarioOutline
  Scenario Outline: BackOffice User can add a new item in the UBO section
    Given User open back office website
    When  User login with credentials "backOfficeEmail" and "backOfficePassword"
    Then  Validate user is on "backOfficeKybPage"
    When  User search for organization by domain name
    Then  Validate organization has vendor user id
    And   Validate status of organization
    When  User open the organization on back office
    And   User Add new item
    Then  Validate Item is added successfully
    Given user is on the login page
    And   Validate Login page is displayed
    And   User login with credentials "backOfficeEmailAddItem" and "validPassword"
    And   Validate user is on "landingPage"
    When  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    And   Validate Item is added successfully

    Examples:
      | email           | firstname | lastname | password      | businessLegalName | phoneNumber | title         |
      | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber | customizePage |



  @ScenarioOutline
  Scenario Outline: BackOffice User can upload a file
    Given User open back office website
    When  User login with credentials "backOfficeEmail" and "backOfficePassword"
    Then  Validate user is on "backOfficeKybPage"
    When  User search for organization by domain name
    Then  Validate organization has vendor user id
    And   Validate status of organization
    When  User open the organization on back office
    And   User upload the Trade License for orgnization documents in Back office
    And   User get the URL of the uploaded document
    And   User view the uploaded document
    Then  Validate the URL format in "<environment>"
    And   Validate the uploaded document opened successfully
    And   Validate Three buttons should appear which they are: Upload file ,Send to NymCard and View file buttons
    Given user is on the login page
    And   Validate Login page is displayed
    And   User login with credentials "backOfficeEmailAddItem" and "validPassword"
    And   Validate user is on "landingPage"
    When  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    And    remove the document to can re-run the test

    Examples:
      | email           | firstname | lastname | password      | businessLegalName | phoneNumber | title          |     environment    |
      | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber | customizePage |   testEnv  |



  @ScenarioOutline
  Scenario Outline: Admin can view an uploaded file
    Given user is on the login page
    And   Validate Login page is displayed
    And   User login with credentials "backOfficeEmailAddItem" and "validPassword"
    And   Validate user is on "landingPage"
    When  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When  User click on open and close tab "one" button
    And   User upload the Trade License for orgnization documents
    And   User get the URL of the uploaded document
    And   User open back office website
    And   User login with credentials "backOfficeEmail" and "backOfficePassword"
    Then  Validate user is on "backOfficeKybPage"
    When  User search for organization by domain name
    Then  Validate organization has vendor user id
    And   Validate status of organization
    When  User open the organization on back office
    And   User view the uploaded document
    Then  Validate the URL format in "<environment>"
    And   Validate the uploaded document opened successfully
    Given user is on the login page
    And   Validate Login page is displayed
    And   User login with credentials "backOfficeEmailAddItem" and "validPassword"
    And   Validate user is on "landingPage"
    When  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    And   remove the document to can re-run the test

    Examples:

      |     environment    |
      |  testEnv  |


  @ScenarioOutline
  Scenario Outline: BackOffice User can send one document to NymCard
    Given User open back office website
    When  User login with credentials "backOfficeEmail" and "backOfficePassword"
    Then  Validate user is on "backOfficeKybPage"
    When  User search for organization by domain name
    Then  Validate organization has vendor user id
    And   Validate status of organization
    When  User open the organization on back office
    And   User upload the Trade License for orgnization documents in Back office
    And   User sync the new users
    Then  Validate Toast message appeared successfully "syncUser"
    When  User send document to nym card
    Then  Validate Toast message appeared successfully "nymCardUser"
    Given user is on the login page
    And   Validate Login page is displayed
    And   User login with credentials "backOfficeEmailAddItem" and "validPassword"
    And   Validate user is on "landingPage"
    When  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    And    remove the document to can re-run the test

    Examples:
      | email           | firstname | lastname | password      | businessLegalName | phoneNumber | title          |     environment    |
      | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber | customizePage |   testEnv  |


  @ScenarioOutline
  Scenario Outline: BackOffice User can add new ‘UBO’ that is ‘Shareholder’, ‘Director’ and ‘Signature’ in the same time
    Given User open back office website
    When  User login with credentials "backOfficeEmail" and "backOfficePassword"
    Then  Validate user is on "backOfficeKybPage"
    When  User search for organization by domain name
    Then  Validate organization has vendor user id
    And   Validate status of organization
    When  User open the organization on back office
    And   User get the number of company UBO
    And   User Add another member in back office
    And   User check on all shareholder types in Back office
    Then Validate New UBO is added successfully
    And   Remove user to can run the scenario again

    Examples:
      | email           | firstname | lastname | password      | businessLegalName | phoneNumber | title         |
      | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber | customizePage |


