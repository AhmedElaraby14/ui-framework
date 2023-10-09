package PageObjects;

import Utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VerificationPage {
WebDriver webDriver;
WebDriverWait wait;
    public VerificationPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(css = ".MuiTypography-root.MuiTypography-body1.css-6okwg4")
    public WebElement emailContainer;

    @FindBy(css = "div[class='MuiBox-root css-cnukzb'] button[type='button']")
    public WebElement resendEmailButton;



    public void validatePageTitle(WebDriver webDriver,String title) throws InterruptedException {
        Wait.untilTitleBecome(webDriver,title,20L);
    }

    public boolean verificationPageIsDisplayed() {
        emailContainer.isDisplayed();
        resendEmailButton.isDisplayed();
        return true;
    }


}
