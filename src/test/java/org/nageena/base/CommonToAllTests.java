package org.nageena.base;

import org.nageena.driver.driverManager;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import static org.nageena.driver.driverManager.*;


public class CommonToAllTests {
    @BeforeMethod
    public void setUp(){
        driverManager.initiate();
    }

    @AfterMethod
    public void tearDown(){
        driverManager.close();
    }

}
