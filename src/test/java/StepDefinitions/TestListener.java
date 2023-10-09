package StepDefinitions;

        import com.aventstack.extentreports.ExtentReports;
        import com.aventstack.extentreports.ExtentTest;
        import com.aventstack.extentreports.Status;
        import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
        import org.testng.ITestContext;
        import org.testng.ITestListener;
        import org.testng.ITestResult;

        import java.util.HashMap;
        import java.util.Map;

public class TestListener implements ITestListener {

    private ExtentReports extent;
    private ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private Map<String, String> scenarioResults = new HashMap<>();

    @Override
    public void onStart(ITestContext context) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        String scenarioName = result.getMethod().getMethodName();
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String scenarioName = result.getMethod().getMethodName();        test.get().log(Status.PASS, "Test passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }


    private void generateCucumberReport() {
        // Generate a Cucumber report containing the details of every step
        // This report can be generated in various formats, such as plain text, HTML, or PDF, depending on your requirements

        // Example: print the results to the console
        System.out.println("Cucumber Report:");
        for (Map.Entry<String, String> entry : scenarioResults.entrySet()) {
            System.out.println("Scenario: " + entry.getKey() + ", Status: " + entry.getValue());
        }
    }

}

