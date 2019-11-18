package com.selenium.pagefactory;

import io.qameta.allure.Step;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//mat-icon")
    WebElement cookiePolicy;

    @FindBy(xpath = "//*[@class='content']//*[@class='heading ui-reveal']")
    WebElement contentTitle;

    @FindBy(xpath = "//*[@class='menu-item']//a[contains(text(), 'Membership Options')]")
    WebElement menuMembershipOptions;

    @FindBy(xpath = "//*[@class='menu-item']//a[contains(text(), 'CORE MEMBERSHIP')]")
    WebElement menuCoreMembership;

    @FindBy(tagName = "footer")
    WebElement footer;

    @FindBy(xpath = "//*[@class='linkFooter mobile']//..//*[@class='icon-trendingflat']")
    WebElement trendingFlatIcon;

    @FindBy(xpath = "//*[@class='title' and text()='Find Us']//..//..//*[@class='list']")
    WebElement address;

    @FindBy(xpath = "//*[@class='title' and text()='Contact Us']//..//..//*[@class='list']")
    WebElement contactUs;

    @Step("Get Text From Content Title")
    public String getTextFromContentTitle(){
        return waitForElementToBeVisible(contentTitle).getText();
    }

    @Step("Get Address")
    public String getAddress(){
        return waitForElementToBeVisible(address).getText();
    }

    @Step("Get Contact Us")
    public String getContactUs(){
        return waitForElementToBeVisible(contactUs).getText();
    }

    @Step("Scroll To Footer")
    public HomePage scrollToFooter(){
        scrollToElement(footer);
        return this;
    }

    @Step("Click Go To Top Icon")
    public HomePage clickGoToTopIcon() throws InterruptedException {
        waitForElementToBeVisible(trendingFlatIcon).click();
        Thread.sleep(3000);
        waitForElementToBeVisible(contentTitle);

        return this;
    }

    @Step("Click Menu Membership Options")
    public HomePage clickMenuMembershipOptions(){
        waitForElementToBeVisible(menuMembershipOptions).click();

        return this;
    }

    @Step("Click Menu Core Membership")
    public CoreMembershipPage clickMenuCoreMembership(){
        waitForElementToBeVisible(menuCoreMembership).click();

        return new CoreMembershipPage();
    }

    @Step("Click Cancel Cookie Policy")
    public HomePage clickCancelCookiePolicy(){
        try{
            cookiePolicy.click();
        }catch (ElementNotInteractableException ex){}

        return this;
    }
}
