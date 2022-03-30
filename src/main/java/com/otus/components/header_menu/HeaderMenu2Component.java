package com.otus.components.header_menu;

import com.otus.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.categories.ProgrammingCategoriesPage;
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

    @FindBy(xpath = "//a[contains(@title,'Тестирование')]/div[contains(@class,'header2-menu__dropdown-subdropdown-trigger')]")
    private WebElement testingSubMenuDpTrigger;

    @FindBy(xpath = "//a[contains(@title,'Программирование')]/div[contains(@class,'header2-menu__dropdown-subdropdown-trigger')]")
    private WebElement programmingSubMenuDpTrigger;

    @FindBy(xpath = ".//a[@title='Python QA Engineer']")
    private WebElement pythonCoursesElement;

    @FindBy(xpath = ".//a[@title='Kotlin Backend Developer']")
    private WebElement kotlinBackendCoursesElement;

    public HeaderMenu2Component(WebDriver webDriver) {
        super(webDriver);
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

    public ProgrammingCategoriesPage goToProgrammingCategoriesPage(){
        programmingHeaderSubMenuItem.click();
        return new ProgrammingCategoriesPage(driver);
    }
}
