package com.otus.components.header_menu;

import com.otus.components.BaseComponent;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.categories.CategoryLessonsPage;
import pages.courses.KotlinCoursePage;
import pages.courses.PythonCoursePage;

////todo убрать по два класса в СЕЛЕКТОРАХ
//@Component("//div[contains(@class,'container-header2')]")
public class HeaderMenu2Component extends BaseComponent<HeaderMenu2Component> {

    @FindBy(xpath = ".//p[normalize-space(text())='Курсы']")
    private WebElement coursesHeaderMenu;

    @FindBy(xpath = ".//a[@title='Тестирование']")
    private WebElement testingHeaderSubMenuItem;

    @FindBy(xpath = ".//a[@title='Программирование']")
    private WebElement programmingHeaderSubMenuItem;

    @FindBy(xpath = ".//a[@title='Подготовительные курсы']")
    private WebElement preparatoryСoursesItem;

    @FindBy(xpath = "//a[contains(@title,'Тестирование')]/div[contains(@class,'header2-menu__dropdown-subdropdown-trigger')]")
    private WebElement testingSubMenuDpTrigger;

    @FindBy(xpath = "//a[contains(@title,'Программирование')]/div[contains(@class,'header2-menu__dropdown-subdropdown-trigger')]")
    private WebElement programmingSubMenuDpTrigger;

    @FindBy(xpath = ".//a[@title='Python QA Engineer']")
    private WebElement pythonCoursesElement;

    @FindBy(xpath = ".//a[@title='Kotlin Backend Developer']")
    private WebElement kotlinBackendCoursesElement;

    public HeaderMenu2Component(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public HeaderMenu2Component moveToCoursesHeaderMenu() {
        actions.moveToElement(coursesHeaderMenu).pause(300).perform();
        return this;
    }

    public HeaderMenu2Component moveToTestingHeaderSubMenuItem() {
        actions.moveToElement(testingHeaderSubMenuItem).pause(300).perform();
        return this;
    }

    public HeaderMenu2Component moveToProgrammingHeaderSubMenuItem() {
        actions.moveToElement(programmingHeaderSubMenuItem).pause(300).perform();
        return this;
    }

    public HeaderMenu2Component moveToTestingSubMenuDpTrigger() {
        actions.moveToElement(testingSubMenuDpTrigger).pause(300).perform();
        return this;
    }

    public HeaderMenu2Component moveToProgrammingSubMenuDpTrigger() {
        actions.moveToElement(programmingSubMenuDpTrigger).pause(300).perform();
        return this;
    }

    public PythonCoursePage goToPythonCourse() {
        return moveElementAndClickAction(pythonCoursesElement, PythonCoursePage.class);
    }

    public KotlinCoursePage goToKotlinCourse() {
        return moveElementAndClickAction(kotlinBackendCoursesElement, KotlinCoursePage.class);
    }

    public CategoryLessonsPage goToProgrammingCategoriesPage() {
        moveToCoursesHeaderMenu()
                .programmingHeaderSubMenuItem.click();
        return new CategoryLessonsPage(guiceScoped);
    }

    public CategoryLessonsPage goToTestingCategoriesPage() {
        moveToCoursesHeaderMenu()
                .testingHeaderSubMenuItem.click();
        return new CategoryLessonsPage(guiceScoped);
    }

    public CategoryLessonsPage goToPreparatoryСourses() {
        moveToCoursesHeaderMenu()
                .preparatoryСoursesItem.click();
        return new CategoryLessonsPage(guiceScoped);
    }

    public CategoryLessonsPage goToCoursesByType(String name) {
        switch (name.toLowerCase()) {
            case "программирование": {
                return goToProgrammingCategoriesPage();
            }
            case "тестирование": {
                return goToTestingCategoriesPage();
            }
            case "подготовительные курсы": {
                return goToPreparatoryСourses();
            }
        }
        return null;
    }
}
