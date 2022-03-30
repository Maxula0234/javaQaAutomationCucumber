package com.otus.steps;

import com.otus.components.NavigationMenuComponent;
import com.otus.dao.CourseTileItem;
import com.otus.exceptions.DriverTypeNotSupported;
import io.cucumber.java.After;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import pages.CategoryLessonsPage;
import pages.MainPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageSteps extends BaseSteps {

    private WebDriver driver = null;

    private MainPage mainPage = null;

    @Дано("открыт браузер {string}")
    @Override
    public void initBrowser(String nameBrowser) throws DriverTypeNotSupported {
        super.initBrowser(nameBrowser);
        driver = baseDriver;
    }

    @After
    public void closeDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Пусть("^Открыта главная страница otus в браузере$")
    public void openMainPage() {
        mainPage = new MainPage(driver)
                .open();
    }

    @Тогда("Главная страница открыта и заголовок {string}")
    public void pageShouldBeOpened(String expectedHeader) {
        mainPage.pageHeaderShouldBeSameAs(expectedHeader);
    }

    @Если("Кликнуть на категорию курса {string}")
    public void clickNavMenuItem(String itemName) {
        CategoryLessonsPage categoryLessonsPage = new NavigationMenuComponent(driver).clickNavItem(itemName);
        List<CourseTileItem> allLessons = categoryLessonsPage.baseCourseTileComponent.getAllLessons();
        assertThat(allLessons.size()).isGreaterThan(0);
        System.out.println(allLessons.size());
    }

}
