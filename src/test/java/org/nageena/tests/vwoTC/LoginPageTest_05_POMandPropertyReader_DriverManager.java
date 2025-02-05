package org.nageena.tests.vwoTC;

import io.qameta.allure.Description;
import org.nageena.Utils.PropertyReader;
import org.nageena.base.CommonToAllTests;
import org.nageena.driver.driverManager;
import org.nageena.pages.PageObjectModel.vwo.NormalPOM.DashboardPage;
import org.nageena.pages.PageObjectModel.vwo.NormalPOM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageTest_05_POMandPropertyReader_DriverManager extends CommonToAllTests {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative() throws Exception {
        //calling  driver from commontoalltests file

        LoginPage log_in = new LoginPage(driverManager.getDriver());

        //Submitting username and password using POM class which has method to return error message
        String err_msg = log_in.negative_login(PropertyReader.readKeys("invalid_username"), PropertyReader.readKeys("invalid_password"));
       //AssertJ
        assertThat(err_msg).isNotEmpty().isNotNull();
        //TestNG
        Assert.assertEquals(err_msg, PropertyReader.readKeys("error_message"));

    }
    @Description("Verify with valid email, pass, and DashboardPage")
    @Test
    public void test_positive() throws Exception {


        LoginPage log_in = new LoginPage(driverManager.getDriver());
        //Calling POM Class - Positive Login


        //Submitting username and password using POM class which has method that returns username who is logged in currently
        log_in.positive_login(PropertyReader.readKeys("username"),PropertyReader.readKeys("password"));
        DashboardPage dash_pg = new DashboardPage(driverManager.getDriver());
        String userLoggedIn = dash_pg.loggedInUserName();
        //AssertJ
        assertThat(userLoggedIn).isNotNull().isNotEmpty().isNotBlank();
        //TestNG
        Assert.assertEquals(userLoggedIn,PropertyReader.readKeys("expected_username"));


    }



}
