package StepDefinitions;

import Managers.FileReaderManager;
import Utilities.ScreenShot;
import Utilities.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;


@CucumberOptions(
        plugin = {"pretty",
                "html:cucumber.html",
        },
        monochrome = true
)
public class Hooks {

    TestContext testContext;
    WebDriver webDriver;


    public Hooks(TestContext context) {
        testContext = context;
    }


    @Before
    public void setUp(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@Api")) {
            testContext.getDriverManager().closeDriver();
            System.out.println("Skip Setup");
        } else {
        webDriver =  testContext.getDriverManager().getDriver();
        webDriver.get(FileReaderManager.getInstance().getConfigFileReader().getProperty("url"));
        webDriver.manage().window().maximize();
    }}

    @After
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.getSourceTagNames().contains("@Api")) {
        } else {
        ScreenShot.takeScreenShot(webDriver,"./src/main/resources/");
        testContext.getDriverManager().getDriver().manage().deleteAllCookies();
      // testContext.getDriverManager().closeDriver();
        }}
}
