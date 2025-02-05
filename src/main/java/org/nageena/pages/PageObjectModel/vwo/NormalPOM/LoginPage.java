package org.nageena.pages.PageObjectModel.vwo.NormalPOM;

import org.nageena.Utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //POM --> dividing test cases and webdriver classes
    //web driver classes --> page class,page locators, page actions


    WebDriver driver;

    //constructor

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // POM declarations by using encapsulation - private
    //Page locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");
    //Page Actions
    //to use private create method
    public void positive_login(String user, String pwd){
        driver.get(PropertyReader.readKeys("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();


    }

    public String negative_login(String user, String pwd){
        driver.get(PropertyReader.readKeys("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        try {
            Thread.sleep(4000); }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        String err = driver.findElement(error_message).getText();
        return err;
        }



}
