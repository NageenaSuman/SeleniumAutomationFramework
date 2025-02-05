package org.nageena.driver;

import org.nageena.Utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class driverManager_SelenoidGrid {
    public static WebDriver driver;
    // it is responsible to share browser, initiate it and terminate it
    // Getter Setter
    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        driverManager_SelenoidGrid.driver = driver;
    }
    public static void initiate(){
        String browser = PropertyReader.readKeys("browser");
        browser = browser.toLowerCase();
        // if browser is not initiated
        if (driver == null) {
            switch (browser){
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    driver = new EdgeDriver(edgeOptions);
                    break;
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions fireOptions = new FirefoxOptions();
                    fireOptions.addArguments("--start-maximized");
                    driver = new FirefoxDriver(fireOptions);
                    break;
                default:
                    System.out.println("Not browser Found!!");

            }


        }


    }
    public static void close(){

        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }



}
