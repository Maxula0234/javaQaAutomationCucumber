package com.otus.support;

import com.otus.driver.DriverFactory;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;

@ScenarioScoped
public class GuiceScoped {

    public WebDriver driver = new DriverFactory().getDriver();


}
