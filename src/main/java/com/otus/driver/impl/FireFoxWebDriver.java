package com.otus.driver.impl;

import com.otus.exceptions.DriverTypeNotSupported;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.logging.Level;

public class FireFoxWebDriver implements IDriver {

    @Override
    public WebDriver newDriver() {
        FirefoxOptions fireFoxOptions = new FirefoxOptions();
        fireFoxOptions.addArguments("--no-sandbox");
        fireFoxOptions.addArguments("--no-first-run");
        fireFoxOptions.addArguments("--enable-extensions");
        fireFoxOptions.addArguments("--homepage=about:blank");
        fireFoxOptions.addArguments("--ignore-certificate-errors");
        fireFoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        fireFoxOptions.setCapability(CapabilityType.VERSION, System.getProperty("browser.version", ""));
        fireFoxOptions.setCapability("enableVNC", Boolean.parseBoolean(System.getProperty("enableVNC", "false")));
        fireFoxOptions.setHeadless(HEADLESS);

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
        fireFoxOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        if (getRemoteUrl() == null) {
            try {
                downloadLocalWebDriver(DriverManagerType.FIREFOX);
            } catch (DriverTypeNotSupported ex) {
                ex.printStackTrace();
            }

            return new FirefoxDriver(fireFoxOptions);
        } else {
            return new RemoteWebDriver(getRemoteUrl(), fireFoxOptions);
        }
    }
}
