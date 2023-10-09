package Managers;

import PageObjects.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver webDriver;
    private LandingPage landingPage;
    private LoginPage loginPage;
    private InvoicesPage invoicesPage;
    private SignUpPage signUpPage;
    private VerificationPage verificationPage;
    private TeamsAndMembersPage teamsAndMembersPage;
    private KYBPage kybPage;
    private ExportPage exportPage;


    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LandingPage getLandingPage() {
        return (landingPage == null) ? landingPage = new LandingPage(webDriver) : landingPage;
    }

    public LoginPage getLoginPage() {

        if (loginPage == null) {
            loginPage = new LoginPage(webDriver);
        }
        return loginPage;
    }

    public SignUpPage getSignUpPage() {

        if (signUpPage == null) {
            signUpPage = new SignUpPage(webDriver);
        }
        return signUpPage;
    }

    public VerificationPage getVerificationPagePage() {

        if (verificationPage == null) {
            verificationPage = new VerificationPage(webDriver);
        }
        return verificationPage;
    }

    public TeamsAndMembersPage getTeamsAndMembersPage() {

        if (teamsAndMembersPage == null) {
            teamsAndMembersPage = new TeamsAndMembersPage(webDriver);
        }
        return teamsAndMembersPage;
    }

    public InvoicesPage getInvoicesPage() {
        if (invoicesPage == null) invoicesPage = new InvoicesPage(webDriver);
        return invoicesPage;
    }

    public KYBPage getKybPage() {
        if (kybPage == null) {
            kybPage = new KYBPage(webDriver);
        }
        return kybPage;
    }
    public ExportPage getExportPage() {
        if (exportPage == null) {
            exportPage = new ExportPage(webDriver);
        }
        return exportPage;
    }

}
