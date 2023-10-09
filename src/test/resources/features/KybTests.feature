Feature: Kyb tests

   Background:
    Given user is on the login page
    And   Validate Login page is displayed

  @ScenarioOutline
  Scenario Outline: submit KYB form
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
    And   Validate user is on "landingPage"
    And   Get Domain Name
    And  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When  User fill the orgnization information
    Then   The orgnization information stored
    When   User click on open and close tab "one" button
    And   User upload the orgnization documents
    Then  The orgnization documents stored
    When   User click on open and close tab "two" button
    And   User Add another member
    And   User check on all shareholder types
    And   User fill shared user "email"
    Then  The shared user information stored
    When  User Add another member
    And   User check on company
    And   User fill shareholder as company "email"
    Then  The company information stored
    When  User Add another member
    And   User check director individual type
    And   User fill first director with admin "email"
    Then   The director information stored
    When  User Add another member
    And   User check shareholder individual type
    And   User fill first shareholder as individual with admin "email"
    Then   The shareholder information stored
    When  User Add another member
    And   User check signature individual type
    And   User fill first signature with admin "email"
    Then   The signature information stored
    And   User click on open and close tab "three" button
    And   User fill politically exposed persons
    Then   The politically exposed stored
    And   User agree on KYB Pemo policy
    And   User submit KYB form
    Then  Validate successful message appeared



#    When  User open back office website
#    And   User login with credentials "backOfficeEmail" and "backOfficePassword"
#    Then  Validate user is on "backOfficeKybPage"
#    When  User search for organization by domain name
#    Then  Validate organization has vendor user id
#    And   Validate status of organization
#    When  User open the organization on back office
#    Then  Validate the organization info sent correctly
#    And   Validate shareholder sent correctly
#    And   Validate signatures sent correctly
#    And   Validate directors sent correctly
#    And   Validate politically exposed persons sent correctly

    Examples:
      | email           | firstname | lastname | password      | businessLegalName | phoneNumber | title         |
      | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber | customizePage |


  @ScenarioOutline
  Scenario Outline:  Team lead, Team  member, External and internal can not view the KYB Dialog in the ‘Settings’ page
    Given User login with credentials "<email>" and "validPassword"
    And   Validate user is on "landingPage"
    When  User go to Setting Page
    Then  Validate page donot contain KYB form button
    And   Validate Page contains Bank Accounts for Invoices

    Examples:
      | email                 |
      | teamLeadInvoiceEmail  |
      | internalInvoiceEmail  |
      | externalInvoiceEmail  |
      | teamMemberInvoiceEmail|



  @ScenarioOutline
  Scenario Outline: Can't submit KYB form without mandatory fields
    Given User login with credentials "kybEmptyEmail" and "validPassword"
    And   Validate user is on "landingPage"
    When  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When  User agree on KYB Pemo policy
    And   User submit KYB form
    Then  Validate user is on "verificationCompany"
    And   Validate error messages for mandatory fields

    Examples:
      | email
      | adminInvoiceEmail


  @ScenarioOutline
  Scenario Outline: Admin can not submit KYB without checking the checkbox of Cards Terms and Conditions
    Given User login with credentials "policyCheckKybEmail" and "validPassword"
    And   Validate user is on "landingPage"
    When  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When  User fill the orgnization information
    And   User upload the orgnization documents
    And   User submit KYB form
    Then  Validate user is on "verificationCompany"

    Examples:
      | num |
      |     |


  @ScenarioOutline
  Scenario Outline: Admin can remove an added UBO from KYB Form
    Given User login with credentials "removeKybEmail" and "validPassword"
    And   Validate user is on "landingPage"
    When  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When  User click on open and close tab "one" button
    And   User click on open and close tab "two" button
    And   Validate no director user is added before
    And   User Add another member
    And   User check director individual type
    And   User Add another member
    And   User check shareholder individual type
    And   User Add another member
    And   User check signature individual type
    And   User get the number of company UBO
    And   User delete a signature UBO
    Then  Validate the UBO is removed
    And   Validate the position of the rest of UBOs
    And   Remove shareholder and director UBOs to can run the scenario again

    Examples:
      | num |
      |     |




  @ScenarioOutline
  Scenario Outline: Admin can view an uploaded file
    Given User login with credentials "viewFileKybEmail" and "validPassword"
    And   Validate user is on "landingPage"
    When  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When  User click on open and close tab "one" button
    And   User upload the Trade License for orgnization documents
    And   User get the URL of the uploaded document
    And   User view the uploaded document
    Then  Validate the URL format in "<environment>"
    And   Validate the uploaded document opened successfully
    And    remove the document to can re-run the test


    Examples:
      |     environment    |
      |  testEnv  |



  @ScenarioOutline
  Scenario Outline: Admin can upload .PNG files in the KYB Form
    Given User login with credentials "viewFileKybEmail" and "validPassword"
    And   Validate user is on "landingPage"
    When  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When  User click on open and close tab "one" button
    And   User upload the Trade License .PNG for orgnization documents
    And   User get the URL of the uploaded document
    And   User view the uploaded document
    Then  Validate the URL format in "<environment>"
    And   Validate the uploaded document opened successfully
    And    remove the document to can re-run the test
    Examples:
      |     environment   |
      |   testEnv      |

  @ScenarioOutline
  Scenario Outline: Admin can upload .JPG files in the KYB Form
    Given User login with credentials "viewFileKybEmail" and "validPassword"
    And   Validate user is on "landingPage"
    When  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When  User click on open and close tab "one" button
    And   User upload the Bank Statement .JPG for orgnization documents
    And   User get the URL of the uploaded document
    And   User view the uploaded document
    Then  Validate the URL format in "<environment>"
    And   Validate the uploaded document opened successfully
    And    remove the document to can re-run the test
    Examples:
      |     environment    |
      |   testEnv  |



  @ScenarioOutline
  Scenario Outline: Admin can not upload .csv file in the KYB Form
    Given User login with credentials "viewFileKybEmail" and "validPassword"
    And   Validate user is on "landingPage"
    When  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When  User click on open and close tab "one" button
    And   User try to upload .CSV file in the Trade License for orgnization documents
    Then  Validate .CSV Can not upload to KYB form

    Examples:
      |     environment    |
      |   testEnvironment  |



  @ScenarioOutline
  Scenario Outline: Admin can change Director type from Individual to Company
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
    And   Validate user is on "landingPage"
    And   Get Domain Name
    And  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When   User click on open and close tab "one" button
    And   User click on open and close tab "two" button
    And   User Add another member
    And   User change Director type from Individual to Company
    Then  Validate fields of company are appeared

    Examples:
      | email           | firstname | lastname | password      | businessLegalName | phoneNumber | title         |
      | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber | customizePage |