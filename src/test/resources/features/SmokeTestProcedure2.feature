Feature: After Finishing the Sign-up UI , Let's submit the KYB form Then validate the data sent successfully to back office

  @SignUp
Scenario Outline: Sign-Up to Pemo Website
    Given user is on the login page
     And   Go to Sign-Up page
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
        | email           | firstname | lastname | password      | businessLegalName | phoneNumber |
        | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber |

  @Kyb
  Scenario Outline: submit KYB form and Validate it reflect correctly in back office
    Given user is on the login page
    And User login with credentials "<email>" and "oPassword"
    And   Validate user is on "landingPage"
    And   Get Domain Name
    And  User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When  User fill the orgnization information
    Then   The orgnization information stored
    When   User click on open and close tab "one" button
    And   User upload the orgnization documents
    Then   The orgnization documents stored
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
    Given User open back office website
    When  User login with credentials "backOfficeEmail" and "backOfficePassword"
    Then  Validate user is on "backOfficeKybPage"
    When  User search for organization by domain name
    Then  Validate organization has vendor user id
    And   Validate status of organization
    When  User open the organization on back office
    Then  Validate the organization info sent correctly
    And   Validate politically exposed persons sent correctly
    When  User click on open and close tab "one" button
    Then  Validate the organization documents sent correctly
    When  User click on open and close tab "two" button
    Then  Validate sharedUser sent correctly
    And   Validate companyUBO sent correctly
    And   Validate directors sent correctly
    And   Validate shareholder sent correctly
    And   Validate signatures sent correctly

    Examples:
      | email           | firstname | lastname | password      | businessLegalName | phoneNumber | title         |
      | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber | customizePage |

  @BackOffice
  Scenario Outline: BackOffice User can approve entry
    Given user is on the login page
    And   Validate Login page is displayed
    And   User login with credentials "<email>" and "validPassword"
    And   Validate user is on "landingPage"
    And   Get Domain Name
    When   User go to Setting Page
    And   User click on lets go button
    Then  Validate user is on "verificationCompany"
    When  The orgnization information stored
    And   User click on open and close tab "one" button
    And   User click on open and close tab "two" button
    And   Remove the last three UBOs to can run the scenario again
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

  @BackOffice
  Scenario Outline: BackOffice User can reject entry
    Given user is on the login page
    And   Validate Login page is displayed
    And   User login with credentials "<email>" and "validPassword"
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
    And   User click on open and close tab "one" button
    And   User click on open and close tab "two" button
    And   Click on Reject entry for address
    And   Enter the rejection reason
    And   Change KYB status to user action needed
    Then  Validate the organization status is User action required
    And   Validate rejection reason appeared under the rejected field in back office
    Given user is on the login page
    And   User login with credentials "<email>" and "validPassword"
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

  @BackOffice

  Scenario Outline: BackOffice User can update user info for a new added UBO via BackOffice that is ‘Shareholder’, ‘Director’ and ‘Signature’ in the same time
    Given user is on the login page
    And   Validate Login page is displayed
    And   User login with credentials "<email>" and "validPassword"
    And   Validate user is on "landingPage"
    And   Get Domain Name
    And User open back office website
    When  User login with credentials "backOfficeEmail" and "backOfficePassword"
    Then  Validate user is on "backOfficeKybPage"
    When  User search for organization by domain name
    Then  Validate organization has vendor user id
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

  @BackOffice
  Scenario Outline: BackOffice User can add new ‘UBO’ that is ‘Shareholder’, ‘Director’ and ‘Signature’ in the same time
    Given user is on the login page
    And   Validate Login page is displayed
    And   User login with credentials "<email>" and "validPassword"
    And   Validate user is on "landingPage"
    And   Get Domain Name
    And   User open back office website
    When  User login with credentials "backOfficeEmail" and "backOfficePassword"
    Then  Validate user is on "backOfficeKybPage"
    When  User search for organization by domain name
    Then  Validate organization has vendor user id
    When  User open the organization on back office
    And   User get the number of company UBO
    And   User Add another member in back office
    And   User check on all shareholder types in Back office
    Then Validate New UBO is added successfully
    And   Remove user to can run the scenario again

    Examples:
      | email           | firstname | lastname | password      | businessLegalName | phoneNumber | title         |
      | registeredEmail | firstName | lastName | validPassword | lastName          | phoneNumber | customizePage |

  @BackOffice
  Scenario Outline: BackOffice User can decline KYB for a company
    Given user is on the login page
    And   Validate Login page is displayed
    And   User login with credentials "<email>" and "validPassword"
    And   Validate user is on "landingPage"
    And   Get Domain Name
    And  User open back office website
    And   User login with credentials "backOfficeEmail" and "backOfficePassword"
    Then  Validate user is on "backOfficeKybPage"
    When  User search for organization by domain name
    Then  Validate organization has vendor user id
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

