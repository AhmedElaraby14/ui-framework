package PageObjects;

import Utilities.Actions;
import Utilities.Wait;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LandingPage {
        WebDriver webDriver;
    public LandingPage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 30), this);
    }

    public String nameText;
    @FindBy(css = ".MuiBox-root.css-new6k5")
    private WebElement headerLogoButton;

    @FindBy(xpath = "//p[normalize-space()='Invoices']")
    private WebElement invoicesButton;

    @FindBy(xpath = "//p[normalize-space()='Archive']")
    private WebElement archiveButton;
    @FindBy(xpath = "//p[normalize-space()='Teams & members']")
    private WebElement teamsAndMembersButton;

    @FindBy(css = ".MuiTypography-root.MuiTypography-body1.css-ovnbdm")
    private WebElement roleElement;

    @FindBy(css = ".MuiTypography-root.MuiTypography-body1.css-9wl6tw")
    private WebElement userFullName;

    @FindBy(css = ".MuiTypography-root.MuiTypography-body1.css-j7ojaa")
    private WebElement businessName;

    @FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1adqb0']")
    private WebElement logOutButton;

    @FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1fob25r']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-9wl6tw']")
    private WebElement fullNameLabel;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk']")
    private WebElement profileSettingButton;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameTextField;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameTextField;

    @FindBy(id = "signUp-3-label")
    private WebElement changePasswordButton;

    @FindBy(id = "profile-1")
    private WebElement oldPasswordTextBox;

    @FindBy(id = "profile-2")
    private WebElement newPasswordTextBox;

    @FindBy(id = "profile-3")
    private WebElement repeatNewPasswordTextBox;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-8ccmww']")
    private WebElement errorMessageContainer;
    @FindBy(xpath = "//input[@class='MuiInputBase-input MuiFilledInput-input MuiInputBase-inputSizeSmall Mui-readOnly MuiInputBase-readOnly css-7ze59x']")
    private WebElement emailTextBox;

    @FindBy(xpath = "//div[@class='whiteBg d-flex align-items-center justify-content-between mt-2 borderNeutral50 br2 p-2']")
    private WebElement autoEmailTextBox;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-180pnjh']")
    private WebElement savePasswordButton;

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast-theme--dark Toastify__toast--success']")
    private WebElement successToastContainer;

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast-theme--dark Toastify__toast--error']")
    private WebElement errorToastContainer;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation css-c6kse8']")
    private WebElement closeChangePasswordTapButton;

    @FindBy(id = "profile-3-helper-text")
    private WebElement errorMessageRepeatedPasswordContainer;

    @FindBy(xpath = "//p[normalize-space()='Settings']")
    private WebElement settingButton;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedError MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-outlined MuiButton-outlinedError MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-disableElevation css-1yuqqrf']")
    private WebElement dashboardCompanyKybVerify;


    public boolean defaultHomePageIsDisplayed(WebDriver webDriver) {
        headerLogoButton.isDisplayed();
        invoicesButton.isDisplayed();
        return true;
    }

    public String getRoleText(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, roleElement);
    }

    public String dashboardCompanyKybVerifyText(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, dashboardCompanyKybVerify);
    }

    public String getUserFullName(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, userFullName);
    }

    public String getBusinessNameText(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, businessName);
    }

    public void openInvoicesPage(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, invoicesButton);
    }

    public void openTeamsAndMembersPage(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, teamsAndMembersButton);
    }

    public void openProfileSettingList(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, profileSettingButton);
    }

    public void openMyAccountSetting(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, myAccountButton);
    }

    public void changeFirstName(WebDriver webDriver, String firstName) throws InterruptedException {
        firstNameTextField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        firstNameTextField.sendKeys(Keys.DELETE);
        nameText = "FirstName" + RandomStringUtils.randomAlphabetic(3);
        Actions.sendKeys(webDriver, firstNameTextField, firstName);
        Actions.click(webDriver, fullNameLabel);
        Thread.sleep(1000);
    }

    public void changeLastName(WebDriver webDriver, String lastName) throws InterruptedException {
        lastNameTextField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        lastNameTextField.sendKeys(Keys.DELETE);
        Actions.sendKeys(webDriver, lastNameTextField, lastName);
        Actions.click(webDriver, fullNameLabel);
        Thread.sleep(1000);
    }

    public String getUniqueName() {
        String generateUniqueName = RandomStringUtils.randomAlphabetic(3);
        return generateUniqueName;
    }

    public String getUserFirstName(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, firstNameTextField);
    }

    public String getUserLastName(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, lastNameTextField);
    }

    public void clickOnChangePassword(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, changePasswordButton);
    }

    public void enterOldPassword(WebDriver webDriver, String oldPassword) throws InterruptedException {
        Actions.sendKeys(webDriver, oldPasswordTextBox, oldPassword);
    }

    public void enterNewPassword(WebDriver webDriver, String newPassword) throws InterruptedException {
        Actions.sendKeys(webDriver, newPasswordTextBox, newPassword);
    }

    public void enterRepeatNewPassword(WebDriver webDriver, String newPassword) throws InterruptedException {
        Actions.sendKeys(webDriver, repeatNewPasswordTextBox, newPassword);
    }

    public void changePassword(WebDriver webDriver, String oldPassword, String newPassword) throws InterruptedException {
        clickOnChangePassword(webDriver);
        enterOldPassword(webDriver, oldPassword);
        enterNewPassword(webDriver, newPassword);
        enterRepeatNewPassword(webDriver, newPassword);
        clickOnSavePasswordButton(webDriver);
    }

    public String getErrorMessage(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, errorMessageContainer);
    }

    public String getEmailText(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, emailTextBox);
    }

    public String getAutomatedEmailText(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, autoEmailTextBox);
    }

    public void tryToChangeEmailAndAutoEmail(WebDriver webDriver) throws InterruptedException {
        Actions.sendKeys(webDriver, emailTextBox, "hello");
        Actions.sendKeys(webDriver, autoEmailTextBox, "bye");
    }

    public void clickOnLogOut(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, logOutButton);
        Thread.sleep(1000);
    }

    public void clickOnSavePasswordButton(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, savePasswordButton);
        Thread.sleep(1000);
    }

    public String getSuccessToast(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, successToastContainer);
    }

    public void waitUntilSuccessToastInVisible(WebDriver webDriver) throws InterruptedException {
        Wait.untilElementIsInVisible(webDriver,successToastContainer,20L);
    }

    public String getErrorToast(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, errorToastContainer);
    }

    public void waitUntilSuccessMessageInvisible(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, fullNameLabel);
    }

    public void waitUntilErrorMessageInvisible(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, closeChangePasswordTapButton);
    }

    public void closeChangePasswordTap(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, closeChangePasswordTapButton);
    }

    public String getErrorMessageRepeatedPasswordContainer(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, errorMessageRepeatedPasswordContainer);
    }

    public void openSettingPage(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, settingButton);
    }

    public void openArchivePage(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, archiveButton);
    }


}





