package org.nageena.tests.vwoTC;

import io.qameta.allure.Description;
import org.nageena.Utils.PropertyReader;
import org.nageena.pages.PageObjectModel.vwo.NormalPOM.DashboardPage;
import org.nageena.pages.PageObjectModel.vwo.NormalPOM.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageTest_04_POMandPropertyReader {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        //Calling POM Class - Negative Login

        LoginPage log_in = new LoginPage(driver);

        //Submitting username and password using POM class which has method to return error message
        String err_msg = log_in.negative_login(PropertyReader.readKeys("invalid_username"), PropertyReader.readKeys("invalid_password"));
        assertThat(err_msg).isNotEmpty().isNotNull();
        Assert.assertEquals(err_msg, PropertyReader.readKeys("error_message"));
        Thread.sleep(5000);
        driver.quit();
    }
    @Description("Verify with valid email, pass, and DashboardPage")
    @Test
    public void test_positive() throws Exception {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        //Calling POM Class - Negative Login

        LoginPage log_in = new LoginPage(driver);
        //Calling POM Class - Positive Login


        //Submitting username and password using POM class which has method that returns username who is logged in currently
        log_in.positive_login(PropertyReader.readKeys("username"),PropertyReader.readKeys("password"));
        DashboardPage dash_pg = new DashboardPage(driver);
        String userLoggedIn = dash_pg.loggedInUserName();
        assertThat(userLoggedIn).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(userLoggedIn,PropertyReader.readKeys("expected_username"));
        Thread.sleep(5000);
        driver.quit();

    }



}
