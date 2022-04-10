package com.otus.steps;

import com.google.inject.Inject;
import com.otus.components.NavigationMenuComponent;
import com.otus.components.header_menu.HeaderMenu2Component;
import com.otus.support.GuiceScoped;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
import pages.MainPage;
import pages.categories.CategoryLessonsPage;

public class MainPageSteps {

    @Inject
    GuiceScoped guiceScoped;
    @Inject
    private MainPage mainPage;

//    @Пусть("^открыта главная страница otus в браузере$")
//    public void openMainPage() {
//        mainPage.open();
//    }

//    @Тогда("главная страница открыта и заголовок {string}")
//    public void pageShouldBeOpened(String expectedHeader) {
//        mainPage.pageHeaderShouldBeSameAs(expectedHeader);
//    }

    @Если("кликнуть на категорию курса {string}")
    public void clickNavMenuItem(String itemName) {
        new NavigationMenuComponent(guiceScoped)
                .clickNavItem(itemName);
    }

    @Тогда("в header выбираем тип курса {string}")
    public void clickCourses(String typeCourse) {
        HeaderMenu2Component headerMenu2Component = new HeaderMenu2Component(guiceScoped);
        HeaderMenu2Component headerMenu2Component1 = headerMenu2Component.moveToCoursesHeaderMenu();
        CategoryLessonsPage categoryLessonsPage = headerMenu2Component1.goToCoursesByType(typeCourse);
    }

    @Тогда("главная страница открыта и заголовок {string}")
    public void pageShouldBeOpened(String expectedHeader) {
        mainPage.pageHeaderShouldBeSameAs(expectedHeader);
    }

    @Затем("открыта главная страница otus в браузере")
    public void openMainPage() {
        mainPage.open();
    }
}
