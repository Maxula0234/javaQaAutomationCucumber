package com.otus.driver;

import com.otus.driver.impl.ChromeWebDriver;
import com.otus.driver.impl.FireFoxWebDriver;
import com.otus.driver.impl.OperaWebDriver;
import com.otus.exceptions.DriverTypeNotSupported;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Locale;

public class DriverFactory implements IDriverFactory {

    private String browserType = System.getProperty("browser").toLowerCase(Locale.ROOT);

    @Override
    public WebDriver getDriver() {
        return initDriver(this.browserType);
    }

    @Override
    public WebDriver getDriver(String nameBrowser) throws DriverTypeNotSupported {
        return initDriver(nameBrowser);
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
