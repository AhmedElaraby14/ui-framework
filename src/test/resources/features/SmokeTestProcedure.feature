Feature: After Finishing the Sign-up UI Automation Test Case and login from the same email that we did
  the Sign-up with, We will do the invitation test procedures, Create teams

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


  @Invitations
  Scenario Outline: Login and send invitation
    When  user is on the login page
    And   User login with credentials "<email>" and "<password>"
    Then Validate user is on "landingPage"
    And  Validate user full name "<firstname>" and "<lastname>" is correct
    And  Validate the role of user is Admin
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed

    When  Login with API "<email>" and "<password>"
    And   Send Invitation with API to memberEmail with access level "apiAdmin"
    And   Teams and Members Page views forty five items
    Then   Validate member is added with the same email and "apiAdmin"
    When   The member activate the invitation with "<firstname>", "<lastname>" and "<password>"
    Then   Validate member with memberEmail and "apiAdmin" is active status

    When  Login with API "<email>" and "<password>"
    And   Send Invitation with API to memberEmail with access level "apiExternalAccountant"
    And   Teams and Members Page views forty five items
    Then   Validate member is added with the same email and "apiExternalAccountant"
    When   The member activate the invitation with "<firstname>", "<lastname>" and "<password>"
    Then   Validate member with memberEmail and "apiExternalAccountant" is active status

    When  Login with API "<email>" and "<password>"
    And   Send Invitation with API to memberEmail with access level "apiInternalAccountant"
    And   Teams and Members Page views forty five items
    Then   Validate member is added with the same email and "apiInternalAccountant"
    When   The member activate the invitation with "<firstname>", "<lastname>" and "<password>"
    Then   Validate member with memberEmail and "apiInternalAccountant" is active status

    When  Login with API "<email>" and "<password>"
    And   Send Invitation with API to memberEmail with access level "apiTeamMember"
    And   Teams and Members Page views forty five items
    Then   Validate member is added with the same email and "apiTeamMember"
    When   The member activate the invitation with "<firstname>", "<lastname>" and "<password>"
    Then   Validate member with memberEmail and "apiTeamMember" is active status


    Examples:
      | email           | firstname | lastname | password      | businessLegalName | accountType    |
      | registeredEmail | firstName | lastName | validPassword | lastName          |        |

  @Api
  Scenario Outline: Login and send invitation using API
    When  Login with API "<email>" and "<password>"
    And   Send Invitation with API to memberEmail with access level "<accountType>"
    Then   The member activate the invitation with "<firstname>", "<lastname>" and "<password>"

    Examples:
      | email           | firstname | lastname | password      | businessLegalName | accountType    |
      | registeredEmail | firstName | lastName | validPassword | lastName          |   apiAdmin     |
      | registeredEmail | firstName | lastName | validPassword | lastName          |   apiAdmin     |
      | registeredEmail | firstName | lastName | validPassword | lastName          |   apiExternalAccountant|
      | registeredEmail | firstName | lastName | validPassword | lastName          |   apiExternalAccountant|
      | registeredEmail | firstName | lastName | validPassword | lastName          |   apiInternalAccountant|
      | registeredEmail | firstName | lastName | validPassword | lastName          |   apiInternalAccountant|
      | registeredEmail | firstName | lastName | validPassword | lastName          |   apiTeamMember     |
      | registeredEmail | firstName | lastName | validPassword | lastName          |   apiTeamMember     |
      | registeredEmail | firstName | lastName | validPassword | lastName          |   apiTeamMember     |
      | registeredEmail | firstName | lastName | validPassword | lastName          |   apiTeamMember     |



  @Teams
  Scenario Outline: Create Team with specific criteria
    When  user is on the login page
    And   User login with credentials "<email>" and "<password>"
    Then Validate user is on "landingPage"
    When  User go to Teams and Members Page
    Then  Validate Teams and Members Page is displayed
    When  Admin Open Team Tab
    And   Admin Open Creation Team Form
    And   Admin create the team with team name and descreption
    And   Admin asign Admin member to the team
    And   Admin asign Internal Accountant member to the team
    And   Admin asign External Accountant member to the team
    And   Admin asign Team member to the team
    And   Admin assign team lead "oneTeamLead"
    Then  Validate nums of team members equals "oneTeamLead" plus "fourTeamMember"
    When  Admin submit the creation
    Then  Validate creation of the team with correct name and desc
    When  Admin Open Creation Team Form
    And   Admin create the team with team name and descreption
    And   Admin asign Admin member to the team
    And   Admin asign Internal Accountant member to the team
    And   Admin asign External Accountant member to the team
    And   Admin asign Team member to the team
    And   Admin assign team lead "oneTeamLead"
    Then  Validate nums of team members equals "oneTeamLead" plus "fourTeamMember"
    When  Admin submit the creation
    Then  Validate creation of the team with correct name and desc
#    When  Admin open the created team
#    And   Admin change card permission for a team lead
#    Then  Validate card toggle is on
#    And   Admin close team creation tab

    Examples:
      | email           | password      |
      | registeredEmail | validPassword   |

  @ForgetPassword
  Scenario Outline: Reset Password and Validate user Can't login with old password but can login with new one
    Given user is on the login page
    Then  Validate Login page is displayed
    When  User click reset password
    And   User enter registered "<email>" to set a new password
    And   User submit sending the email
    Then  Validate confirmation page for sending forgetten password email opened successfully
    When  Get the token of "<email>" using API
    And   Set the new password
    And   user is on the login page
    And   User login with credentials "<email>" and "<oldPassword>"
    Then  Validate user is on "loginPage"
    And   User login with credentials "<email>" and "newPassword"
    Then  Validate user is on "landingPage"
    Examples:
      | email                | oldPassword   | title       |
      | registeredEmail      | validPassword | landingPage |


  @MyAccountPage
  Scenario Outline: Admin can change First & Last Name from ‘My Account’ page
    When  user is on the login page
    And   User login with credentials "<email>" and "newPassword"
    Then Validate user is on "landingPage"
    When User open setting list
    And  User open my account setting
    And  User change first name
    When User change last name
    And  Validate full name label on top right page updated successfully
    When User change password "newPassword" to "oPassword"
    Then Validate the successful toast appeared
    When User logout
    When User login with credentials "<email>" and "oPassword"
    Then Validate user is on "landingPage"
    Examples:
      | email                | password   | title       |
      | registeredEmail      | newPassword | landingPage |

@UploadInvoices
  Scenario Outline:Upload single invoice
  Given user is on the login page
  And User login with credentials "<email>" and "oPassword"
  And   Validate user is on "landingPage"
  When  User go to Invoices Page
  And   Validate Invoices page is displayed
  When  User click on upload invoice button
  And   User enter single invoice
  And   User submit the uploaded invoices
  Then  Validate the invoice in uploading status
  And   Validate action button is disabled
  When  Open invoices review tab
  Then  Validate no invoices with uploading status
  When  Open invoices approval tab
  Then  Validate no invoices with uploading status
  When  Open invoices payment tab
  Then  Validate no invoices with uploading status
  When  Open all invoices tab
  Then   Validate invoice status changed to review
  And   Validate the full name appeared under submited by column
  And   Validate the name of file "<invoiceName>" is added correctly


  Examples:
    | email               | password          |     invoiceName        |
    | registeredEmail     | newPassword       |    singleInvoice       |


 @UploadInvoices
  Scenario Outline:Upload multi invoices
    Given user is on the login page
    And User login with credentials "<email>" and "oPassword"
    And   Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    When  User click on upload invoice button
    And   User enter multi invoice
    And   User submit the uploaded invoices
    Then  Validate the multiInvoices in uploading status

    Examples:
      | email                 | password
      | registeredEmail       | newPassword

   @UploadInvoices
   Scenario Outline:Automated Email should not contain the word undefined
     Given user is on the login page
     And User login with credentials "<email>" and "oPassword"
     And   Validate user is on "landingPage"
     When  User go to Invoices Page
     And   Validate Invoices page is displayed
     When  User click on upload invoice button
     Then  Check automated Email should not contain the word undefined

     Examples:
       | email                 | password
       | registeredEmail       | newPassword

  @UploadInvoices
  Scenario Outline:Upload Invoice Dialog should contain description of the upload invoice
    Given user is on the login page
    And User login with credentials "<email>" and "oPassword"
    And   Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    When  User click on upload invoice button
    Then  Check the dialog should contain description of the upload invoice

    Examples:
      | email                 | password
      | registeredEmail       | oPassword



  @RejectInvoices
  Scenario Outline: Reject an Invoice from Quick Actions in case ‘All’ tab is selected and Invoice Status is 'Review'
    Given user is on the login page
    And User login with credentials "<email>" and "oPassword"
    And   Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Count number of uploaded Review invoice "rejectReviewAll"
    And   Upload Invoice "rejectReviewAll" with status review in case havnot any
    When  Click on reject invoice from Quick Actions
    And   Enter the rejection reason "rejectionAdmin"
    And   Submit reject invoice
    Then  Validate the rejection successful toast appeared correctly
    And   Validate the rejection invoice "rejectReviewAll" disappeared from All tab
    Given Get num of invoices by api using same "<email>" and "oPassword"
    Then   Validate num of invoices besides the ‘All’ tab & Number in the Footer & Count of rows in the ‘All’ tab & Total count fetched from API should be equal
    And   Validate invoice "rejectReviewAll" record should appear in the ‘Archive’ page under ‘Rejected’ tab in the First Row
    And   Validate number besides the ‘Rejected’ tab = Number in the Footer
    And   Validate the full name appeared under submited by column
    And   Validate rejection reason "rejectionAdmin" is appeared in audit trail


    Examples:
      | email                 | password             |     invoiceName        | rejectionReason |
      | registeredEmail       | oPassword            |    rejectReviewAll     | rejectionAdminQuickAction  |


  @RejectInvoices
  Scenario Outline:Admin can reject an Invoice from Invoice details tab in case ‘All’ tab is selected and Invoice Status is 'Review'
    Given user is on the login page
    And User login with credentials "<email>" and "oPassword"
    And   Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Count number of uploaded Review invoice "<invoiceName>"
    And   Upload Invoice "<invoiceName>" with status review in case havnot any
    When  Open invoice details tab
    And   Click on reject invoice from Invoice details
    And   Enter the rejection reason "rejectionAdmin"
    And   Submit reject invoice
    Then  Validate the rejection successful toast appeared correctly
    And   Validate the rejection invoice "<invoiceName>" disappeared from All tab
    Given Get num of invoices by api using same "<email>" and "oPassword"
    Then   Validate num of invoices besides the ‘All’ tab & Number in the Footer & Count of rows in the ‘All’ tab & Total count fetched from API should be equal
    And   Validate invoice "<invoiceName>" record should appear in the ‘Archive’ page under ‘Rejected’ tab in the First Row
    And   Validate number besides the ‘Rejected’ tab = Number in the Footer
    And   Validate the full name appeared under submited by column
    And   Validate rejection reason "rejectionAdmin" is appeared in audit trail


    Examples:
      | email                 | password      |     invoiceName        | rejectionReason |
      | registeredEmail       | oPassword     |    rejectReviewAll     |rejectionAdminInvoiceDetails   |
  @RejectInvoices
  Scenario Outline:Admin can reject an Invoice from Quick Actions in case ‘All’ tab is selected and Invoice Status is ‘Approval’
    Given user is on the login page
    And User login with credentials "<email>" and "oPassword"
    And   Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Count number of uploaded Approval invoice "<invoiceName>"
    And   Upload Invoice "<invoiceName>" with status approval in case havnot any
    When  Click on reject invoice from Quick Actions
    And   Enter the rejection reason "<rejectionReason>"
    And   Submit reject invoice
    Then  Validate the rejection successful toast appeared correctly
    And   Validate the rejection Approval invoice "<invoiceName>" disappeared from All tab
    Given Get num of invoices by api using same "<email>" and "oPassword"
    Then   Validate num of invoices besides the ‘All’ tab & Number in the Footer & Count of rows in the ‘All’ tab & Total count fetched from API should be equal
    And   Validate invoice "<invoiceName>" record should appear in the ‘Archive’ page under ‘Rejected’ tab in the First Row
    And   Validate number besides the ‘Rejected’ tab = Number in the Footer
    And   Validate the full name appeared under submited by column
    And   Validate rejection reason "<rejectionReason>" is appeared in audit trail


    Examples:
      | email                 | password    |      invoiceName        | rejectionReason |
      | registeredEmail       | oPassword   |    rejectApprovalAll    |rejectionApprovalAdminQuickAction|

  @RejectInvoices
  Scenario Outline:Admin can reject an Invoice from Quick Actions in case ‘All’ tab is selected and Invoice Status is ‘Payment’
    Given user is on the login page
    And User login with credentials "<email>" and "oPassword"
    And Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Count number of uploaded Approval invoice "rejectPaymentAll"
    And   Upload Invoice "rejectPaymentAll" with status payment in case havnot any
    When  Click on reject invoice from Quick Actions
    And   Enter the rejection reason "rejectionPaymentAdminQuickAction"
    And   Submit reject invoice
    Then  Validate the rejection successful toast appeared correctly
    And   Validate the rejection Payment invoice "<invoiceName>" disappeared from All tab
    Given Get num of invoices by api using same "<email>" and "oPassword"
    Then   Validate num of invoices besides the ‘All’ tab & Number in the Footer & Count of rows in the ‘All’ tab & Total count fetched from API should be equal
    And   Validate invoice "rejectPaymentAll" record should appear in the ‘Archive’ page under ‘Rejected’ tab in the First Row
    And   Validate number besides the ‘Rejected’ tab = Number in the Footer
    And   Validate the full name appeared under submited by column
    And   Validate rejection reason "rejectionPaymentAdminQuickAction" is appeared in audit trail


    Examples:
      | email                 | password      |      invoiceName        | rejectionReason |
      | registeredEmail       | oPassword     |     rejectPaymentAll    |rejectionPaymentAdminQuickAction|


  @PayASAPInvoices

  Scenario Outline: Admin can Flag Invoice Pay ASAP from Quick Actions
    Given user is on the login page
    And User login with credentials "<email>" and "oPassword"
    And Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Upload Invoice "<invoiceName>" with status review in case havnot any
    When  Click on add or remove pay ASAP flag from Quick Actions
    And   Click on confirm add or remove pay ASAP flag
    Then  Validate the pay ASAP successful toast appeared correctly
    And   Validate Under the ‘Flag’ column related to the the invoice with the name ‘ASAP Invoice‘ there should be ‘Pay ASAP’
    And   Validate first action under ‘Invoice document timeline‘ in audit trail contain ‘the user full name and "<flaggedOrRemove>"‘


    Examples:
      | email                 | password      |     invoiceName        | flaggedOrRemove |
      | registeredEmail     | validPassword |    payASAPInvoice      | flaggedText     |


  @PayASAPInvoices

  Scenario Outline: Admin can Remove Flag Invoice Pay ASAP from Quick Actions

    Given user is on the login page
    And User login with credentials "<email>" and "oPassword"
    And Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Count number of uploaded Review invoice "<invoiceName>"
    And   Upload Invoice "<invoiceName>" with status review and with pay ASAP flag in case havnot any
    When  Click on add or remove pay ASAP flag from Quick Actions
    And   Click on confirm add or remove pay ASAP flag
    Then  Validate the pay ASAP successful toast appeared correctly
    And   Validate the pay ASAP flag disappeared Under the ‘Flag’ column related to the the invoice with the name ‘ASAP Invoice‘
    And   Validate first action under ‘Invoice document timeline‘ in audit trail contain ‘the user full name and "<flaggedOrRemove>"‘


    Examples:
      | email                 | password      |     invoiceName        | flaggedOrRemove |
      | registeredEmail     | validPassword |    payASAPInvoice      | removeFlagText  |


  @PayASAPInvoices

  Scenario Outline: Admin can Flag Invoice Pay ASAP from Invoice Details
    Given user is on the login page
    And User login with credentials "<email>" and "oPassword"
    And Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Upload Invoice "<invoiceName>" with status review in case havnot any
    When  Open invoice details tab
    And   Add or remove pay ASAP flag from Invoice details
    And   Click on confirm add or remove pay ASAP flag
    Then  Validate the pay ASAP successful toast appeared correctly
    Given Close invoice details tab
    Then   Validate Under the ‘Flag’ column related to the the invoice with the name ‘ASAP Invoice‘ there should be ‘Pay ASAP’
    And   Validate first action under ‘Invoice document timeline‘ in audit trail contain ‘the user full name and "<flaggedOrRemove>"‘


    Examples:
      | email                 | password      |     invoiceName        | flaggedOrRemove |
      | registeredEmail     | validPassword |    payASAPInvoice      | flaggedText     |

  @PayASAPInvoices

  Scenario Outline:  Admin can Remove Flag Invoice Pay ASAP from Invoice Details

    Given user is on the login page
    And User login with credentials "<email>" and "oPassword"
    And Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Upload Invoice "<invoiceName>" with status review and with pay ASAP flag in case havnot any
    When  Open invoice details tab
    And   Add or remove pay ASAP flag from Invoice details
    And   Click on confirm add or remove pay ASAP flag
    Then  Validate the pay ASAP successful toast appeared correctly
    Given Close invoice details tab
    Then  Validate the pay ASAP flag disappeared Under the ‘Flag’ column related to the the invoice with the name ‘ASAP Invoice‘
    And   Validate first action under ‘Invoice document timeline‘ in audit trail contain ‘the user full name and "<flaggedOrRemove>"‘


    Examples:
      | email                 | password      |     invoiceName        | flaggedOrRemove |
      | registeredEmail     | validPassword |    payASAPInvoice      | removeFlagText     |