package StepDefinitions;
import Managers.FileReaderManager;
import PageObjects.*;
import Utilities.TestContext;
import Utilities.Wait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class KybSteps {
    TestContext testContext;
    LoginPage loginPage;
    SignUpPage signUpPage;
    VerificationPage verificationPage;
    LandingPage landingPage;
    TeamsAndMembersPage teamsAndMembersPage;

    KYBPage kybPage;
    public KybSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        signUpPage = testContext.getPageObjectManager().getSignUpPage();
        verificationPage = testContext.getPageObjectManager().getVerificationPagePage();
        landingPage = testContext.getPageObjectManager().getLandingPage();
        teamsAndMembersPage = testContext.getPageObjectManager().getTeamsAndMembersPage();
        kybPage = testContext.getPageObjectManager().getKybPage();
    }

    int numOfUBO;
    String uniquePartOfURL;

    @When("User go to Setting Page")
    public void user_go_to_setting_page() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        landingPage.openSettingPage(webDriver);
        Thread.sleep(2000);
    }

    @When("User click on lets go button")
    public void user_click_on_lets_go_button() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(2500);
        kybPage.openVerificationCompanyPage(webDriver);
        Thread.sleep(1000);
    }

    @When("User fill the orgnization information")
    public void user_fill_the_orgnization_information() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.fillOrgInfo(webDriver);
        Thread.sleep(1000);
    }

    @When("User click on open and close tab {string} button")
    public void user_click_on_open_and_close_tab_button(String numOfTab) throws InterruptedException {
        Thread.sleep(2000);
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.openOrCloseTabs(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(numOfTab));
        Thread.sleep(1000);
    }

    @When("User upload the orgnization documents")
    public void user_upload_the_orgnization_documents() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.uploadOrgDocs(webDriver);
        Thread.sleep(1000);
    }

    @When("User fill first shareholder as individual with admin {string}")
    public void user_fill_first_shareholder_as_individual(String email) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.fillTheIndividualShereholderOne(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(email));
        Thread.sleep(2500);
    }

    @When("User Add another member")
    public void user_add_another_member() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(2000);
        kybPage.clickOnAddUser(webDriver);
        Thread.sleep(1000);
    }

    @When("User fill shareholder as company {string}")
    public void user_fill_sec_shareholder_as_company(String email) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.fillTheCompanyShereholder(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(email));
        Thread.sleep(2000);
    }

    @And("User fill first signature with admin {string}")
    public void userFillFirstSignatureWithAdmin(String email) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.fillTheSignatureOne(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(email));
        Thread.sleep(2500);
    }

    @And("User fill second signature with admin {string}")
    public void userFillSecondSignatureWithAdmin(String email) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.fillTheSignatureTwo(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(email));
    }

    @And("User fill first director with admin {string}")
    public void userFillFirstDirectorWithAdmin(String email) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.fillTheDirectorOne(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(email));
        Thread.sleep(2500);
    }

    @And("User fill second director with admin {string}")
    public void userFillSecondDirectorWithAdmin(String email) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.fillTheDirectorTwo(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(email));
    }

    @And("User fill politically exposed persons")
    public void userFillPoliticallyExposedPersons() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(2500);
        kybPage.fillPoliticallyExposedPersons(webDriver);
    }

    @And("User agree on KYB Pemo policy")
    public void userAgreeOnKYBPemoPolicy() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(2000);
        kybPage.clickOnpolicyAgreementCheckbox(webDriver);
    }

    @And("User submit KYB form")
    public void userSubmitKYBForm() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        //kybPage.submitKybForm(webDriver);
        Thread.sleep(2000);
        kybPage.submitKybForm(webDriver);
        Thread.sleep(1000);
    }

    @Then("Validate successful message appeared")
    public void validateSuccessfulMessageAppeared() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(5000);
        Assert.assertTrue(kybPage.getSuccessfulMessage(webDriver).contains("Thank you"),"KYB form not submit pls check");
    }

    @And("Validate error messages for mandatory fields")
    public void validateErrorMessagesForMandatoryFields() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(500);
        Assert.assertTrue(kybPage.getEmployeeNumbersListErrorMessage(webDriver).contains("This field is mandatory, please select from a list"),"Error message script is wrong");
        System.out.println(kybPage.getEmployeeNumbersListErrorMessage(webDriver));
        Assert.assertTrue(kybPage.getCompanyWebsiteErrorMessage(webDriver).contains("This field is mandatory, please enter a valid input"),"Error message script is wrong");
        System.out.println(kybPage.getCompanyWebsiteErrorMessage(webDriver));
        Assert.assertTrue(kybPage.getApproximateAnnualErrorMessage(webDriver).contains("This field is mandatory, please enter a valid input"),"Error message script is wrong");
        System.out.println(kybPage.getApproximateAnnualErrorMessage(webDriver));
        Assert.assertTrue(kybPage.getTradeLicenseFileErrorMessage(webDriver).contains("This field is mandatory, please upload a valid file"),"Error message script is wrong");
        System.out.println(kybPage.getTradeLicenseFileErrorMessage(webDriver));
        Assert.assertTrue(kybPage.getMemorandumFileErrorMessage(webDriver).contains("This field is mandatory, please upload a valid file"),"Error message script is wrong");
        System.out.println(kybPage.getMemorandumFileErrorMessage(webDriver));
    }

    @When("User open back office website")
    public void userOpenBackOfficeWebsite() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        webDriver.get(FileReaderManager.getInstance().getConfigFileReader().getProperty("backOfficeUrl"));
        Thread.sleep(1000);
    }

    @When("User search for organization by domain name")
    public void userSearchForOrganizationByDomainName() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(2000);
        kybPage.searchWithDomainName(webDriver);
        Thread.sleep(1500);
    }

    @And("Get Domain Name")
    public void getDomainName() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(5000);
        kybPage.getBussinessLegalName(webDriver);
        System.out.println(kybPage.getBussinessLegalName(webDriver));
    }

    @Then("Validate organization has vendor user id")
    public void validateOrganizationHasVendorUserId() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        System.out.println(kybPage.getVendorUserId(webDriver));
        Assert.assertFalse(kybPage.getVendorUserId(webDriver).contains("--"),"Vendor User Id is empty");
    }

    @And("Validate status of organization")
    public void validateStatusOfOrganization() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        System.out.println(kybPage.getStatusText(webDriver));
        Assert.assertTrue(kybPage.getStatusText(webDriver).contains("Under pemo review"),"Wrong Status");
    }

    @When("User open the organization on back office")
    public void userOpenTheOrganizationOnBackOffice() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.openOrganisationPage(webDriver);
        Thread.sleep(10000);
    }

    @And("The orgnization information stored")
    public void theOrganizationInformationStored() throws InterruptedException {
        kybPage.getOrgInfo();
    }

    @Then("The shareholder information stored")
    public void theShareholderInformationStored() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.getShareholderInfo();

        kybPage.waitUntilDocument14IsAppeared(webDriver);
        kybPage.shSource = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument12());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument12()));

        kybPage.shPassport = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument13());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument13()));

        kybPage.shId = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument14());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument14()));
    }

    @Then("The signature information stored")
    public void theSignatureInformationStored() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.getSignatureInfo();

        kybPage.waitUntilDocument17IsAppeared(webDriver);
        kybPage.sgSource = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument15());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument15()));

        kybPage.sgPassport = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument16());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument16()));

        kybPage.sgId = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument17());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument17()));
    }

    @Then("The director information stored")
    public void theDirectorInformationStored() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.getDirectorInfo();

        kybPage.waitUntilDocument11IsAppeared(webDriver);
        kybPage.dirSource = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument9());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument9()));

        kybPage.dirPassport = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument10());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument10()));

        kybPage.dirId = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument11());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument11()));
    }

    @Then("The politically exposed stored")
    public void thePoliticallyExposedStored() throws InterruptedException {
        kybPage.getPoliticallyExposed();
    }

    @Then("Validate the organization info sent correctly")
    public void validateTheOrganizationInfoSentCorrectly() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        System.out.println("BO: " + kybPage.getNumOfEmpsBO(webDriver) + " Pemo form: " + kybPage.numOfEmps);
        Assert.assertTrue(kybPage.numOfEmps.contains(kybPage.getNumOfEmpsBO(webDriver)));

        Assert.assertEquals(kybPage.getAnnualBO(webDriver), kybPage.annual);
        System.out.println("BO: " + kybPage.getAnnualBO(webDriver) + " Pemo form: " + kybPage.annual);

        Assert.assertEquals(kybPage.getTaxBO(webDriver), kybPage.tax);
        System.out.println("BO: " + kybPage.getTaxBO(webDriver) + " Pemo form: " + kybPage.tax);

        Assert.assertEquals(kybPage.getRegulatorNameBO(webDriver), kybPage.regulatorName);
        System.out.println("BO: " + kybPage.getRegulatorNameBO(webDriver) + " Pemo form: " + kybPage.regulatorName);

        Assert.assertEquals(kybPage.getCompanyNameBO(webDriver), kybPage.companyName);
        System.out.println("BO: " + kybPage.getCompanyNameBO(webDriver) + " Pemo form: " + kybPage.companyName);
    }

    @And("Validate shareholder sent correctly")
    public void validateShareholderSentCorrectly() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertEquals(kybPage.getShFNBackOffice(webDriver), kybPage.shFN);
        System.out.println("BO: " + kybPage.getShFNBackOffice(webDriver) + " Pemo form: " + kybPage.shFN);

        Assert.assertEquals(kybPage.getShLNBackOffice(webDriver), kybPage.shLN);
        System.out.println("BO: " + kybPage.getShLNBackOffice(webDriver) + " Pemo form: " + kybPage.shLN);

        Assert.assertEquals(kybPage.getShPhBackOffice(webDriver), kybPage.shPh);
        System.out.println("BO: " + kybPage.getShPhBackOffice(webDriver) + " Pemo form: " + kybPage.shPh);

        Assert.assertEquals(kybPage.getShMobBackOffice(webDriver), kybPage.shMob);
        System.out.println("BO: " + kybPage.getShMobBackOffice(webDriver) + " Pemo form: " + kybPage.shMob);

        Assert.assertEquals(kybPage.getShEBackOffice(webDriver), kybPage.shE);
        System.out.println("BO: " + kybPage.getShEBackOffice(webDriver) + " Pemo form: " + kybPage.shE);

        Assert.assertEquals(kybPage.getShAddBackOffice(webDriver), kybPage.shAdd);
        System.out.println("BO: " + kybPage.getShAddBackOffice(webDriver) + " Pemo form: " + kybPage.shAdd);

        System.out.println(kybPage.shSource);
        Assert.assertTrue(kybPage.getUrlOfDocument12().contains(kybPage.shSource));

        System.out.println(kybPage.shPassport);
        Assert.assertTrue(kybPage.getUrlOfDocument13().contains(kybPage.shPassport));

        System.out.println(kybPage.shId);
        Assert.assertTrue(kybPage.getUrlOfDocument14().contains(kybPage.shId));
    }

    @And("Validate signatures sent correctly")
    public void validateSignaturesSentCorrectly() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertEquals(kybPage.getSg1FNBackOffice(webDriver), kybPage.sg1FN);
        System.out.println("BO: " + kybPage.getSg1FNBackOffice(webDriver) + " Pemo form: " + kybPage.sg1FN);

        Assert.assertEquals(kybPage.getSg1LNBackOffice(webDriver), kybPage.sg1LN);
        System.out.println("BO: " + kybPage.getSg1LNBackOffice(webDriver) + " Pemo form: " + kybPage.sg1LN);

        Assert.assertEquals(kybPage.getSg1PhBackOffice(webDriver), kybPage.sg1Ph);
        System.out.println("BO: " + kybPage.getSg1PhBackOffice(webDriver) + " Pemo form: " + kybPage.sg1Ph);

        Assert.assertEquals(kybPage.getSg1MobBackOffice(webDriver), kybPage.sg1Mob);
        System.out.println("BO: " + kybPage.getSg1MobBackOffice(webDriver) + " Pemo form: " + kybPage.sg1Mob);

        Assert.assertEquals(kybPage.getSg1EBackOffice(webDriver), kybPage.sg1E);
        System.out.println("BO: " + kybPage.getSg1EBackOffice(webDriver) + " Pemo form: " + kybPage.sg1E);

        Assert.assertEquals(kybPage.getSg1AddBackOffice(webDriver), kybPage.sg1Add);
        System.out.println("BO: " + kybPage.getSg1AddBackOffice(webDriver) + " Pemo form: " + kybPage.sg1Add);

        System.out.println(kybPage.sgSource);
        Assert.assertTrue(kybPage.getUrlOfDocument15().contains(kybPage.sgSource));

        System.out.println(kybPage.sgPassport);
        Assert.assertTrue(kybPage.getUrlOfDocument16().contains(kybPage.sgPassport));

        System.out.println(kybPage.sgId);
        Assert.assertTrue(kybPage.getUrlOfDocument17().contains(kybPage.sgId));
    }

    @And("Validate directors sent correctly")
    public void validateDirectorsSentCorrectly() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertEquals(kybPage.getDir1FNBackOffice(webDriver), kybPage.dir1FN);
        System.out.println("BO: " + kybPage.getDir1FNBackOffice(webDriver) + " Pemo form: " + kybPage.dir1FN);

        Assert.assertEquals(kybPage.getDir1LNBackOffice(webDriver), kybPage.dir1LN);
        System.out.println("BO: " + kybPage.getDir1LNBackOffice(webDriver) + " Pemo form: " + kybPage.dir1LN);

        Assert.assertEquals(kybPage.getDir1PhBackOffice(webDriver), kybPage.dir1Ph);
        System.out.println("BO: " + kybPage.getDir1PhBackOffice(webDriver) + " Pemo form: " + kybPage.dir1Ph);

        Assert.assertEquals(kybPage.getDir1MobBackOffice(webDriver), kybPage.dir1Mob);
        System.out.println("BO: " + kybPage.getDir1MobBackOffice(webDriver) + " Pemo form: " + kybPage.dir1Mob);

        Assert.assertEquals(kybPage.getDir1EBackOffice(webDriver), kybPage.dir1E);
        System.out.println("BO: " + kybPage.getDir1EBackOffice(webDriver) + " Pemo form: " + kybPage.dir1E);

        Assert.assertEquals(kybPage.getDir1AddBackOffice(webDriver), kybPage.dir1Add);
        System.out.println("BO: " + kybPage.getDir1AddBackOffice(webDriver) + " Pemo form: " + kybPage.dir1Add);

        System.out.println(kybPage.dirSource);
        Assert.assertTrue(kybPage.getUrlOfDocument9().contains(kybPage.dirSource));

        System.out.println(kybPage.dirPassport);
        Assert.assertTrue(kybPage.getUrlOfDocument10().contains(kybPage.dirPassport));

        System.out.println(kybPage.dirId);
        Assert.assertTrue(kybPage.getUrlOfDocument11().contains(kybPage.dirId));
    }

    @And("Validate politically exposed persons sent correctly")
    public void validatePoliticallyExposedPersonsSentCorrectly() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertEquals(kybPage.getPrimaryPersonNameBO(webDriver), kybPage.primaryPersonName);
        System.out.println("BO: " + kybPage.getPrimaryPersonNameBO(webDriver) + " Pemo form: " + kybPage.primaryPersonName);

        Assert.assertEquals(kybPage.getSecondaryPersonNameBO(webDriver), kybPage.secondaryPersonName);
        System.out.println("BO: " + kybPage.getSecondaryPersonNameBO(webDriver) + " Pemo form: " + kybPage.secondaryPersonName);
    }

    @And("User decline the form")
    public void userDeclineTheForm() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.userDeclineKybForm(webDriver);
        Thread.sleep(1000);
        kybPage.userClickOnConfirmButton(webDriver);
        Thread.sleep(1500);
    }

    @Then("Validate the organization status is declined")
    public void validateTheOrganizationStatusIsDeclined() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(2000);
        System.out.println(kybPage.getStatusOfOrgBO(webDriver));
        Assert.assertTrue(kybPage.getStatusOfOrgBO(webDriver).toLowerCase().contains("decline"), "Wrong Org status");
    }

    @Then("The company information stored")
    public void theCompanyInformationStored() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.getCompanyInfo();

        kybPage.waitUntilDocument8IsAppeared(webDriver);
        kybPage.comTrade = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument4());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument4()));

        kybPage.comMemo = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument5());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument5()));

        kybPage.comIncorporation = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument6());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument6()));

        kybPage.comIncumbency = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument7());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument7()));

        kybPage.comBank = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument8());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument8()));
    }

    @And("User fill shared user {string}")
    public void userFillSharedUser(String email) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.fillTheSharedUser(webDriver,FileReaderManager.getInstance().getConfigFileReader().getProperty(email));
        Thread.sleep(2500);
    }

    @Then("The shared user information stored")
    public void theSharedUserInformationStored() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.getSharedUserInfo();

        kybPage.waitUntilDocument3IsAppeared(webDriver);
        kybPage.sharedSource = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument1());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument1()));

        kybPage.sharedPassport = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument2());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument2()));

        kybPage.sharedId = kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument3());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument3()));
    }

    @Then("Validate page donot contain KYB form button")
    public void validatePageDoesNotContainKYBFormButton() throws InterruptedException {
        System.out.println(kybPage.getSettingPageContainer());
        Assert.assertFalse(kybPage.getSettingPageContainer().contains("Your company needs to be verified before you can issue corporate cards"));
    }

    @And("Validate Page contains Bank Accounts for Invoices")
    public void validatePageContainsBankAccountsForInvoices() throws InterruptedException {
        System.out.println(kybPage.getSettingPageContainer());
        Assert.assertTrue(kybPage.getSettingPageContainer().contains("Bank Accounts for Invoices"));
        Assert.assertTrue(kybPage.getSettingPageContainer().contains("Add account"));
    }

    @And("User check on all individual types")
    public void userCheckOnAllIndividualTypes() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(5500);
        kybPage.clickOnAllCheckboxes(webDriver);
        kybPage.getTextOfCheckedBox1(webDriver);
    }

    @And("User check signature individual type")
    public void userCheckSignatureIndividualType() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(500);
        kybPage.chooseIndividualTypeNum5();
        kybPage.waitUntilAddUserTabIsClosed();
        Thread.sleep(8000);
        kybPage.clickOnSignature4ChecboxButton();
        kybPage.waitUntilLoadingIsFinish();
    }

    @And("User check shareholder individual type")
    public void userCheckShareholderIndividualType() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(500);
        kybPage.chooseIndividualTypeNum4();
        kybPage.waitUntilAddUserTabIsClosed();
        Thread.sleep(8000);
        kybPage.clickOnShareholder3ChecboxButton();
        kybPage.waitUntilLoadingIsFinish();
    }

    @And("User check director individual type")
    public void userCheckDirectorIndividualType() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(1000);
        kybPage.chooseIndividualTypeNum3();
        kybPage.waitUntilAddUserTabIsClosed();
        Thread.sleep(8000);
        kybPage.clickOnDirector2ChecboxButton();
        kybPage.waitUntilLoadingIsFinish();
    }

    @And("User check on company")
    public void userCheckOnCompany() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(500);
        kybPage.chooseCompanyType();
        kybPage.waitUntilAddUserTabIsClosed();
        Thread.sleep(6000);
    }

    @And("User get the number of company UBO")
    public void userGetTheNumberOfCompanyUBO() throws InterruptedException {
        Thread.sleep(500);
        numOfUBO = kybPage.numOfCompanyUBO();
        System.out.println(kybPage.numOfCompanyUBO());
    }

    @And("User delete a signature UBO")
    public void userDeleteASignatureUBO() throws InterruptedException {
        kybPage.removeCompanyUBO5();
        Thread.sleep(1000);
    }

    @Then("Validate the UBO is removed")
    public void validateTheUBOIsRemoved() throws InterruptedException {
        Thread.sleep(1000);
        int numOfUBOUpdated = numOfUBO - 1;
        System.out.println(kybPage.numOfCompanyUBO());
        Assert.assertEquals(kybPage.numOfCompanyUBO(), numOfUBOUpdated);
    }

    @And("Validate the position of the rest of UBOs")
    public void validateThePositionOfTheRestOfUBOs() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertTrue(kybPage.getTextOfCheckedBox1(webDriver).contains("Director"));
        Assert.assertTrue(kybPage.getTextOfCheckedBox2(webDriver).contains("Shareholder"));
        Assert.assertTrue(kybPage.getTextOfCheckedBox3(webDriver).contains("Signatures"));
        Assert.assertTrue(kybPage.getTextOfCheckedBox4(webDriver).contains("Director"));
        Assert.assertTrue(kybPage.getTextOfCheckedBox5(webDriver).contains("Shareholder"));
    }

    @And("Remove shareholder and director UBOs to can run the scenario again")
    public void removeShareholderAndDirectorUBOsToCanRunTheScenarioAgain() throws InterruptedException {
        kybPage.removeCompanyUBO4();
        Thread.sleep(1500);
        kybPage.removeCompanyUBO3();
    }

    @And("User upload the Trade License for orgnization documents")
    public void userUploadTheTradeLicenseForOrganizationDocuments() throws InterruptedException {
        kybPage.uploadTradeLicense();
        Thread.sleep(3000);
    }

    @And("User view the uploaded document")
    public void userViewTheUploadedDocument() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.openTheUploadedDocument1();
    }

    @And("User get the URL of the uploaded document")
    public void userGetTheURLOfTheUploadedDocument() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(1000);
        System.out.println(kybPage.getUrlOfDocument1());
        uniquePartOfURL= kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument1());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument1()));
    }

    @Then("Validate the URL format in {string}")
    public void validateTheURLFormat(String env) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        System.out.println(kybPage.getUrlOfDocument1());
        Assert.assertTrue(kybPage.getUrlOfDocument1().contains("https://api-media."+FileReaderManager.getInstance().getConfigFileReader().getProperty(env)+".pemo.io/"));
    }

    @And("Validate the uploaded document opened successfully")
    public void validateTheUploadedDocumentOpenedSuccessfully() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.openNextTab(webDriver);
        Thread.sleep(1000);
        String documentURL = webDriver.getCurrentUrl();
        Assert.assertTrue(documentURL.contains(uniquePartOfURL));
        Thread.sleep(500);
        kybPage.openOrginalTab(webDriver);
    }

    @And("remove the document to can re-run the test")
    public void removeTheDocumentToCanReRunTheTest() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.remove1Document();
    }

    @And("User upload the Trade License .PNG for orgnization documents")
    public void userUploadTheTradeLicensePNGForOrganizationDocuments() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.uploadTradeLicensePNG();
        Thread.sleep(1000);
    }

    @And("User upload the Bank Statement .JPG for orgnization documents")
    public void userUploadTheBankStatementJPGForOrganizationDocuments() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.uploadRecentBankStatementJPG();
        Thread.sleep(1000);
    }

    @And("User try to upload .CSV file in the Trade License for orgnization documents")
    public void userTryToUploadCSVFileInTheTradeLicenseForOrganizationDocuments() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.uploadTradeLicenseCSV();
    }

    @Then("Validate .CSV Can not upload to KYB form")
    public void validateCSVCanNotUploadToKYBForm() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(5000);
        Assert.assertTrue(kybPage.browseFileContainerText().contains("Browse files"));
    }

    @And("User change Director type from Individual to Company")
    public void userChangeShareholderTypeFromIndividualToCompany() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(500);
        kybPage.chooseIndividualTypeNum1();
        kybPage.waitUntilAddUserTabIsClosed();
        Thread.sleep(6000);
        kybPage.chooseCompany1Type();
        kybPage.waitUntilAddUserTabIsClosed();
        Thread.sleep(4000);
    }

    @Then("Validate fields of company are appeared")
    public void validateFieldsOfCompanyAreAppeared() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertTrue(kybPage.ValidateFieldsOfCompanyAreAppeared());
    }

    @Then("Validate “Company verification has been declined“ button appeared successfully")
    public void validateCompanyVerificationHasBeenDeclinedButtonAppearedSuccessfully() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(1000);
        Assert.assertTrue(landingPage.dashboardCompanyKybVerifyText(webDriver).contains("Company verification has been declined"));
    }

    @Then("Validate In the KYB box this text “Company Verification is declined” is appeared")
    public void validateInTheKYBBoxThisTextCompanyVerificationIsDeclinedIsAppeared() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(kybPage.getSettingPageContainer().contains("Company Verification is declined"));
    }

    @And("Validate KYB Button is disabled")
    public void validateKYBButtonIsDisabled() throws InterruptedException {
        Assert.assertTrue(kybPage.validateViewFormButtonIsDisabled());
    }

    @And("User enter director adress {string}")
    public void userEnterDirectorAddress(String add) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.enterAddressForDirectorForBackofficeTests(webDriver,FileReaderManager.getInstance().getConfigFileReader().getProperty(add));
        Thread.sleep(1500);
    }

    @And("Click on Approve entry for address")
    public void clickOnApproveEntryForAddress() throws InterruptedException {
        Thread.sleep(3000);
        kybPage.clickOnBackOfficeAddressUBO3ApproveButton();
        Thread.sleep(2000);
    }

    @Then("Validate Toast message appeared successfully {string}")
    public void validateToastMessageAppearedSuccessfully(String toastMessage) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.validateToastMessageIsDisplayed(webDriver);
        System.out.println(kybPage.getToastMessageText());
        Assert.assertTrue(kybPage.getToastMessageText().contains(FileReaderManager.getInstance().getConfigFileReader().getProperty(toastMessage)));
        Thread.sleep(1500);
    }

    @Then("Remove director UBO to can run the scenario again")
    public void removeDirectorUBOToCanRunTheScenarioAgain() throws InterruptedException {
        kybPage.removeCompanyUBO3();
        Thread.sleep(1000);
    }

    @And("Click on Reject entry for address")
    public void clickOnRejectEntryForAddress() throws InterruptedException {
        Thread.sleep(3000);
        kybPage.clickOnBackOfficeAddressUBO3RejectButton();
        Thread.sleep(2000);
    }

    @And("Enter the rejection reason")
    public void enterTheRejectionReason() throws InterruptedException {
        Thread.sleep(1000);
        kybPage.enterRejectionReasonForEntry("The entered residential address is fake");
        kybPage.clickOnBackOfficeConfirmButton();
        Thread.sleep(4000);
    }

    @And("Change KYB status to user action needed")
    public void changeKYBStatusToUserActionNeeded() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.clickOnUserActionButtonBackOffice();
        Thread.sleep(500);
        kybPage.userClickOnConfirmButton(webDriver);
        kybPage.waitUntilAddUserTabIsClosed();
    }

    @Then("Validate the organization status is User action required")
    public void validateTheOrganizationStatusIsUserActionRequired() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(2000);
        System.out.println(kybPage.getStatusOfOrgBO(webDriver));
        Assert.assertTrue(kybPage.getStatusOfOrgBO(webDriver).contains("User action required"), "Wrong Org status");
        Thread.sleep(500);
    }

    @And("Validate rejection reason appeared under the rejected field in back office")
    public void validateRejectionReasonAppearedUnderTheRejectedFieldInBackOffice() throws InterruptedException {
        System.out.println(kybPage.getBackOfficeAddressErrorMessageText());
        Assert.assertTrue(kybPage.getBackOfficeAddressErrorMessageText().contains("The entered residential address is fake"));
    }

    @And("Validate rejection reason appeared under the rejected field in pemo")
    public void validateRejectionReasonAppearedUnderTheRejectedFieldInPemo() throws InterruptedException {
        System.out.println(kybPage.getPemoAddressErrorMessageText());
        Assert.assertTrue(kybPage.getPemoAddressErrorMessageText().contains("The entered residential address is fake"));
    }

    @Then("Validate In the KYB box this text “One more thing!” is appeared")
    public void validateInTheKYBBoxThisTextOneMoreThingIsAppeared() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(kybPage.getSettingPageContainer().contains("One more thing!"));
    }

    @And("User check on all shareholder types")
    public void userCheckOnAllShareholderTypes() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(1000);
        kybPage.chooseIndividualTypeNum1();
        kybPage.waitUntilAddUserTabIsClosed();
        Thread.sleep(5000);
        kybPage.clickOnAllCheckboxes(webDriver);
        kybPage.getTextOfCheckedBox1(webDriver);
    }

    @And("User Add another member in back office")
    public void userAddAnotherMemberInBackOffice() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(1500);
        kybPage.clickOnAddUserBackOffice();
        Thread.sleep(1500);
        kybPage.userClickOnConfirmButton(webDriver);
        kybPage.waitUntilAddUserTabIsClosed();
    }

    @And("User check on all shareholder types in Back office")
    public void userCheckOnAllShareholderTypesInBackOffice() throws InterruptedException {
        Thread.sleep(5000);
        kybPage.clickOnAllCheckboxesBackOffice();
    }

    @And("User sync the new users")
    public void userSyncTheNewUsers() throws InterruptedException {
        kybPage.syncNewUsers();
        kybPage.waitUntilAddUserTabIsClosed();
    }

    @When("User Update User Info")
    public void userUpdateUserInfo() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(3000);
        kybPage.updateUserInfo();
        kybPage.waitUntilAddUserTabIsClosed();
    }

    @And("Remove user to can run the scenario again")
    public void removeUserToCanRunTheScenarioAgain() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.removeUserBackOffice();
    }

    @And("User Add new item")
    public void userAddNewItem() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.addItemInBackOffice();
        kybPage.addItemDetailsInBackOffice();
        kybPage.confirmAddItem();
        Thread.sleep(3000);
    }

    @Then("Validate Item is added successfully")
    public void validateItemIsAddedSuccessfully() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        System.out.println(kybPage.itemName);
        System.out.println(kybPage.getCompanyUBO1ContanierText());
        Assert.assertTrue(kybPage.getCompanyUBO1ContanierText().contains(kybPage.itemName));
    }

    @And("User upload the Trade License for orgnization documents in Back office")
    public void userUploadTheTradeLicenseForOrganizationDocumentsInBackOffice() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(1000);
        kybPage.uploadTradeLicenseBackOffice();
        Thread.sleep(5000);
    }

    @And("Validate Three buttons should appear which they are: Upload file ,Send to NymCard and View file buttons")
    public void validateThreeButtonsShouldAppearWhichTheyAreUploadFileSendToNymCardAndViewFileButtons() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertTrue(kybPage.ValidateThreeButtonForTradeFileInBackOfficeAreAppeared());
    }

    @And("User send document to nym card")
    public void userSendDocumentToNymCard() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(2000);
        kybPage.clickOnSendToNymCard1();
    }

    @Then("Validate New UBO is added successfully")
    public void validateNewUBOIsAddedSuccessfully() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(1000);
        int numOfUBOUpdated = numOfUBO+1;
        System.out.println(kybPage.numOfCompanyUBO());
        Assert.assertEquals(kybPage.numOfCompanyUBO(),numOfUBOUpdated);
    }

    @And("Validate sharedUser sent correctly")
    public void validateSharedUserSentCorrectly() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertEquals(kybPage.getSharedFNBackOffice(webDriver), kybPage.shared1FN);
        System.out.println("BO: " + kybPage.getSharedFNBackOffice(webDriver) + " Pemo form: " + kybPage.shared1FN);

        Assert.assertEquals(kybPage.getSharedLNBackOffice(webDriver), kybPage.shared1LN);
        System.out.println("BO: " + kybPage.getSharedLNBackOffice(webDriver) + " Pemo form: " + kybPage.shared1LN);

        Assert.assertEquals(kybPage.getSharedPhBackOffice(webDriver), kybPage.shared1Ph);
        System.out.println("BO: " + kybPage.getSharedPhBackOffice(webDriver) + " Pemo form: " + kybPage.shared1Ph);

        Assert.assertEquals(kybPage.getSharedMobBackOffice(webDriver), kybPage.shared1Mob);
        System.out.println("BO: " + kybPage.getSharedMobBackOffice(webDriver) + " Pemo form: " + kybPage.shared1Mob);

        Assert.assertEquals(kybPage.getSharedEBackOffice(webDriver), kybPage.shared1E);
        System.out.println("BO: " + kybPage.getSharedEBackOffice(webDriver) + " Pemo form: " + kybPage.shared1E);

        Assert.assertEquals(kybPage.getSharedAddBackOffice(webDriver), kybPage.shared1Add);
        System.out.println("BO: " + kybPage.getSharedAddBackOffice(webDriver) + " Pemo form: " + kybPage.shared1Add);

        System.out.println(kybPage.sharedSource);
        Assert.assertTrue(kybPage.getUrlOfDocument1().contains(kybPage.sharedSource));

        System.out.println(kybPage.sharedPassport);
        Assert.assertTrue(kybPage.getUrlOfDocument2().contains(kybPage.sharedPassport));

        System.out.println(kybPage.sharedId);
        Assert.assertTrue(kybPage.getUrlOfDocument3().contains(kybPage.sharedId));
    }

    @And("Remove the last three UBOs to can run the scenario again")
    public void removeTheLastThreeUBOsToCanRunTheScenarioAgain() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(1000);
        kybPage.removeCompanyUBO5();
        kybPage.waitUntilLoadingIsFinish();
        kybPage.removeCompanyUBO4();
        kybPage.waitUntilLoadingIsFinish();
        kybPage.removeCompanyUBO3();
        kybPage.waitUntilLoadingIsFinish();
    }

    @And("Remove director UBO in back office to can run the scenario again")
    public void removeDirectorUBOInBackOfficeToCanRunTheScenarioAgain() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.removeCompanyUBOInBackOffice3();
        Thread.sleep(1000);
    }

    @And("Validate companyUBO sent correctly")
    public void validateCompanyUBOSentCorrectly() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertEquals(kybPage.getComPhBackOffice(webDriver), kybPage.com1Ph);
        System.out.println("BO: " + kybPage.getComPhBackOffice(webDriver) + " Pemo form: " + kybPage.com1Ph);

        Assert.assertEquals(kybPage.getComEBackOffice(webDriver), kybPage.com1E);
        System.out.println("BO: " + kybPage.getComEBackOffice(webDriver) + " Pemo form: " + kybPage.com1E);

        Assert.assertEquals(kybPage.getComAddBackOffice(webDriver), kybPage.com1Add);
        System.out.println("BO: " + kybPage.getComAddBackOffice(webDriver) + " Pemo form: " + kybPage.com1Add);

        System.out.println(kybPage.comTrade);
        Assert.assertTrue(kybPage.getUrlOfDocument4().contains(kybPage.comTrade));

        System.out.println(kybPage.comMemo);
        Assert.assertTrue(kybPage.getUrlOfDocument5().contains(kybPage.comMemo));

        System.out.println(kybPage.comIncorporation);
        Assert.assertTrue(kybPage.getUrlOfDocument6().contains(kybPage.comIncorporation));

        System.out.println(kybPage.comIncumbency);
        Assert.assertTrue(kybPage.getUrlOfDocument7().contains(kybPage.comIncumbency));

        System.out.println(kybPage.comBank);
        Assert.assertTrue(kybPage.getUrlOfDocument8().contains(kybPage.comBank));
    }

    @Then("The orgnization documents stored")
    public void theOrganizationDocumentsStored() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        kybPage.waitUntilDocument4IsAppeared(webDriver);
        kybPage.orgTrade=kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument1());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument1()));

        kybPage.orgMemo=kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument2());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument2()));

        kybPage.orgBank=kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument3());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument3()));

        kybPage.orgSupport=kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument4());
        System.out.println(kybPage.extractUrlUntilPdf(kybPage.getUrlOfDocument4()));
    }

    @Then("Validate the organization documents sent correctly")
    public void validateTheOrganizationDocumentsSentCorrectly() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        System.out.println(kybPage.orgTrade);
        Assert.assertTrue(kybPage.getUrlOfDocument1().contains(kybPage.orgTrade));

        System.out.println(kybPage.orgMemo);
        Assert.assertTrue(kybPage.getUrlOfDocument2().contains(kybPage.orgMemo));

        System.out.println(kybPage.orgBank);
        Assert.assertTrue(kybPage.getUrlOfDocument3().contains(kybPage.orgBank));

        System.out.println(kybPage.orgSupport);
        Assert.assertTrue(kybPage.getUrlOfDocument4().contains(kybPage.orgSupport));
    }

    @And("Validate no director user is added before")
    public void validateNoDirectorUserIsAddedBefore() throws InterruptedException {
        kybPage.validateNoDirectorUserIsAddedBefore();
    }
}