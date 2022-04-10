package com.otus.steps.common;

import com.google.inject.Inject;
import com.otus.driver.DriverFactory;
import com.otus.support.GuiceScoped;
import io.cucumber.java.ru.Пусть;
import pages.MainPage;

public class CommonPageSteps {
    @Inject
    private DriverFactory driverFactory;
    @Inject
    private GuiceScoped guiceScoped;
    @Inject
    private MainPage mainPage;

    @Пусть("открываю браузер {string}")
    public void openMainPage(String nameBrowser) {
        guiceScoped.browserName = nameBrowser;
        guiceScoped.driver = driverFactory.getDriver();
        mainPage.open();
    }
}
