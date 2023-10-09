package StepDefinitions;
import Managers.FileReaderManager;
import PageObjects.LoginPage;
import PageObjects.SignUpPage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {
    TestContext testContext;
    LoginPage loginPage;
    SignUpPage signUpPage;

    public LoginSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        signUpPage = testContext.getPageObjectManager().getSignUpPage();
    }


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
       if (testContext.getDriverManager().getDriver().getTitle() != "Pemo | Sign-In") {
            testContext.getDriverManager().getDriver().get(FileReaderManager.getInstance().getConfigFileReader().getProperty("loginUrl"));
        }
    }

    @Then("Validate Login page is displayed")
    public void loginPageIsDisplayed() {
        Assert.assertTrue(loginPage.emailLoginPageIsDisplayed());
        String actualLoginHeaderTitle = testContext.getDriverManager().getDriver().getTitle();
        Assert.assertEquals(actualLoginHeaderTitle,"Pemo | Sign-In","Wrong Text for Title Page");
    }


    @When("User login with credentials {string} and {string}")
    public void userLoginWithValidCredentialsAnd(String email, String password) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        email = FileReaderManager.getInstance().getConfigFileReader().getProperty(email);
        password=FileReaderManager.getInstance().getConfigFileReader().getProperty(password);

        if ("registeredEmail".equals(email)) {
            email = signUpPage.getSavedTimeStampEmail();
        }
        if ("newPassword".equals(password)) {
            password = loginPage.getSavedTimeStampPassword();
        }
        if ("oldPassword".equals(password)) {
            password = loginPage.oldPassword;
        }
        loginPage.login(webDriver,email,password);
    }

    @Then("Validate user is on {string}")
    public void validateUserIsOnLandingPage(String title) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        loginPage.validatePageTitle(webDriver,FileReaderManager.getInstance().getConfigFileReader().getProperty(title));
        System.out.println(FileReaderManager.getInstance().getConfigFileReader().getProperty(title));
        Thread.sleep(2500);
        String actualLoginHeaderTitle = webDriver.getTitle();
        Assert.assertEquals(actualLoginHeaderTitle,FileReaderManager.getInstance().getConfigFileReader().getProperty(title),"Login is failed");
    }
}

