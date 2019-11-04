package com.selenium.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestInfoPage extends HomePage {


    @FindBy(id = "Email-clone")
    WebElement emailElement;

    @FindBy(id = "Phone-clone")
    WebElement phoneNumberElement;

    @FindBy(id = "Company__c-clone")
    WebElement companyElement;

    @FindBy(id = "Address-clone")
    WebElement addressElement;

    @FindBy(id = "City-clone")
    WebElement cityElement;

    @FindBy(id = "PostalCode-clone")
    WebElement zipElement;

    @FindBy(id = "State-clone")
    WebElement stateElement;

    @FindBy(id = "Country-clone")
    WebElement countryElement;

    @FindBy(xpath = "//*[contains(text(), 'HOW MANY PRIVATE FLIGHTS DO YOU TAKE A YEAR?')]//..//*[contains(@class, 'dropdown')]//*[name()='svg']")
    WebElement howManyFlightsField;

    @FindBy(xpath = "//*[contains(text(), 'HOW MANY PRIVATE FLIGHTS DO YOU TAKE A YEAR?')]//..//*[contains(@class, 'dropdown')]//*[contains(text(), '1-5')]")
    WebElement howManyFlights1_5;

    @FindBy(xpath = "//*[contains(text(), 'DO YOU HAVE A NEED TO TRAVEL WITH PETS?')]//..//*[text() = 'Yes']//..//span[@class='circle']")
    WebElement travelWithPatsYes;

    @FindBy(xpath = "//*[contains(text(), 'Do you own or travel to a second home?')]//..//*[contains(@class, 'dropdown')]//*[contains(text(), 'Please select one')]")
    WebElement travelToSecondHomeField;

    @FindBy(xpath = "//*[contains(text(), 'Do you own or travel to a second home?')]//..//*[contains(@class, 'dropdown')]//*[contains(text(), 'No')]")
    WebElement travelToSecondHomeNo;

    @FindBy(xpath = "//*[contains(text(), 'How do you currently FLY?')]//..//span[text()='Charter']//..//*[@class='square']")
    WebElement howDoYouCurrentlyFlyCharter;

    @FindBy(xpath = "//*[contains(text(), 'WHAT MEMBERSHIP TYPE ARE YOU INTERESTED IN?')]//..//span[text()='Wheels Up Core Membership']//..//*[@class='square']")
    WebElement whatMembershipAreYouInterestedCore;


    @FindBy(xpath = "//*[contains(text(), 'How did you hear about us?')]//..//*[contains(@class, 'dropdown')]//*[contains(text(), 'Please select one')]")
    WebElement howDidYouHearAboutUsField;

    @FindBy(xpath = "//*[contains(text(), 'How did you hear about us?')]//..//*[contains(@class, 'dropdown')]//*[contains(text(), 'Email from Wheels Up')]")
    WebElement howDidYouHearAboutUsEmailFromWheelsUp;

    @FindBy(xpath = "//*[contains(text(), 'Please let us know any specific questions you want answered.')]//..//textarea")
    WebElement anySpecificQuestions;

    @FindBy(xpath = "//*[@class='close']//*[@class='icon-close']")
    WebElement cancelIcon;


    public RequestInfoPage fillEmail(String email){
        waitForElementToBeVisible(emailElement).sendKeys(email);

        return this;
    }

    public RequestInfoPage fillPhoneNumber(String phoneNumber){
        waitForElementToBeVisible(phoneNumberElement).sendKeys(phoneNumber);

        return this;
    }

    public RequestInfoPage fillCompanyName(String companyName){
        waitForElementToBeVisible(companyElement).sendKeys(companyName);

        return this;
    }

    public RequestInfoPage fillAddress(String address){
        waitForElementToBeVisible(addressElement).sendKeys(address);

        return this;
    }

    public RequestInfoPage fillCity(String city){
        waitForElementToBeVisible(cityElement).sendKeys(city);

        return this;
    }

    public RequestInfoPage fillZipCode(String zipCode){
        waitForElementToBeVisible(zipElement).sendKeys(zipCode);

        return this;
    }

    public RequestInfoPage fillState(String state){
        waitForElementToBeVisible(stateElement).sendKeys(state);

        return this;
    }

    public RequestInfoPage fillCountry(String country){
        waitForElementToBeVisible(countryElement).sendKeys(country);

        return this;
    }

    public RequestInfoPage howManyFlightsDoYouTake1_5(){
        scrollToElement(howManyFlightsField);
        clickWithJS(howManyFlightsField);
        waitForElementToBeVisible(howManyFlights1_5).click();

        return this;
    }


    public RequestInfoPage travelWithPats_Yes(){
        clickWithJS(travelWithPatsYes);

        return this;
    }

    public RequestInfoPage travelToASecondHome_No(){
        clickWithJS(travelToSecondHomeField);
        clickWithJS(travelToSecondHomeNo);

        return this;
    }

    public RequestInfoPage howDoYouCurrentlyFly_Charter(){
        clickWithJS(howDoYouCurrentlyFlyCharter);

        return this;
    }

    public RequestInfoPage whatMembershipAreYouInterested_Core(){
        clickWithJS(whatMembershipAreYouInterestedCore);

        return this;
    }

    public RequestInfoPage howDidYouHearAboutUs_EmailFromWheelsUp(){
        clickWithJS(howDidYouHearAboutUsField);
        waitForElementToBeVisible(howDidYouHearAboutUsEmailFromWheelsUp).click();

        return this;
    }

    public RequestInfoPage fillAnySpecificQuestions(String comment){
        waitForElementToBeVisible(anySpecificQuestions).sendKeys(comment);

        return this;
    }

    public void clickCancel(){
        waitForElementToBeVisible(cancelIcon).click();
    }
}
