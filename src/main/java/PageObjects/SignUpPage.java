package PageObjects;

import Managers.FileReaderManager;
import Utilities.Actions;
import Utilities.Wait;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
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

public class SignUpPage {
WebDriver webDriver;
    public SignUpPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

public String rigisteredEmail,myToken;
    public String storedEmail= rigisteredEmail;
public Boolean verificationStatus;
    @FindBy(id = "signUp-1")
    public WebElement emailFiled;

    @FindBy(id = "signUp-2")
    public WebElement firstNameFiled;

    @FindBy(id = "signUp-3")
    public WebElement lastNameFiled;

    @FindBy(id = "signUp-4")
    public WebElement passwordFiled;

    @FindBy(id = "signUp-5")
    public WebElement passwordRepeatedFiled;

    @FindBy(css = "button[type='submit']")
    public WebElement continueButton;

    @FindBy(xpath = "//div[contains(text(),'Verification email has been sent')]")
    public WebElement emailSentPopUp;

    @FindBy(xpath = "//p[contains(text(),'Please verify your email....')]")
    public WebElement verifyEmailMessage;

    @FindBy(xpath = "//p[contains(text(),\"We've sent an email confirmation to\")]")
    public WebElement verifyEmailMessage2;

    @FindBy(id = "info-1")
    public WebElement businessLegalNameFiled;

    @FindBy(name = "contactNumber")
    public WebElement phoneNumberFiled;

    @FindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
    public WebElement pemoPolicyCheckBox;

    @FindBy(xpath = "//body/div[@id='__next']/div[2]/div[2]/div[1]/form[1]/div[5]/button[1]")
    public WebElement finishButton;



    public void validateTheemailIsVerified() {
        assert verificationStatus : "Email verification failed";
    }



    private static final String TIMESTAMP_EMAIL_FILE = "timestamp_email.txt";

    public static void saveTimeStampEmail(String timeStampEmail) {
        File file = new File(TIMESTAMP_EMAIL_FILE);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(timeStampEmail);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  String getSavedTimeStampEmail() {
        try {
            return Files.readString(Paths.get(TIMESTAMP_EMAIL_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String generateTimestampEmail() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        return timestamp + "@pemo.com";
    }
    public String getTimestampEmail(){
        rigisteredEmail =generateTimestampEmail();
        saveTimeStampEmail(rigisteredEmail);
        return rigisteredEmail;
    }

    public String getTimestamp(){
        rigisteredEmail =generateTimestampEmail();
        return rigisteredEmail;
    }

    public void fillUserInformationData(WebDriver webDriver, String email, String firstName, String lastName, String password) throws InterruptedException {
        fillEmailData(webDriver, email);
        fillFirstAndLastNameData(webDriver, firstName, lastName);
        fillPasswordData(webDriver, password);
    }

    public void fillCustomizeAccountInformationData(WebDriver webDriver, String businessLegalName, String phoneNumber) throws InterruptedException {
        fillBusinessLegalNameData(webDriver, businessLegalName);
        fillPhoneNumberData(webDriver, phoneNumber);
    }

    public void validatePageTitle(WebDriver webDriver, String title) throws InterruptedException {
        Wait.untilTitleBecome(webDriver, title, 20L);
    }

    public boolean signUpPageIsDisplayed() {
        emailFiled.isDisplayed();
        firstNameFiled.isDisplayed();
        lastNameFiled.isDisplayed();
        passwordFiled.isDisplayed();
        passwordRepeatedFiled.isDisplayed();
        continueButton.isDisplayed();
        return true;
    }

    public boolean customizeAccountPageIsDisplayed() {
        businessLegalNameFiled.isDisplayed();
        phoneNumberFiled.isDisplayed();
        pemoPolicyCheckBox.isDisplayed();
        return true;
    }

    public void fillEmailData(WebDriver webDriver, String email) throws InterruptedException {
        Actions.clear(webDriver, emailFiled);
        Actions.sendKeys(webDriver, emailFiled, email);
    }

    public void fillFirstAndLastNameData(WebDriver webDriver, String firstName, String lastName) throws InterruptedException {
        Actions.clear(webDriver, firstNameFiled);
        Actions.sendKeys(webDriver, firstNameFiled, firstName);
        Actions.clear(webDriver, lastNameFiled);
        Actions.sendKeys(webDriver, lastNameFiled, lastName);
    }

    public void fillPasswordData(WebDriver webDriver, String password) throws InterruptedException {
        Actions.clear(webDriver, passwordFiled);
        Actions.sendKeys(webDriver, passwordFiled, password);
        Actions.clear(webDriver, passwordRepeatedFiled);
        Actions.sendKeys(webDriver, passwordRepeatedFiled, password);
    }

    public void fillBusinessLegalNameData(WebDriver webDriver, String businessLegalName) throws InterruptedException {
        Actions.clear(webDriver, businessLegalNameFiled);
        Actions.sendKeys(webDriver, businessLegalNameFiled, businessLegalName);
    }

    public void fillPhoneNumberData(WebDriver webDriver, String phoneNumber) throws InterruptedException {
        Actions.clear(webDriver, phoneNumberFiled);
        Actions.sendKeys(webDriver, phoneNumberFiled, phoneNumber);
    }

    public void clickpemoPolicyCheckBox(WebDriver webDriver) throws InterruptedException {
        pemoPolicyCheckBox.click();
       // Actions.click(webDriver, pemoPolicyCheckBox);
    }

    public void clickContinueButton(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, continueButton);
    }

}
