package com.selenium.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoreMembershipPage extends HomePage {

    @FindBy(xpath = "//*[@class='content']//*[contains(@class,'heading ui-reveal')]")
    WebElement contentTitle;

    @FindBy(xpath = "//*[contains(@class, 'module-title')]//*[text()='Becoming a Wheels Up Core Member is easy']")
    WebElement becomingAWheelsUpCoreMemberIsEasySection;

    @FindBy(xpath = "//*[contains(@class, 'module-title')]//*[text()='Learn more today']")
    WebElement learnMoreTodaySection;

    @FindBy(xpath = "//*[contains(@class, 'title') and text()='One-time initiation fee']//..//*[@class='description']")
    WebElement oneTimeInitiationFeeDescription;

    @FindBy(xpath = "//*[contains(@class, 'module-title')]//*[text()='Learn more today']//..//..//..//..//input[contains(@id, 'FirstName')]")
    WebElement firstNameElement;

    @FindBy(xpath = "//*[contains(@class, 'module-title')]//*[text()='Learn more today']//..//..//..//..//input[contains(@id, 'LastName')]")
    WebElement lastNameElement;

    @FindBy(xpath = "//*[contains(@class, 'module-title')]//*[text()='Learn more today']//..//..//..//..//a[@href='/request-info']")
    WebElement continueButton;

    public CoreMembershipPage scrollToBecomingAWheelsUpCoreMemberIsEasySection() throws InterruptedException {
        waitForElementToBeVisible(contentTitle);
        Thread.sleep(3000);
        scrollToElement(becomingAWheelsUpCoreMemberIsEasySection);

        return this;
    }

    public CoreMembershipPage scrollToLearnMoreTodaySection() {
        scrollToElement(learnMoreTodaySection);

        return this;
    }

    public String getTextFromOneTimeInitiationFeeDescription() {
        return waitForElementToBeVisible(oneTimeInitiationFeeDescription).getText();
    }

    public CoreMembershipPage fillFirstName(String firstName){
        waitForElementToBeVisible(firstNameElement).sendKeys(firstName);

        return this;
    }

    public CoreMembershipPage fillLastName(String lastName){
        waitForElementToBeVisible(lastNameElement).sendKeys(lastName);

        return this;
    }

    public RequestInfoPage clickContinue(){
        waitForElementToBeVisible(continueButton).click();

        return new RequestInfoPage();
    }
}
