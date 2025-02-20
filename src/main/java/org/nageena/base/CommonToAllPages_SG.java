package org.nageena.base;

import org.nageena.Utils.PropertyReader;
import org.nageena.driver.driverManager_SelenoidGrid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonToAllPages_SG {

    // If you want to call something before every Page Object Class call, Put your Code here");
    // Open File, Open Data Base Connection You can write code here
    // What are all generic functions we can mention it here like opening url,wait,
    //submitting username, password,click element,get text, get element, explicit wait etc

    public void open_url(){
        driverManager_SelenoidGrid.getDriver().get(PropertyReader.readKeys("url"));

    }
    // for POM
    public void click(By by){
        driverManager_SelenoidGrid.getDriver().findElement(by).click();
    }
    // for PageFactory
    public void click(WebElement by){
        by.click();
    }
    // for POM
    public void enterInput(By by, String key){
        driverManager_SelenoidGrid.getDriver().findElement(by).sendKeys(key);
    }
    // for PageFactory
    public void enterInput(WebElement by, String key){
        by.sendKeys(key);
    }
    // for POM
    public String get_text(By by){
        return driverManager_SelenoidGrid.getDriver().findElement(by).getText();

    }
    // for PageFactory
    public String get_text(WebElement by){
        return by.getText();

    }

    public void custom_wait(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(driverManager_SelenoidGrid.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(driverManager_SelenoidGrid.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }
    // for PageFactory

    //public WebElement visibilityOfElement(WebElement elementLocation) {
        //return new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated((By) elementLocation));
  // }

    public WebElement getElement(By key) {
        return driverManager_SelenoidGrid.getDriver().findElement(key);
    }



}
