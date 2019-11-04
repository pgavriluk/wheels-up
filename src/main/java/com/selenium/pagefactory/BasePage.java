package com.selenium.pagefactory;

import com.util.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BasePage {

    private static final Logger LOG = LoggerFactory.getLogger(BasePage.class);
    private static String browser = "chrome";
    private static String url = "https://wheelsup.com/";
    private static WebDriver driver;
    private static WebDriverWait wait;

    BasePage() {
        driver = WebDriverManager.getWebDriver(browser);
        PageFactory.initElements(driver, this);
        if (wait == null) {
            wait = new WebDriverWait(driver, 20);
        }
    }

    public void openUrl(){
        LOG.info("Opening the following url: " + url);
        driver.get(url);
    }

    public void tearDown(){
        LOG.info("Starting tear down method and closing all browsers");
        driver.quit();
    }

    WebElement waitForElementToBeVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    void clickWithJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('click', {view: window, bubbles:true, cancelable: true}))", element);
    }
}
