package com.otus.dao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LessonsBasePage;
import pages.SpecializationBasePage;

public class CourseTileItem {
    WebDriver driver;
    private WebElement date;
    private WebElement name;
    private WebElement thisElement;

    public LessonsBasePage goToLesson() {
        thisElement.click();
        return new LessonsBasePage(driver);
    }

    public SpecializationBasePage goToSpecialization() {
        thisElement.click();
        return new SpecializationBasePage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDate() {
        return date;
    }

    public void setDate(WebElement date) {
        this.date = date;
    }

    public WebElement getName() {
        return name;
    }

    public void setName(WebElement name) {
        this.name = name;
    }

    public WebElement getThisElement() {
        return thisElement;
    }

    public void setThisElement(WebElement thisElement) {
        this.thisElement = thisElement;
    }
}
