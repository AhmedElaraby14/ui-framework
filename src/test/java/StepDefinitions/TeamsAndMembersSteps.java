package StepDefinitions;
import Managers.FileReaderManager;
import PageObjects.*;
import Utilities.TestContext;
import Utilities.Wait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import javax.swing.text.Utilities;

public class TeamsAndMembersSteps {
    TestContext testContext;
    LoginPage loginPage;
    SignUpPage signUpPage;
    VerificationPage verificationPage;
    LandingPage landingPage;
    TeamsAndMembersPage teamsAndMembersPage;

    public TeamsAndMembersSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        signUpPage = testContext.getPageObjectManager().getSignUpPage();
        verificationPage = testContext.getPageObjectManager().getVerificationPagePage();
        landingPage = testContext.getPageObjectManager().getLandingPage();
        teamsAndMembersPage = testContext.getPageObjectManager().getTeamsAndMembersPage();

    }

    @When("User go to Teams and Members Page")
    public void userGoToTeamsAndMembersPage() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        landingPage.openTeamsAndMembersPage(webDriver);
        Thread.sleep(2000);
    }

    @Then("Validate Teams and Members Page is displayed")
    public void validateTeamsAndMembersPageIsDisplayed() {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertTrue(teamsAndMembersPage.teamsAndMembersPageIsDisplayed(webDriver));
        String actualTeamsAndMembersPageHeaderTitle = webDriver.getTitle();
        Assert.assertEquals(actualTeamsAndMembersPageHeaderTitle, "Pemo | Teams & members", "Wrong Text for Title Page");
    }

    @When("User click invite user")
    public void userClickInviteUser() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.clickOnInviteUserButton(webDriver);
        Thread.sleep(2000);
    }

    @And("Enter Member's email {string}")
    public void enterMemberSEmail(String memberEmail) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.splitMails(webDriver,FileReaderManager.getInstance().getConfigFileReader().getProperty(memberEmail));
    }

    @And("Select Account access level {string}")
    public void selectAccountAccessLevel(String accountType) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.selectMemberInvitationRole(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(accountType));
    }

    @And("User submit the invitation")
    public void userSubmitTheInvitation() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.submitTheinvitation(webDriver);
    }

    @Then("Validate invitation sent successfully")
    public void validateInvitationSentSuccessfully() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        System.out.println(teamsAndMembersPage.getSuccessfulMessage(webDriver));
        Assert.assertTrue(teamsAndMembersPage.getSuccessfulMessage(webDriver).toLowerCase().contains("sent successfully"), "The toast message is not as expected.");
    }

    @Then("Login with API {string} and {string}")
    public void loginWithAPIAnd(String email, String password) {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        email = FileReaderManager.getInstance().getConfigFileReader().getProperty(email);
        if ("registeredEmail".equals(email)) {
            email = signUpPage.getSavedTimeStampEmail();
        }
        teamsAndMembersPage.loginByUsingResendAPI(email, FileReaderManager.getInstance().getConfigFileReader().getProperty(password));
    }

    @When("Send Invitation with API to memberEmail with access level {string}")
    public void send_invitation_with_api_to_member_email_with_access_level(String accountType) {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.apiInvitationEmail = FileReaderManager.getInstance().getConfigFileReader().getProperty(accountType) + signUpPage.getTimestamp();
        System.out.println(teamsAndMembersPage.apiInvitationEmail);
        teamsAndMembersPage.sendInvitationByUsingResendAPI(teamsAndMembersPage.apiInvitationEmail, FileReaderManager.getInstance().getConfigFileReader().getProperty(accountType));
    }

    @When("The member activate the invitation with {string}, {string} and {string}")
    public void activateTheInvitationWithAnd(String firstName, String lastName, String password) {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.verifyInvitationUsingAPI(FileReaderManager.getInstance().getConfigFileReader().getProperty(firstName), FileReaderManager.getInstance().getConfigFileReader().getProperty(lastName), FileReaderManager.getInstance().getConfigFileReader().getProperty(password));
    }

    @And("Validate member is added with the same email and {string}")
    public void validateMemberIsAddedWithTheSameAnd(String accountType) {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertTrue(teamsAndMembersPage.validateUser(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(accountType) + signUpPage.rigisteredEmail, FileReaderManager.getInstance().getConfigFileReader().getProperty(accountType), "Pending"));
    }

    @When("Teams and Members Page views forty five items")
    public void teamsAndMembersPageViewsFortyFiveItems() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.chooseFortyFiveItemsChoice(webDriver);
    }

    @Given("Wait until successfull message disappeared")
    public void waitUntilSuccessfullMessageDisappear() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.successfulMessageDisappeared(webDriver);
    }

    @Then("Validate member with memberEmail and {string} is active status")
    public void validate_member_with_member_email_and_is_active_status(String accountType) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(1000);
        webDriver.navigate().refresh();
        Thread.sleep(2000);
        teamsAndMembersPage.validateUser(webDriver, FileReaderManager.getInstance().getConfigFileReader().getProperty(accountType) + signUpPage.rigisteredEmail, FileReaderManager.getInstance().getConfigFileReader().getProperty(accountType), "Active");
    }

    @Then("Admin Open Team Tab")
    public void adminOpenTeamTab() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        webDriver.navigate().refresh();
        Thread.sleep(2000);
        teamsAndMembersPage.clickOnTeamTab(webDriver);
        Thread.sleep(1000);
    }

    @And("Admin create the team with team name and descreption")
    public void adminCreateTeam() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(2000);
        teamsAndMembersPage.fillTeamNameAndDesc(webDriver);
    }

    @And("Admin assign team lead {string}")
    public void adminAssignTeamLead(String numsOfTeamLead) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.selectTeamLead(webDriver, Integer.parseInt(FileReaderManager.getInstance().getConfigFileReader().getProperty(numsOfTeamLead)));
        Thread.sleep(1000);
        teamsAndMembersPage.getTeamMemberEmail(webDriver);
    }

    @And("Admin assign team member {string}")
    public void adminAssignTeamMember(String numsOfTeamMember) throws InterruptedException {
        Thread.sleep(1500);
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.selectTeamMembers(webDriver, Integer.parseInt(FileReaderManager.getInstance().getConfigFileReader().getProperty(numsOfTeamMember)));
        Thread.sleep(1000);
    }

    @And("Admin submit the creation")
    public void adminSubmitTheCreation() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.submitTheTeam(webDriver);
    }

    @Then("Validate nums of team members equals {string} plus {string}")
    public void validateNumsOfTeamMembers(String numsOfTeamMember, String numsOfTeamLead) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(2000);
        System.out.println(teamsAndMembersPage.numOfTeamMembers(webDriver));
        Assert.assertTrue(teamsAndMembersPage.numOfTeamMembers(webDriver) == Integer.parseInt(FileReaderManager.getInstance().getConfigFileReader().getProperty(numsOfTeamMember)) + Integer.parseInt(FileReaderManager.getInstance().getConfigFileReader().getProperty(numsOfTeamLead)), "Num of team members not equals the required please check");
    }

    @Then("Validate creation of the team with correct name and desc")
    public void validateCreationOfTheTeamWithCorrectNameAndDescription() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        System.out.println(teamsAndMembersPage.teamName);
        Thread.sleep(4000);
        Assert.assertTrue(teamsAndMembersPage.validateCreationOfTheTeamWithCorrectNameAndDesc(webDriver).contains(teamsAndMembersPage.teamName.toLowerCase()), "Team name not found");
        System.out.println(teamsAndMembersPage.teamDesc);
        Assert.assertTrue(teamsAndMembersPage.validateCreationOfTheTeamWithCorrectNameAndDesc(webDriver).contains(teamsAndMembersPage.teamDesc.toLowerCase()), "Team description not found");
    }

    @Given("Admin open the created team")
    public void adminOpenTheCreatedTeam() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.selectTheCreatedTeam(webDriver);
    }

    @When("Admin edit the team name")
    public void adminEditTheTeamName() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.editTeamName(webDriver);
        Thread.sleep(1000);
    }

    @And("Admin edit the team desc")
    public void adminEditTheTeamDescription() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.editTeamDesc(webDriver);
        Thread.sleep(1000);
    }

    @Then("Validate nums of team members {string} plus {string} changed successfully")
    public void validateNumsOfTeamMembersPlus(String numsOfTeamMember, String numsOfTeamLead) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(2000);
        Assert.assertTrue(teamsAndMembersPage.numOfTeamMembers(webDriver) == ((Integer.parseInt(FileReaderManager.getInstance().getConfigFileReader().getProperty(numsOfTeamMember)) * 2) + (Integer.parseInt(FileReaderManager.getInstance().getConfigFileReader().getProperty(numsOfTeamLead)) * 2)), "Num of team members not equals the required please check");
    }

    @When("Admin close team creation tab")
    public void adminCloseTeamCreationTab() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.closeTeamTab(webDriver);
    }

    @Then("Validate team name and desc edited successfully")
    public void validateTeamNameAndDescriptionEditedSuccessfully() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(1000);
        Assert.assertTrue(teamsAndMembersPage.validateCreationOfTheTeamWithCorrectNameAndDesc(webDriver).contains(teamsAndMembersPage.teamName.toLowerCase() + " new"), "Team name not found");
        Assert.assertTrue(teamsAndMembersPage.validateCreationOfTheTeamWithCorrectNameAndDesc(webDriver).contains(teamsAndMembersPage.teamDesc.toLowerCase() + " new"), "Team description not found");
    }

    @And("Validate role of team member {string}")
    public void validateRoleOfTeamMember(String type) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(1000);
        System.out.println(teamsAndMembersPage.getTheRoleOfTeamLead(webDriver));
        Assert.assertTrue(teamsAndMembersPage.getTheRoleOfTeamLead(webDriver).contains(FileReaderManager.getInstance().getConfigFileReader().getProperty(type)), "Role of team member is wrong");
    }

    @And("Validate card toggle is off")
    public void validateCardToggleIsOff() {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertTrue(teamsAndMembersPage.validateCardToggleIsOff(webDriver));
    }

    @When("Admin change card permission for a team lead")
    public void adminChangeCardPermissionForATeamLead() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.clickOnCardToggle(webDriver);
        Thread.sleep(3000);
    }

    @Then("Validate card toggle is on")
    public void validateCardToggleIsOn() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Thread.sleep(1000);
        Assert.assertTrue(teamsAndMembersPage.validateCardToggleIsOn(webDriver));
    }

    @When("Admin Promote a team member")
    public void adminPromoteATeamMember() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.grantTeamLeaderRights(webDriver);
        Thread.sleep(2000);
    }

    @When("Admin Downgrade a team lead")
    public void adminDowngradeATeamLead() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.downgradeTeamLead(webDriver);
        Thread.sleep(2000);
    }

    @When("Admin select member without a team")
    public void adminSelectMemberWithoutATeam() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.selectMemberWithoutTeam(webDriver);
        Thread.sleep(1000);
        teamsAndMembersPage.getTheMemberEmail(webDriver);
    }

    @And("Admin open the team list")
    public void adminOpenTheTeamList() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.openTeamList(webDriver);
    }

    @And("Admin choose the team for this member")
    public void adminChooseTheTeamForThisMember() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.getTheTeamName(webDriver);
        teamsAndMembersPage.assignTeamForTheMember(webDriver);
    }

    @And("Admin close member edit tab")
    public void adminCloseMemberEditTab() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.closeMemberTab(webDriver);
    }

    @Then("Validate the member is added to the team members")
    public void validateTheMemberIsAddedToTheTeamMembers() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        Assert.assertTrue(teamsAndMembersPage.validateTheMemberIsAddedToTheTeamMembers(webDriver), "Member not found");
    }

    @When("Admin select member who in a team")
    public void adminSelectMemberWhoIsInATeam() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        teamsAndMembersPage.selectMemberWithTeam(webDriver);
    }

    @And("Admin remove member from the team")
    public void adminRemoveMemberFromTheTeam() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        teamsAndMembersPage.removeMemberFromTeam(webDriver);
    }

    @Then("Validate the member is not in a team")
    public void validateTheMemberIsNotInATeam() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        System.out.println(teamsAndMembersPage.getTeamName(webDriver));
        Assert.assertTrue(teamsAndMembersPage.getTeamName(webDriver).toLowerCase().contains("not in a team"));
    }

    @And("Admin Open Creation Team Form")
    public void adminOpenCreationTeamForm() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();

        teamsAndMembersPage.clickOnCreateTeamButton(webDriver);
    }

    @And("User login with API email invitation and {string}")
    public void userLoginWithAPIEmailInvitationAnd(String password) throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        loginPage.login(webDriver, teamsAndMembersPage.apiInvitationEmail, FileReaderManager.getInstance().getConfigFileReader().getProperty(password));
    }

    @Then("Validate this user type can't create team")
    public void validateThisUserTypeCanTCreateATeam() {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.validateUserCantCreateTeam(webDriver);
    }

    @And("Admin assign Admin member to the team")
    public void adminAssignAdminMemberToTheTeam() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.selectMemberWithSpecificRole(webDriver, "admin");
    }

    @And("Admin assign Internal Accountant member to the team")
    public void adminAssignInternalAccountantMemberToTheTeam() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.selectMemberWithSpecificRole(webDriver, "internal");
    }

    @And("Admin assign External Accountant member to the team")
    public void adminAssignExternalAccountantMemberToTheTeam() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.selectMemberWithSpecificRole(webDriver, "external");
    }

    @And("Admin assign Team member to the team")
    public void adminAssignTeamMemberToTheTeam() throws InterruptedException {
        WebDriver webDriver = testContext.getDriverManager().getDriver();
        teamsAndMembersPage.selectMemberWithSpecificRole(webDriver, "member");
    }

}