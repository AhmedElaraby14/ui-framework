package PageObjects;

import Managers.FileReaderManager;
import Utilities.Actions;
import Utilities.Wait;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static io.restassured.RestAssured.given;


public class InvoicesPage {
    FileReaderManager fileReaderManager;
    private final WebDriver webDriver;
    public int countUploadedInvoice=0;
    public int countRestOfInvoices=0;
    public int payAsapInvoiceRowNumber;
    public String countInvoicesByApi;

    public InvoicesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-ax01r8'])[1]")
    private WebElement uploadInvoiceButton;

    @FindBy(xpath = "//div[@class='MuiBox-root css-fgm9ha']")
    private WebElement invoicesTable;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation btn-ocean-disabled css-8qtbd7'])[1]")
    private WebElement submitFileButton;


    @FindBy(id = "NymCardInvoices-uploadInvoice-1")
    private WebElement disabledUploadFileButton;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation css-18ym2z1']")
    private WebElement cancelButton;

    @FindBy(xpath = "//p[@class='MuiTablePagination-displayedRows css-1vz5rqz']")
    private WebElement itemsPerPage;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-y7ccvg']")
    private WebElement teamName;

    @FindBy(xpath = "//button[@id='NymCardInvoices-removeInvoice-1']")
    private WebElement deleteButton1;

    @FindBy(xpath = "(//button[@class='invoices-actions-btn '])[1]")
    private WebElement actionButton;

    @FindBy(xpath = "//button[@class='arrowBtn ']")
    private WebElement invoiceDetailsActionButton;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-19ucgzv']")
    private WebElement submitConfirmReview;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-180pnjh']")
    private WebElement submitConfirmApprove;

    @FindBy(xpath = "(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1fob25r'])[1]")
    private WebElement showInvoiceButton;

    @FindBy(css = ".MuiButtonBase-root.MuiButton-root.MuiButton-text.MuiButton-textPrimary.MuiButton-sizeMedium.MuiButton-textSizeMedium.MuiButton-disableElevation.css-1hefes1")
    private WebElement chooseFileButton;

    @FindBy(css = "input[type='file']")
    private WebElement uploadFileContainer;

    @FindBy(xpath = "//div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']")
    private WebElement errorToast;

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast-theme--dark Toastify__toast--error']")
    private WebElement errorToastText;

    @FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body1 css-a3iuln']")
    private WebElement autoEmailText;

    @FindBy(xpath = "//div[@class='MuiBox-root css-1plwret']")
    private WebElement invoiceDialog;

    @FindBy(id = "NymCardInvoices-allInvoicesTab-1")
    private WebElement allInvoicesButton;

    @FindBy(id = "NymCardInvoices-showInvoice-1")
    private WebElement showInvoice;

    @FindBy(id = "NymCardInvoices-reviewInvoicesTab-1")
    private WebElement reviewInvoicesButton;

    @FindBy(id = "NymCardInvoices-approvalInvoicesTab-1")
    private WebElement approvalInvoicesButton;

    @FindBy(id = "NymCardInvoices-paymentInvoicesTab-1")
    private WebElement paymentInvoicesButton;

    @FindBy(id = "NymCardInvoices-reject-1")
    private WebElement rejectButtonQuickAction;

    @FindBy(id = "NymCardInvoices-approve-1")
    private WebElement approveButtonQuickAction;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-180pnjh']")
    private WebElement submitRejectButtonQuickAction;

    @FindBy(name = "reason")
    private WebElement rejectReasonFieldQuickAction;

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast-theme--dark Toastify__toast--success']")
    private WebElement rejctionSuccessToast;
    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast-theme--dark Toastify__toast--success']")
    private WebElement reviewSuccessToast;

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast-theme--dark Toastify__toast--success']")
    private WebElement payASAPSuccessToast;

    @FindBy(xpath = "(//div[@class='d-flex align-items-start my-4 py-2'])[1]")
    private WebElement invoiceDocumentTimelineFirstAction;

    @FindBy(id = "NymCardInvoices-allInvoicesBadge-1")
    private WebElement allInvoicesBadge;

    @FindBy(id = "NymCardInvoice-auditTrailTab-1")
    private WebElement auditTrailTab;

    @FindBy(id = "NymCardInvoice-confirmReview-1")
    private WebElement confirmReview;

    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-s86i8e'])[2]")
    private WebElement rejectedInvoicesBadge;

    @FindBy(xpath = "//p[@class='px14 neutral90 mb-0 lineHeight140Percent']")
    private WebElement rejectionReasonField;

    @FindBy(xpath = "//div[@class='d-flex align-items-center justify-content-end px-3 data-section-z-index']")
    private WebElement rejectAndActionButtonsContainer;

    @FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']")
    private WebElement quickActionList;

    @FindBy(xpath = "//button[@class='generic-button smallPadding alert40Bg white mx-3']")
    private WebElement rejectInvoiceButtonInInvoiceDetails;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-c0o2in']")
    private WebElement rejectedTabButton;

    @FindBy(xpath = "//input[@class='rejectInvoiceModalInput error']")
    private WebElement rejectionFieldEmptyError;

    @FindBy(id = "NymCardInvoices-payASAP-1")
    private WebElement payASAPButton;


    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-w7sprg']")
    private WebElement payASAPConfirmButton;

    @FindBy(xpath = "//p[@class='mb-0 neutral90 px14 f-600']")
    private WebElement submitedByFullNameAuditTrail;

    @FindBy(xpath = "(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters d-flex align-items-center justify-content-between css-1fob25r'])[1]")
    private WebElement payAsapInvoiceDetailsButton;

    @FindBy(id = "NymCardInvoice-cancelInvoiceDetails-1")
    private WebElement closeInvoiceDetailsTabButton;

    public void split(WebDriver webDriver, String multiPdfPath) throws InterruptedException {
        String[] multiPdfsPaths = multiPdfPath.split(",");
        for (String multiPdfsPath : multiPdfsPaths) {
            System.out.println(multiPdfsPath);
            Actions.sendKeys(webDriver, uploadFileContainer, multiPdfsPath);
            Thread.sleep(2000);
            Actions.clear(webDriver, uploadFileContainer);
        }
    }

    public void clickOnUploadInvoiceButton(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, uploadInvoiceButton);
    }

    public void clickOnChooseFileButton(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, chooseFileButton);
    }
    public void sendFileToContainer(String invoiceName) {
        uploadFileContainer.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/"+invoiceName+".pdf");
    }

    public void sendPngFileToContainer() {
        uploadFileContainer.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/tradeLicense.png");
    }

    public void sendExeFileToContainer() {
        uploadFileContainer.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/setup.exe");
    }

    public void sendMultiFilesToContainer() {
        uploadFileContainer.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Pemo_UI_Testing.pdf"+"\n"+System.getProperty("user.dir")+"/UploadedDocs/Reject_Reviiew_All.pdf"+"\n"+System.getProperty("user.dir")+"/UploadedDocs/Reject_Approoval_All.pdf"
                +"\n"+System.getProperty("user.dir")+"/UploadedDocs/Reject_Team_Member.pdf"+"\n"+System.getProperty("user.dir")+"/UploadedDocs/Reject_External_Accountant.pdf"
                +"\n"+System.getProperty("user.dir")+"/UploadedDocs/Reject_Reviiew_Invoice_Details.pdf"+"\n"+System.getProperty("user.dir")+"/UploadedDocs/Reject_Internal_Accountant.pdf"
                +"\n"+System.getProperty("user.dir")+"/UploadedDocs/Reject_Team_Lead.pdf"+"\n"+System.getProperty("user.dir")+"/UploadedDocs/Reject_Paymeent_All.pdf"
                +"\n"+System.getProperty("user.dir")+"/UploadedDocs/ASAAP_Invoice.pdf");

    }

    public void send11FilesToContainer() {
        uploadFileContainer.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Pemo_UI_Testing.pdf"+"\n"+System.getProperty("user.dir")+"/UploadedDocs/Pemo_UI_Testing.pdf"+"\n"+System.getProperty("user.dir")+"/UploadedDocs/Pemo_UI_Testing.pdf"
                +"\n"+System.getProperty("user.dir")+"/UploadedDocs/Pemo_UI_Testing.pdf"+"\n"+System.getProperty("user.dir")+"/UploadedDocs/Pemo_UI_Testing.pdf"
                +"\n"+System.getProperty("user.dir")+"/UploadedDocs/Pemo_UI_Testing.pdf"+"\n"+System.getProperty("user.dir")+"/UploadedDocs/Pemo_UI_Testing.pdf"
                +"\n"+System.getProperty("user.dir")+"/UploadedDocs/Pemo_UI_Testing.pdf"+"\n"+System.getProperty("user.dir")+"/UploadedDocs/Pemo_UI_Testing.pdf"
                +"\n"+System.getProperty("user.dir")+"/UploadedDocs/Pemo_UI_Testing.pdf"+"\n"+System.getProperty("user.dir")+"/UploadedDocs/Pemo_UI_Testing.pdf");

    }

    public void send3FilesToContainer() {
        uploadFileContainer.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Pemo_UI_Testing.pdf"+"\n"+System.getProperty("user.dir")+"/UploadedDocs/Reject_Team_Member.pdf"+"\n"+System.getProperty("user.dir")+"/UploadedDocs/ASAAP_Invoice.pdf");

    }

    public void clickOnSubmitFileButton(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, submitFileButton);
    }

    public Boolean validateInvoice(WebDriver webDriver) {
        WebElement table = webDriver.findElement(By.xpath("//table[@class='customTable']"));
        List<WebElement> rows1 = table.findElements(By.tagName("tr"));
        String tableC = table.getText();
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        System.out.println(rows.size());

        String invoice = rows.get(0).getText();
        System.out.println("\n" + invoice);
        boolean found = false;

        if (invoice.contains("Uploading")) {
            found = true;
        }
        return found;
    }

    public Boolean validateEveryTableRowReviewStatus(WebDriver webDriver, String invoiceName) throws InterruptedException {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        boolean found = false;
        int count = 1;
        for (WebElement row : rows) {
            System.out.println(row.getText());
            if (row.getText().contains(invoiceName) && row.getText().contains("Review") && !row.getText().contains("Pay ASAP")) {
                WebElement actionBttn = webDriver.findElement(By.xpath("(//button[@class='invoices-actions-btn '])[" + count + "]"));
                Actions.click(webDriver, actionBttn);
                found = true;
                payAsapInvoiceRowNumber = count - 1;
                break;
            }
            count++;
        }

        if (!found) {
            clickOnUploadInvoiceButton(webDriver);
            Thread.sleep(500);
            sendFileToContainer(invoiceName);
            Thread.sleep(500);
            clickOnSubmitFileButton(webDriver);
            waitUntilSuccessMessageInvisible(webDriver);
            Thread.sleep(2000);
            waitUntilStatusChangedToReview(webDriver);
            waitActionButtonIsClickable(webDriver);
            Thread.sleep(500);
            Actions.click(webDriver, actionButton);
            found = true;
        }

        return found;
    }

    public Boolean validateEveryTableRowReviewStatusAndFlagPayASAP(WebDriver webDriver, String invoiceName) throws InterruptedException {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        boolean found = false;
        int count = 1;
        for (WebElement row : rows) {
            if (row.getText().contains(invoiceName) && row.getText().contains("Review") && row.getText().contains("Pay ASAP")) {
                WebElement actionBttn = webDriver.findElement(By.xpath("(//button[@class='invoices-actions-btn '])[" + count + "]"));
                Actions.click(webDriver, actionBttn);
                found = true;
                payAsapInvoiceRowNumber = count - 1;
                break;
            }
            count++;
        }

        if (!found) {
            clickOnUploadInvoiceButton(webDriver);
            Thread.sleep(500);
            sendFileToContainer(invoiceName);
            Thread.sleep(500);
            clickOnSubmitFileButton(webDriver);
            waitUntilSuccessMessageInvisible(webDriver);
            Thread.sleep(2000);
            waitUntilStatusChangedToReview(webDriver);
            waitActionButtonIsClickable(webDriver);
            Thread.sleep(500);
            Actions.click(webDriver, actionButton);
            Thread.sleep(500);
            clickOnPayASAPToAddOrRemove(webDriver);
            clickOnConfirmPayASAPToAddOrRemove(webDriver);
            Wait.untilElementIsVisible(webDriver, payASAPSuccessToast, 30L);
            Wait.untilElementIsInVisible(webDriver, payASAPSuccessToast, 30L);
            Thread.sleep(1000);
            Actions.click(webDriver, actionButton);
            found = true;
        }

        return found;
    }

    public Boolean validatePayAsapFlagIsDisplayed(WebDriver webDriver) throws InterruptedException {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        boolean found = false;
        System.out.println(rows.get(payAsapInvoiceRowNumber).getText());
        if (rows.get(payAsapInvoiceRowNumber).getText().contains("Pay ASAP")) {
            found = true;
        }
        return found;
    }

    public Boolean validatePayAsapFlagIsDisappeared(WebDriver webDriver) throws InterruptedException {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        boolean found = false;
        Thread.sleep(1000);
        System.out.println(rows.get(payAsapInvoiceRowNumber).getText());
        if (!rows.get(payAsapInvoiceRowNumber).getText().contains("Pay ASAP")) {
            found = true;
        }
        return found;
    }

    public void clickOnQuickActionButtonForTheRequiedInvoice(WebDriver webDriver) throws InterruptedException {
        System.out.println(payAsapInvoiceRowNumber);
        int count = payAsapInvoiceRowNumber + 1;
        WebElement actionBttn = webDriver.findElement(By.xpath("(//button[@class='invoices-actions-btn '])[" + count + "]"));
        Actions.click(webDriver, actionBttn);
    }

    public Boolean validateEveryTableRowApprovalStatus(WebDriver webDriver, String invoiceName) throws InterruptedException {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        boolean found = false;
        int count = 1;
        for (WebElement row : rows) {
            System.out.println(row.getText());
            if (row.getText().contains(invoiceName) && row.getText().contains("Approval")) {
                WebElement actionBttn = webDriver.findElement(By.xpath("(//button[@class='invoices-actions-btn '])[" + count + "]"));
                Actions.click(webDriver, actionBttn);
                found = true;
                break;
            }
            count++;
        }

        if (!found) {
            clickOnUploadInvoiceButton(webDriver);
            Thread.sleep(500);
            sendFileToContainer(invoiceName);
            Thread.sleep(500);
            clickOnSubmitFileButton(webDriver);
            waitUntilSuccessMessageInvisible(webDriver);
            Thread.sleep(2000);
            waitUntilStatusChangedToReview(webDriver);
            waitActionButtonIsClickable(webDriver);
            Thread.sleep(500);
            showInvoiceDetailsFromScratch(webDriver);
            waitUntilInvoiceDetailsActionButtonAppear(webDriver);
            Thread.sleep(2000);
            confirmReview(webDriver);
            waitUntilReviewSuccessToastIsVisible(webDriver);
            waitUntilReviewSuccessToastIsInvisible(webDriver);
            Actions.click(webDriver, actionButton);
            found = true;
        }

        return found;
    }

    public Boolean validateEveryTableRowPaymentStatus(WebDriver webDriver, String invoiceName) throws InterruptedException {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        boolean found = false;
        int count = 1;
        for (WebElement row : rows) {
            System.out.println(row.getText());
            if (row.getText().contains(invoiceName) && row.getText().contains("Payment")) {
                WebElement actionBttn = webDriver.findElement(By.xpath("(//button[@class='invoices-actions-btn '])[" + count + "]"));
                Actions.click(webDriver, actionBttn);
                found = true;
                break;
            }
            count++;
        }

        if (!found) {
            clickOnUploadInvoiceButton(webDriver);
            Thread.sleep(500);
            sendFileToContainer(invoiceName);
            Thread.sleep(500);
            clickOnSubmitFileButton(webDriver);
            waitUntilSuccessMessageInvisible(webDriver);
            Thread.sleep(3000);
            waitUntilStatusChangedToReview(webDriver);
            waitActionButtonIsClickable(webDriver);
            Thread.sleep(500);
            showInvoiceDetailsFromScratch(webDriver);
            waitUntilInvoiceDetailsActionButtonAppear(webDriver);
            Thread.sleep(2000);
            confirmReview(webDriver);
            waitUntilReviewSuccessToastIsVisible(webDriver);
            waitUntilReviewSuccessToastIsInvisible(webDriver);
            Actions.click(webDriver, actionButton);
            Thread.sleep(500);
            approveInvoiceQuickAction(webDriver);
            Thread.sleep(500);
            waitUntilReviewSuccessToastIsVisible(webDriver);
            waitUntilReviewSuccessToastIsInvisible(webDriver);
            waitUntilStatusChangedToPayment(webDriver);
            Actions.click(webDriver, actionButton);
            found = true;
        }

        return found;
    }

    public Integer countNumOfUploadedReviewInvoices(WebDriver webDriver, String invoiceName) throws InterruptedException {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        countUploadedInvoice = 0;
        for (WebElement row : rows) {
            if (row.getText().contains(invoiceName) && row.getText().contains("Review")) {
                System.out.println(row.getText());
                countUploadedInvoice++;
            }
        }
        return countUploadedInvoice;
    }

    public Integer countNumOfUploadedPaymentInvoices(WebDriver webDriver, String invoiceName) throws InterruptedException {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        countUploadedInvoice = 0;
        for (WebElement row : rows) {
            if (row.getText().contains(invoiceName) && row.getText().contains("Payment")) {
                System.out.println(row.getText());
                countUploadedInvoice++;
            }
        }
        return countUploadedInvoice;
    }

    public Integer countNumOfUploadedApprovalInvoices(WebDriver webDriver, String invoiceName) throws InterruptedException {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        countUploadedInvoice = 0;
        for (WebElement row : rows) {
            if (row.getText().contains(invoiceName) && row.getText().contains("Approval")) {
                countUploadedInvoice++;
            }
        }
        return countUploadedInvoice;
    }

    public void waitUntilSuccessMessageInvisible(WebDriver webDriver) {
        Wait.untilElementIsInVisible(webDriver, cancelButton, 60L);
    }

    public Boolean validateActionButtonIsDisabled() {
        return  !actionButton.isEnabled();
    }

    public void waitActionButtonIsClickable(WebDriver webDriver) {
        Wait.untilElementIsClickable(webDriver, actionButton, 60L);
    }

    public void waitUntilStatusChangedToReview(WebDriver webDriver) {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        Wait.untilTextContain(webDriver, "Review", 120L, rows.get(0));
        System.out.println(rows.get(0).getText());
    }

    public void waitUntilStatusChangedToPayment(WebDriver webDriver) {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        Wait.untilTextContain(webDriver, "Payment", 120L, rows.get(0));
        System.out.println(rows.get(0).getText());
    }

    public Boolean validateTheFullNameAppearedUnderSubmitedByColumn(WebDriver webDriver, String text) {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        String invoiceDetails = rows.get(0).getText();
        boolean found = false;
        if (invoiceDetails.contains(text)) {
            found = true;
        }
        return found;
    }

    public Boolean validateTheInvoiceNameAddedCorrectly(WebDriver webDriver, String text) {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        String invoiceDetails = rows.get(0).getText();
        boolean found = false;
        if (invoiceDetails.contains(text)) {
            found = true;
        }
        return found;
    }

    public Boolean validateMultiInvoices(WebDriver webDriver) {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        boolean found = false;
        int rowCount = 0;
        for (WebElement row : rows) {
            if (rowCount >= 10) {
                break;
            }
            String invoiceStatus = row.getText();
            System.out.println(invoiceStatus);
            if (invoiceStatus.contains("Uploading")) {
                found = true;
                rowCount++;
            } else {
                found = false;
                break;
            }
        }
        return found;
    }
    public Boolean validatesubmitFileButtonIsDisabled() {
        return  !disabledUploadFileButton.isEnabled();
    }

    public Boolean validateInvoiceErrorToastIsDisplayed() {
        return  errorToast.isDisplayed();
    }

    public String errorToastText(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, errorToastText);
    }

    public String autoEmailText(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, autoEmailText);
    }

    public String invoiceDialogText(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, invoiceDialog);
    }

    public void deleteFirstUploadedInvoice(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, deleteButton1);
    }

    public Integer countNumberOfUploadedInvoices(WebDriver webDriver) {
        WebElement uploadedInvoices = webDriver.findElement(By.xpath("//div[@class='MuiBox-root css-1k8024n']"));
        List<WebElement> rows = uploadedInvoices.findElements(By.tagName("div"));
        return rows.size();
    }

    public void clickOnCancelButton(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, cancelButton);
    }

    public String itemsPerPageText(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, itemsPerPage);
    }

    public String teamNameText(WebDriver webDriver)throws InterruptedException {
        return Actions.getText(webDriver, teamName);
    }

    public String invoiceTableText(WebDriver webDriver)throws InterruptedException {
        return Actions.getText(webDriver, invoicesTable);
    }

    public void clickOnAllInvoicesButton(WebDriver webDriver)throws InterruptedException {
        Thread.sleep(500);
        Actions.click(webDriver, allInvoicesButton);
    }

    public void clickOnReviewInvoicesButton(WebDriver webDriver)throws InterruptedException {
        Thread.sleep(500);
        Actions.click(webDriver, reviewInvoicesButton);
    }

    public void clickOnApprovalInvoicesButton(WebDriver webDriver)throws InterruptedException {
        Thread.sleep(500);
        Actions.click(webDriver, approvalInvoicesButton);
    }

    public void clickOnPaymentInvoicesButton(WebDriver webDriver)throws InterruptedException {
        Thread.sleep(500);
        Actions.click(webDriver, paymentInvoicesButton);
    }

    public void clickOnRejectButtonQuickAction(WebDriver webDriver) throws InterruptedException{
        Thread.sleep(500);
        rejectButtonQuickAction.click();    }

    public String quickActionListText(WebDriver webDriver) throws InterruptedException{
        return Actions.getText(webDriver, quickActionList);
    }

    public void enterRejectionReasonQuickAction(WebDriver webDriver, String reason)throws InterruptedException {
        Actions.sendKeys(webDriver, rejectReasonFieldQuickAction, reason);
    }

    public void clickOnSubmitRejectButtonQuickAction(WebDriver webDriver)throws InterruptedException {
        Actions.click(webDriver, submitRejectButtonQuickAction);
    }

    public Boolean validateRejectionSuccessToastIsDisplayed(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(500);
        Wait.untilElementIsVisible(webDriver,rejctionSuccessToast,50L);
        return  rejctionSuccessToast.isDisplayed();
    }

    public void waitUntilRejectionSuccessToastIsInvisible(WebDriver webDriver) {
        Wait.untilElementIsInVisible(webDriver, rejctionSuccessToast, 30L);
    }

    public void waitUntilReviewSuccessToastIsInvisible(WebDriver webDriver) {
        Wait.untilElementIsInVisible(webDriver, reviewSuccessToast, 30L);
    }

    public void waitUntilReviewSuccessToastIsVisible(WebDriver webDriver) {
        Wait.untilElementIsVisible(webDriver, reviewSuccessToast, 30L);
    }

    public String rejctionSuccessToastText(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, rejctionSuccessToast);
    }

    public String getPartOfString(String inputString, String delimiter, int partNum) {
        String[] parts = inputString.split(delimiter);
        return parts[partNum];
    }

    public String getFooterNum(WebDriver webDriver) throws InterruptedException {
        return getPartOfString(itemsPerPageText(webDriver), " ", 4);
    }

    public String getNumOfInvoicesBesideAllTab(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, allInvoicesBadge);
    }

    public String getNumOfInvoicesBesideRejectedTab(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, rejectedInvoicesBadge);
    }

    public Integer countNumOfRestInvoices(WebDriver webDriver) throws InterruptedException {
        WebElement tbody = webDriver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        countRestOfInvoices = 0;
        for (WebElement row : rows) {
            if (row.getText().contains("Actions")) {
                countUploadedInvoice++;
            }
        }
        return countUploadedInvoice;
    }

    public void clickRejectedTabButton(WebDriver webDriver)throws InterruptedException {
        Actions.click(webDriver, rejectedTabButton);
    }

    public void showInvoiceDetailsFromScratch(WebDriver webDriver) throws InterruptedException {
        waitActionButtonIsClickable(webDriver);
        Thread.sleep(2500);
        Actions.click(webDriver, actionButton);
        Thread.sleep(1500);
        showInvoiceDetails(webDriver);
    }
    public void showInvoiceDetails(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(1000);
        Actions.click(webDriver, showInvoiceButton);
    }

    public Boolean validateRejectedInvoice(WebDriver driver, String invoiceName) {
        WebElement tbody = driver.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        String invoice = rows.get(0).getText();
        System.out.println("\n" + invoice);
        boolean found = false;
        if (invoice.contains(invoiceName) && invoice.contains("Rejected")) {
            found = true;
        }
        return found;
    }

    public void clickAuditTrailTab(WebDriver webDriver) throws InterruptedException{
        Actions.click(webDriver, auditTrailTab);
    }

    public String getRejectionReasonAuditTrail(WebDriver webDriver) throws InterruptedException{
        return Actions.getText(webDriver, rejectionReasonField);
    }

    public String getRejectAndActionButtonsText(WebDriver webDriver)throws InterruptedException {
        return Actions.getText(webDriver, rejectAndActionButtonsContainer);
    }

    public void waitUntilRejectionReasonFieldAppear(WebDriver webDriver) throws InterruptedException{
        Wait.untilElementIsVisible(webDriver, rejectionReasonField, 10L);
    }

    public void waitUntilAduitTrailButtonAppear(WebDriver webDriver) {
        Wait.untilElementIsVisible(webDriver, auditTrailTab, 30L);
    }

    public void waitUntilInvoiceDetailsActionButtonAppear(WebDriver webDriver) {
        Wait.untilElementIsVisible(webDriver, invoiceDetailsActionButton, 10L);
    }

    public void clickOnInvoiceDetailsActionButton(WebDriver webDriver) throws InterruptedException{
        Actions.click(webDriver, invoiceDetailsActionButton);
    }

    public void clickOnPayAsapInvoiceDetailsButton(WebDriver webDriver)throws InterruptedException {
        Actions.click(webDriver, payAsapInvoiceDetailsButton);
    }

    public void clickOnConfirmReview(WebDriver webDriver) throws InterruptedException{
        Actions.click(webDriver, confirmReview);
    }

    public void submitConfirmReview(WebDriver webDriver)throws InterruptedException {
        Actions.click(webDriver, submitConfirmReview);
    }

    public void confirmReview(WebDriver webDriver) throws InterruptedException {
        clickOnInvoiceDetailsActionButton(webDriver);
        Thread.sleep(1000);
        clickOnConfirmReview(webDriver);
        Thread.sleep(1000);
        submitConfirmReview(webDriver);
        Thread.sleep(1000);
    }

    public void clickOnActionButton(WebDriver webDriver) throws InterruptedException{
        Actions.click(webDriver, actionButton);
    }

    public void clickOnApproveButton(WebDriver webDriver) throws InterruptedException{
        Actions.click(webDriver, approveButtonQuickAction);
    }

    public void clickOnSubmitApproveButton(WebDriver webDriver) throws InterruptedException{
        Actions.click(webDriver, submitConfirmApprove);
    }

    public void approveInvoiceQuickAction(WebDriver webDriver) throws InterruptedException {
        clickOnApproveButton(webDriver);
        Thread.sleep(500);
        clickOnSubmitApproveButton(webDriver);
    }

    public void clickOnShowInvoice(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(500);
        Actions.click(webDriver, showInvoice);
    }

    public void clickOnRejectInvoiceButtonInInvoiceDetails() throws InterruptedException {
        Thread.sleep(500);
        rejectInvoiceButtonInInvoiceDetails.click();
    }

    public Boolean validateRejectionFieldEmptyErrorIsDisplayed() throws InterruptedException {
        return  rejectionFieldEmptyError.isDisplayed();
    }

    public String getInvoiceDocumentTimelineFirstActionText(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, invoiceDocumentTimelineFirstAction);
    }

    public void clickOnPayASAPToAddOrRemove(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(500);
        Actions.click(webDriver, payASAPButton);
    }

    public void clickOnConfirmPayASAPToAddOrRemove(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(500);
        Actions.click(webDriver, payASAPConfirmButton);
    }

    public void waitUntilPayASAPAddOrRemoveSuccessToastIsInvisible(WebDriver webDriver) {
        Wait.untilElementIsInVisible(webDriver, payASAPSuccessToast, 30L);
    }

    public void waitUntilPayASAPAddOrRemoveSuccessToastIsVisible(WebDriver webDriver) {
        Wait.untilElementIsVisible(webDriver, payASAPSuccessToast, 30L);
    }

    public Boolean validatePayAsapSuccessToastIsDisplayed(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(500);
        Wait.untilElementIsVisible(webDriver,payASAPSuccessToast,30L);
        return  payASAPSuccessToast.isDisplayed();
    }

    public String getPayAsapSuccessToastText(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, payASAPSuccessToast);
    }

    public String getSubmitedByFullNameAuditTrailText(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, submitedByFullNameAuditTrail);
    }

    public void waitUntilSubmitedByFullNameAuditTrailIsVisible(WebDriver webDriver) {
        Wait.untilElementIsVisible(webDriver, submitedByFullNameAuditTrail, 30L);
    }

    public void waitUntilInvoiceDocumentTimelineFirstActionIsVisible(WebDriver webDriver) {
        Wait.untilElementIsVisible(webDriver, invoiceDocumentTimelineFirstAction, 30L);
    }

    public void clickOnCloseInvoiceDetailsTabButton(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(500);
        Actions.click(webDriver, closeInvoiceDetailsTabButton);
    }


}
