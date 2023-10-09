package StepDefinitions;
import Managers.FileReaderManager;
import PageObjects.*;
import Utilities.TestContext;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.cfg.CoercionAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static io.cucumber.core.internal.com.fasterxml.jackson.databind.cfg.CoercionAction.Fail;

public class ForgetPasswordSteps {
    TestContext testContext;
    LoginPage loginPage;
    SignUpPage signUpPage;
    VerificationPage verificationPage;
    LandingPage landingPage;
    TeamsAndMembersPage teamsAndMembersPage;

    public ForgetPasswordSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        signUpPage = testContext.getPageObjectManager().getSignUpPage();
        verificationPage = testContext.getPageObjectManager().getVerificationPagePage();
        landingPage = testContext.getPageObjectManager().getLandingPage();
        teamsAndMembersPage = testContext.getPageObjectManager().getTeamsAndMembersPage();

    }

    @When("User click reset password")
    public void user_click_reset_password() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        loginPage.clickResetPasswordButton(webDriver);
        Thread.sleep(2000);
    }
    @When("User enter registered {string} to set a new password")
    public void user_enter_registered_to_set_a_new_password(String email) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        email = FileReaderManager.getInstance().getConfigFileReader().getProperty(email);
        if ("registeredEmail".equals(email)) {
            email = signUpPage.getSavedTimeStampEmail();
        }
        loginPage.enterForgettenPasswordEmail(webDriver,email);
    }
    @When("User submit sending the email")
    public void user_submit_sending_the_email() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        loginPage.clickSendResetEmailPasswordButton(webDriver);
        Thread.sleep(2000);
    }
    @Then("Validate confirmation page for sending forgetten password email opened successfully")
    public void validate_confirmation_page_for_sending_forgetten_password_email_opened_successfully() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        try {
        if (loginPage.blockedMessageForForgettenPassword.isDisplayed()){
            System.out.println(loginPage.getBlockMessageForForgettenPassword(webDriver));
            CoercionAction fail = Fail;
        }
       } catch (NoSuchElementException e) {
            System.out.println("");
       }
        Thread.sleep(1000);
        Assert.assertTrue(loginPage.forgettenPasswordEmailConfirmationPageIsDisplayed(),"Page not opened");
        Assert.assertTrue(loginPage.getConfirmationForForgettenEmail(webDriver).contains("sent you an email with a reset link"));
    }
    @When("Get the token of {string} using API")
    public void get_the_token_of_using_api(String email) {
        email = FileReaderManager.getInstance().getConfigFileReader().getProperty(email);
        if ("registeredEmail".equals(email)) {
            email = signUpPage.getSavedTimeStampEmail();
        }
        loginPage.getTheTokenByUsingForgetPasswordAPI(email);
        System.out.println(loginPage.forgettenPasswordToken);
    }
    @When("Set the new password")
    public void set_the( ) {
        loginPage.setNewPasswordUsingAPI(loginPage.getTimestampNewPassword());
    }

    @And("Save the password as old password")
    public void saveThePasswordAsOldPassword() {
        loginPage.oldPassword=loginPage.newPassword;
    }

    @And("Validate the token of {string} will not send using API")
    public void validateTheTokenOfWillNotSendUsingAPI(String email) {
        try {
            loginPage.getTheTokenByUsingForgetPasswordAPI(FileReaderManager.getInstance().getConfigFileReader().getProperty(email));
        } catch (JSONException e) {
            System.out.println("No token, Un-Registered User can not reset password using Forget password from Sign-in page");
            }
    }

    @When("User click on resend password email")
    public void userClickOnResendPasswordEmail() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(1000);
        loginPage.clickResendPasswordEmailButton(webDriver);
        Thread.sleep(1000);
    }

    @Then("Validate blocking message appeared successfully")
    public void validateBlockingMessageAppearedSuccessfully() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertTrue(loginPage.getBlockMessageForForgettenPassword(webDriver).contains("Your account is blocked due to 5 password reset attempts"));
        System.out.println(loginPage.getBlockMessageForForgettenPassword(webDriver));
    }

}