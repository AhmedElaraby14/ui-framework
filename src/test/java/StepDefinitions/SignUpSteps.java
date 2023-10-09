package StepDefinitions;
import Managers.FileReaderManager;
import PageObjects.*;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpSteps {
    TestContext testContext;
    LoginPage loginPage;
    SignUpPage signUpPage;
    VerificationPage verificationPage;
    KYBPage kybPage;
    LandingPage landingPage;
    public SignUpSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        signUpPage = testContext.getPageObjectManager().getSignUpPage();
        verificationPage = testContext.getPageObjectManager().getVerificationPagePage();
        landingPage = testContext.getPageObjectManager().getLandingPage();
        kybPage = testContext.getPageObjectManager().getKybPage();


    }


    @Given("Go to Sign-Up page")
    public void goToSignUpPage() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        loginPage.openSignUpPage(webDriver);
        Thread.sleep(2000);
    }

    @And("Validate Sign-Up page is displayed")
    public void validateSignUpPageIsDisplayed() {
        Assert.assertTrue(signUpPage.signUpPageIsDisplayed());
        String actualLoginHeaderTitle = testContext.getDriverManager().getDriver().getTitle();
        Assert.assertEquals(actualLoginHeaderTitle,"Pemo | Sign-Up","Wrong Text for Title Page");
    }


    @When("User enter valid information email, {string}, {string} and {string}")
    public void userEnterValidInformationAnd( String firstName, String lastName, String password)throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        signUpPage.fillUserInformationData(webDriver,signUpPage.getTimestampEmail(),FileReaderManager.getInstance().getConfigFileReader().getProperty(firstName),FileReaderManager.getInstance().getConfigFileReader().getProperty(lastName),FileReaderManager.getInstance().getConfigFileReader().getProperty(password));
    }
    @And("User submit these data")
    public void userSubmitTheseData() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        signUpPage.clickContinueButton(webDriver);
       // Thread.sleep(3000);
    }

    @Then("Validate user is on customize account page {string}")
    public void validateUserIsOnCustomizeAccountPage(String title) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        signUpPage.validatePageTitle(webDriver,FileReaderManager.getInstance().getConfigFileReader().getProperty(title));
        Assert.assertTrue(signUpPage.customizeAccountPageIsDisplayed());
        String actualLoginHeaderTitle = testContext.getDriverManager().getDriver().getTitle();
        Assert.assertEquals(actualLoginHeaderTitle,"Pemo | Customize-account","Wrong Text for Title Page");

    }

    @And("User Agree on pemo policy")
    public void userAgreeOnPemoPolicy()throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        signUpPage.clickpemoPolicyCheckBox(webDriver);
    }

    @When("User enter valid customize account information {string} and {string}")
    public void userEnterValidCustomizeAccountInformationAnd(String businessLegalName, String phoneNumber)throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        signUpPage.fillCustomizeAccountInformationData(webDriver,FileReaderManager.getInstance().getConfigFileReader().getProperty(businessLegalName)+kybPage.generate5RandomNumbers(),FileReaderManager.getInstance().getConfigFileReader().getProperty(phoneNumber));
    }

    @Then("Validate User is on verifying page")
    public void validateUserIsOnVerifyingPage() throws InterruptedException {
        verificationPage.validatePageTitle(testContext.getDriverManager().getDriver(),"Pemo | Verification");
        Assert.assertTrue(verificationPage.verificationPageIsDisplayed());
    }



    @Then("Validate user full name {string} and {string} is correct")
    public void validateUserFullNameIsCorrect(String firstname,String lastname) throws InterruptedException{
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        String expectedUserFullname = FileReaderManager.getInstance().getConfigFileReader().getProperty(firstname).concat(" "+FileReaderManager.getInstance().getConfigFileReader().getProperty(lastname));
        System.out.println(expectedUserFullname);
        Assert.assertEquals(landingPage.getUserFullName(webDriver),expectedUserFullname);
    }

    @And("Validate businessName {string} is correct")
    public void validateBusinessNameIsCorrect(String businessLegalName) throws InterruptedException{
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        String expectedBusinessName = FileReaderManager.getInstance().getConfigFileReader().getProperty(businessLegalName);
        System.out.println(expectedBusinessName);
        Assert.assertEquals(landingPage.getBusinessNameText(webDriver),expectedBusinessName);
    }

    @And("Validate the role of user is Admin")
    public void validateRoleOfUserIsCorrect() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        String expectedRoleName = "Admin";
        Assert.assertEquals(landingPage.getRoleText(webDriver),expectedRoleName);
    }

    @Then("Validate the email is verified")
    public void validateTheEmailIsVerified() {
        signUpPage.validateTheemailIsVerified();
    }

    @When("User verify  the email")
    public void userVerifyTheEmail() {
        signUpPage.getTheTokenByUsingResendAPI();
        signUpPage.verifyEmailUsingAPI();
    }
}

