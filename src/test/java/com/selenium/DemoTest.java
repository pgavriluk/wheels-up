package com.selenium;

import com.selenium.pagefactory.CoreMembershipPage;
import com.selenium.pagefactory.RequestInfoPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class DemoTest extends BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(DemoTest.class);

    @Before
    public void beforeTest() {
        LOG.info("Starting Before Test method");
        openUrl();
    }


    @Test
    public void demoTest() throws InterruptedException {
        LOG.info("Starting test: " + testName.getMethodName());
        String contentTitleText = homePage.clickCancelCookiePolicy().getTextFromContentTitle();
        LOG.info("Content Title is: " + contentTitleText);

        homePage.scrollToFooter();
        Thread.sleep(1000);

        String address = homePage.getAddress();
        String contactUs = homePage.getContactUs();

        LOG.info("Our Address is: " + address.replace("\n", ", "));
        LOG.info("Our Phone Number is: " + contactUs.split("\n")[0]);
        LOG.info("Our Email is: " + contactUs.split("\n")[1]);

        CoreMembershipPage coreMembershipPage =
                homePage.clickGoToTopIcon()
                        .clickMenuMembershipOptions()
                        .clickMenuCoreMembership()
                        .scrollToBecomingAWheelsUpCoreMemberIsEasySection();

        String oneTimeInitiationFee = coreMembershipPage.getTextFromOneTimeInitiationFeeDescription();

        LOG.info("One Time Initiation Fee is: " + oneTimeInitiationFee);

        RequestInfoPage requestInfoPage =
                coreMembershipPage.scrollToLearnMoreTodaySection()
                .fillFirstName("John")
                .fillLastName("Smith")
                .clickContinue();

        fillRequestInfoAndCancel(requestInfoPage);

        LOG.info("End of the test");
    }

    private void fillRequestInfoAndCancel(RequestInfoPage requestInfoPage) {

        requestInfoPage.fillEmail("demoEmail@gmail.com")
                .fillPhoneNumber("201-999-9999")
                .fillCompanyName("Great company")
                .fillAddress("50 Washington Blvd")
                .fillCity("New York")
                .fillZipCode("10000")
                .fillState("NY")
                .fillCountry("USA")
                .howManyFlightsDoYouTake1_5()
                .travelWithPats_Yes()
                .travelToASecondHome_No()
                .howDoYouCurrentlyFly_Charter()
                .whatMembershipAreYouInterested_Core()
                .howDidYouHearAboutUs_EmailFromWheelsUp()
                .fillAnySpecificQuestions("I have a great question")
                .clickCancel();
    }


}
