package com.selenium.pagefactory;

import com.util.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;


public abstract class BasePage {

    private static final Logger LOG = LoggerFactory.getLogger(BasePage.class);
    private static final String BROWSER = "BROWSER";
    private static final String HUB_HOST = "localhost";
    private static String browser = "chrome";
    private static String host = "localhost";
    private static String url = "https://wheelsup.com/";
    private static WebDriver driver;
    private static WebDriverWait wait;

    BasePage() {
        // Browser --> chrome/firefox
        // HUB_HOST --> localhost/10.0.1.3/hostname
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("no-sandbox");
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        if(System.getProperty(BROWSER) != null && System.getProperty(BROWSER).equalsIgnoreCase("firefox")){
            desiredCapabilities = DesiredCapabilities.firefox();
        }

        if(System.getProperty(HUB_HOST) != null){
            host = System.getProperty(HUB_HOST);
        }

        String fullUrl = "http://" + host + ":4444/wd/hub";

        try {
            driver = new RemoteWebDriver(new URL(fullUrl), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //driver = WebDriverManager.getWebDriver(browser);

        PageFactory.initElements(driver, this);
        if (wait == null) {
            wait = new WebDriverWait(driver, 20);
        }


    }

    @Step("Open Url")
    public void openUrl(){
        LOG.info("Opening the following url: " + url);
        driver.get(url);
    }

    @Step("Tear Down")
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
