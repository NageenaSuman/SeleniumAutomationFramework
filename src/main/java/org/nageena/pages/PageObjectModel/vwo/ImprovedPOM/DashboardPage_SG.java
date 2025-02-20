package org.nageena.pages.PageObjectModel.vwo.ImprovedPOM;

import org.nageena.base.CommonToAllPages;
import org.nageena.base.CommonToAllPages_SG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage_SG extends CommonToAllPages_SG {
    WebDriver driver;

    //constructor

    public DashboardPage_SG(WebDriver driver) {
        this.driver = driver;
    }
    By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");


    // Page Actions
    public String loggedInUserName(){
        // custom_wait(); or
        visibilityOfElement(userNameOnDashboard);
        return get_text(userNameOnDashboard);
    }
}
