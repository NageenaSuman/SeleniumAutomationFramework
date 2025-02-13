package org.nageena.tests.vwoTC;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nageena.Listeners.RetryAnalyser;
import org.nageena.Utils.PropertyReader;
import org.nageena.base.CommonToAllTests;
import org.nageena.driver.driverManager;
import org.nageena.pages.PageFactory.DashboardPage_PF;
import org.nageena.pages.PageFactory.LoginPage_PF;
import org.nageena.pages.PageObjectModel.vwo.ImprovedPOM.DashboardPage;
import org.nageena.pages.PageObjectModel.vwo.ImprovedPOM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageTest_09_PageFactory_AllwithLoggerandListeners extends CommonToAllTests {
    //create an instance for logger

    private static final Logger logger = LogManager.getLogger(LoginPageTest_09_PageFactory_AllwithLoggerandListeners.class.getName());
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative() throws Exception {

        logger.info("Starting the Test Case for InValid Credentials");
        //calling  driver from commontoalltests file
        //POM - LoginPage log_in = new LoginPage(driverManager.getDriver());

        LoginPage_PF log_in = new LoginPage_PF(driverManager.getDriver());

        //Submitting username and password using POM class which has method to return error message
        String err_msg = log_in.negative_login(PropertyReader.readKeys("invalid_username"), PropertyReader.readKeys("invalid_password"));

        logger.info("Closing and Asserting the Test Case for InValid Credentials");
        //AssertJ
        assertThat(err_msg).isNotBlank().isNotEmpty().isNotNull();
        //TestNG
        Assert.assertEquals(err_msg, PropertyReader.readKeys("error_message"));

    }
    @Description("Verify with valid email, pass, and DashboardPage")
    @Test
    public void test_positive() throws Exception {

        logger.info("Starting the Test Case for Valid Credentials");
        LoginPage_PF log_in = new LoginPage_PF(driverManager.getDriver());
        //Calling POM Class - Positive Login


        //Submitting username and password using POM class which has method that returns username who is logged in currently
        log_in.positive_login(PropertyReader.readKeys("username"), PropertyReader.readKeys("password"));
        DashboardPage_PF dash_pg = new DashboardPage_PF(driverManager.getDriver());
        String userLoggedIn = dash_pg.loggedInUserName();
        logger.info("Closing and Asserting the Test Case for Valid Credentials");
        //AssertJ
        assertThat(userLoggedIn).isNotNull().isNotEmpty().isNotBlank();
        //TestNG
        Assert.assertEquals(userLoggedIn,PropertyReader.readKeys("expected_username"));


    }
    @Description("Verify with valid email, pass, and DashboardPage")
    @Test(retryAnalyzer = RetryAnalyser.class)
    public void test_fail() throws Exception {

        logger.info("Starting the Test Case for Valid Credentials");
        LoginPage_PF log_in = new LoginPage_PF(driverManager.getDriver());
        //Calling POM Class - Positive Login


        //Submitting username and password using POM class which has method that returns username who is logged in currently
        log_in.positive_login(PropertyReader.readKeys("invalid_username"), PropertyReader.readKeys("invalid_password"));
        DashboardPage dash_pg = new DashboardPage(driverManager.getDriver());
        String userLoggedIn = dash_pg.loggedInUserName();
        logger.info("Closing and Asserting the Test Case for Valid Credentials");
        //AssertJ
        assertThat(userLoggedIn).isNotNull().isNotEmpty().isNotBlank();
        //TestNG
        Assert.assertEquals(userLoggedIn,PropertyReader.readKeys("Nageena"));


    }



}
