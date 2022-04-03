package com.otus.steps.common;

import com.google.inject.Inject;
import com.otus.driver.DriverFactory;
import com.otus.support.GuiceScoped;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import pages.MainPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonPageSteps {
    @Inject
    private DriverFactory driverFactory;
    @Inject
    private GuiceScoped guiceScoped;
    @Inject
    private MainPage mainPage;

    @Тогда("URL страницы содержит {string}")
    public void urlPageCheck(String name) {
        String currentUrl = guiceScoped.driver.getCurrentUrl();
        String format = String.format("https?:\\/\\/(?:.*?)?otus\\.ru\\/categories\\/?%s", name);

        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(currentUrl);

        assertThat(matcher.find()).as("URL некорректный").isTrue();
    }

    @Пусть("открываю браузер {string}")
    public void openMainPage(String nameBrowser) {
        guiceScoped.browserName = nameBrowser;
        guiceScoped.driver = driverFactory.getDriver();
        mainPage.open();
    }
}
