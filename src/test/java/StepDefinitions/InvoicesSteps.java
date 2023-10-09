package StepDefinitions;

import Managers.FileReaderManager;
import PageObjects.*;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InvoicesSteps {

    TestContext testContext;
    LandingPage landingPage;
    InvoicesPage invoicesPage;
    TeamsAndMembersPage teamsAndMembersPage;
    LoginPage   loginPage;
    SignUpPage  signUpPage;

    String itemsPerPage;
    int numOfUploadedInvoices;
    public InvoicesSteps(TestContext context) {
        testContext = context;
        landingPage = testContext.getPageObjectManager().getLandingPage();
        invoicesPage = testContext.getPageObjectManager().getInvoicesPage();
        teamsAndMembersPage = testContext.getPageObjectManager().getTeamsAndMembersPage();
        loginPage = testContext.getPageObjectManager().getLoginPage();
        signUpPage = testContext.getPageObjectManager().getSignUpPage();

    }


    @Given("User go to Invoices Page")
    public void userIsOnInvoicesPage() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        landingPage.openInvoicesPage(webDriver);
    }

    @And("Validate Invoices page is displayed")
    public void validateInvoicesPageIsDisplayed() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(5000);
        String actualLoginHeaderTitle = testContext.getDriverManager().getDriver().getTitle();
        Assert.assertEquals(actualLoginHeaderTitle,"Pemo | Invoices","Wrong Text for Title Page or You are on the wrong page");
    }

    @When("User click on upload invoice button")
    public void userClickOnUploadInvoiceButton() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.clickOnUploadInvoiceButton(webDriver);
        Thread.sleep(2000);
    }

    @And("User enter single invoice")
    public void userEnterSingleInvoice() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.sendFileToContainer("Reject_Reviiew_All");
        Thread.sleep(1000);
    }

    @And("User submit the uploaded invoices")
    public void userSubmitTheUploadedInvoices() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.clickOnSubmitFileButton(webDriver);

    }

    @Then("Validate the invoice in uploading status")
    public void validateTheInvoiceInUploadingStatus() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.waitUntilSuccessMessageInvisible(webDriver);
        Thread.sleep(2000);
        Assert.assertTrue(invoicesPage.validateInvoice(webDriver));
    }

    @And("Validate action button is disabled")
    public void validateActionButtonIsDisabled() {
        Assert.assertTrue(invoicesPage.validateActionButtonIsDisabled());
    }

    @And("Validate invoice status changed to review")
    public void validateInvoiceStatusChangedToReview() {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.waitUntilStatusChangedToReview(webDriver);
    }

    @And("Validate the full name appeared under submited by column")
    public void validateTheFullNameAppearedUnderSubmitedByColumn() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        System.out.println(landingPage.getUserFullName(webDriver));
        Assert.assertTrue(invoicesPage.validateTheFullNameAppearedUnderSubmitedByColumn(webDriver,landingPage.getUserFullName(webDriver)));
    }

    @And("Validate the name of file {string} is added correctly")
    public void validateTheNameOfFileIsAddedCorrectly(String invoiceName) {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertTrue(invoicesPage.validateTheInvoiceNameAddedCorrectly(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName)));
    }

    @And("Validate member {string} appeared under submited by column")
    public void validateMemberAppearedUnderSubmitedByColumn(String teamName) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        System.out.println(invoicesPage.teamNameText(webDriver));
        Assert.assertTrue(invoicesPage.teamNameText(webDriver).contains(FileReaderManager.getInstance().getConfigFileReader().getProperty(teamName)));
    }

    @And("User enter multi invoice")
    public void userEnterMultiInvoice() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        invoicesPage.sendMultiFilesToContainer();
        Thread.sleep(1000);
    }

    @Then("Validate the multiInvoices in uploading status")
    public void validateTheMultiInvoicesInUploadingStatus() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.waitUntilSuccessMessageInvisible(webDriver);
        Thread.sleep(2000);
        Assert.assertTrue(invoicesPage.validateMultiInvoices(webDriver));
    }

    @And("User try to enter .PNG invoice")
    public void userTryToEnterPNGInvoice() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        invoicesPage.sendPngFileToContainer();
        Thread.sleep(1000);
    }

    @Then("Validate submit invoice button is disabled")
    public void validateSubmitInvoiceButtonIsDisabled() {

        Assert.assertTrue(invoicesPage.validatesubmitFileButtonIsDisabled());
    }

    @And("User try to enter .EXE invoice")
    public void userTryToEnterEXEInvoice() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        invoicesPage.sendExeFileToContainer();
        Thread.sleep(1000);
    }

    @And("User enter eleven invoices")
    public void userEnterElevenInvoices() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.send11FilesToContainer();
        Thread.sleep(1000);
    }

    @Then("Validate the invoice error toast appeared correctly")
    public void validateTheInvoiceErrorToastAppeared() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        Thread.sleep(1000);
        invoicesPage.validateInvoiceErrorToastIsDisplayed();
        System.out.println(invoicesPage.errorToastText(webDriver));
        Assert.assertTrue(invoicesPage.errorToastText(webDriver).contains("You can't upload more than 10 files !"));
    }

    @Then("Check automated Email should not contain the word undefined")
    public void checkUtomatedEmailShouldNotContainTheWordUndefined() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        Thread.sleep(1000);
        System.out.println(invoicesPage.autoEmailText(webDriver));
        Assert.assertFalse(invoicesPage.autoEmailText(webDriver).contains("undefined"));
      //  Assert.assertTrue(invoicesPage.autoEmailText().contains("automated"));
    }

    @Then("Check the dialog should contain description of the upload invoice")
    public void checkTheDialogShouldContainDescriptionOfTheUploadInvoice() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        Thread.sleep(1000);
        Assert.assertTrue(invoicesPage.invoiceDialogText(webDriver).contains("Automate upload via email"));
        Assert.assertTrue(invoicesPage.invoiceDialogText(webDriver).contains("Payments shouldn’t be complicated. To make your life easier we give you a personal upload email address where you can send your invoices. Just forward attached invoices to this email address, and they will be processed automatically."));

    }

    @And("User enter three invoices")
    public void userEnterThreeInvoices() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        Thread.sleep(1000);
        invoicesPage.send3FilesToContainer();
    }

    @And("User delete one invoice from the uploaded")
    public void userDeleteOneInvoiceFromTheUploaded() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        Thread.sleep(1000);
        invoicesPage.deleteFirstUploadedInvoice(webDriver);

    }

    @Then("Validate nums of uploaded invoices are {string}")
    public void validateNumsOfUploadedInvoicesAre(String numOfUploadedInvoice) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        Thread.sleep(1000);
        Assert.assertTrue(invoicesPage.countNumberOfUploadedInvoices(webDriver)==Integer.parseInt(FileReaderManager.getInstance().getConfigFileReader().getProperty(numOfUploadedInvoice)));
    }

    @And("User click on cancel button")
    public void userClickOnCancelButton() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        Thread.sleep(1000);
        invoicesPage.clickOnCancelButton(webDriver);
    }
    @And("Check the nums of items per the invoice page")
    public void checkTheNumsOfItemsPerTheInvoicePage() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        Assert.assertEquals(invoicesPage.itemsPerPageText(webDriver), itemsPerPage);
    }

    @And("Get the nums of items per the invoice page")
    public void getTheNumsOfItemsPerTheInvoicePage() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        itemsPerPage = invoicesPage.itemsPerPageText(webDriver);
    }

    @Then("Validate no invoices with uploading status")
    public void validateNoInvoicesWithUploadingStatus() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        Thread.sleep(2000);
        System.out.println(invoicesPage.invoiceTableText(webDriver));
        Assert.assertFalse(invoicesPage.invoiceTableText(webDriver).contains("Uploading"));
        // Assert.assertTrue(invoicesPage.invoiceTableText().contains("Uploading"));
    }

    @When("Open invoices review tab")
    public void openInvoicesReviewTab()throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        invoicesPage.clickOnReviewInvoicesButton(webDriver);
    }

    @When("Open invoices approval tab")
    public void openInvoicesApprovalTab() throws InterruptedException{
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        invoicesPage.clickOnApprovalInvoicesButton(webDriver);
    }

    @When("Open invoices payment tab")
    public void openInvoicesPaymentTab()throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        invoicesPage.clickOnPaymentInvoicesButton(webDriver);
    }

    @When("Open all invoices tab")
    public void openAllInvoicesTab() throws InterruptedException{
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        invoicesPage.clickOnAllInvoicesButton(webDriver);
    }

    @Given("Upload Invoice {string} with status review in case havnot any")
    public void uploadInvoiceWithStatusReviewInCaseHavnotAny(String invoiceName) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        invoicesPage.validateEveryTableRowReviewStatus(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName));
    }

    @When("Click on reject invoice from Quick Actions")
    public void clickOnRejectInvoiceFromQuickActions() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        Thread.sleep(500);
        invoicesPage.clickOnRejectButtonQuickAction(webDriver);
    }

    @And("Enter the rejection reason {string}")
    public void enterTheRejectionReason(String rejectionReason) throws InterruptedException{
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        invoicesPage.enterRejectionReasonQuickAction(webDriver,FileReaderManager.getInstance().getConfigFileReader().getProperty(rejectionReason));
    }

    @And("Submit reject invoice")
    public void submitRejectInvoice()throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        invoicesPage.clickOnSubmitRejectButtonQuickAction(webDriver);
    }

    @Then("Validate the rejection successful toast appeared correctly")
    public void validateTheRejectionSuccessfulToastAppearedCorrectly() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        invoicesPage.validateRejectionSuccessToastIsDisplayed(webDriver);
        System.out.println(invoicesPage.rejctionSuccessToastText(webDriver));
        Assert.assertTrue(invoicesPage.rejctionSuccessToastText(webDriver).contains("Invoice rejected successfully"));
    }

    @And("Count number of uploaded Review invoice {string}")
    public void countNumberOfUploadedInvoice(String invoiceName) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        numOfUploadedInvoices = invoicesPage.countNumOfUploadedReviewInvoices(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName));
        System.out.println(invoicesPage.countUploadedInvoice);
        System.out.println(invoicesPage.countNumOfUploadedReviewInvoices(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName)));
    }

    @And("Validate the rejection invoice {string} disappeared from All tab")
    public void validateTheRejectionInvoiceDisappearedFromAllTab(String invoiceName) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.waitUntilRejectionSuccessToastIsInvisible(webDriver);
        Thread.sleep(2000);
        if (numOfUploadedInvoices == 0) {
            Assert.assertEquals(invoicesPage.countNumOfUploadedReviewInvoices(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName)), numOfUploadedInvoices);
            System.out.println("No other invoices with the same name");
        } else {
            Assert.assertEquals(invoicesPage.countNumOfUploadedReviewInvoices(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName)), (numOfUploadedInvoices - 1));
            System.out.println("we still have " + invoicesPage.countUploadedInvoice + " Invoices with the same name");
        }
    }

    @And("Validate num of invoices besides the ‘All’ tab & Number in the Footer & Count of rows in the ‘All’ tab & Total count fetched from API should be equal")
    public void validateNumOfInvoicesBesidesTheAllTabNumberInTheFooterCountOfRowsInTheAllTabTotalCountFetchedFromAPIShouldBeEqual() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        System.out.println(invoicesPage.getFooterNum(webDriver));
        System.out.println(invoicesPage.getNumOfInvoicesBesideAllTab(webDriver));
        int countNumOfRestInvoices = invoicesPage.countNumOfRestInvoices(webDriver);
        System.out.println(countNumOfRestInvoices);
        Assert.assertEquals(invoicesPage.getFooterNum(webDriver), invoicesPage.getNumOfInvoicesBesideAllTab(webDriver));
        Assert.assertEquals(invoicesPage.getNumOfInvoicesBesideAllTab(webDriver), "" + countNumOfRestInvoices + "");
        Assert.assertEquals(invoicesPage.countInvoicesByApi, invoicesPage.getFooterNum(webDriver));
    }


    @And("Validate invoice {string} record should appear in the ‘Archive’ page under ‘Rejected’ tab in the First Row")
    public void validateInvoiceRecordShouldAppearInTheArchivePageUnderRejectedTabInTheFirstRow(String invoiceName) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        landingPage.openArchivePage(webDriver);
        invoicesPage.clickRejectedTabButton(webDriver);
        Thread.sleep(3000);
        Assert.assertTrue(invoicesPage.validateRejectedInvoice(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName)));
    }

    @And("Validate number besides the ‘Rejected’ tab = Number in the Footer")
    public void validateNumberBesidesTheRejectedTabNumberInTheFooter() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        System.out.println(invoicesPage.getFooterNum(webDriver));
        System.out.println(invoicesPage.getNumOfInvoicesBesideRejectedTab(webDriver));
        Assert.assertEquals(invoicesPage.getFooterNum(webDriver), invoicesPage.getNumOfInvoicesBesideRejectedTab(webDriver));
    }

    @And("Validate rejection reason {string} is appeared in audit trail")
    public void validateRejectionReasonIsAppearedInAuditTrail(String rejectionReason) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.waitActionButtonIsClickable(webDriver);
        Thread.sleep(1000);
        invoicesPage.showInvoiceDetailsFromScratch(webDriver);
        Thread.sleep(1000);
        invoicesPage.waitUntilAduitTrailButtonAppear(webDriver);
        invoicesPage.clickAuditTrailTab(webDriver);
        invoicesPage.waitUntilRejectionReasonFieldAppear(webDriver);
        Thread.sleep(1000);
        System.out.println(invoicesPage.getRejectionReasonAuditTrail(webDriver));
        Assert.assertTrue(invoicesPage.getRejectionReasonAuditTrail(webDriver).contains(FileReaderManager.getInstance().getConfigFileReader().getProperty(rejectionReason)));
    }


    @And("Count number of uploaded Approval invoice {string}")
    public void countNumberOfUploadedApprovalInvoice(String invoiceName) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        numOfUploadedInvoices= invoicesPage.countNumOfUploadedApprovalInvoices(webDriver,FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName));
        System.out.println(invoicesPage.countUploadedInvoice);
        System.out.println(invoicesPage.countNumOfUploadedApprovalInvoices(webDriver,FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName)));

    }

    @And("Upload Invoice {string} with status approval in case havnot any")
    public void uploadInvoiceWithStatusApprovalInCaseHavnotAny(String invoiceName) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.validateEveryTableRowApprovalStatus(webDriver,FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName));
    }

    @And("Upload Invoice {string} with status payment in case havnot any")
    public void uploadInvoiceWithStatusPaymentInCaseHavnotAny(String invoiceName) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.validateEveryTableRowPaymentStatus(webDriver,FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName));
    }


    @When("Try to reject invoice from Quick Actions")
    public void tryToRejectInvoiceFromQuickActions()throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        try{
            invoicesPage.clickOnRejectButtonQuickAction(webDriver);
        }
        catch (NoSuchElementException e) {
            System.out.println("Can't Reject");
    }
    }

    @Then("Validate reject button is not displayed")
    public void validateRejectButtonIsNotDisplayed()throws InterruptedException{
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        System.out.println(invoicesPage.quickActionListText(webDriver));
        Assert.assertFalse(invoicesPage.quickActionListText(webDriver).contains("Reject"));
    }

    @When("Open invoice details tab")
    public void openInvoiceDetailsTab() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        invoicesPage.clickOnShowInvoice(webDriver);
    }

    @And("Click on reject invoice from Invoice details")
    public void clickOnRejectInvoiceFromInvoiceDetails() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.waitUntilInvoiceDetailsActionButtonAppear(webDriver);
        invoicesPage.clickOnRejectInvoiceButtonInInvoiceDetails();
    }

    @When("Try to reject invoice from Invoice Details")
    public void tryToRejectInvoiceFromInvoiceDetails() throws InterruptedException{
        Thread.sleep(2000);
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.waitUntilInvoiceDetailsActionButtonAppear(webDriver);
        try{
            invoicesPage.clickOnRejectInvoiceButtonInInvoiceDetails();
        }
        catch (NoSuchElementException e) {
            System.out.println("Can't Reject");
        }
    }

    @Then("Validate reject button is not displayed in invoice details")
    public void validateRejectButtonIsNotDisplayedInInvoiceDetails() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        Thread.sleep(500);
        System.out.println(invoicesPage.getRejectAndActionButtonsText(webDriver));
        Assert.assertFalse(invoicesPage.getRejectAndActionButtonsText(webDriver).contains("Reject Invoice"));
    }

    @When("Reject invoice from Invoice Details without reason")
    public void rejectInvoiceFromInvoiceDetailsWithoutReason() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        Thread.sleep(2000);
        invoicesPage.waitUntilInvoiceDetailsActionButtonAppear(webDriver);
        invoicesPage.clickOnRejectInvoiceButtonInInvoiceDetails();

    }

    @Then("Validate rejection reason field become red according to this error")
    public void validateRejectionReasonFieldBecomeRedAccordingToThisError() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        Thread.sleep(1000);
        try{
            Assert.assertTrue(invoicesPage.validateRejectionFieldEmptyErrorIsDisplayed());
        }
        catch (NoSuchElementException e) {
            Assert.assertTrue(false);
        }
    }

    @Given("apii {string} and {string}")
    public void apii(String email, String password) {
        teamsAndMembersPage.loginByUsingResendAPI(FileReaderManager.getInstance().getConfigFileReader().getProperty(email), FileReaderManager.getInstance().getConfigFileReader().getProperty(password));
        invoicesPage.getNumberOfInvoicesByAPI();
        System.out.println(invoicesPage.countInvoicesByApi);
    }

    @Given("Get num of invoices by api using same {string} and {string}")
    public void getNumOfInvoicesByApiUsingSameAnd(String email, String password) {
        email = FileReaderManager.getInstance().getConfigFileReader().getProperty(email);
        password = FileReaderManager.getInstance().getConfigFileReader().getProperty(password);

        if ("registeredEmail".equals(email)) {
            email = signUpPage.getSavedTimeStampEmail();
        }
        if ("newPassword".equals(password)) {
            password = loginPage.getSavedTimeStampPassword();
        }
        if ("oldPassword".equals(password)) {
            password = loginPage.oldPassword;
        }
        teamsAndMembersPage.loginByUsingResendAPI(email, password);
        invoicesPage.getNumberOfInvoicesByAPI();
    }

    @And("Validate the rejection Approval invoice {string} disappeared from All tab")
    public void validateTheRejectionApprovalInvoiceDisappearedFromAllTab(String invoiceName) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        invoicesPage.waitUntilRejectionSuccessToastIsInvisible(webDriver);
        Thread.sleep(2000);
        if (numOfUploadedInvoices == 0) {
            Assert.assertEquals(invoicesPage.countNumOfUploadedApprovalInvoices(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName)), numOfUploadedInvoices);
            System.out.println("No other invoices with the same name");
        } else {
            Assert.assertEquals(invoicesPage.countNumOfUploadedApprovalInvoices(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName)), (numOfUploadedInvoices - 1));
            System.out.println("we still having " + invoicesPage.countUploadedInvoice + " Invoices with the same name");
        }
    }

    @And("Validate the rejection Payment invoice {string} disappeared from All tab")
    public void validateTheRejectionPaymentInvoiceDisappearedFromAllTab(String invoiceName) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.waitUntilRejectionSuccessToastIsInvisible(webDriver);
        Thread.sleep(2000);
        if (numOfUploadedInvoices == 0) {
            Assert.assertEquals(invoicesPage.countNumOfUploadedPaymentInvoices(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName)), numOfUploadedInvoices);
            System.out.println("No other invoices with the same name");
        } else {
            Assert.assertEquals(invoicesPage.countNumOfUploadedPaymentInvoices(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName)), (numOfUploadedInvoices - 1));
            System.out.println("we still having " + invoicesPage.countUploadedInvoice + " Invoices with the same name");
        }
    }

    @When("Click on add or remove pay ASAP flag from Quick Actions")
    public void clickOnAddOrRemovePayASAPFlagFromQuickActions() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        Thread.sleep(700);
        invoicesPage.clickOnPayASAPToAddOrRemove(webDriver);
    }

    @And("Click on confirm add or remove pay ASAP flag")
    public void clickOnConfirmAddOrRemovePayASAPFlag() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        invoicesPage.clickOnConfirmPayASAPToAddOrRemove(webDriver);
        Thread.sleep(1000);
    }

    @Then("Validate the pay ASAP successful toast appeared correctly")
    public void validateThePayASAPSuccessfulToastAppearedCorrectly() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver(); // Added line
        invoicesPage.validatePayAsapSuccessToastIsDisplayed(webDriver);
        System.out.println(invoicesPage.getPayAsapSuccessToastText(webDriver));
        Assert.assertTrue(invoicesPage.getPayAsapSuccessToastText(webDriver).contains("ASAP"));
    }

    @And("Validate Under the ‘Flag’ column related to the the invoice with the name ‘ASAP Invoice‘ there should be ‘Pay ASAP’")
    public void validateUnderTheFlagColumnRelatedToTheInvoiceWithTheNameASAPInvoiceThereShouldBePayASAP() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.waitUntilPayASAPAddOrRemoveSuccessToastIsInvisible(webDriver);
        Thread.sleep(3000);
        Assert.assertTrue(invoicesPage.validatePayAsapFlagIsDisplayed(webDriver));
    }

    @And("Validate first action under ‘Invoice document timeline‘ in audit trail contain ‘the user full name and {string}‘")
    public void validateFirstActionUnderInvoiceDocumentTimelineInAuditTrailContainTheUserFullNameAnd(String flaggedOrRemove) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.clickOnQuickActionButtonForTheRequiedInvoice(webDriver);
        invoicesPage.showInvoiceDetails(webDriver);
        Thread.sleep(1000);
        invoicesPage.waitUntilAduitTrailButtonAppear(webDriver);
        invoicesPage.clickAuditTrailTab(webDriver);
        Thread.sleep(1000);
        invoicesPage.waitUntilSubmitedByFullNameAuditTrailIsVisible(webDriver);
        invoicesPage.waitUntilInvoiceDocumentTimelineFirstActionIsVisible(webDriver);
        System.out.println(invoicesPage.getInvoiceDocumentTimelineFirstActionText(webDriver));
        Assert.assertTrue(invoicesPage.getInvoiceDocumentTimelineFirstActionText(webDriver).contains(FileReaderManager.getInstance().getConfigFileReader().getProperty(flaggedOrRemove)) && invoicesPage.getInvoiceDocumentTimelineFirstActionText(webDriver).contains(invoicesPage.getSubmitedByFullNameAuditTrailText(webDriver)));
    }

    @And("Upload Invoice {string} with status review and with pay ASAP flag in case havnot any")
    public void uploadInvoiceWithStatusReviewAndWithPayASAPFlagInCaseHavnotAny(String invoiceName) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.validateEveryTableRowReviewStatusAndFlagPayASAP(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(invoiceName));
    }

    @And("Validate the pay ASAP flag disappeared Under the ‘Flag’ column related to the the invoice with the name ‘ASAP Invoice‘")
    public void validateThePayASAPFlagDisappearedUnderTheFlagColumnRelatedToTheInvoiceWithTheNameASAPInvoice() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.waitUntilPayASAPAddOrRemoveSuccessToastIsInvisible(webDriver);
        Thread.sleep(2000);
        Assert.assertTrue(invoicesPage.validatePayAsapFlagIsDisappeared(webDriver));
    }

    @And("Add or remove pay ASAP flag from Invoice details")
    public void addOrRemovePayASAPFlagFromInvoiceDetails() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        invoicesPage.waitUntilInvoiceDetailsActionButtonAppear(webDriver);
        Thread.sleep(2000);
        invoicesPage.clickOnInvoiceDetailsActionButton(webDriver);
        Thread.sleep(600);
        invoicesPage.clickOnPayAsapInvoiceDetailsButton(webDriver);
        Thread.sleep(600);
    }

    @Given("Close invoice details tab")
    public void closeInvoiceDetailsTab() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        invoicesPage.waitUntilPayASAPAddOrRemoveSuccessToastIsInvisible(webDriver);
        Thread.sleep(1000);
        invoicesPage.clickOnCloseInvoiceDetailsTabButton(webDriver);
    }

}
