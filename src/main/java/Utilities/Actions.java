package Utilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {

    private static void until(WebDriver webDriver, Long timeOutInSeconds, Function<WebDriver, Boolean> waitCondition) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds));
        try {
            webDriverWait.until(waitCondition);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void untilAjaxCallIsDone(WebDriver webDriver, Long timeOutInSeconds) {
        until(webDriver, timeOutInSeconds, (function) -> {
            Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) webDriver)
                    .executeScript("return jQuery.active==0");
            if (!isJqueryCallDone)
                System.out.println("jQuery call is in progress");
            return isJqueryCallDone;
        });
    }

    public static void untilPageReadyState(WebDriver webDriver, Long timeOutInSeconds) {
        until(webDriver, timeOutInSeconds, (function) -> {
            String isPageLoaded = String
                    .valueOf(((JavascriptExecutor) webDriver).executeScript("return document.readyState"));
            if (isPageLoaded.equals("complete")) {
                return true;
            } else {
                System.out.println("Document is loading");
                return false;
            }
        });
    }

    public static void untilElementIsVisible(WebDriver webDriver, WebElement webElement, Long timeOutInSeconds) {
        new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void untilElementIsClickable(WebDriver webDriver, WebElement webElement, Long timeOutInSeconds) {
        new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void untilElementIsInVisible(WebDriver webDriver, WebElement webElement, Long timeOutInSeconds) {
        new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds))
                .until(ExpectedConditions.invisibilityOf(webElement));
    }

    public static void untilListElementIsVisible(WebDriver webDriver, List<WebElement> webElements,
            Long timeOutInSeconds) {
        new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds))
                .until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    public static void untilTitleBecome(WebDriver webDriver, String title, Long timeOutInSeconds) {
        new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds)).until(ExpectedConditions.titleIs(title));
    }

    public static void untilTextContain(WebDriver webDriver, String text, Long timeOutInSeconds,
            WebElement webElement) {
        new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds))
                .until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    public static void compare_csv_file(String filePath) throws IOException, CsvValidationException {
        CSVReader readcsv = new CSVReader(new FileReader(filePath));
        String[] nextLine;
        while ((nextLine = readcsv.readNext()) != null) {
            System.out.println(nextLine[0]);
            System.out.println(nextLine[1]);
            System.out.println(nextLine[2]);
            System.out.println(nextLine[3]);
            System.out.println(nextLine[4]);
            System.out.println(nextLine[5]);
        }
    }

    public static void sendKeys(WebDriver webDriver, WebElement element, String data) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(data);
    }

    public static void click(WebDriver webDriver, WebElement element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static String getText(WebDriver webDriver, WebElement element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public static String getAttribute(WebDriver webDriver, WebElement element,String attribute) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute(attribute);
    }

    public static void clear(WebDriver webDriver, WebElement element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

}
