package org.nageena.tests.vwoTC;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest_01_Normal {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        //driver.navigate().to("https://app.vwo.com");
        driver.get("https://app.vwo.com");

        // 1. Find the email inputbox and enter the email

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");


        // 2. Find the password inputbox and enter the password

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin");


        // 3. Find the submit button and click on it.


        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        Thread.sleep(3000);


        // 4. Find the invalid error message and verify.

        WebElement error_message = driver.findElement(By.className("notification-box-description"));

        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");


        Thread.sleep(5000);
        driver.quit();
        // It will close all the tabs. - session id == null


    }



}
