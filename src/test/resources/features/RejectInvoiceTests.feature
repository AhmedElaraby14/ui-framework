Feature: Reject Invoices tests
  Background:
    Given user is on the login page
    And Validate Login page is displayed
    
  Scenario Outline: Reject an Invoice from Quick Actions in case ‘All’ tab is selected and Invoice Status is 'Review'
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    And   User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Count number of uploaded Review invoice "<invoiceName>"
    And   Upload Invoice "<invoiceName>" with status review in case havnot any
    When  Click on reject invoice from Quick Actions
    And   Enter the rejection reason "<rejectionReason>"
    And   Submit reject invoice
    Then  Validate the rejection successful toast appeared correctly
    And   Validate the rejection invoice "<invoiceName>" disappeared from All tab
    Given Get num of invoices by api using same "<email>" and "<password>"
    Then   Validate num of invoices besides the ‘All’ tab & Number in the Footer & Count of rows in the ‘All’ tab & Total count fetched from API should be equal
    And   Validate invoice "<invoiceName>" record should appear in the ‘Archive’ page under ‘Rejected’ tab in the First Row
    #And   Validate number besides the ‘Rejected’ tab = Number in the Footer
    And   Validate the full name appeared under submited by column
    And   Validate member "<teamName>" appeared under submited by column
    And   Validate rejection reason "<rejectionReason>" is appeared in audit trail


    Examples:
      | email                 | password      | teamName       |     invoiceName        | rejectionReason |
      | adminInvoiceEmail     | validPassword | teamName       |    rejectReviewAll     | rejectionAdminQuickAction  |
      | teamLeadInvoiceEmail  | validPassword | teamName       |    rejectTeamLead      | rejectionTeamLeadQuickAction |


  Scenario Outline: Internal, External and Team member can't reject an Invoice
  from Quick Actions in case ‘All’ tab is selected and Invoice Status is 'Review'

    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    And   User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Count number of uploaded Review invoice "<invoiceName>"
    And   Upload Invoice "<invoiceName>" with status review in case havnot any
    When  Try to reject invoice from Quick Actions
    Then  Validate reject button is not displayed
    Examples:
      | email                 | password      | teamName       |     invoiceName        |
      | internalInvoiceEmail  | validPassword | teamName       |    rejectInternalAccountant |
      | externalInvoiceEmail  | validPassword | teamName       |    rejectExternalAccountant |
      | teamMemberInvoiceEmail| validPassword | teamName       |    rejectTeamMember    |


  Scenario Outline: Admin can reject an Invoice from Quick Actions in case ‘All’ tab is selected and Invoice Status is ‘Approval’
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    And   User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Count number of uploaded Approval invoice "<invoiceName>"
    And   Upload Invoice "<invoiceName>" with status approval in case havnot any
    When  Click on reject invoice from Quick Actions
    And   Enter the rejection reason "<rejectionReason>"
    And   Submit reject invoice
    Then  Validate the rejection successful toast appeared correctly
    And   Validate the rejection Approval invoice "<invoiceName>" disappeared from All tab
    Given Get num of invoices by api using same "<email>" and "<password>"
    Then   Validate num of invoices besides the ‘All’ tab & Number in the Footer & Count of rows in the ‘All’ tab & Total count fetched from API should be equal
    And   Validate invoice "<invoiceName>" record should appear in the ‘Archive’ page under ‘Rejected’ tab in the First Row
    #And   Validate number besides the ‘Rejected’ tab = Number in the Footer
    And   Validate the full name appeared under submited by column
    And   Validate member "<teamName>" appeared under submited by column
    And   Validate rejection reason "<rejectionReason>" is appeared in audit trail


    Examples:
      | email                 | password      | teamName       |     invoiceName        | rejectionReason |
      | adminInvoiceEmail     | validPassword | teamName       |    rejectApprovalAll   |rejectionApprovalAdminQuickAction|

  Scenario Outline: Admin can reject an Invoice from Quick Actions in case ‘All’ tab is selected and Invoice Status is ‘Payment’
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    And   User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Count number of uploaded Approval invoice "<invoiceName>"
    And   Upload Invoice "<invoiceName>" with status payment in case havnot any
    When  Click on reject invoice from Quick Actions
    And   Enter the rejection reason "<rejectionReason>"
    And   Submit reject invoice
    Then  Validate the rejection successful toast appeared correctly
    And   Validate the rejection Payment invoice "<invoiceName>" disappeared from All tab
    Given Get num of invoices by api using same "<email>" and "<password>"
    Then   Validate num of invoices besides the ‘All’ tab & Number in the Footer & Count of rows in the ‘All’ tab & Total count fetched from API should be equal
    And   Validate invoice "<invoiceName>" record should appear in the ‘Archive’ page under ‘Rejected’ tab in the First Row
    #And   Validate number besides the ‘Rejected’ tab = Number in the Footer
    And   Validate the full name appeared under submited by column
    And   Validate member "<teamName>" appeared under submited by column
    And   Validate rejection reason "<rejectionReason>" is appeared in audit trail


    Examples:
      | email                 | password      | teamName       |     invoiceName        | rejectionReason |
      | adminInvoiceEmail     | validPassword | teamName       |    rejectPaymentAll    |rejectionPaymentAdminQuickAction|


  Scenario Outline: Reject an Invoice from Invoice details tab in case ‘All’ tab is selected and Invoice Status is 'Review'
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    And   User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Count number of uploaded Review invoice "<invoiceName>"
    And   Upload Invoice "<invoiceName>" with status review in case havnot any
    When  Open invoice details tab
    And   Click on reject invoice from Invoice details
    And   Enter the rejection reason "<rejectionReason>"
    And   Submit reject invoice
    Then  Validate the rejection successful toast appeared correctly
    And   Validate the rejection invoice "<invoiceName>" disappeared from All tab
    Given Get num of invoices by api using same "<email>" and "<password>"
    Then   Validate num of invoices besides the ‘All’ tab & Number in the Footer & Count of rows in the ‘All’ tab & Total count fetched from API should be equal
    And   Validate invoice "<invoiceName>" record should appear in the ‘Archive’ page under ‘Rejected’ tab in the First Row
    #And   Validate number besides the ‘Rejected’ tab = Number in the Footer
    And   Validate the full name appeared under submited by column
    And   Validate member "<teamName>" appeared under submited by column
    And   Validate rejection reason "<rejectionReason>" is appeared in audit trail


    Examples:
      | email                 | password      | teamName       |     invoiceName        | rejectionReason |
      | adminInvoiceEmail     | validPassword | teamName       |    rejectReviewAll     |rejectionAdminInvoiceDetails   |
      | teamLeadInvoiceEmail  | validPassword | teamName       |    rejectTeamLead      | rejectionTeamLeadInvoiceDetails  |


  Scenario Outline: Internal, External and Team member can't reject an Invoice from Invoice details tab in case ‘All’ tab is selected and Invoice Status is 'Review'
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    And   User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Count number of uploaded Review invoice "<invoiceName>"
    And   Upload Invoice "<invoiceName>" with status review in case havnot any
    When  Open invoice details tab
    When  Try to reject invoice from Invoice Details
    Then  Validate reject button is not displayed in invoice details

    Examples:
      | email                 | password      | teamName       |     invoiceName        |
      | internalInvoiceEmail  | validPassword | teamName       |    rejectInternalAccountant |
      | externalInvoiceEmail  | validPassword | teamName       |    rejectExternalAccountant |
      | teamMemberInvoiceEmail| validPassword | teamName       |    rejectTeamMember    |


  Scenario Outline: Admin can not reject an Invoice without a rejection reason
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    And   User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Count number of uploaded Review invoice "<invoiceName>"
    And   Upload Invoice "<invoiceName>" with status review in case havnot any
    When  Open invoice details tab
    And   Reject invoice from Invoice Details without reason
    And   Submit reject invoice
    Then  Validate rejection reason field become red according to this error

    Examples:
      | email                 | password      | teamName       |     invoiceName        |
      | adminInvoiceEmail     | validPassword | teamName       |    rejectReviewAll     |


  Scenario Outline: Admin can not reject an Invoice with spaces as rejection reason
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    And   User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Count number of uploaded Review invoice "<invoiceName>"
    And   Upload Invoice "<invoiceName>" with status review in case havnot any
    When  Open invoice details tab
    And   Reject invoice from Invoice Details without reason
    And   Enter the rejection reason "<rejectionReason>"
    And   Submit reject invoice
    Then  Validate rejection reason field become red according to this error

    Examples:
      | email                 | password      | teamName       |     invoiceName        | rejectionReason |
      | adminInvoiceEmail     | validPassword | teamName       |    rejectReviewAll     |  emptyRejection |
