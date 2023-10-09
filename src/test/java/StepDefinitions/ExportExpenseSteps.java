package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.opencsv.exceptions.CsvValidationException;

import PageObjects.ExportPage;
import Utilities.Actions;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ExportExpenseSteps {

    TestContext testContext;
    ExportPage exportPage;
    WebDriver webDriver;

    public ExportExpenseSteps(TestContext context) throws MalformedURLException {
        testContext = context;
        exportPage = testContext.getPageObjectManager().getExportPage();
        webDriver = testContext.getDriverManager().getDriver();
    }

    @And("User go to Export pocket expenses Page")
    public void User_go_to_Export_pocket_expenses_Page() throws IOException, CsvValidationException, InterruptedException {
        Actions.click(webDriver, exportPage.enableAccountibgV2Toggle);
         Actions.click(webDriver, exportPage.exportPocketExpensesPage);

    }

    @And("User go to history tab")
    public void User_go_to_history_tab() throws IOException, CsvValidationException, InterruptedException {
        Actions.click(webDriver, exportPage.historyBtn);
    }

    @And("User export expenses")
    public void User_export_expenses() throws IOException, CsvValidationException, InterruptedException {
        Actions.click(webDriver, exportPage.exportFirstFile);
    }

    @Then("User check exported file")
    public void User_check_exported_file() throws IOException, CsvValidationException, InterruptedException {
       Thread.sleep(5000);
        String home = System.getProperty("user.home");
        String filePath = home+"/Downloads/" + "Pemo-oop-QB-2023-09-12_085450117"+ ".csv"; 
        Actions.compare_csv_file(filePath);
    }

}
