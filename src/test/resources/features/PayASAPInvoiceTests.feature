Feature: Pay ASAP Invoices tests
  Background:
    Given user is on the login page
    And Validate Login page is displayed
    
  Scenario Outline: Admin can Flag Invoice Pay ASAP from Quick Actions
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    And   User go to Invoices Page
    And   Validate Invoices page is displayed
    And   Upload Invoice "<invoiceName>" with status review in case havnot any
    When  Click on add or remove pay ASAP flag from Quick Actions
    And   Click on confirm add or remove pay ASAP flag
    Then  Validate the pay ASAP successful toast appeared correctly
    And   Validate Under the ‘Flag’ column related to the the invoice with the name ‘ASAP Invoice‘ there should be ‘Pay ASAP’
    And   Validate first action under ‘Invoice document timeline‘ in audit trail contain ‘the user full name and "<flaggedOrRemove>"‘


    Examples:
      | email                 | password      |     invoiceName        | flaggedOrRemove |
      | adminInvoiceEmail     | validPassword |    payASAPInvoice      | flaggedText     |
      | teamLeadInvoiceEmail  | validPassword |    payASAPInvoice      | flaggedText     |
      | internalInvoiceEmail  | validPassword |    payASAPInvoice      | flaggedText     |
      | externalInvoiceEmail  | validPassword |    payASAPInvoice      | flaggedText     |
      | teamMemberInvoiceEmail| validPassword |    payASAPInvoice      | flaggedText     |


  Scenario Outline: Admin can Remove Flag Invoice Pay ASAP from Quick Actions

    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    And   User go to Invoices Page
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
      | adminInvoiceEmail     | validPassword |    payASAPInvoice      | removeFlagText  |
      | teamLeadInvoiceEmail  | validPassword |    payASAPInvoice      | removeFlagText  |
      | internalInvoiceEmail  | validPassword |    payASAPInvoice      | removeFlagText  |
      | externalInvoiceEmail  | validPassword |    payASAPInvoice      | removeFlagText  |
      | teamMemberInvoiceEmail| validPassword |    payASAPInvoice      | removeFlagText  |


  Scenario Outline: Admin can Flag Invoice Pay ASAP from Invoice Details
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    And   User go to Invoices Page
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
      | adminInvoiceEmail     | validPassword |    payASAPInvoice      | flaggedText     |


  Scenario Outline:  Admin can Remove Flag Invoice Pay ASAP from Invoice Details

    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    And   User go to Invoices Page
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
      | adminInvoiceEmail     | validPassword |    payASAPInvoice      | removeFlagText     |