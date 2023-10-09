package PageObjects;

import Utilities.Actions;
import Utilities.Wait;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class KYBPage {
    private final WebDriver webDriver;
    public String domainName,numOfEmps,companyName,annual,tax,regulatorName;
    public String orgTrade,orgMemo,orgBank,orgSupport;
    public String shFN,shLN,shPh,shE,shAdd,shMob,shSource,shPassport,shId;
    public String shared1FN,shared1LN,shared1Ph,shared1E,shared1Add,shared1Mob,sharedSource,sharedPassport,sharedId;
    public String sg1FN,sg1LN,sg1Ph,sg1E,sg1Add,sg1Mob,sgSource,sgPassport,sgId,sg2FN,sg2LN,sg2Ph,sg2E,sg2Add;
    public String com1Add,com1E,com1Ph,comTrade,comMemo,comIncumbency,comIncorporation,comBank;
    public String dir1FN,dir1LN,dir1Ph,dir1E,dir1Add,dir1Mob,dirSource,dirPassport,dirId,dir2FN,dir2LN,dir2Ph,dir2E,dir2Add;
    public String primaryPersonName,secondaryPersonName;
    public String itemName;

    public KYBPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast-theme--dark Toastify__toast--success']")
    private WebElement toastMessageText;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-j7ojaa']")
    private WebElement bussinessLegalName;

    @FindBy(xpath = "(//span[@aria-label='Approve entry'])[52]")
    private WebElement backOfficeAdressUBO3ApproveButton;

    @FindBy(xpath = "(//span[@aria-label='Reject entry'])[52]")
    private WebElement backOfficeAdressUBO3RejectButton;

    @FindBy(id = "kyb-rejectionReasonTextField-1")
    private WebElement backOfficeRejectionField;

    @FindBy(id = "kyb-rejectionReasonConfirm-1")
    private WebElement backOfficeConfirmButton;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-1qw7oyn'])[1]")
    private WebElement kybVerfyingPageButton;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation Mui-disabled MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-1qw7oyn']")
    private WebElement disabledViewFormButton;

    @FindBy(xpath = "//div[@class='MuiBox-root css-190jr6a']")
    private WebElement settingPageContainer;

    @FindBy(xpath = "//div[@class='MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-1dv96os']")
    private WebElement numOfEmployeesContainer;
    @FindBy(id = "kyb-numberOfEmployees-1-1")
    private WebElement numOfEmployeesContainerBackOffice;

    @FindBy(id = "NymCardKyb-companyWebsite-1-2")
    private WebElement companyWebsiteField;

    @FindBy(id = "NymCardKyb-approximateAnnual-1-3")
    private WebElement approximateAnnualField;

    @FindBy(xpath ="(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]")
    private WebElement yesRadioButton;

    @FindBy(xpath ="(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]")
    private WebElement yes2RadioButton;

    @FindBy(css = ".MuiTypography-root.MuiTypography-body1.css-9wl6tw")
    private WebElement userFullName;

    @FindBy(id = "NymCardKyb-regulatorName-1-4")
    private WebElement regulatorNameField;

    @FindBy(id = "NymCardKyb-taxRegistrationNumber-1-5")
    private WebElement taxRegistrationNumberField;

    @FindBy(xpath ="(//input[@value='Individual'])[1]")
    private WebElement individualOneRadioButton;

    @FindBy(xpath ="(//input[@value='Individual'])[2]")
    private WebElement individualTwoRadioButton;

    @FindBy(xpath ="(//input[@value='Individual'])[3]")
    private WebElement individualThreeRadioButton;

    @FindBy(xpath ="(//input[@value='Individual'])[4]")
    private WebElement individualFourRadioButton;

    @FindBy(xpath ="(//input[@value='Individual'])[5]")
    private WebElement individualFiveRadioButton;

    @FindBy(xpath ="(//input[@value='DIRECTOR'])[1]")
   // @FindBy(xpath ="(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]")
    private WebElement directorChecboxButton;

    @FindBy(xpath ="(//input[@value='DIRECTOR'])[3]")
    private WebElement director2ChecboxButton;

    @FindBy(xpath ="(//input[@value='DIRECTOR'])[3]")
    private WebElement directorBackOffice;

    @FindBy(xpath ="(//input[@value='SHARE_HOLDER'])[3]")
    private WebElement shareholderBackOffice;

    @FindBy(xpath ="(//input[@value='SIGNATURES'])[3]")
    private WebElement signatureBackoffice;

    @FindBy(xpath ="(//input[@value='SHARE_HOLDER'])[4]")
    private WebElement shareholder3ChecboxButton;

    @FindBy(xpath ="(//input[@value='SHARE_HOLDER'])[1]")
    private WebElement shareholderChecboxButton;

    @FindBy(xpath ="(//input[@value='SIGNATURES'])[1]")
    private WebElement signatureChecboxButton;
    @FindBy(xpath ="(//input[@value='SIGNATURES'])[5]")
    private WebElement signature4ChecboxButton;

    @FindBy(xpath ="//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1i5ogmo']")
    private WebElement directorChecboxContainer;

    @FindBy(xpath ="(//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium Mui-checked MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1i5ogmo'])[1]")
    private WebElement directorChecboxFullContainer;

    @FindBy(xpath ="(//input[@value='SHARE_HOLDER'])[1]")
    private WebElement shareholderChecboxContainer;

    @FindBy(xpath ="(//input[@value='SIGNATURES'])[1]")
    private WebElement signatureChecboxContainer;

    @FindBy(xpath ="//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-disableElevation css-1myhn2s']")
    private WebElement confirmTypeOfOrg;

    @FindBy(xpath ="//div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper MuiDialog-paperScrollPaper MuiDialog-paperWidthSm css-1x78120']")
    private WebElement addUserTab;

    @FindBy(xpath ="(//span[@class='MuiCircularProgress-root MuiCircularProgress-indeterminate MuiCircularProgress-colorSecondary css-1a0c9um'])[2]")
    private WebElement loadingIcon;

    @FindBy(xpath ="(//input[@value='Company'])[1]")
    private WebElement companyOneRadioButton;

    @FindBy(xpath ="(//input[@value='Company'])[2]")
    private WebElement companyTwoRadioButton;

    @FindBy(xpath = "//input[@id='NymCardKyb-primaryPersonName-1-1']")
    private WebElement primaryPersonNameField;

    @FindBy(id = "NymCardKyb-secondaryPersonName-1-2")
   private WebElement secondaryPersonNameField;

    @FindBy(xpath = "(//input[@placeholder='Email address'])[1]")
    private WebElement firstEmail;

    @FindBy(xpath = "(//input[@placeholder='Email address'])[2]")
    private WebElement secondEmail;

    @FindBy(xpath = "(//input[@placeholder='Email address'])[3]")
    private WebElement thirdEmail;

    @FindBy(xpath = "(//input[@placeholder='Email address'])[4]")
    private WebElement forthEmail;

    @FindBy(xpath = "(//input[@placeholder='Email address'])[5]")
    private WebElement fifthEmail;

    @FindBy(xpath = "(//input[@id='NymCardKyb-firstName-1-1'])[1]")
    private WebElement shared1FirstName;

    @FindBy(xpath = "(//input[@id='NymCardKyb-firstName-1-1'])[3]")
    private WebElement shareholder1FirstName;

    @FindBy(xpath = "(//input[@id='NymCardKyb-firstName-1-1'])[4]")
    private WebElement signature1FirstName;

    @FindBy(xpath = "(//input[@id='NymCardKyb-firstName-1'])[2]")
    private WebElement shareholder2FirstName;


    @FindBy(xpath = "(//input[@id='NymCardKyb-firstName-2'])[2]")
    private WebElement signature2FirstName;


    @FindBy(xpath = "(//input[@id='NymCardKyb-firstName-1-1'])[2]")
    private WebElement director1FirstName;

    @FindBy(xpath = "(//input[@id='NymCardKyb-firstName-3'])[2]")
    private WebElement director2FirstName;

    @FindBy(xpath = "(//input[@id='NymCardKyb-lastName-1-2'])[1]")
    private WebElement shared1LastName;

    @FindBy(xpath = "(//input[@id='NymCardKyb-lastName-1-2'])[3]")
    private WebElement shareholder1LastName;

    @FindBy(xpath = "(//input[@id='NymCardKyb-lastName-1-2'])[4]")
    private WebElement signature1LastName;

    @FindBy(xpath = "(//input[@id='NymCardKyb-lastName-1'])[2]")
    private WebElement shareholder2LastName;



    @FindBy(xpath = "(//input[@id='NymCardKyb-lastName-2'])[2]")
    private WebElement signature2LastName;


    @FindBy(xpath = "(//input[@id='NymCardKyb-lastName-1-2'])[2]")
    private WebElement director1LastName;

    @FindBy(xpath = "(//input[@id='NymCardKyb-lastName-3'])[2]")
    private WebElement director2LastName;

    @FindBy(xpath = "(//input[@id='NymCardKyb-phoneNumber-1-3'])[1]")
    private WebElement shared1PhoneNumber;

    @FindBy(id = "NymCardKyb-phoneNumber-1-1")
    private WebElement companyPhoneNumber;

    @FindBy(id = "NymCardKyb-residentialAddress-1-3")
    private WebElement companyAdress;

    @FindBy(xpath = "(//input[@id='NymCardKyb-phoneNumber-1-3'])[3]")
    private WebElement shareholder1PhoneNumber;

    @FindBy(xpath = "(//input[@id='NymCardKyb-phoneNumber-1-3'])[4]")
    private WebElement signature1PhoneNumber;

    @FindBy(xpath = "(//input[@id='NymCardKyb-mobileNumber-1-4'])[1]")
    private WebElement shared1Mobile;

    @FindBy(xpath = "(//input[@id='NymCardKyb-mobileNumber-1-4'])[3]")
    private WebElement shareholder1Mobile;

    @FindBy(xpath = "(//input[@id='NymCardKyb-mobileNumber-1-4'])[4]")
    private WebElement signature1Mobile;

    @FindBy(xpath = "(//input[@id='NymCardKyb-phoneNumber-1'])[2]")
    private WebElement shareholder2PhoneNumber;


    @FindBy(xpath = "(//input[@id='NymCardKyb-phoneNumber-2'])[2]")
    private WebElement signature2PhoneNumber;

    @FindBy(xpath = "(//input[@id='NymCardKyb-phoneNumber-1-3'])[2]")
    private WebElement director1PhoneNumber;

    @FindBy(xpath = "(//input[@id='NymCardKyb-mobileNumber-1-4'])[2]")
    private WebElement director1Mobile;

    @FindBy(xpath = "(//input[@id='NymCardKyb-phoneNumber-3'])[2]")
    private WebElement director2PhoneNumber;

    @FindBy(xpath = "(//input[@id='NymCardKyb-residentialAddress-1-6'])[1]")
    private WebElement shared1ResidentialAddress;

    @FindBy(xpath = "(//input[@id='NymCardKyb-residentialAddress-1-6'])[3]")
    private WebElement shareholder1ResidentialAddress;

    @FindBy(xpath = "(//input[@id='NymCardKyb-residentialAddress-1-6'])[4]")
    private WebElement signature1ResidentialAddress;

    @FindBy(xpath = "(//input[@id='NymCardKyb-residentialAddress-1'])[2]")
    private WebElement shareholder2ResidentialAddress;



    @FindBy(xpath = "(//input[@id='NymCardKyb-residentialAddress-2'])[2]")
    private WebElement signature2ResidentialAddress;


    @FindBy(xpath = "(//input[@id='NymCardKyb-residentialAddress-1-6'])[2]")
    private WebElement director1ResidentialAddress;

    @FindBy(xpath = "(//input[@id='NymCardKyb-residentialAddress-3'])[2]")
    private WebElement director2ResidentialAddress;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    private WebElement policyAgreementCheckbox;

//    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
//    private WebElement policyAgreementCheckbox;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-disableElevation css-14cxibm']")
    private WebElement kybSubmitButton;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-109hyds'])[1]")
    private WebElement orgnizationInformationTab;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-109hyds'])[2]")
    private WebElement orgnizationDocumentsTab;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-109hyds'])[3]")
    private WebElement shareholdersTab;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-109hyds'])[4]")
    private WebElement signaturesTab;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-109hyds'])[5]")
    private WebElement directorsTab;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-109hyds'])[6]")
    private WebElement politicallyExposedPersons;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-1u0z3c7'])[1]")
    private WebElement addMemberButton;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[1]")
    private WebElement remove1Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[2]")
    private WebElement remove2Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[3]")
    private WebElement remove3Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[4]")
    private WebElement remove4Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[5]")
    private WebElement remove5Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[6]")
    private WebElement remove6Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[7]")
    private WebElement remove7Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[7]")
    private WebElement remove8Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[7]")
    private WebElement remove9Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[7]")
    private WebElement remove10Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[7]")
    private WebElement remove11Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[7]")
    private WebElement remove12Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[7]")
    private WebElement remove13Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[7]")
    private WebElement remove14Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[7]")
    private WebElement remove15Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[7]")
    private WebElement remove16Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[7]")
    private WebElement remove17Button;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation alert40 px16 css-1ypmmar'])[7]")
    private WebElement remove18Button;

    @FindBy(id = "NymCardKyb-passportFirstPage-1-8")
    private WebElement passportUpload;
    @FindBy(id = "NymCardKyb-pemoSourceOfFunds-1-7")
    private WebElement pemoSourceOfFunds;
    @FindBy(id = "NymCardKyb-emiratesId-1-9")
    private WebElement emiratesIdUpload;

    @FindBy(xpath = "(//input[@id='NymCardKyb-passport-2'])[1]")
    private WebElement passportSignatureUpload;

    @FindBy(xpath = "(//input[@id='NymCardKyb-emiratesId-2'])[1]")
    private WebElement emiratesIdSignatureUpload;

    @FindBy(xpath = "(//input[@id='NymCardKyb-passport-2'])[2]")
    private WebElement passportSignatureUpload2;

    @FindBy(xpath = "(//input[@id='NymCardKyb-emiratesId-2'])[2]")
    private WebElement emiratesIdSignatureUpload2;

    @FindBy(xpath = "(//input[@id='NymCardKyb-passportFirstPage-1-8'])[2]")
    private WebElement passportDirectorUpload;

    @FindBy(xpath = "(//input[@id='NymCardKyb-pemoSourceOfFunds-1-7'])[2]")
    private WebElement pemoSourceOfFundsDirector;

    @FindBy(xpath = "(//input[@id='NymCardKyb-emiratesId-1-9'])[2]")
    private WebElement emiratesIdDirectorUpload;

    @FindBy(xpath = "(//input[@id='NymCardKyb-passport-3'])[2]")
    private WebElement passportDirectorUpload2;

    @FindBy(xpath = "(//input[@id='NymCardKyb-emiratesId-3'])[2]")
    private WebElement emiratesIdDirectorUpload2;

    @FindBy(id = "NymCardKyb-tradeLicense-1-1")
    private WebElement tradeLicenseUpload;

    @FindBy(id = "kyb-commercialLicense-1-2")
    private WebElement tradeLicenseBackOfficeUpload;

    @FindBy(id = "NymCardKyb-memorandumOfAssociation-1-2")
    private WebElement memorandumOfAssociationUpload;

    @FindBy(id = "NymCardKyb-certificateOfIncorporation-1")
    private WebElement certificateOfIncorporationUpload;

    @FindBy(id = "NymCardKyb-supportingFiles-1-4")
    private WebElement supportingFilesUpload;

    @FindBy(id = "NymCardKyb-recentBank-1-3")
    private WebElement recentBankStatementUpload;

    @FindBy(id = "NymCardKyb-tradeLicense-2-4")
    private WebElement tradeLicenseUpload2;

    @FindBy(id = "NymCardKyb-memorandumArticles-1-5")
    private WebElement memorandumOfAssociationUpload2;

    @FindBy(id = "NymCardKyb-certificateOfIncorporation-2-6")
    private WebElement certificateOfIncorporationUpload2;

    @FindBy(id = "NymCardKyb-certificateOfIncumbency-2-7")
    private WebElement certificateOfIncumbencyUpload2;

    @FindBy(id = "NymCardKyb-recentBankStatement-1-8")
    private WebElement recentBankStatementUpload2;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation css-1u0z3c7'])[1]")
    private WebElement addUserButton;

    @FindBy(id = "kyb-addUBO-1")
    private WebElement addUserButtonBackOffice;

    @FindBy(xpath = "//p[@class='px66 grey1']")
    private WebElement successfulMessage;

    @FindBy(id = "NymCardKyb-companyWebsite-1-2-helper-text")
    private WebElement companyWebsiteErrorMessage;

    @FindBy(id = "NymCardKyb-approximateAnnual-1-3-helper-text")
    private WebElement approximateAnnualErrorMessage;

    @FindBy(xpath = "(//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeMedium MuiFormHelperText-contained css-1sh4b5t'])[1]")
    private WebElement employeeNumbersListErrorMessage;

    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-9gcmrm'])[1]")
    private WebElement tradeLicenseFileErrorMessage;

    @FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-9gcmrm'])[2]")
    private WebElement memorandumFileErrorMessage;

    @FindBy(xpath = "(//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-9d0h0l'])[4]")
    private WebElement vendorUserIdText;

    @FindBy(xpath = "(//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-9d0h0l'])[5]")
    private WebElement statusKybText;

    @FindBy(name = "searchValue")
    public WebElement kybSearchField;

    @FindBy(id = "kyb-approximateAnnualTurnover-1-1")
    private WebElement annualBackOffice;

    @FindBy(id = "kyb-regulatorName-1-1")
    private WebElement regulatorNameBackOffice;

    @FindBy(id = "kyb-taxIdentificationNumber-1-1")
    private WebElement taxBackOffice;

    @FindBy(id = "kyb-companyWebsite-1-1")
    private WebElement companyNameBackOffice;

    @FindBy(id = "kyb-priPepCheckName-1-1")
    private WebElement primaryPersonBackOffice;

    @FindBy(id = "kyb-secPepCheckName-1-1")
    private WebElement secondaryPersonBackOffice;

    @FindBy(id = "kyb-residentialAddress-1-3-2")
    private WebElement comAddBackOffice;

    @FindBy(id = "kyb-phoneNumber-2-3-2")
    private WebElement comPhBackOffice;

    @FindBy(id = "kyb-emailAddress-2-3-2")
    private WebElement comEBackOffice;

    @FindBy(id = "kyb-firstName-2-3-4")
    private WebElement shFNBackOffice;

    @FindBy(id = "kyb-lastName-2-3-4")
    private WebElement shLNBackOffice;

    @FindBy(id = "kyb-residentialAddress-1-3-4")
    private WebElement shAddBackOffice;

    @FindBy(id = "kyb-phoneNumber-2-3-4")
    private WebElement shPhBackOffice;

    @FindBy(id = "kyb-mobileNumber-2-3-4")
    private WebElement shMobBackOffice;

    @FindBy(id = "kyb-emailAddress-2-3-4")
    private WebElement shEBackOffice;


    @FindBy(id = "kyb-firstName-2-3-1")
    private WebElement sharedFNBackOffice;

    @FindBy(id = "kyb-lastName-2-3-1")
    private WebElement sharedLNBackOffice;

    @FindBy(id = "kyb-residentialAddress-1-3-1")
    private WebElement sharedAddBackOffice;

    @FindBy(id = "kyb-phoneNumber-2-3-1")
    private WebElement sharedPhBackOffice;

    @FindBy(id = "kyb-mobileNumber-2-3-1")
    private WebElement sharedMobBackOffice;

    @FindBy(id = "kyb-emailAddress-2-3-1")
    private WebElement sharedEBackOffice;

    @FindBy(id = "kyb-firstName-2-3-5")
    private WebElement sg1FNBackOffice;

    @FindBy(id = "kyb-lastName-2-3-5")
    private WebElement sg1LNBackOffice;

    @FindBy(id = "kyb-phoneNumber-2-3-5")
    private WebElement sg1PhBackOffice;

    @FindBy(id = "kyb-mobileNumber-2-3-5")
    private WebElement sg1MobBackOffice;

    @FindBy(id = "kyb-emailAddress-2-3-5")
    private WebElement sg1EBackOffice;

    @FindBy(id = "kyb-residentialAddress-1-3-5")
    private WebElement sg1AddBackOffice;

    @FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-p5le3c'])[12]")
    private WebElement sg2FNBackOffice;

    @FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-p5le3c'])[13]")
    private WebElement sg2LNBackOffice;

    @FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-p5le3c'])[17]")
    private WebElement sg2PhBackOffice;

    @FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-p5le3c'])[19]")
    private WebElement sg2EBackOffice;

    @FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-p5le3c'])[21]")
    private WebElement sg2AddBackOffice;

    @FindBy(id = "kyb-firstName-2-3-3")
    private WebElement dir1FNBackOffice;

    @FindBy(id = "kyb-lastName-2-3-3")
    private WebElement dir1LNBackOffice;

    @FindBy(id = "kyb-phoneNumber-2-3-3")
    private WebElement dir1PhBackOffice;

    @FindBy(id = "kyb-mobileNumber-2-3-3")
    private WebElement dir1MobBackOffice;

    @FindBy(id = "kyb-emailAddress-2-3-3")
    private WebElement dir1EBackOffice;

    @FindBy(id = "kyb-residentialAddress-1-3-3")
    private WebElement dir1AddBackOffice;

    @FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-p5le3c'])[12]")
    private WebElement dir2FNBackOffice;

    @FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-p5le3c'])[13]")
    private WebElement dir2LNBackOffice;

    @FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-p5le3c'])[17]")
    private WebElement dir2PhBackOffice;

    @FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-p5le3c'])[19]")
    private WebElement dir2EBackOffice;

    @FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-p5le3c'])[21]")
    private WebElement dir2AddBackOffice;

    @FindBy(id = "NymCard(AED)Kyb-approveKyb-1")
    private WebElement approvedButtonBackOffice;

    @FindBy(xpath = "(//button[@id='NymCard(AED)Kyb-declineKyb-1'])[2]")
    private WebElement declinedButtonBackOffice;
    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-disableElevation css-3bvhs1']")
    private WebElement declinedConfirmationButtonBackOffice;
    @FindBy(id = "NymCard(AED)Kyb-userActionKyb-1")
    private WebElement userActionButtonBackOffice;

    @FindBy(id = "kyb-residentialAddress-1-3-3-helper-text")
    private WebElement backOfficeAddressErrorMessageContainer;

    @FindBy(id = "NymCardKyb-residentialAddress-1-6-helper-text")
    private WebElement pemoAddressErrorMessageContainer;

    @FindBy(id = "kyb-rejectionReasonTextField-1")
    private WebElement rejectionReasonFieldBackOffice;
    @FindBy(id = "kyb-rejectionReasonConfirm-1")
    private WebElement rejectionReasonConfirmBackOffice;

    @FindBy(id = "kyb-regulatorName-1-helper-text")
    private WebElement rejectionReasonErrorMessageBackOffice;

//    @FindBy(xpath = "//span[@class='MuiChip-label MuiChip-labelSmall css-1pjtbja']")
//    private WebElement orgStatusBackOffice;

    @FindBy(xpath = "(//div[@class='MuiBox-root css-70qvj9'])[3]")
    private WebElement orgStatusBackOffice;

    @FindBy(xpath = "//div[@class='MuiChip-root MuiChip-filled MuiChip-sizeSmall MuiChip-colorDefault MuiChip-filledDefault css-1evqd8v']")
    private WebElement userActionRequiredStatusBackOffice;


    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedError MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-outlined MuiButton-outlinedError MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-disableElevation css-1yuqqrf']")
    private WebElement dashboardCompanyKybVerify;

    @FindBy(id = "kyb-organizationInfoUpdateUserInfo-1")
    private WebElement orgInfoUpdateUserInfoBackOffice;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-disableElevation css-3bvhs1']")
    private WebElement orgInfoUpdateUserConfirmationBackOffice;

    @FindBy(xpath = "//div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']")
    private WebElement toastContainerBackOffice;

    @FindBy(id = "kyb-organizationDocumentsAddItem-1")
    private WebElement organizationDocumentsAddItemBackOffice;

    @FindBy(id = "kyb-addItemDetailsTitle-1")
    private WebElement addItemDetailsTitleBackOffice;

    @FindBy(id = "kyb-addItemDetailsDescription-1")
    private WebElement addItemDetailsDescriptionBackOffice;

    @FindBy(id = "kyb-addItemDetailsPlaceholder-1")
    private WebElement addItemDetailsPlaceholderBackOffice;

    @FindBy(id = "kyb-addItemDetailsConfirm-1")
    private WebElement addItemDetailsConfirmBackOffice;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation css-1fi9mre'])[1]")
    private WebElement removeCompanyUBO1;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation css-1fi9mre'])[2]")
    private WebElement removeCompanyUBO2;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation css-1fi9mre'])[3]")
    private WebElement removeCompanyUBO3;


    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation css-1fi9mre'])[4]")
    private WebElement removeCompanyUBO4;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation css-1fi9mre'])[5]")
    private WebElement removeCompanyUBO5;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation css-1fi9mre'])[6]")
    private WebElement removeCompanyUBO6;

    @FindBy(id = "kyb-uboRemoveItem-3")
    private WebElement removeCompanyUBOInBackOffice03;

    @FindBy(xpath = "//div[@class='MuiBox-root css-sdqz5y']")
    private List<WebElement> companyUBOContanier;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[1]")
    private WebElement viewDocument1;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1v23b2g'])[1]")
    private WebElement sendToNymCard1;

    @FindBy(xpath = "(//div[@class='MuiBox-root css-sdqz5y'])[1]")
    private WebElement companyUBO1Contanier;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[2]")
    private WebElement viewDocument2;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[3]")
    private WebElement viewDocument3;


    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[4]")
    private WebElement viewDocument4;


    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[5]")
    private WebElement viewDocument5;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[6]")
    private WebElement viewDocument6;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[7]")
    private WebElement viewDocument7;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[8]")
    private WebElement viewDocument8;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[9]")
    private WebElement viewDocument9;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[10]")
    private WebElement viewDocument10;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[11]")
    private WebElement viewDocument11;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[12]")
    private WebElement viewDocument12;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[13]")
    private WebElement viewDocument13;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[14]")
    private WebElement viewDocument14;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[15]")
    private WebElement viewDocument15;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[16]")
    private WebElement viewDocument16;

    @FindBy(xpath = "(//a[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[17]")
    private WebElement viewDocument17;

    @FindBy(xpath = "(//span[@class='MuiTypography-root MuiTypography-body1 css-rotlvs'])[1]")
    private WebElement browseFileButton1;

    @FindBy(xpath = "(//div[@class='MuiBox-root css-tmzma9'])[1]")
    private WebElement browseFileContainer1;

    @FindBy(id = "title")
    private WebElement pageTitle;

    @FindBy(id = "NymCardKyb-tradeLicense-2-4")
    private WebElement tradeLicenseComUpload;

    @FindBy(id = "NymCardKyb-memorandumArticles-1-5")
    private WebElement memorandumOfAssociationComUpload;

    @FindBy(id = "NymCardKyb-certificateOfIncorporation-2-6")
    private WebElement certificateOfIncorporationComUpload;

    @FindBy(id = "NymCardKyb-certificateOfIncumbency-2-7")
    private WebElement certificateOfIncumbencyComUpload;
    @FindBy(id = "NymCardKyb-recentBankStatement-1-8")
    private WebElement recentBankStatementComUpload;

    @FindBy(id = "kyb-uboUpdateUserInfo-3")
    private WebElement updateUserInfoButton;

    @FindBy(id = "kyb-uboRemoveItem-3")
    private WebElement removeUserBackOfficeButton;

    @FindBy(id = "kyb-uboAddItem-1")
    private WebElement addItemButtonBackOffice;

    @FindBy(id = "kyb-addItemDetailsPlaceholder-1")
    private WebElement addItemDetailsPlaceholderField;

    @FindBy(id = "kyb-addItemDetailsDescription-1")
    private WebElement addItemDetailsDescriptionField;

    @FindBy(id = "kyb-addItemDetailsTitle-1")
    private WebElement addItemDetailsTitleField;


    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-disableElevation css-hhpoeh'])[1]")
    private WebElement syncNewUsersButton;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedSecondary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-disableElevation css-3bvhs1'])[1]")
    private WebElement syncConfirmationButton;

    public void split(String multiPdfPath) throws InterruptedException {
    String[] multiPdfsPaths = multiPdfPath.split(" ");
    for (String multiPdfsPath : multiPdfsPaths) {
        System.out.println(multiPdfsPath);
        Thread.sleep(2000);
    }
    }

    public String generate5RandomNumbers() {
        String generateRandomNumbers = RandomStringUtils.randomNumeric(5);
        return generateRandomNumbers;
    }

    public String generate8RandomNumbers() {
        String generateRandomNumbers = RandomStringUtils.randomNumeric(8);
        return generateRandomNumbers;
    }

    public String generateRandomNumberFrom1To3() {
        String generateRandomNumber = RandomStringUtils.random(1,49,51,false,true);
        return generateRandomNumber;
    }

    public void openVerificationCompanyPage(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, kybVerfyingPageButton);
    }

    public String getBussinessLegalName(WebDriver webDriver) throws InterruptedException {
        Wait.untilElementIsVisible(webDriver, bussinessLegalName, 10L);
        domainName = Actions.getText(webDriver, bussinessLegalName);
        return domainName;
    }

    public void chooseRandomNumbersOfEmployees(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, numOfEmployeesContainer);
        Thread.sleep(1000);
        String numOfEmployeesOption = generateRandomNumberFrom1To3();
        System.out.println(numOfEmployeesOption);
        WebElement numOfEmployees = webDriver.findElement(By.xpath("(//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1fob25r'])[" + numOfEmployeesOption + "]"));
        Actions.click(webDriver, numOfEmployees);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }


    public void enterCompanyWebsite(WebDriver webDriver) throws InterruptedException {
        clearField(companyWebsiteField);
        String companyWebsite = "www." + getBussinessLegalName(webDriver) + ".com";
        System.out.println(companyWebsite);
        Actions.sendKeys(webDriver,companyWebsiteField,companyWebsite);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterApproximateAnnual(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(500);
        Actions.clear(webDriver, approximateAnnualField);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1500);
        String approximateAnnual = generate5RandomNumbers();
        System.out.println(approximateAnnual);
        Actions.sendKeys(webDriver, approximateAnnualField, approximateAnnual);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public String getUserFullName(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, userFullName);
    }

    public void enterRegulatorName(WebDriver webDriver) throws InterruptedException {
        yesRadioButton.click();
        Thread.sleep(1500);
        String regulatorName = "Regulator" + getUserFullName(webDriver);
        System.out.println(regulatorName);
        clearField(regulatorNameField);
        Actions.sendKeys(webDriver, regulatorNameField, regulatorName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterTaxNum(WebDriver webDriver) throws InterruptedException {
        clearField(taxRegistrationNumberField);
        String taxRegistrationNumber= generate5RandomNumbers();
        System.out.println(taxRegistrationNumber);
        Actions.sendKeys(webDriver, taxRegistrationNumberField, taxRegistrationNumber);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void fillOrgInfo(WebDriver webDriver) throws InterruptedException {
       chooseRandomNumbersOfEmployees(webDriver);
       enterCompanyWebsite(webDriver);
       enterApproximateAnnual(webDriver);
       enterRegulatorName(webDriver);
       enterTaxNum(webDriver);
    }

    public void openOrCloseTabs(WebDriver webDriver,String numOfTab) throws InterruptedException {
        WebElement openAndCloseTabs = webDriver.findElement(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-109hyds'])["+numOfTab+"]"));
        Actions.click(webDriver,openAndCloseTabs);
    }

    public void clearField(WebElement webElement) throws InterruptedException {
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        webElement.sendKeys(Keys.DELETE);
    }

    public void uploadTradeLicense() throws InterruptedException {
        try{
            tradeLicenseUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Trade_Commercial_license.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove1Button.isEnabled())
            System.out.println("Already uploaded");
        }
        Thread.sleep(1000);
    }


    public void uploadTradeLicenseBackOffice() throws InterruptedException {
        try{
            tradeLicenseBackOfficeUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Trade_Commercial_license.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove1Button.isEnabled())
                System.out.println("Already uploaded");
        }
        Thread.sleep(1000);
    }

    public void uploadTradeLicensePNG() throws InterruptedException {
        try{
            tradeLicenseUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/tradeLicense.png");
        }
        catch (NoSuchElementException e) {
            if (remove1Button.isEnabled())
                System.out.println("Already uploaded");
        }
        Thread.sleep(1000);
    }
    public void uploadTradeLicenseCSV() throws InterruptedException {
            tradeLicenseUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Test.csv");
    }

    public void uploadMemorandumOfAssociation() throws InterruptedException {
        try{
            memorandumOfAssociationUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Memorandum_Articles_of_association.pdf");        }
        catch (NoSuchElementException e) {
            if (remove2Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }

    public void uploadCertificateOfIncorporation() throws InterruptedException {
        try{
            certificateOfIncorporationUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/CertificateOfIncorporation.pdf");        }
        catch (NoSuchElementException e) {
            if (remove3Button.isEnabled())
                System.out.println("Already uploaded");
        }
        Thread.sleep(1000);
    }

    public void uploadSupportingFiles() throws InterruptedException {
        try{
            supportingFilesUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Supporting_files.pdf");        }
        catch (NoSuchElementException e) {
            if (remove4Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }

    public void uploadRecentBankStatement() throws InterruptedException {
        try{
            recentBankStatementUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Recent_bank_statement.pdf");        }
        catch (NoSuchElementException e) {
            if (remove3Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }

    public void uploadRecentBankStatementJPG() throws InterruptedException {
        try{
            recentBankStatementUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/bank statement.jpg");        }
        catch (NoSuchElementException e) {
            if (remove3Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }

    public void uploadTradeLicenseForCompanyShareholder() throws InterruptedException {
        try{
            tradeLicenseUpload2.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Company Trade_Commercial.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove4Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }

    public void uploadMemorandumOfAssociationForCompanyShareholder() throws InterruptedException {
        try{
            memorandumOfAssociationUpload2.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Company Memorandum_Articles.pdf");        }
        catch (NoSuchElementException e) {
            if (remove5Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }

    public void uploadCertificateOfIncorporationForCompanyShareholder() throws InterruptedException {
        try{
            certificateOfIncorporationUpload2.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Company_Certificate_incorporation.pdf");        }
        catch (NoSuchElementException e) {
            if (remove6Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }

    public void uploadCertificateOfIncumbencyForCompanyShareholder() throws InterruptedException {
        try{
            certificateOfIncumbencyUpload2.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Company_Certificate_incumbency.pdf");        }
        catch (NoSuchElementException e) {
            if (remove7Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }

    public void uploadRecentBankStatementForCompanyShareholder() throws InterruptedException {
        try{
            recentBankStatementUpload2.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Company_bank_statement.pdf");        }
        catch (NoSuchElementException e) {
            if (remove8Button.isEnabled()){
                System.out.println("Already uploaded");        }
          else {
                throw new RuntimeException("Failure: this file is not uploaded");

            }  
        }}
    public void uploadOrgDocs(WebDriver webDriver) throws InterruptedException {
       uploadTradeLicense();
       uploadMemorandumOfAssociation();
       uploadRecentBankStatement();
       uploadSupportingFiles();
    }

    public void uploadCompanyShareholder() throws InterruptedException {
        uploadTradeLicenseForCompanyShareholder();
        uploadMemorandumOfAssociationForCompanyShareholder();
        uploadCertificateOfIncorporationForCompanyShareholder();
        uploadCertificateOfIncumbencyForCompanyShareholder();
        uploadRecentBankStatementForCompanyShareholder();
        Thread.sleep(1000);
    }

    public void enterCompanyPhoneNumber(WebDriver webDriver) throws InterruptedException {
        clearField(companyPhoneNumber);
        String shareholderPhoneNumber = "+971" + generate8RandomNumbers();
        System.out.println(shareholderPhoneNumber);
        Actions.sendKeys(webDriver, companyPhoneNumber, shareholderPhoneNumber);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterAddressForCompany(WebDriver webDriver) throws InterruptedException {
        clearField(companyAdress);
        Actions.sendKeys(webDriver, companyAdress, "Residential address Dubai");
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterShareholder1FirstName(WebDriver webDriver) throws InterruptedException {
        clearField(shareholder1FirstName);
        String[] parts = getUserFullName(webDriver).split(" ");
        String shareholderFirstName = "Shareholder One " + parts[0];
        System.out.println(shareholderFirstName);
        Actions.sendKeys(webDriver, shareholder1FirstName, shareholderFirstName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterShareholder1LastName(WebDriver webDriver) throws InterruptedException {
        clearField(shareholder1LastName);
        String[] parts = getUserFullName(webDriver).split(" ");
        String shareholderLastName = "Shareholder One " + parts[1];
        System.out.println(shareholderLastName);
        Actions.sendKeys(webDriver, shareholder1LastName, shareholderLastName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterShareholder1PhoneNumber(WebDriver webDriver) throws InterruptedException {
        clearField(shareholder1PhoneNumber);
        String shareholderPhoneNumber = "+971" + generate8RandomNumbers();
        System.out.println(shareholderPhoneNumber);
        Actions.sendKeys(webDriver, shareholder1PhoneNumber, shareholderPhoneNumber);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterShareholder1Mobile(WebDriver webDriver) throws InterruptedException {
        clearField(shareholder1Mobile);
        String shareholderPhoneNumber = "+971" + generate8RandomNumbers();
        System.out.println(shareholderPhoneNumber);
        Actions.sendKeys(webDriver, shareholder1Mobile, shareholderPhoneNumber);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterSignature1FirstName(WebDriver webDriver) throws InterruptedException {
        clearField(signature1FirstName);
        String[] parts = getUserFullName(webDriver).split(" ");
        String signatureFirstName = "Signature One " + parts[0];
        System.out.println(signatureFirstName);
        Actions.sendKeys(webDriver, signature1FirstName, signatureFirstName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterSignature1LastName(WebDriver webDriver) throws InterruptedException {
        clearField(signature1LastName);
        String[] parts = getUserFullName(webDriver).split(" ");
        String signatureLastName = "Signature One " + parts[1];
        System.out.println(signatureLastName);
        Actions.sendKeys(webDriver, signature1LastName, signatureLastName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterSignature1PhoneNumber(WebDriver webDriver) throws InterruptedException {
        clearField(signature1PhoneNumber);
        String signaturePhoneNumber = "+971" + generate8RandomNumbers();
        System.out.println(signaturePhoneNumber);
        Actions.sendKeys(webDriver, signature1PhoneNumber, signaturePhoneNumber);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterSignature1Mobile(WebDriver webDriver) throws InterruptedException {
        clearField(signature1Mobile);
        String shareholderPhoneNumber = "+971" + generate8RandomNumbers();
        System.out.println(shareholderPhoneNumber);
        Actions.sendKeys(webDriver, signature1Mobile, shareholderPhoneNumber);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterSharedUserFirstName(WebDriver webDriver) throws InterruptedException {
        clearField(shared1FirstName);
        String[] parts = getUserFullName(webDriver).split(" ");
        String directorFirstName = "Shared " + parts[0];
        System.out.println(directorFirstName);
        Actions.sendKeys(webDriver, shared1FirstName, directorFirstName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterSharedUserLastName(WebDriver webDriver) throws InterruptedException {
        clearField(shared1LastName);
        String[] parts = getUserFullName(webDriver).split(" ");
        String directorLastName = "Shared" + parts[1];
        System.out.println(directorLastName);
        Actions.sendKeys(webDriver, shared1LastName, directorLastName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterSharedUserPhoneNumber(WebDriver webDriver) throws InterruptedException {
        clearField(shared1PhoneNumber);
        String directorPhoneNumber = "+971" + generate8RandomNumbers();
        System.out.println(directorPhoneNumber);
        Actions.sendKeys(webDriver, shared1PhoneNumber, directorPhoneNumber);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterSharedUserMobile(WebDriver webDriver) throws InterruptedException {
        clearField(shared1Mobile);
        String directorPhoneNumber = "+971" + generate8RandomNumbers();
        System.out.println(directorPhoneNumber);
        Actions.sendKeys(webDriver, shared1Mobile, directorPhoneNumber);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterDirector1FirstName(WebDriver webDriver) throws InterruptedException {
        clearField(director1FirstName);
        String[] parts = getUserFullName(webDriver).split(" ");
        String directorFirstName = "Director One " + parts[0];
        System.out.println(directorFirstName);
        Actions.sendKeys(webDriver, director1FirstName, directorFirstName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterDirector1LastName(WebDriver webDriver) throws InterruptedException {
        clearField(director1LastName);
        String[] parts = getUserFullName(webDriver).split(" ");
        String directorLastName = "Director One" + parts[1];
        System.out.println(directorLastName);
        Actions.sendKeys(webDriver, director1LastName, directorLastName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterDirector1PhoneNumber(WebDriver webDriver) throws InterruptedException {
        clearField(director1PhoneNumber);
        String directorPhoneNumber = "+971" + generate8RandomNumbers();
        System.out.println(directorPhoneNumber);
        Actions.sendKeys(webDriver, director1PhoneNumber, directorPhoneNumber);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterDirector1Mobile(WebDriver webDriver) throws InterruptedException {
        clearField(director1Mobile);
        String directorPhoneNumber = "+971" + generate8RandomNumbers();
        System.out.println(directorPhoneNumber);
        Actions.sendKeys(webDriver, director1Mobile, directorPhoneNumber);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterDirector2FirstName(WebDriver webDriver) throws InterruptedException {
        clearField(director2FirstName);
        String[] parts = getUserFullName(webDriver).split(" ");
        String directorFirstName = "Director Two " + parts[0];
        System.out.println(directorFirstName);
        Actions.sendKeys(webDriver, director2FirstName, directorFirstName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterDirector2LastName(WebDriver webDriver) throws InterruptedException {
        clearField(director2LastName);
        String[] parts = getUserFullName(webDriver).split(" ");
        String directorLastName = "Director Two " + parts[1];
        System.out.println(directorLastName);
        Actions.sendKeys(webDriver, director2LastName, directorLastName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterDirector2PhoneNumber(WebDriver webDriver) throws InterruptedException {
        clearField(director2PhoneNumber);
        String directorPhoneNumber = "+971" + generate8RandomNumbers();
        System.out.println(directorPhoneNumber);
        Actions.sendKeys(webDriver, director2PhoneNumber, directorPhoneNumber);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterSignature2FirstName(WebDriver webDriver) throws InterruptedException {
        clearField(signature2FirstName);
        String[] parts = getUserFullName(webDriver).split(" ");
        String signatureFirstName = "Signature Two " + parts[0];
        System.out.println(signatureFirstName);
        Actions.sendKeys(webDriver, signature2FirstName, signatureFirstName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterSignature2LastName(WebDriver webDriver) throws InterruptedException {
        clearField(signature2LastName);
        String[] parts = getUserFullName(webDriver).split(" ");
        String signatureLastName = "Signature Two " + parts[1];
        System.out.println(signatureLastName);
        Actions.sendKeys(webDriver, signature2LastName, signatureLastName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterSignature2PhoneNumber(WebDriver webDriver) throws InterruptedException {
        clearField(signature2PhoneNumber);
        String signaturePhoneNumber = "+971" + generate8RandomNumbers();
        System.out.println(signaturePhoneNumber);
        Actions.sendKeys(webDriver, signature2PhoneNumber, signaturePhoneNumber);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterEmail(WebDriver webDriver, String email) throws InterruptedException {
        clearField(firstEmail);
        Actions.sendKeys(webDriver, firstEmail, email);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterSecEmail(WebDriver webDriver, String email) throws InterruptedException {
        clearField(secondEmail);
        Actions.sendKeys(webDriver, secondEmail, email);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterThirdEmail(WebDriver webDriver, String email) throws InterruptedException {
        clearField(thirdEmail);
        Actions.sendKeys(webDriver, thirdEmail, email);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterFourthEmail(WebDriver webDriver, String email) throws InterruptedException {
        clearField(forthEmail);
        Actions.sendKeys(webDriver, forthEmail, email);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterFifthEmail(WebDriver webDriver, String email) throws InterruptedException {
        clearField(fifthEmail);
        Actions.sendKeys(webDriver, fifthEmail, email);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterAddressForShareholder(WebDriver webDriver) throws InterruptedException {
        clearField(shareholder1ResidentialAddress);
        Actions.sendKeys(webDriver, shareholder1ResidentialAddress, "Residential address Dubai");
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterAddressForSharedUser(WebDriver webDriver) throws InterruptedException {
        clearField(shared1ResidentialAddress);
        Actions.sendKeys(webDriver, shared1ResidentialAddress, "Residential address Dubai");
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterAddressForSignature(WebDriver webDriver) throws InterruptedException {
        clearField(signature1ResidentialAddress);
        Actions.sendKeys(webDriver, signature1ResidentialAddress, "Residential address Dubai");
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterAddressForDirector(WebDriver webDriver) throws InterruptedException {
        clearField(director1ResidentialAddress);
        Actions.sendKeys(webDriver, director1ResidentialAddress, "Residential address Dubai");
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterAddressForDirectorForBackofficeTests(WebDriver webDriver, String add) throws InterruptedException {
        clearField(director1ResidentialAddress);
        Actions.sendKeys(webDriver, director1ResidentialAddress, add);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterAddressForDirector2(WebDriver webDriver) throws InterruptedException {
        clearField(director2ResidentialAddress);
        Actions.sendKeys(webDriver, director2ResidentialAddress, "Residential address Dubai");
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterAddressForSignature2(WebDriver webDriver) throws InterruptedException {
        clearField(signature2ResidentialAddress);
        Actions.sendKeys(webDriver, signature2ResidentialAddress, "Residential address Dubai");
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }


    public void uploadPemoSourceOfFundsForSharedUser() throws InterruptedException {
        try{
            pemoSourceOfFunds.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/All_Pemo_source.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove1Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }


    public void uploadPassportForSharedUser() throws InterruptedException {
        try{
            passportUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/All_Passport.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove2Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }

    public void uploadEmiratesIdForSharedUser() throws InterruptedException {
        try{
            emiratesIdUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/All_Emirates_ID.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove3Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }


    public void uploadPemoSourceOfFundsForDirector() throws InterruptedException {
        try{
            pemoSourceOfFunds.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Director_Pemo_source.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove9Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }


    public void uploadPassportForDirector() throws InterruptedException {
        try{
            passportUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Director_Passport.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove10Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }

    public void uploadEmiratesIdForDirector() throws InterruptedException {
        try{
            emiratesIdUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Director_Emirates_ID.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove11Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }

    public void uploadPemoSourceOfFundsForShareholder() throws InterruptedException {
        try{
            pemoSourceOfFunds.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Shareholder_Pemo_source.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove12Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }


    public void uploadPassportForShareholder() throws InterruptedException {
        try{
            passportUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Shareholder_Passport.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove13Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }

    public void uploadEmiratesIdForShareholder() throws InterruptedException {
        try{
            emiratesIdUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Shareholder_Emirates_ID.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove14Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }


    public void uploadPemoSourceOfFundsForSignature() throws InterruptedException {
        try{
            pemoSourceOfFunds.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Signature_Pemo_source.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove15Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }


    public void uploadPassportForSignature() throws InterruptedException {
        try{
            passportUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Signature_Passport.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove16Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }

    public void uploadEmiratesIdForSignature() throws InterruptedException {
        try{
            emiratesIdUpload.sendKeys(System.getProperty("user.dir")+"/UploadedDocs/Signature_Emirates_ID.pdf");
        }
        catch (NoSuchElementException e) {
            if (remove17Button.isEnabled())
                System.out.println("Already uploaded");        }
        Thread.sleep(1000);
    }

    public void fillTheIndividualShereholderOne(WebDriver webDriver,String email) throws InterruptedException {
        enterShareholder1FirstName(webDriver);
        enterShareholder1LastName(webDriver);
        enterShareholder1PhoneNumber(webDriver);
        enterShareholder1Mobile(webDriver);
        enterFourthEmail(webDriver,email);
        enterAddressForShareholder(webDriver);
        uploadPemoSourceOfFundsForShareholder();
        uploadPassportForShareholder();
        uploadEmiratesIdForShareholder();
    }
    public void clickOnAddUser(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver,addUserButton);
    }

    public void clickOnAddUserBackOffice() throws InterruptedException {
        Actions.click(webDriver,addUserButtonBackOffice);
    }


    public void chooseCompanyShereholderType() throws InterruptedException {
        Thread.sleep(500);
        Actions.click(webDriver,companyTwoRadioButton);
        Thread.sleep(1000);
    }
    public void fillTheCompanyShereholder(WebDriver webDriver,String email) throws InterruptedException {
        enterCompanyPhoneNumber(webDriver);
        enterSecEmail(webDriver,email);
        enterAddressForCompany(webDriver);
        uploadCompanyShareholder();
    }

    public void fillTheSignatureOne(WebDriver webDriver,String email) throws InterruptedException {
        enterSignature1FirstName(webDriver);
        enterSignature1LastName(webDriver);
        enterSignature1PhoneNumber(webDriver);
        enterSignature1Mobile(webDriver);
        enterFifthEmail(webDriver,email);
        enterAddressForSignature(webDriver);
        uploadPemoSourceOfFundsForSignature();
        uploadPassportForSignature();
        uploadEmiratesIdForSignature();
    }

    public void fillTheDirectorOne(WebDriver webDriver,String email) throws InterruptedException {
        enterDirector1FirstName(webDriver);
        enterDirector1LastName(webDriver);
        enterDirector1PhoneNumber(webDriver);
        enterDirector1Mobile(webDriver);
        enterThirdEmail(webDriver,email);
        enterAddressForDirector(webDriver);
        uploadPemoSourceOfFundsForDirector();
        uploadPassportForDirector();
        uploadEmiratesIdForDirector();
    }

    public void fillTheSharedUser(WebDriver webDriver,String email) throws InterruptedException {
        enterSharedUserFirstName(webDriver);
        enterSharedUserLastName(webDriver);
        enterSharedUserPhoneNumber(webDriver);
        enterSharedUserMobile(webDriver);
        enterEmail(webDriver,email);
        enterAddressForSharedUser(webDriver);
        uploadPemoSourceOfFundsForSharedUser();
        uploadPassportForSharedUser();
        uploadEmiratesIdForSharedUser();
        Thread.sleep(1500);
    }

    public void fillTheDirectorTwo(WebDriver webDriver,String email) throws InterruptedException {
        enterDirector2FirstName(webDriver);
        enterDirector2LastName(webDriver);
        enterDirector2PhoneNumber(webDriver);
        enterSecEmail(webDriver,email);
        enterAddressForDirector2(webDriver);

    }

    public void fillTheSignatureTwo(WebDriver webDriver,String email) throws InterruptedException {
        enterSignature2FirstName(webDriver);
        enterSignature2LastName(webDriver);
        enterSignature2PhoneNumber(webDriver);
        enterSecEmail(webDriver,email);
        enterAddressForSignature2(webDriver);
        Thread.sleep(1000);
    }

    public void enterPrimaryPersonName(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(500);
        yesRadioButton.click();
        Thread.sleep(3000);
        Actions.click(webDriver, primaryPersonNameField);
        clearField(primaryPersonNameField);
        String[] parts = getUserFullName(webDriver).split(" ");
        String primaryPersonName = "Politically Exposed Persons " + parts[0];
        System.out.println(primaryPersonName);
        Actions.sendKeys(webDriver, primaryPersonNameField, primaryPersonName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void enterSecondaryPersonName(WebDriver webDriver) throws InterruptedException {
        yes2RadioButton.click();
        Thread.sleep(3000);
        clearField(secondaryPersonNameField);
        String[] parts = getUserFullName(webDriver).split(" ");
        String secondaryPersonName = "Politically Exposed Persons " + parts[1];
        System.out.println(secondaryPersonName);
        Actions.sendKeys(webDriver, secondaryPersonNameField, secondaryPersonName);
        Actions.click(webDriver, bussinessLegalName);
        Thread.sleep(1000);
    }

    public void fillPoliticallyExposedPersons(WebDriver webDriver) throws InterruptedException {
        enterPrimaryPersonName(webDriver);
        Thread.sleep(1500);
        enterSecondaryPersonName(webDriver);
    }

    public void clickOnpolicyAgreementCheckbox(WebDriver webDriver) throws InterruptedException {
        policyAgreementCheckbox.click();    }

    public void submitKybForm(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, kybSubmitButton);
    }

    public String getSuccessfulMessage(WebDriver webDriver) throws InterruptedException {
        Wait.untilElementIsVisible(webDriver, successfulMessage, 15L);
        return Actions.getText(webDriver, successfulMessage);
    }

    public String getEmployeeNumbersListErrorMessage(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, employeeNumbersListErrorMessage);
    }

    public String getCompanyWebsiteErrorMessage(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, companyWebsiteErrorMessage);
    }

    public String getApproximateAnnualErrorMessage(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, approximateAnnualErrorMessage);
    }

    public String getTradeLicenseFileErrorMessage(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, tradeLicenseFileErrorMessage);
    }

    public String getMemorandumFileErrorMessage(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, memorandumFileErrorMessage);
    }

    public void searchWithDomainName(WebDriver webDriver) throws InterruptedException {
        if (domainName != null) {
            Actions.sendKeys(webDriver, kybSearchField, domainName.toLowerCase());
        } else {
            Actions.sendKeys(webDriver, kybSearchField, "elaraby01561");
        }
    }

    public String getVendorUserId(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, vendorUserIdText);
    }

    public String getStatusText(WebDriver webDriver) throws InterruptedException {
        return Actions.getText(webDriver, statusKybText);
    }

    public void openOrganisationPage(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, vendorUserIdText);
    }

    public String getNumberOfEmps(WebDriver webDriver) throws InterruptedException {
        numOfEmps = Actions.getText(webDriver, numOfEmployeesContainer);
        return Actions.getText(webDriver, numOfEmployeesContainer);
    }

    public String getCompanyWebsite(WebDriver webDriver) throws InterruptedException {
        companyName = Actions.getAttribute(webDriver, companyWebsiteField, "value");
        return Actions.getAttribute(webDriver, companyWebsiteField, "value");
    }

    public String getAnnual(WebDriver webDriver) throws InterruptedException {
        annual = Actions.getAttribute(webDriver, approximateAnnualField, "value");
        return Actions.getAttribute(webDriver, approximateAnnualField, "value");
    }

    public String getRegulatorName(WebDriver webDriver) throws InterruptedException {
        regulatorName = Actions.getAttribute(webDriver, regulatorNameField, "value");
        return Actions.getAttribute(webDriver, regulatorNameField, "value");
    }

    public String getTax(WebDriver webDriver) throws InterruptedException {
        tax = Actions.getAttribute(webDriver, taxRegistrationNumberField, "value");
        return Actions.getAttribute(webDriver, taxRegistrationNumberField, "value");
    }


    public void getOrgInfo() throws InterruptedException {
        getNumberOfEmps(webDriver);
        getCompanyWebsite(webDriver);
        getAnnual(webDriver);
        getRegulatorName(webDriver);
        getTax(webDriver);
    }

    public String getShareholderFirstName(WebDriver webDriver) throws InterruptedException {
        shFN = Actions.getAttribute(webDriver, shareholder1FirstName, "value");
        return Actions.getAttribute(webDriver, shareholder1FirstName, "value");
    }

    public String getShareholderLastName(WebDriver webDriver) throws InterruptedException {
        shLN = Actions.getAttribute(webDriver, shareholder1LastName, "value");
        return Actions.getAttribute(webDriver, shareholder1LastName, "value");
    }

    public String getShareholderPhone(WebDriver webDriver) throws InterruptedException {
        shPh = Actions.getAttribute(webDriver, shareholder1PhoneNumber, "value");
        return Actions.getAttribute(webDriver, shareholder1PhoneNumber, "value");
    }

    public String getShareholderEmail(WebDriver webDriver) throws InterruptedException {
        shE = Actions.getAttribute(webDriver, firstEmail, "value");
        return Actions.getAttribute(webDriver, firstEmail, "value");
    }

    public String getShareholderResidentialAddress(WebDriver webDriver) throws InterruptedException {
        shAdd = Actions.getAttribute(webDriver, shareholder1ResidentialAddress, "value");
        return Actions.getAttribute(webDriver, shareholder1ResidentialAddress, "value");
    }

    public String getSignature1FirstName(WebDriver webDriver) throws InterruptedException {
        sg1FN = Actions.getAttribute(webDriver, signature1FirstName, "value");
        return Actions.getAttribute(webDriver, signature1FirstName, "value");
    }

    public String getSignature1LastName(WebDriver webDriver) throws InterruptedException {
        sg1LN = Actions.getAttribute(webDriver, signature1LastName, "value");
        return Actions.getAttribute(webDriver, signature1LastName, "value");
    }

    public String getSignature1Phone(WebDriver webDriver) throws InterruptedException {
        sg1Ph = Actions.getAttribute(webDriver, signature1PhoneNumber, "value");
        return Actions.getAttribute(webDriver, signature1PhoneNumber, "value");
    }

    public String getSignature1Email(WebDriver webDriver) throws InterruptedException {
        sg1E = Actions.getAttribute(webDriver, firstEmail, "value");
        return Actions.getAttribute(webDriver, firstEmail, "value");
    }

    public String getSignature1ResidentialAddress(WebDriver webDriver) throws InterruptedException {
        sg1Add = Actions.getAttribute(webDriver, signature1ResidentialAddress, "value");
        return Actions.getAttribute(webDriver, signature1ResidentialAddress, "value");
    }

    public String getCompanyPhone(WebDriver webDriver) throws InterruptedException {
        com1Ph = Actions.getAttribute(webDriver, companyPhoneNumber, "value");
        return Actions.getAttribute(webDriver, companyPhoneNumber, "value");
    }

    public String getCompanyEmail(WebDriver webDriver) throws InterruptedException {
        com1E = Actions.getAttribute(webDriver, secondEmail, "value");
        return Actions.getAttribute(webDriver, secondEmail, "value");
    }

    public String getCompanyAddress(WebDriver webDriver) throws InterruptedException {
        com1Add = Actions.getAttribute(webDriver, companyAdress, "value");
        return Actions.getAttribute(webDriver, companyAdress, "value");
    }

    public String getDirector1FirstName(WebDriver webDriver) throws InterruptedException {
        dir1FN = Actions.getAttribute(webDriver, director1FirstName, "value");
        return Actions.getAttribute(webDriver, director1FirstName, "value");
    }

    public String getDirector1LastName(WebDriver webDriver) throws InterruptedException {
        dir1LN = Actions.getAttribute(webDriver, director1LastName, "value");
        return Actions.getAttribute(webDriver, director1LastName, "value");
    }

    public String getDirector1Phone(WebDriver webDriver) throws InterruptedException {
        dir1Ph = Actions.getAttribute(webDriver, director1PhoneNumber, "value");
        return Actions.getAttribute(webDriver, director1PhoneNumber, "value");
    }

    public String getDirector1Email(WebDriver webDriver) throws InterruptedException {
        dir1E = Actions.getAttribute(webDriver, firstEmail, "value");
        return Actions.getAttribute(webDriver, firstEmail, "value");
    }

    public String getDirector1ResidentialAddress(WebDriver webDriver) throws InterruptedException {
        dir1Add = Actions.getAttribute(webDriver, director1ResidentialAddress, "value");
        return Actions.getAttribute(webDriver, director1ResidentialAddress, "value");
    }

    public String getSharedUserFirstName(WebDriver webDriver) throws InterruptedException {
        shared1FN = Actions.getAttribute(webDriver, shared1FirstName, "value");
        return Actions.getAttribute(webDriver, shared1FirstName, "value");
    }

    public String getSharedUserLastName(WebDriver webDriver) throws InterruptedException {
        shared1LN = Actions.getAttribute(webDriver, shared1LastName, "value");
        return Actions.getAttribute(webDriver, shared1LastName, "value");
    }

    public String getSharedUserPhone(WebDriver webDriver) throws InterruptedException {
        shared1Ph = Actions.getAttribute(webDriver, shared1PhoneNumber, "value");
        return Actions.getAttribute(webDriver, shared1PhoneNumber, "value");
    }

    public String getSharedUserMob(WebDriver webDriver) throws InterruptedException {
        shared1Mob = Actions.getAttribute(webDriver, shared1Mobile, "value");
        return Actions.getAttribute(webDriver, shared1Mobile, "value");
    }

    public String getSharedUserEmail(WebDriver webDriver) throws InterruptedException {
        shared1E = Actions.getAttribute(webDriver, firstEmail, "value");
        return Actions.getAttribute(webDriver, firstEmail, "value");
    }

    public String getSharedUserResidentialAddress(WebDriver webDriver) throws InterruptedException {
        shared1Add = Actions.getAttribute(webDriver, shared1ResidentialAddress, "value");
        return Actions.getAttribute(webDriver, shared1ResidentialAddress, "value");
    }

    public String getSignature2FirstName(WebDriver webDriver) throws InterruptedException {
        sg2FN = Actions.getAttribute(webDriver, signature2FirstName, "value");
        return Actions.getAttribute(webDriver, signature2FirstName, "value");
    }

    public String getSignature2LastName(WebDriver webDriver) throws InterruptedException {
        sg2LN = Actions.getAttribute(webDriver, signature2LastName, "value");
        return Actions.getAttribute(webDriver, signature2LastName, "value");
    }

    public String getSignature2Phone(WebDriver webDriver) throws InterruptedException {
        sg2Ph = Actions.getAttribute(webDriver, signature2PhoneNumber, "value");
        return Actions.getAttribute(webDriver, signature2PhoneNumber, "value");
    }

    public String getSignature2Email(WebDriver webDriver) throws InterruptedException {
        sg2E = Actions.getAttribute(webDriver, secondEmail, "value");
        return Actions.getAttribute(webDriver, secondEmail, "value");
    }

    public String getSignature2ResidentialAddress(WebDriver webDriver) throws InterruptedException {
        sg2Add = Actions.getAttribute(webDriver, signature2ResidentialAddress, "value");
        return Actions.getAttribute(webDriver, signature2ResidentialAddress, "value");
    }

    public String getDirector2FirstName(WebDriver webDriver) throws InterruptedException {
        dir2FN = Actions.getAttribute(webDriver, director2FirstName, "value");
        return Actions.getAttribute(webDriver, director2FirstName, "value");
    }

    public String getDirector2LastName(WebDriver webDriver) throws InterruptedException {
        dir2LN = Actions.getAttribute(webDriver, director2LastName, "value");
        return Actions.getAttribute(webDriver, director2LastName, "value");
    }

    public String getDirector2Phone(WebDriver webDriver) throws InterruptedException {
        dir2Ph = Actions.getAttribute(webDriver, director2PhoneNumber, "value");
        return Actions.getAttribute(webDriver, director2PhoneNumber, "value");
    }

    public String getDirector2Email(WebDriver webDriver) throws InterruptedException {
        dir2E = Actions.getAttribute(webDriver, secondEmail, "value");
        return Actions.getAttribute(webDriver, secondEmail, "value");
    }

    public String getDirector2ResidentialAddress(WebDriver webDriver) throws InterruptedException {
        dir2Add = Actions.getAttribute(webDriver, director2ResidentialAddress, "value");
        return Actions.getAttribute(webDriver, director2ResidentialAddress, "value");
    }

    public String getShareholderMob(WebDriver webDriver) throws InterruptedException {
        shMob = Actions.getAttribute(webDriver, shareholder1Mobile, "value");
        return Actions.getAttribute(webDriver, shareholder1Mobile, "value");
    }

    public String getSignatureMob(WebDriver webDriver) throws InterruptedException {
        sg1Mob = Actions.getAttribute(webDriver, signature1Mobile, "value");
        return Actions.getAttribute(webDriver, signature1Mobile, "value");
    }

    public String getDirectorMob(WebDriver webDriver) throws InterruptedException {
        dir1Mob = Actions.getAttribute(webDriver, director1Mobile, "value");
        return Actions.getAttribute(webDriver, director1Mobile, "value");
    }


    public void getShareholderInfo() throws InterruptedException {
        getShareholderFirstName(webDriver);
        getShareholderLastName(webDriver);
        getShareholderPhone(webDriver);
        getShareholderMob(webDriver);
        getShareholderEmail(webDriver);
        getShareholderResidentialAddress(webDriver);
    }

    public void getSignatureInfo() throws InterruptedException {
        getSignature1FirstName(webDriver);
        getSignature1LastName(webDriver);
        getSignature1Phone(webDriver);
        getSignatureMob(webDriver);
        getSignature1Email(webDriver);
        getSignature1ResidentialAddress(webDriver);

    }

    public void getCompanyInfo() throws InterruptedException {
        getCompanyPhone(webDriver);
        getCompanyEmail(webDriver);
        getCompanyAddress(webDriver);

    }

    public void getDirectorInfo() throws InterruptedException {
        getDirector1FirstName(webDriver);
        getDirector1LastName(webDriver);
        getDirector1Phone(webDriver);
        getDirectorMob(webDriver);
        getDirector1Email(webDriver);
        getDirector1ResidentialAddress(webDriver);
    }


    public void getSharedUserInfo() throws InterruptedException {
        getSharedUserFirstName(webDriver);
        getSharedUserLastName(webDriver);
        getSharedUserPhone(webDriver);
        getSharedUserMob(webDriver);
        getSharedUserEmail(webDriver);
        getSharedUserResidentialAddress(webDriver);
    }

    public String getPrimaryPersonName(WebDriver webDriver) throws InterruptedException {
        primaryPersonName = Actions.getAttribute(webDriver, primaryPersonNameField, "value");
        return Actions.getAttribute(webDriver, primaryPersonNameField, "value");
    }

    public String getSecondaryPersonName(WebDriver webDriver) throws InterruptedException {
        secondaryPersonName = Actions.getAttribute(webDriver, secondaryPersonNameField, "value");
        return Actions.getAttribute(webDriver, secondaryPersonNameField, "value");
    }

    public void getPoliticallyExposed() throws InterruptedException {
        getPrimaryPersonName(webDriver);
        getSecondaryPersonName(webDriver);
    }

    public String getCompanyNameBO(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, companyNameBackOffice, "value");
    }

    public String getNumOfEmpsBO(WebDriver webDriver) throws InterruptedException {
        return numOfEmployeesContainerBackOffice.getText();
    }

    public String getTaxBO(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, taxBackOffice, "value");
    }

    public String getAnnualBO(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, annualBackOffice, "value");
    }

    public String getRegulatorNameBO(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, regulatorNameBackOffice, "value");
    }

    public String getShFNBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, shFNBackOffice, "value");
    }

    public String getShLNBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, shLNBackOffice, "value");
    }

    public String getShPhBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, shPhBackOffice, "value");
    }

    public String getShMobBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, shMobBackOffice, "value");
    }

    public String getShEBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, shEBackOffice, "value");
    }

    public String getShAddBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, shAddBackOffice, "value");
    }

    public String getSharedFNBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sharedFNBackOffice, "value");
    }

    public String getSharedLNBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sharedLNBackOffice, "value");
    }

    public String getSharedPhBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sharedPhBackOffice, "value");
    }

    public String getSharedMobBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sharedMobBackOffice, "value");
    }

    public String getSharedEBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sharedEBackOffice, "value");
    }

    public String getSharedAddBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sharedAddBackOffice, "value");
    }

    public String getComPhBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, comPhBackOffice, "value");
    }

    public String getComEBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, comEBackOffice, "value");
    }

    public String getComAddBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, comAddBackOffice, "value");
    }

    public String getSg1FNBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sg1FNBackOffice, "value");
    }

    public String getSg1LNBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sg1LNBackOffice, "value");
    }

    public String getSg1PhBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sg1PhBackOffice, "value");
    }

    public String getSg1MobBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sg1MobBackOffice, "value");
    }

    public String getSg1EBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sg1EBackOffice, "value");
    }

    public String getSg1AddBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sg1AddBackOffice, "value");
    }

    public String getSg2FNBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sg2FNBackOffice, "value");
    }

    public String getSg2LNBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sg2LNBackOffice, "value");
    }

    public String getSg2PhBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sg2PhBackOffice, "value");
    }

    public String getSg2EBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sg2EBackOffice, "value");
    }

    public String getSg2AddBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, sg2AddBackOffice, "value");
    }

    public String getDir1FNBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, dir1FNBackOffice, "value");
    }

    public String getDir1LNBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, dir1LNBackOffice, "value");
    }

    public String getDir1PhBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, dir1PhBackOffice, "value");
    }

    public String getDir1MobBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, dir1MobBackOffice, "value");
    }

    public String getDir1EBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, dir1EBackOffice, "value");
    }

    public String getDir1AddBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, dir1AddBackOffice, "value");
    }

    public String getDir2FNBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, dir2FNBackOffice, "value");
    }

    public String getDir2LNBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, dir2LNBackOffice, "value");
    }

    public String getDir2PhBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, dir2PhBackOffice, "value");
    }

    public String getDir2EBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, dir2EBackOffice, "value");
    }

    public String getDir2AddBackOffice(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, dir2AddBackOffice, "value");
    }

    public String getSecondaryPersonNameBO(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, secondaryPersonBackOffice, "value");
    }

    public String getPrimaryPersonNameBO(WebDriver webDriver) throws InterruptedException {
        return Actions.getAttribute(webDriver, primaryPersonBackOffice, "value");
    }

    public void userDeclineKybForm(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, declinedButtonBackOffice);
    }

    public void userClickOnConfirmButton(WebDriver webDriver) throws InterruptedException {
        Actions.click(webDriver, declinedConfirmationButtonBackOffice);
    }

    public String getStatusOfOrgBO(WebDriver webDriver) throws InterruptedException {
        return orgStatusBackOffice.getText();
    }

    public String getStatusOfOrgBoOfUserActionRequired(WebDriver webDriver) throws InterruptedException {
        return userActionRequiredStatusBackOffice.getText();
    }

    public void clickOnIndividualOneRadioButton() throws InterruptedException {
        individualOneRadioButton.click();
    }

    public void clickOnIndividualTwoRadioButton() throws InterruptedException {
        individualTwoRadioButton.click();
    }

    public void clickOnIndividualThreeRadioButton() throws InterruptedException {
        individualThreeRadioButton.click();
    }

    public void clickOnIndividualFourRadioButton() throws InterruptedException {
        individualFourRadioButton.click();
    }

    public void clickOnIndividualFiveRadioButton() throws InterruptedException {
        individualFiveRadioButton.click();
    }

    public void clickOnCompanyRadioButton() throws InterruptedException {
        companyTwoRadioButton.click();
    }

    public void clickOnCompany1RadioButton() throws InterruptedException {
        companyOneRadioButton.click();
    }


    public void clickOnConfirmTypeOrgButton() throws InterruptedException {
        Actions.click(webDriver, confirmTypeOfOrg);
    }

    public void chooseIndividualTypeNum1() throws InterruptedException {
        //clickOnIndividualOneRadioButton();
        Thread.sleep(500);
        clickOnConfirmTypeOrgButton();
    }

    public void chooseIndividualTypeNum2() throws InterruptedException {
       // clickOnIndividualTwoRadioButton();
        Thread.sleep(500);
        clickOnConfirmTypeOrgButton();
    }

    public void chooseIndividualTypeNum3() throws InterruptedException {
      //  clickOnIndividualThreeRadioButton();
        Thread.sleep(500);
        clickOnConfirmTypeOrgButton();
    }

    public void chooseCompanyType() throws InterruptedException {
        clickOnCompanyRadioButton();
        Thread.sleep(500);
        clickOnConfirmTypeOrgButton();
    }

    public void chooseCompany1Type() throws InterruptedException {
        clickOnCompany1RadioButton();
        Thread.sleep(500);
        clickOnConfirmTypeOrgButton();
    }

    public void chooseIndividualTypeNum4() throws InterruptedException {
      //  clickOnIndividualFourRadioButton();
        Thread.sleep(500);
        clickOnConfirmTypeOrgButton();
    }

    public void chooseIndividualTypeNum5() throws InterruptedException {
      //  clickOnIndividualFiveRadioButton();
        Thread.sleep(500);
        clickOnConfirmTypeOrgButton();
    }

    public void clickOnDirector2ChecboxButton() throws InterruptedException {
        director2ChecboxButton.click();
        Thread.sleep(600);
    }

    public void clickOnShareholder3ChecboxButton() throws InterruptedException {
        shareholder3ChecboxButton.click();
        Thread.sleep(600);
    }

    public void clickOnSignature4ChecboxButton() throws InterruptedException {
        signature4ChecboxButton.click();
        Thread.sleep(600);
    }

    public void clickOnDirectorChecboxButton() throws InterruptedException {
        directorChecboxButton.click();
        Thread.sleep(1000);
    }
    public void clickOnShareholderChecboxButton(WebDriver webDriver) throws InterruptedException {
        shareholderChecboxButton.click();
        Thread.sleep(1000);

    }
    public void clickOnSignatureChecboxButton(WebDriver webDriver) throws InterruptedException {
        signatureChecboxButton.click();
        Thread.sleep(1000);

    }

    public void clickOnAllCheckboxes(WebDriver webDriver) throws InterruptedException {
        clickOnDirectorChecboxButton();
        waitUntilLoadingIsFinish();
        Thread.sleep(1000);
        clickOnShareholderChecboxButton(webDriver);
        waitUntilLoadingIsFinish();
        Thread.sleep(1000);
        clickOnSignatureChecboxButton(webDriver);
        Thread.sleep(1500);
    }

    public void clickOnAllCheckboxesBackOffice() throws InterruptedException {
        directorBackOffice.click();
        Thread.sleep(500);
        waitUntilLoadingIsFinish();
        Thread.sleep(1000);
        shareholderBackOffice.click();
        Thread.sleep(500);
        waitUntilLoadingIsFinish();
        Thread.sleep(1000);
        signatureBackoffice.click();
        Thread.sleep(500);
        waitUntilLoadingIsFinish();
        Thread.sleep(2000);
    }


    public String getDirectorChecboxContainer() throws InterruptedException {
        return directorChecboxContainer.getAttribute("data-testid");
    }

    public String getDirectorChecboxFullContainer() throws InterruptedException {
        return directorChecboxFullContainer.getText();
    }

    public void waitUntilDirectorChecboxButtonIsVisible() {
        Wait.untilElementIsVisible(webDriver, directorChecboxButton, 30L);
    }

    public void waitUntilAddUserTabIsClosed() {
        Wait.untilElementIsInVisible(webDriver, addUserTab, 60L);
    }

    public void waitUntilLoadingIsFinish() throws InterruptedException {
        Thread.sleep(500);
        Wait.untilElementIsInVisible(webDriver, loadingIcon, 30L);
        Thread.sleep(1000);
    }


    public String getSettingPageContainer() throws InterruptedException {
        return Actions.getText(webDriver,settingPageContainer);
    }
    public String getTextOfCheckedBox1(WebDriver webDriver) throws InterruptedException {
        String checkedBoxText = null;
        try {
            WebElement targetElement = webDriver.findElement(By.xpath("(//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium Mui-checked MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1i5ogmo'])[1]"));
            WebElement parentElement = targetElement.findElement(By.xpath(".."));
            checkedBoxText = parentElement.getText();
            System.out.println("The checked box is: " + checkedBoxText);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return checkedBoxText;
    }

    public String getTextOfCheckedBox2(WebDriver webDriver) throws InterruptedException {
        String checkedBoxText = null;
        try {
            WebElement targetElement = webDriver.findElement(By.xpath("(//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium Mui-checked MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1i5ogmo'])[2]"));
            WebElement parentElement = targetElement.findElement(By.xpath(".."));
            checkedBoxText = parentElement.getText();
            System.out.println("The checked box is: " + checkedBoxText);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return checkedBoxText;
    }

    public String getTextOfCheckedBox3(WebDriver webDriver) throws InterruptedException {
        String checkedBoxText = null;
        try {
            WebElement targetElement = webDriver.findElement(By.xpath("(//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium Mui-checked MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1i5ogmo'])[3]"));
            WebElement parentElement = targetElement.findElement(By.xpath(".."));
            checkedBoxText = parentElement.getText();
            System.out.println("The checked box is: " + checkedBoxText);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return checkedBoxText;
    }

    public String getTextOfCheckedBox4(WebDriver webDriver) throws InterruptedException {
        String checkedBoxText = null;
        try {
            WebElement targetElement = webDriver.findElement(By.xpath("(//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium Mui-checked MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1i5ogmo'])[4]"));
            WebElement parentElement = targetElement.findElement(By.xpath(".."));
            checkedBoxText = parentElement.getText();
            System.out.println("The checked box is: " + checkedBoxText);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return checkedBoxText;
    }

    public String getTextOfCheckedBox5(WebDriver webDriver) throws InterruptedException {
        String checkedBoxText = null;
        try {
            WebElement targetElement = webDriver.findElement(By.xpath("(//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium Mui-checked MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1i5ogmo'])[5]"));
            WebElement parentElement = targetElement.findElement(By.xpath(".."));
            checkedBoxText = parentElement.getText();
            System.out.println("The checked box is: " + checkedBoxText);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return checkedBoxText;
    }

    public String getTextOfCheckedBox6(WebDriver webDriver) throws InterruptedException {
        String checkedBoxText = null;
        try {
            WebElement targetElement = webDriver.findElement(By.xpath("(//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium Mui-checked MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-sizeMedium css-1i5ogmo'])[6]"));
            WebElement parentElement = targetElement.findElement(By.xpath(".."));
            checkedBoxText = parentElement.getText();
            System.out.println("The checked box is: " + checkedBoxText);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return checkedBoxText;
    }
    public void removeCompanyUBO5() throws InterruptedException {
        Thread.sleep(500);
        Actions.click(webDriver, removeCompanyUBO5);
    }

    public Integer numOfCompanyUBO() throws InterruptedException {
        Thread.sleep(500);
        return companyUBOContanier.size();
    }

    public void removeCompanyUBO4() throws InterruptedException {
        Thread.sleep(500);
        Actions.click(webDriver, removeCompanyUBO4);
    }

    public void removeCompanyUBO3() throws InterruptedException {
       Thread.sleep(500);
       Actions.click(webDriver, removeCompanyUBO3);
    }


    public void removeCompanyUBOInBackOffice3() throws InterruptedException {
        Thread.sleep(500);
        Actions.click(webDriver, removeCompanyUBOInBackOffice03);
    }

    public void openTheUploadedDocument1() throws InterruptedException {
        Actions.click(webDriver, viewDocument1);
    }

    public String getUrlOfDocument1() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument1, "href");
    }

    public String getUrlOfDocument2() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument2, "href");
    }

    public String getUrlOfDocument3() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument3, "href");
    }

    public String getUrlOfDocument4() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument4, "href");
    }

    public String getUrlOfDocument5() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument5, "href");
    }

    public String getUrlOfDocument6() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument6, "href");
    }

    public String getUrlOfDocument7() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument7, "href");
    }

    public String getUrlOfDocument8() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument8, "href");
    }

    public String getUrlOfDocument9() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument9, "href");
    }

    public String getUrlOfDocument10() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument10, "href");
    }

    public String getUrlOfDocument11() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument11, "href");
    }

    public String getUrlOfDocument12() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument12, "href");
    }

    public String getUrlOfDocument13() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument13, "href");
    }

    public String getUrlOfDocument14() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument14, "href");
    }

    public String getUrlOfDocument15() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument15, "href");
    }

    public String getUrlOfDocument16() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument16, "href");
    }

    public String getUrlOfDocument17() throws InterruptedException {
        return Actions.getAttribute(webDriver, viewDocument17, "href");
    }

    public void waitUntilDocument8IsAppeared(WebDriver webDriver) throws InterruptedException {
        Wait.untilElementIsVisible(webDriver, viewDocument8, 20L);
    }

    public void waitUntilDocument11IsAppeared(WebDriver webDriver) throws InterruptedException {
        Wait.untilElementIsVisible(webDriver, viewDocument11, 20L);
    }

    public void waitUntilDocument14IsAppeared(WebDriver webDriver) throws InterruptedException {
        Wait.untilElementIsVisible(webDriver, viewDocument14, 20L);
    }

    public void waitUntilDocument17IsAppeared(WebDriver webDriver) throws InterruptedException {
        Wait.untilElementIsVisible(webDriver, viewDocument17, 20L);
    }

    public void waitUntilDocument3IsAppeared(WebDriver webDriver) throws InterruptedException {
        Wait.untilElementIsVisible(webDriver, viewDocument3, 20L);
    }


    public void waitUntilDocument4IsAppeared(WebDriver webDriver) throws InterruptedException {
         Wait.untilElementIsVisible(webDriver,viewDocument4,20L);
    }

    public String extractUrlUntilPdf(String fullUrl) {
        if (fullUrl.indexOf(".pdf") != -1) {
            return fullUrl.substring(0, fullUrl.indexOf(".pdf") + 4);
        }
        if (fullUrl.indexOf(".png") != -1) {
            return fullUrl.substring(0, fullUrl.indexOf(".png") + 4);
        }
        return fullUrl.substring(0, fullUrl.indexOf(".jpg") + 4);
    }




    public void openNextTab(WebDriver driver) throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));    }

    public void openOrginalTab(WebDriver driver) throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));    }

    public String getPageTitle() {
        return pageTitle.getText();
    }


    public void remove1Document() throws InterruptedException {
        Actions.click(webDriver,remove1Button);
    }
    public void remove2Document() throws InterruptedException {
        Actions.click(webDriver,remove2Button);
    }
    public void remove3Document() throws InterruptedException {
        Actions.click(webDriver,remove3Button);
    }
    public void remove4Document() throws InterruptedException {
        Actions.click(webDriver,remove4Button);
    }
    public void remove5Document() throws InterruptedException {
        Actions.click(webDriver,remove5Button);
    }

    public String browseFileContainerText() throws InterruptedException {
       return Actions.getText(webDriver,browseFileContainer1);
    }

    public boolean ValidateFieldsOfCompanyAreAppeared() throws InterruptedException {
        companyPhoneNumber.isEnabled();
        companyAdress.isEnabled();
        firstEmail.isEnabled();
        tradeLicenseComUpload.isEnabled();
        memorandumOfAssociationComUpload.isEnabled();
        certificateOfIncorporationComUpload.isEnabled();
        certificateOfIncumbencyComUpload.isEnabled();
        recentBankStatementComUpload.isEnabled();
        return true;
    }

    public boolean validateViewFormButtonIsDisabled() throws InterruptedException {
        return  !disabledViewFormButton.isEnabled();
    }

    public void clickOnBackOfficeAddressUBO3ApproveButton() throws InterruptedException {
        backOfficeAdressUBO3ApproveButton.click();    }


    public void clickOnBackOfficeAddressUBO3RejectButton() throws InterruptedException {
        backOfficeAdressUBO3RejectButton.click();    }

    public String getToastMessageText() throws InterruptedException {
        return Actions.getText(webDriver,toastMessageText);
    }

    public Boolean validateToastMessageIsDisplayed(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(500);
        Wait.untilElementIsVisible(webDriver,toastMessageText,30L);
        return  toastMessageText.isDisplayed();
    }

    public void enterRejectionReasonForEntry(String reason) throws InterruptedException {
        Actions.sendKeys(webDriver, backOfficeRejectionField, reason);
    }

    public void clickOnBackOfficeConfirmButton() throws InterruptedException {
        Actions.click(webDriver, backOfficeConfirmButton);
    }

    public void clickOnUserActionButtonBackOffice() throws InterruptedException {
        Actions.click(webDriver, userActionButtonBackOffice);
    }

    public String getBackOfficeAddressErrorMessageText() throws InterruptedException {
        return Actions.getText(webDriver,backOfficeAddressErrorMessageContainer);
    }

    public String getPemoAddressErrorMessageText() throws InterruptedException {
        return Actions.getText(webDriver,pemoAddressErrorMessageContainer);
    }

    public void syncNewUsers() throws InterruptedException {
        Thread.sleep(500);
        Actions.click(webDriver, syncNewUsersButton);
        Thread.sleep(1000);
        Actions.click(webDriver, syncConfirmationButton);
    }

    public void updateUserInfo() throws InterruptedException {
        Actions.click(webDriver, updateUserInfoButton);
        Thread.sleep(1000);
        Actions.click(webDriver, orgInfoUpdateUserConfirmationBackOffice);
    }

    public void removeUserBackOffice() throws InterruptedException {
        Actions.click(webDriver, removeUserBackOfficeButton);
        Thread.sleep(1000);
    }

    public void addItemInBackOffice() throws InterruptedException {
        Actions.click(webDriver, addItemButtonBackOffice);
        Thread.sleep(500);
    }

    public void addItemDetailsInBackOffice() throws InterruptedException {
        itemName = generateUniqueItemName();
        Actions.sendKeys(webDriver, addItemDetailsTitleField, itemName);
        Thread.sleep(300);
        Actions.sendKeys(webDriver, addItemDetailsDescriptionField, "added description test");
        Thread.sleep(300);
        Actions.sendKeys(webDriver, addItemDetailsPlaceholderBackOffice, "added placeholder test");
    }

    public void confirmAddItem() throws InterruptedException {
        Actions.click(webDriver, orgInfoUpdateUserConfirmationBackOffice);
        Thread.sleep(500);
    }

    public static String generateUniqueItemName() {
        String generateUniqueTeamName = RandomStringUtils.randomAlphanumeric(3);
        return "added item test" + generateUniqueTeamName;
    }

    public void clickOnSendToNymCard1() throws InterruptedException {
        Actions.click(webDriver, sendToNymCard1);
        Thread.sleep(500);
    }

    public String getCompanyUBO1ContanierText() throws InterruptedException {
        return Actions.getText(webDriver,companyUBO1Contanier);
    }


    public boolean ValidateThreeButtonForTradeFileInBackOfficeAreAppeared() throws InterruptedException {
        viewDocument1.isEnabled();
        sendToNymCard1.isEnabled();
        tradeLicenseBackOfficeUpload.isEnabled();
        return true;
    }

    public void validateNoDirectorUserIsAddedBefore() throws InterruptedException {
        try {
            if (removeCompanyUBO3.isDisplayed()) {
                removeCompanyUBO3();
                Wait.untilElementIsInVisible(webDriver,removeCompanyUBO3,10L);
                if (removeCompanyUBO3.isDisplayed()){
                    removeCompanyUBO3();
                    Thread.sleep(500);                }
                if (removeCompanyUBO3.isDisplayed()){
                    removeCompanyUBO3();
                    Thread.sleep(500);
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("No user added before");
        }
    }

}
