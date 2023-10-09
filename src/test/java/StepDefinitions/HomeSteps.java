package StepDefinitions;

import PageObjects.LandingPage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomeSteps {

    LandingPage landingPage;
    TestContext testContext;

    public HomeSteps(TestContext context) {
        testContext = context;
        landingPage = testContext.getPageObjectManager().getLandingPage();
    }

    @Given("Home page without authorizations")
    public void homePageWithoutAuthorizations() {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertTrue(landingPage.defaultHomePageIsDisplayed(webDriver));
    }}


