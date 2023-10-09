package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExportPage {

    private final WebDriver webDriver;

        public ExportPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Accounting V2')]")
    public WebElement enableAccountibgV2Toggle;

    @FindBy(xpath = "//p[contains(text(),'Export pocket expenses')]")
    public WebElement exportPocketExpensesPage;

    @FindBy(xpath = "//*[@id=\"drawer-container\"]/div/div[1]/div[2]/button[2]")
    public WebElement historyBtn;

    @FindBy(xpath = "//*[@id=\"drawer-container\"]/div/div/table/tbody/tr[1]/td[5]/a")
    public WebElement exportFirstFile;


    
}
