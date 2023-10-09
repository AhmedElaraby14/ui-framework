package PageObjects;
import Managers.FileReaderManager;
import Utilities.Actions;
import Utilities.Wait;
import dev.failsafe.internal.util.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static io.restassured.RestAssured.given;

public class TeamsAndMembersPage {
    FileReaderManager fileReaderManager;
    private final WebDriver webDriver;
    public static String businessName;
    public static String cookie;
    public String invitationToken;
    public String teamName;
    public String teamDesc;
    public String memberEmail;
    public String apiInvitationEmail;
    public TeamsAndMembersPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = ".MuiTypography-root.MuiTypography-body1.css-1982up9")
    private WebElement inviteUserButton;
    @FindBy(css = ".MuiButtonBase-root.MuiButton-root.MuiButton-contained.MuiButton-containedSecondary.MuiButton-sizeLarge.MuiButton-containedSizeLarge.MuiButton-disableElevation.MuiButton-root.MuiButton-contained.MuiButton-containedSecondary.MuiButton-sizeLarge.MuiButton-containedSizeLarge.MuiButton-disableElevation.css-nzv8b4")
    private WebElement submitInviteUserButton;
    @FindBy(xpath = "//input[contains(@class, 'MuiInputBase-input') and contains(@class, 'MuiFilledInput-input') and contains(@class, 'MuiAutocomplete-input')]")
    private WebElement invitationEmailTextbox;
    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-s86i8e'])[1]")
    private WebElement membersTab;
    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-s86i8e'])[2]")
    private WebElement teamsTab;
    @FindBy(css = ".MuiButtonBase-root.MuiButton-root.MuiButton-text.MuiButton-textPrimary.MuiButton-sizeMedium.MuiButton-textSizeMedium.MuiButton-disableElevation.btn-ocean-disabled.css-1xt2f85")
    private WebElement submitFileButton;
    @FindBy(css = ".Toastify__toast-body")
    private WebElement successfulMessage;
    @FindBy(css = "li:nth-child(3)")
    private WebElement fortyFiveValuesChoice;
    @FindBy(xpath = "//*[@id=\"drawer-container\"]/div[1]/div[2]/div[2]/div/div[2]")
    private WebElement itemsPerPageMenu;
    @FindBy(css = ".MuiTypography-root.MuiTypography-body1.css-1982up9")
    private WebElement createTeamButton;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement teamNameField;
    @FindBy(xpath = "//input[@name='description']")
    private WebElement teamDescField;
    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium MuiAutocomplete-popupIndicator css-uge3vf'])[1]")
    private WebElement teamLeadSelector;
    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium MuiAutocomplete-popupIndicator css-uge3vf'])[2]")
    private WebElement teamMembersSelector;
    @FindBy(xpath = "//li[@class='MuiAutocomplete-option MuiBox-root css-1lekzkb']")
    private List<WebElement> numsOfAvailableTeamLead;
    @FindBy(xpath = "//ul[@role='listbox']")
    private WebElement chooseTeamMember;
    @FindBy(id = "NymCardTeams-createATeam-2")
    private WebElement submitTeamButton;
    @FindBy(xpath = "(//div[@role='presentation'])[1]")
    private WebElement checkLeadList;
    @FindBy(xpath = "//div[@class='MuiBox-root css-7ov69l']")
    private  List<WebElement> numOfTeamMembers;
    @FindBy(xpath = "//div[@class='MuiStack-root css-1fnjbtv']")
    private  WebElement textOfTeamPage;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-5e674r']")
    private  WebElement teamDetailsLabel;
    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[2]")
    private  WebElement teamTabCloseButton;
    @FindBy(xpath = "//div[@class='MuiBox-root css-1kx4xl8']")
    private  WebElement teamLeadRole;
    @FindBy(xpath = "(//input[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3'])[2]")
    private  WebElement toggleCardButton;
    @FindBy(xpath = "//span[@class='MuiButtonBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary css-48ql8p']")
    private  WebElement toggleCardOff;
    @FindBy(xpath = "//span[@class='MuiButtonBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary Mui-checked PrivateSwitchBase-root MuiSwitch-switchBase MuiSwitch-colorPrimary Mui-checked Mui-checked css-48ql8p']")
    private  WebElement toggleCardOn;
    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1gzn3wv'])[2]")
    private  WebElement grantTeamLeaderRightsButton;
    @FindBy(xpath = "(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1fob25r'])[1]")
    private  WebElement assignTeam;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-7cfwrs']")
    private  WebElement memberWithoutTeam;
    @FindBy(xpath = "(//div[@class='MuiSelect-select MuiSelect-filled MuiInputBase-input MuiOutlinedInput-input css-18e3avr'])[2]")
    private  WebElement teamsList;
    @FindBy(xpath = "//span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-njbo8z']")
    private  WebElement teamRemovingButton;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-ikuczp']")
    private  WebElement memberWithTeam;
    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[47]")
    private  WebElement closeMemberTab;
    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-nxbbgu'])[1]")
    private  WebElement memberEmailContainer;
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-fe0b99']")
    private  WebElement teamMembersEmailsContainer;
    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-nxbbgu'])[2]")
    private  WebElement teamNameContainer;



    public Boolean validateUser(WebDriver driver, String email, String role, String status) {
        // Locate the table
        WebElement table = driver.findElement(By.xpath("//*[@id=\"drawer-container\"]/div[1]/div[2]/div[1]/table/tbody"));

        // Find all the rows in the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Iterate through the rows and check the email, role, and status
        boolean found = false;
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));

            // Ensure the row has the correct number of columns
            if (columns.size() == 5) {
                String userEmail = columns.get(0).getText();
                String userRole = columns.get(1).getText();
                String userStatus = columns.get(3).getText();
                System.out.println(userRole);
                if (userEmail.contains(email) && role.contains(userRole.replace(" ","_").toLowerCase()) && userStatus.contains(status)) {
                    found = true;
                    System.out.println("User found with email: " + email + ", role: " + userRole + ", and status: " + status);
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("User not found with email: " + email + ", role: " + role + ", and status: " + status);
        }
        return found;
    }


    public void split(String multiPdfPath) throws InterruptedException {
    String[] multiPdfsPaths = multiPdfPath.split(",");
    for (String multiPdfsPath : multiPdfsPaths) {
        System.out.println(multiPdfsPath);
        Thread.sleep(2000);
    }
    }
    public void clickOnInviteUserButton(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, inviteUserButton);
    }

    public void successfulMessageDisappeared(WebDriver webDriver) throws InterruptedException {
        Wait.untilElementIsInVisible(webDriver, successfulMessage, 20L);
    }

    public void chooseFortyFiveItemsChoice(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, itemsPerPageMenu);
        Actions.click(webDriver, fortyFiveValuesChoice);
        Thread.sleep(5000);
    }

    public void submitTheinvitation(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, submitInviteUserButton);
    }

    public String getSuccessfulMessage(WebDriver webDriver) throws InterruptedException {
        Wait.untilElementIsVisible(webDriver, successfulMessage, 5L);
        return Actions.getText(webDriver,successfulMessage);
    }

    public void selectMemberInvitationRole(WebDriver driver, String text) throws InterruptedException {
        List<WebElement> radioButtons = driver.findElements(By.xpath("//div[@role='button']"));

        // Iterate through the radio buttons and select the one matching the given text
        for (WebElement radioButton : radioButtons) {
            System.out.println(radioButton.getText());
            if (radioButton.getText().contains(text)) {
                Actions.click(driver, radioButton);
                break;
            }
        }
    }

    public boolean teamsAndMembersPageIsDisplayed(WebDriver webDriver) {
        inviteUserButton.isDisplayed();
        teamsTab.isDisplayed();
        membersTab.isDisplayed();
        return true;
    }

    public void splitMails(WebDriver webDriver, String memberEmail) throws InterruptedException {
        String[] membersEmails = memberEmail.split(",");
        for (String membersEmail : membersEmails) {
            Actions.sendKeys(webDriver, invitationEmailTextbox, membersEmail + ",");
        }
    }

    public void clickOnTeamTab(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(1500);
        Actions.click(webDriver, teamsTab);
    }

    public void clickOnCreateTeamButton(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, createTeamButton);
    }

    public void fillTeamNameAndDesc(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(2000);
        teamName = generateUniqueTeamName();
        enterTeamName(webDriver, teamName);
        Thread.sleep(1000);
        teamDesc = generateUniqueTeamDesc();
        enterDescName(webDriver, teamDesc);
        Thread.sleep(1000);
    }

    public void enterTeamName(WebDriver webDriver, String teamName) throws InterruptedException {
        Actions.sendKeys(webDriver, teamNameField, teamName);
    }

    public void enterDescName(WebDriver webDriver, String teamDesc) throws InterruptedException {
        Actions.clear(webDriver, teamDescField);
        Actions.sendKeys(webDriver, teamDescField, teamDesc);
    }

    public void selectTeamLead(WebDriver webDriver, int numsOfTeamLead) throws InterruptedException {
        for (int i = 0; i < numsOfTeamLead; i++) {
            Actions.click(webDriver, teamLeadSelector);
            int numsOfAvailableTeamMembers = numsOfAvailableTeamLead.size();
            if (numsOfTeamLead <= numsOfAvailableTeamMembers) {
                WebElement chooseTeamLead = webDriver.findElement(By.xpath("//li[@data-option-index='" + i + "']"));
                Actions.click(webDriver, chooseTeamLead);
                Thread.sleep(2000);
            } else {
                System.out.println("num of team members less than the required you have only " + numsOfAvailableTeamMembers);
                Actions.click(webDriver, teamLeadSelector);
                break;
            }
        }
    }

    public void selectTeamMembers(WebDriver webDriver, int numsOfTeamMember) throws InterruptedException {
        for (int i = 0; i < numsOfTeamMember; i++) {
            Actions.click(webDriver, teamMembersSelector);
            int numsOfAvailableTeamMembers = numsOfAvailableTeamLead.size();
            if (numsOfTeamMember <= numsOfAvailableTeamMembers) {
                WebElement chooseTeamMember = webDriver.findElement(By.xpath("//li[@data-option-index='" + i + "']"));
                Actions.click(webDriver, chooseTeamMember);
                Thread.sleep(2000);
            } else {
                System.out.println("num of team members less than the required you have only " + numsOfAvailableTeamMembers);
                Actions.click(webDriver, teamMembersSelector);
                break;
            }
        }
    }

    public void submitTheTeam(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, submitTeamButton);
    }

    public static String generateUniqueTeamName() {
        String generateUniqueTeamName = RandomStringUtils.randomAlphanumeric(5);
        return "Team" + generateUniqueTeamName;
    }

    public static String generateUniqueTeamDesc() {
        String generateUniqueTeamDesc = RandomStringUtils.randomAlphanumeric(5);
        return "Desc" + generateUniqueTeamDesc;
    }

    public int numOfTeamMembers(WebDriver webDriver) throws InterruptedException {
        int numsOfTeamLead = numOfTeamMembers.size();
        return numsOfTeamLead;
    }

    public String validateCreationOfTheTeamWithCorrectNameAndDesc(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(2000);
        return Actions.getText(webDriver,textOfTeamPage).toLowerCase();
    }

    public void selectTheCreatedTeam(WebDriver webDriver) throws InterruptedException {
        WebElement createdTeam = webDriver.findElement(By.xpath("//p[@title='" + teamName + "']"));
        Actions.click(webDriver, createdTeam);
        Thread.sleep(2000);
    }

    public void editTeamName(WebDriver webDriver) throws InterruptedException {
        teamNameField.sendKeys(" New");
        Actions.click(webDriver, teamDetailsLabel);
        Thread.sleep(2000);
    }

    public void editTeamDesc(WebDriver webDriver) throws InterruptedException {
        teamDescField.sendKeys(" New");
        Actions.click(webDriver, teamDetailsLabel);
        Thread.sleep(2000);
    }

    public void closeTeamTab(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, teamTabCloseButton);
    }

    public String getTheRoleOfTeamLead(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(1000);
        return Actions.getText(webDriver,teamLeadRole).toLowerCase();
    }

    public boolean validateCardToggleIsOff(WebDriver webDriver) {
        toggleCardOff.isDisplayed();
        return true;
    }

    public boolean validateCardToggleIsOn(WebDriver webDriver) throws InterruptedException {
        toggleCardOn.isDisplayed();
        return true;
    }

    public void clickOnCardToggle(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, toggleCardButton);
        Thread.sleep(1000);
    }

    public void grantTeamLeaderRights(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, grantTeamLeaderRightsButton);
        Thread.sleep(2000);
    }

    public void downgradeTeamLead(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, grantTeamLeaderRightsButton);
        Thread.sleep(2000);
    }

    public void selectMemberWithoutTeam(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, memberWithoutTeam);
        Thread.sleep(2000);
    }

    public void selectMemberWithTeam(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, memberWithTeam);
        Thread.sleep(2000);
    }

    public void openTeamList(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, teamsList);
        Thread.sleep(2000);
    }

    public void removeMemberFromTeam(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, teamRemovingButton);
        Thread.sleep(2000);
    }

    public void assignTeamForTheMember(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, assignTeam);
        Thread.sleep(2000);
    }

    public String getTheTeamName(WebDriver webDriver) throws InterruptedException {
        teamName = Actions.getText(webDriver,assignTeam);
        System.out.println(teamName);
        return teamName;
    }

    public void closeMemberTab(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, closeMemberTab);
    }

    public String getTheMemberEmail(WebDriver webDriver) throws InterruptedException {
        memberEmail = Actions.getText(webDriver,memberEmailContainer);
        System.out.println(memberEmail);
        return memberEmail;
    }

    public String getTeamName(WebDriver webDriver) throws InterruptedException {
        return teamNameContainer.getText();
    }

    public Boolean validateTheMemberIsAddedToTheTeamMembers(WebDriver driver) {
        List<WebElement> teamMemberEmails = driver.findElements(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-fe0b99']"));
        boolean x = false;
        // Iterate through the radio buttons and select the one matching the given text
        for (WebElement teamMemberEmail : teamMemberEmails) {
            System.out.println(teamMemberEmail.getText());
            if (teamMemberEmail.getText().contains(memberEmail)) {
                x = true;
                break;
            }
        }
        return x;
    }

    public Boolean validateUserCantCreateTeam(WebDriver webDriver) {
        boolean x = true;
        try {
            if (createTeamButton.isDisplayed()) {
                x = false;
            }
        } catch (NoSuchElementException e) {
            System.out.println("This user can't create a team");
        }
        return x;
    }

    public String getTeamMemberEmail(WebDriver webDriver) throws InterruptedException {
        memberEmail = Actions.getText(webDriver,teamMembersEmailsContainer);
        System.out.println(memberEmail);
        return memberEmail;
    }

    public void selectMemberWithSpecificRole(WebDriver webDriver, String text) throws InterruptedException {
        Actions.click(webDriver, teamMembersSelector);
        Thread.sleep(2000);
        List<WebElement> memberRoles = webDriver.findElements(By.xpath("//li[@class='MuiAutocomplete-option MuiBox-root css-1lekzkb']"));
        Thread.sleep(1000);

        System.out.println(memberRoles);

        // Iterate through the radio buttons and select the one matching the given text
        for (WebElement memberRole : memberRoles) {
            System.out.println(memberRole.getText());
            if (memberRole.getText().toLowerCase().contains(text)) {
                Actions.click(webDriver, memberRole);
                break;
            }
        }
    }


}