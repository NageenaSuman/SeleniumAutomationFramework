package org.nageena.base;

import org.nageena.driver.driverManager_SelenoidGrid;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;


public class CommonToAllTests_SG {
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driverManager_SelenoidGrid.initiate();
    }

    @AfterMethod
    public void tearDown(){
        driverManager_SelenoidGrid.close();
    }

}
