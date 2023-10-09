Feature: Upload Invoices tests
  Background:
    Given user is on the login page
    And Validate Login page is displayed
    
  Scenario Outline:Upload single invoice
    Given User login with credentials "<email>" and "<password>"
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
    And   Validate member "<teamName>" appeared under submited by column
    And   Validate the name of file "<invoiceName>" is added correctly


    Examples:
      | email                 | password      | teamName       |     invoiceName        |
      | adminInvoiceEmail     | validPassword | teamName       |    singleInvoice       |
      | internalInvoiceEmail  | validPassword | teamName       |    singleInvoice       |
      | externalInvoiceEmail  | validPassword | teamName       |    singleInvoice       |
      | teamMemberInvoiceEmail| validPassword | teamName       |    singleInvoice       |
      | teamLeadInvoiceEmail  | validPassword | teamName       |    singleInvoice       |


  Scenario Outline:Upload multi invoices
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    When  User click on upload invoice button
    And   User enter multi invoice
    And   User submit the uploaded invoices
    Then  Validate the multiInvoices in uploading status

    Examples:
      | email                 | password      | teamName       |     invoiceName        |
      | validUsername         | validPassword | teamName       |    singleInvoice       |


  Scenario Outline:Admin can not upload .PNG file
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    When  User click on upload invoice button
    And   User try to enter .PNG invoice
    Then  Validate submit invoice button is disabled

    Examples:
      | email                 | password      | teamName       |     invoiceName        |
      | validUsername         | validPassword | teamName       |    singleInvoice       |

  Scenario Outline:Admin can not upload .EXE file
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    When  User click on upload invoice button
    And   User try to enter .EXE invoice
    Then  Validate submit invoice button is disabled

    Examples:
      | email                 | password      | teamName       |     invoiceName        |
      | validUsername         | validPassword | teamName       |    singleInvoice       |


  Scenario Outline:Admin can not view Invoice Details in case status is ‘Uploading’
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    When  User click on upload invoice button
    And   User enter single invoice
    And   User submit the uploaded invoices
    Then  Validate the invoice in uploading status
    And   Validate action button is disabled

    Examples:
      | email                 | password      | teamName       |     invoiceName        |
      | validUsername         | validPassword | teamName       |    singleInvoice       |


  Scenario Outline:  Admin can not upload 11 Invoices

    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    When  User click on upload invoice button
    And   User enter eleven invoices
    And   User submit the uploaded invoices
    Then  Validate the invoice error toast appeared correctly

    Examples:
      | email                 | password      | teamName       |     invoiceName        |
      | validUsername         | validPassword | teamName       |    singleInvoice       |


  Scenario Outline:Automated Email should not contain the word undefined
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    When  User click on upload invoice button
    Then  Check automated Email should not contain the word undefined

    Examples:
      | email                 | password      | teamName       |     invoiceName        |
      | validUsername         | validPassword | teamName       |    singleInvoice       |

  Scenario Outline:Upload Invoice Dialog should contain description of the upload invoice
    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    When  User click on upload invoice button
    Then  Check the dialog should contain description of the upload invoice

    Examples:
      | email                 | password      | teamName       |     invoiceName        |
      | validUsername         | validPassword | teamName       |    singleInvoice       |

  Scenario Outline:  Admin can delete invoice in the ‘Upload Invoice' Dialog

    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    When  User click on upload invoice button
    And   User enter three invoices
    Then  Validate nums of uploaded invoices are "three"
    And   User delete one invoice from the uploaded
    Then  Validate nums of uploaded invoices are "two"

    Examples:
      | email                 | password      | teamName       |     invoiceName        |
      | validUsername         | validPassword | teamName       |    singleInvoice       |

  Scenario Outline:  Admin can cancel the Uploaded Invoices

    Given User login with credentials "<email>" and "<password>"
    And   Validate user is on "landingPage"
    When  User go to Invoices Page
    And   Validate Invoices page is displayed
    When  User click on upload invoice button
    And   User enter three invoices
    And   Get the nums of items per the invoice page
    And   User click on cancel button
    Then  Check the nums of items per the invoice page


    Examples:
      | email                 | password      | teamName       |     invoiceName        |
      | validUsername         | validPassword | teamName       |    singleInvoice       |