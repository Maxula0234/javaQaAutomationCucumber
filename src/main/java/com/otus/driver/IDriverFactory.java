package com.otus.driver;

import com.otus.exceptions.DriverTypeNotSupported;
import org.openqa.selenium.WebDriver;

public interface IDriverFactory {
    public WebDriver getDriver() throws DriverTypeNotSupported;

    public WebDriver getDriver(String nameBrowser) throws DriverTypeNotSupported;
}
