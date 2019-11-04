package com.selenium;

import com.selenium.pagefactory.HomePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public abstract class BaseTest {

    static HomePage homePage;
    @Rule
    public TestName testName = new TestName();


    @BeforeClass
    public static void setUpBeforeClass(){
        homePage = new HomePage();
    }


    void openUrl(){
        homePage.openUrl();
    }

    @AfterClass
    public static void tearDownAfterClass(){
        homePage.tearDown();
    }

}
