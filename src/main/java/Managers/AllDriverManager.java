package Managers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class AllDriverManager {

    private WebDriver webDriver;
    ChromeOptions options_chrome = new ChromeOptions();
    FirefoxOptions options_firefox = new FirefoxOptions();
    private static ThreadLocal<RemoteWebDriver> remote_driver = new ThreadLocal<>();
    String remote_url = "http://localhost:4444/wd/hub";

    public AllDriverManager() {
        ;
        FileReaderManager.getInstance().getConfigFileReader();
    }

    private WebDriver createDriver() {

        if (webDriver == null) {
            String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser")
                    : FileReaderManager.getInstance().getConfigFileReader().getProperty("browser");
            switch (browser) {
                case "chrome":
                    options_chrome.addArguments("--remote-allow-origins=*");
                    webDriver = new ChromeDriver(options_chrome);
                    break;
                case "chrome-headless":
                    options_chrome.addArguments("--remote-allow-origins=*");
                    options_chrome.addArguments("--headless");
                    webDriver = new ChromeDriver(options_chrome);
                    break;
                case "firefox":
                    webDriver = new FirefoxDriver(options_firefox);
                    break;
                case "firefox-headless":
                    options_firefox.addArguments("--headless");
                    webDriver = new FirefoxDriver(options_firefox);

                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    InternetExplorerOptions options_ie = new InternetExplorerOptions();
                    webDriver = new InternetExplorerDriver(options_ie);
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    EdgeOptions options_edge = new EdgeOptions();
                    webDriver = new EdgeDriver(options_edge);

                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    SafariOptions options_safari = new SafariOptions();
                    webDriver = new SafariDriver(options_safari);
                    break;

                case "remote_chrome":
                    // Initiating chrome driver with docker
                    // ChromeOptions options = new ChromeOptions();
                    // options.addArguments("start-maximized"); // open Browser in maximized mode
                    // options.addArguments("disable-infobars"); // disabling infobars
                    // options.addArguments("--disable-extensions"); // disabling extensions
                    // options.addArguments("--disable-gpu"); // applicable to windows os only
                    // options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                    // options.addArguments("--no-sandbox"); // Bypass OS security model
                    // options.addArguments("--headless");
                    // options.addArguments("--remote-debugging-port=9222");
                    // //options.setCapability("platform", Platform.ANY);

                    // try {
                    //     remote_driver.set(new RemoteWebDriver(new URL(remote_url), options));
                    // } catch (MalformedURLException e) {
                    //     e.printStackTrace();
                    // }

                    FirefoxOptions options = new FirefoxOptions();
                    try {
                    remote_driver.set(new RemoteWebDriver(new URL(remote_url), options));
                    } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    }
                    break;
            }
        }
        if (webDriver != null)
            return webDriver;
        else
            return remote_driver.get();
    }

    public WebDriver getDriver() {
        if (webDriver == null)
            webDriver = createDriver();
        return webDriver;
    }

    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }
}
