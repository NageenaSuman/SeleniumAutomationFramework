package org.nageena.driver;

import org.nageena.Utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

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
    public static void initiate() throws MalformedURLException {
        String browser = PropertyReader.readKeys("browser");
        browser = browser.toLowerCase();
        // if browser is not initiated
        if (driver == null) {
            switch (browser) {
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    driver = new EdgeDriver(edgeOptions);
                    break;
                case "chrome":
                    //Using SELENOID to run test cases

                    ChromeOptions options = new ChromeOptions();
                   // options.setCapability("browserVersion", "128.0");
                    options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                        /* How to add test badge */
                        put("name", "VWO Login Tests...");

                        /* How to set session timeout */
                        put("sessionTimeout", "15m");

                        /* How to set timezone */
                        put("env", new ArrayList<String>() {{
                            add("TZ=IST");
                        }});

                        /* How to add "trash" button */
                        put("labels", new HashMap<String, Object>() {{
                            put("automation", "true");
                        }});

                        /* How to enable video recording */
                        put("enableVideo", true);
                    }});
                    //if you use AWS Machines then use its random IP instead of localhost
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                    driver.manage().window().maximize();

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
