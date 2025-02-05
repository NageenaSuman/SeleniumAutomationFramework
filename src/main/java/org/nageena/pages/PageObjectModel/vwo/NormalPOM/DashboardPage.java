package org.nageena.pages.PageObjectModel.vwo.NormalPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;

    //constructor

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");


    // Page Actions
    public String loggedInUserName(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(userNameOnDashboard).getText();
    }
}
