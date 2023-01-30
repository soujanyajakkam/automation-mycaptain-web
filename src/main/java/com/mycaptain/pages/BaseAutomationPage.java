package com.mycaptain.pages;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;


public abstract class BaseAutomationPage {
    private static final Logger logger = Logger.getLogger(BaseAutomationPage.class.getName());
    public static String TEST_FILE_PATH;
    protected WebDriver driver;

    protected BaseAutomationPage(WebDriver driver) {
        this.driver = driver;
        if (TEST_FILE_PATH == null) {
            logger.debug("In Constructor " + TEST_FILE_PATH);
        }
        PageFactory.initElements(driver, this);
    }

    public void pause(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void selectDropdown(String xpath, String value) {
        Select conditions = new Select(driver.findElement(By.xpath(xpath)));
        conditions.selectByValue(value);
    }

    protected void selectDropdownByIndex(String xpath, int index) {
        Select conditions = new Select(driver.findElement(By.xpath(xpath)));
        conditions.selectByIndex(index);

    }

    protected WebElement findElement(WebElement webelement, WEB_ACTIONS webActions) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        switch (webActions) {
            case CLICK:
                wait.until(ExpectedConditions.elementToBeClickable(webelement));
                break;
            case VISIBILE:
                wait.until(ExpectedConditions.visibilityOf(webelement));
                break;
            default:
                wait.until(ExpectedConditions.visibilityOf(webelement));
        }
        return webelement;
    }

    protected List<WebElement> findElements(WebElement webelement, WEB_ACTIONS mobileActions) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        switch (mobileActions) {
            case CLICK:
                wait.until(ExpectedConditions.elementToBeClickable(webelement));
                break;
            case VISIBILE:
                wait.until(ExpectedConditions.visibilityOf(webelement));
                break;
            default:
                wait.until(ExpectedConditions.visibilityOf(webelement));

        }
        return (List<WebElement>) webelement;
    }

    protected void clickOnWebElementUsingJS(WebElement webelement) {
        findElement(webelement, WEB_ACTIONS.CLICK);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webelement);
    }

    protected void clickOnWebElement(WebElement webelement) {
        findElement(webelement, WEB_ACTIONS.CLICK).click();
    }

    protected String getText(WebElement webelement) {
        return findElement(webelement, WEB_ACTIONS.VISIBILE).getText();
    }

    protected void sendKeys(WebElement webelement, String keys) {
        findElement(webelement, WEB_ACTIONS.VISIBILE).sendKeys(keys);
    }

    protected void clearText(WebElement webelement) {
        findElement(webelement, WEB_ACTIONS.VISIBILE).clear();
    }

    protected Actions scrolltoView(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        return actions;
    }

    protected Actions scrollDown() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        return actions;
    }

    protected Actions scrollUp() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        return actions;
    }

  
public void switchToNewUrl(String url) {
	Actions action = new Actions(driver); action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform(); //opening the URL saved. 
	driver.get(url);
	
}
    public enum WEB_ACTIONS {
        CLICK, VISIBILE, TEXT
    }
}


