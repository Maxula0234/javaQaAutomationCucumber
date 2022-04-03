package com.otus.steps;

import com.google.inject.Inject;
import com.otus.components.NavigationMenuComponent;
import com.otus.support.GuiceScoped;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import pages.MainPage;

public class MainPageSteps {

    @Inject
    GuiceScoped guiceScoped;
    @Inject
    private MainPage mainPage;

    @Пусть("^Открыта главная страница otus в браузере$")
    public void openMainPage() {
        mainPage.open();
    }

    @Тогда("Главная страница открыта и заголовок {string}")
    public void pageShouldBeOpened(String expectedHeader) {
        mainPage.pageHeaderShouldBeSameAs(expectedHeader);
    }

    @Если("Кликнуть на категорию курса {string}")
    public void clickNavMenuItem(String itemName) {
        new NavigationMenuComponent(guiceScoped)
                .clickNavItem(itemName);
    }

}
