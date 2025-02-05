package org.nageena.base;

import org.nageena.Utils.PropertyReader;
import org.openqa.selenium.By;
import org.nageena.driver.driverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonToAllPages {

    // If you want to call something before every Page Object Class call, Put your Code here");
    // Open File, Open Data Base Connection You can write code here
    // What are all generic functions we can mention it here like opening url,wait,
    //submitting username, password,click element,get text, get element, explicit wait etc

    public void open_url(){
        driverManager.getDriver().get(PropertyReader.readKeys("url"));

    }

    public void click(By by){
        driverManager.getDriver().findElement(by).click();
    }

    public void enterInput(By by, String key){
        driverManager.getDriver().findElement(by).sendKeys(key);
    }

    public String get_text(By by){
        return driverManager.getDriver().findElement(by).getText();

    }

    public void custom_wait(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public WebElement getElement(By key) {
        return driverManager.getDriver().findElement(key);
    }



}
