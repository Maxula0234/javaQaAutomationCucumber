package com.otus.driver;

import com.google.inject.Inject;
import com.otus.driver.impl.ChromeWebDriver;
import com.otus.driver.impl.FireFoxWebDriver;
import com.otus.driver.impl.OperaWebDriver;
import com.otus.exceptions.DriverTypeNotSupported;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Locale;

public class DriverFactory implements IDriverFactory {
    public GuiceScoped guiceScoped;

    private final String browserType = System.getProperty("browser").toLowerCase(Locale.ROOT);

    @Inject
    public DriverFactory (GuiceScoped guiceScoped){
        this.guiceScoped=guiceScoped;
    }

    @Override
    public WebDriver getDriver() {
        return initDriver(guiceScoped.browserName);
    }

    private WebDriver initDriver(String nameBrowser) {
        switch (nameBrowser.toLowerCase()) {
            case "chrome": {
                return new EventFiringWebDriver(new ChromeWebDriver().newDriver());
            }
            case "safari": {
                return new EventFiringWebDriver(new SafariDriver());
            }
            case "firefox": {
                return new EventFiringWebDriver(new FireFoxWebDriver().newDriver());
            }
            case "opera": {
                return new EventFiringWebDriver(new OperaWebDriver().newDriver());
            }
            default:
                try {
                    throw new DriverTypeNotSupported(this.browserType);
                } catch (DriverTypeNotSupported ex) {
                    ex.printStackTrace();
                    return null;
                }
        }
    }

}
