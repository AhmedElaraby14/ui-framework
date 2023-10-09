package PageObjects;

import Managers.FileReaderManager;
import Utilities.Actions;
import Utilities.Wait;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class LoginPage {
    WebDriver webDriver;
public String forgettenPasswordEmail,forgettenPasswordToken,newPassword,oldPassword;
public Boolean  verificationStatus;
    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(xpath = "//input[@id='signIn-1']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@id='signIn-2']")
    public WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    public WebElement signInButton;

    @FindBy(css = ".MuiTypography-root.MuiTypography-body1.css-1b21kwz")
    public WebElement signUpButton;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1fn1bxk']")
    public WebElement forgotPasswordButton;
    @FindBy(id = "forgotPassword-1")
    public WebElement resetYourPasswordTextFiled;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiLoadingButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiLoadingButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-st1kxq']")
    public WebElement sendResetEmailButton;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeLarge MuiButton-textSizeLarge MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeLarge MuiButton-textSizeLarge MuiButton-disableElevation css-o8rlm6']")
    public WebElement resendPasswordEmailButton;

    @FindBy(xpath = "//div[@class='MuiBox-root css-11kgo8y']")
    public WebElement emailSentMessage;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-6okwg4']")
    public WebElement forgetPasswordEmailContainer;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement blockedMessageForForgettenPassword;

    @FindBy(xpath = "//div[contains(text(),'Incorrect Email or Password!')]")
    public WebElement incorrectEmailPasswordMessage;

    @FindBy(xpath = "//*[@id=\"mui-1\"]/button")
    public WebElement closeWelcomeMsg;

    @FindBy(tagName = "title")
    private WebElement loginHeaderTitle;

    @FindBy(css = ".MuiTypography-root.MuiTypography-body1.css-1dxgpz5")
    private WebElement forgetPasswordQuestionText;

    public void login(WebDriver webDriver, String email, String password) throws InterruptedException {
        fillEmailData(webDriver, email);
        fillPasswordData(webDriver, password);
       // Thread.sleep(500);
        clickSignInButton(webDriver);
    }

    public void validatePageTitle(WebDriver webDriver, String title) throws InterruptedException {
        Wait.untilTitleBecome(webDriver, title, 80L);
    }

    public boolean emailLoginPageIsDisplayed() {
        emailField.isDisplayed();
        passwordField.isDisplayed();
        return true;
    }

    public void openSignUpPage(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, signUpButton);
    }

    public String getQuestionForgetPasswordText() throws InterruptedException {
        return Actions.getText(webDriver, forgetPasswordQuestionText);
    }

    public void fillEmailData(WebDriver webDriver, String email) throws InterruptedException {
        emailField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        emailField.sendKeys(Keys.DELETE);
        Actions.click(webDriver, emailField);
        Actions.sendKeys(webDriver, emailField, email);
    }

    public void fillPasswordData(WebDriver webDriver, String password) throws InterruptedException {
        passwordField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        passwordField.sendKeys(Keys.DELETE);
        Actions.click(webDriver, passwordField);
        Actions.sendKeys(webDriver, passwordField, password);
    }

    public void clickSignInButton(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, signInButton);
    }

    public void clickResetPasswordButton(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, forgotPasswordButton);
    }

    public void enterForgettenPasswordEmail(WebDriver webDriver, String email) throws InterruptedException {
        Actions.sendKeys(webDriver, resetYourPasswordTextFiled, email);
    }

    public void clickSendResetEmailPasswordButton(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, sendResetEmailButton);
    }

    public boolean forgettenPasswordEmailConfirmationPageIsDisplayed() {
        forgetPasswordEmailContainer.isDisplayed();
        emailSentMessage.isDisplayed();
        return true;
    }

    public String getConfirmationForForgettenEmail(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, emailSentMessage);
    }

    public String generateTimestampPassword() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        return "Fox@" + timestamp;
    }

    public String getTimestampNewPassword() {
        newPassword = generateTimestampPassword();
        saveTimeStampPassword(newPassword);
        return newPassword;
    }

    private static final String TIMESTAMP_Password_FILE = "timestamp_password.txt";

    public static void saveTimeStampPassword(String timeStampPassword) {
        File file = new File(TIMESTAMP_Password_FILE);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(timeStampPassword);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSavedTimeStampPassword() {
        try {
            return Files.readString(Paths.get(TIMESTAMP_Password_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getBlockMessageForForgettenPassword(WebDriver webDriver) throws InterruptedException {
        Wait.untilElementIsVisible(webDriver, blockedMessageForForgettenPassword, 5L);
        return blockedMessageForForgettenPassword.getText();
    }

    public void clickResendPasswordEmailButton(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, resendPasswordEmailButton);
    }

}
