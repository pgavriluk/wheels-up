package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.function.Supplier;

public final class WebDriverManager {

    private static final Logger LOG = LoggerFactory.getLogger(WebDriverManager.class);
    private static WebDriver driver;

    public static WebDriver getWebDriver(String browserName) {
        if (driver == null) {
            Browser browser = getBrowserFromString(browserName);
            switch (browser) {
                case FIREFOX:
                    System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
                    break;
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
                    break;
                case IE:
                    // implementation for IE
                    break;
                default:
                    break;
            }
            driver = browser.getDriver();
            driver.manage().window().maximize();
        }

        return driver;

    }

    private static Browser getBrowserFromString(String value) {
        for (Browser browser : Browser.values()) {
            if (value != null && value.toLowerCase().equals(browser.getName())) {
                return browser;
            }
        }
        LOG.error("Invalid driver name passed as 'browser' property. "
                + "One of: " + Arrays.toString(Browser.values()) + " is expected.");
        return Browser.CHROME;
    }

    private enum Browser {
        FIREFOX("firefox", FirefoxDriver::new),
        CHROME("chrome", ChromeDriver::new),
        IE("ie", InternetExplorerDriver::new);

        private String name;
        private Supplier<WebDriver> driverSupplier;

        Browser(String name, Supplier<WebDriver> driverSupplier) {
            this.name = name;
            this.driverSupplier = driverSupplier;
        }

        public String getName() {
            return name;
        }

        public WebDriver getDriver() {
            return driverSupplier.get();
        }

    }
}
