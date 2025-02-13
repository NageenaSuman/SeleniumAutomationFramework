package org.nageena.pages.PageFactory;

import org.nageena.Utils.PropertyReader;
import org.nageena.base.CommonToAllPages;
import org.nageena.driver.driverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage_PF extends CommonToAllPages {
    // Page Locators
    // In Page factory the initialisation of elements will happen at beginning itself so no
    // need to find elements and

    WebDriver driver;

    //constructor

    public LoginPage_PF(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "login-username")
    private WebElement username;
    @FindBy(id = "login-password")
    private WebElement password;
    @FindBy(id = "js-login-btn")
    private WebElement signButton;
    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;

    //Page Actions
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
        custom_wait();
        return get_text(error_message);

    }






}
