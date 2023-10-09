package StepDefinitions;
import Managers.FileReaderManager;
import PageObjects.*;
import Utilities.TestContext;
import Utilities.Wait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccountSteps {
    TestContext testContext;
    LoginPage loginPage;
    SignUpPage signUpPage;
    VerificationPage verificationPage;
    LandingPage landingPage;
    TeamsAndMembersPage teamsAndMembersPage;

    public MyAccountSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        signUpPage = testContext.getPageObjectManager().getSignUpPage();
        verificationPage = testContext.getPageObjectManager().getVerificationPagePage();
        landingPage = testContext.getPageObjectManager().getLandingPage();
        teamsAndMembersPage = testContext.getPageObjectManager().getTeamsAndMembersPage();
    }

    @When("User open setting list")
    public void user_open_setting_list() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        landingPage.openProfileSettingList(webDriver);
    }
    @When("User open my account setting")
    public void user_open_my_account_setting() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        landingPage.openMyAccountSetting(webDriver);
        Thread.sleep(1000);
    }
    @When("User change first name")
    public void user_change_first_name() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        landingPage.changeFirstName(webDriver,"FirstName"+landingPage.getUniqueName());
        Thread.sleep(1000);
    }
    @When("User change last name")
    public void user_change_last_name() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        landingPage.changeLastName(webDriver,"LastName"+landingPage.getUniqueName());
        Thread.sleep(1000);
    }
    @Then("Validate full name label on top right page updated successfully")
    public void validate_full_name_label_on_top_right_page_updated_successfully() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        System.out.println(landingPage.getUserFullName(webDriver));
        Assert.assertTrue(landingPage.getUserFullName(webDriver).contains(landingPage.getUserFirstName(webDriver)+landingPage.getUserLastName(webDriver)),"Full Name not updated");
    }

    @And("User change first name to empty")
    public void userChangeFirstNameToEmpty() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        landingPage.changeFirstName(webDriver,"");
        Thread.sleep(1000);
    }

    @When("User change last name  to invalid syntax")
    public void userChangeLastNameToInvalidSyntax() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        landingPage.changeLastName(webDriver,"Admin123");
        Thread.sleep(1000);
    }

    @Then("Validate empty error message appeared")
    public void validateEmptyErrorMessageAppeared() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(500);
        Assert.assertTrue(landingPage.getErrorMessage(webDriver).contains("This field is required"),"Error Message script is wrong");

    }

    @Then("Validate invalid syntax error message appeared")
    public void validateInvalidSyntaxErrorMessageAppeared() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        Thread.sleep(500);
        Assert.assertTrue(landingPage.getErrorMessage(webDriver).contains("Field must be only english letters"),"Error Message script is wrong");
    }

    @And("Validate User cannot change email or automated email")
    public void userTryToChangeEmailAndAutomatedEmail()throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();


        boolean x = false;
        try {
        landingPage.tryToChangeEmailAndAutoEmail(webDriver);
     } catch (ElementNotInteractableException e) {
         System.out.println( "You Can't change Email or Auto Email");
         x= true;
     }
        Assert.assertTrue(x);
     }

    @And("User change password {string} to {string}")
    public void userChangePasswordTo(String oPassword, String nPassword) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();


        oPassword=FileReaderManager.getInstance().getConfigFileReader().getProperty(oPassword);
        if ("newPassword".equals(oPassword)) {
            oPassword = loginPage.getSavedTimeStampPassword();
        }
        landingPage.changePassword(webDriver,oPassword,FileReaderManager.getInstance().getConfigFileReader().getProperty(nPassword));
    }

    @Then("Validate the successful toast appeared")
    public void theSuccessfulMessageAppeared() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertTrue(landingPage.getSuccessToast(webDriver).contains("Password changed successfully"),"Message script is wrong");
       // landingPage.waitUntilSuccessToastInVisible(webDriver);
        Thread.sleep(8000);
    }

    @When("User logout")
    public void userLogout() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        landingPage.openProfileSettingList(webDriver);
        landingPage.clickOnLogOut(webDriver);
    }

    @Then("Validate the error toast appeared")
    public void validateTheErrorToastAppeared() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        Assert.assertTrue(landingPage.getErrorToast(webDriver).contains("Incorrect Email or Password"),"Message script is wrong");
        Thread.sleep(6000);
    }

    @When("User close change password tab")
    public void userCloseChangePasswordTab() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        landingPage.closeChangePasswordTap(webDriver);
        Thread.sleep(1000);
    }


    @When("User change password by enter old password {string}")
    public void user_change_password_by_enter_old_password(String oPassword) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        landingPage.clickOnChangePassword(webDriver);
       landingPage.enterOldPassword(webDriver,FileReaderManager.getInstance().getConfigFileReader().getProperty(oPassword));
    }
    @When("User enter new password {string}")
    public void user_enter_new_password(String nPassword)throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        landingPage.enterNewPassword(webDriver,FileReaderManager.getInstance().getConfigFileReader().getProperty(nPassword));

    }
    @When("User repeated new password {string}")
    public void user_repeated_new_password(String oPassword)throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        landingPage.enterRepeatNewPassword(webDriver,FileReaderManager.getInstance().getConfigFileReader().getProperty(oPassword));

    }
    @Then("Validate the error message appeared")
    public void validate_the_error_message_appeared() throws InterruptedException{
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        Assert.assertTrue(landingPage.getErrorMessageRepeatedPasswordContainer(webDriver).contains("Repeat password must match new password"),"Message script is wrong");
    }


    @And("User click on save password")
    public void userClickOnSavePassword() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        landingPage.clickOnSavePasswordButton(webDriver);
    }
}