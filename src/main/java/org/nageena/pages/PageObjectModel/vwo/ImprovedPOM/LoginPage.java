package org.nageena.pages.PageObjectModel.vwo.ImprovedPOM;

import org.nageena.Utils.PropertyReader;
import org.nageena.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPages {
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
        // call open url from commontoallpages file
        open_url();
        // call improved pom login page username and password
        enterInput(username, user);
        enterInput(password, pwd);
        click(signButton);


    }

    public String negative_login(String user, String pwd){
        // call open url from commontoallpages file
        open_url();
        // call commontoallpages username and password
        enterInput(username, user);
        enterInput(password, pwd);
        click(signButton);
        // call custom wait / presence of element located from commontoallpages file
        visibilityOfElement(error_message);
        return get_text(error_message);

        }



}
