package com.otus.steps;

import com.otus.driver.DriverFactory;
import com.otus.exceptions.DriverTypeNotSupported;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    public WebDriver baseDriver = null;

    public void initBrowser(String nameBrowser) throws DriverTypeNotSupported {
        baseDriver = new DriverFactory().getDriver(nameBrowser);
    }
}
