package com.otus.dao;

import com.google.inject.Inject;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LessonsBasePage;
import pages.SpecializationBasePage;

import java.util.Date;

public class CourseTileItem {
    @Inject
    GuiceScoped guiceScoped;
    private WebElement date;
    private WebElement name;
    private WebElement thisElement;
    private Date dateStrat;

    public GuiceScoped getGuiceScoped() {
        return guiceScoped;
    }

    public void setGuiceScoped(GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
    }

    public Date getDateStrat() {
        return dateStrat;
    }

    public void setDateStrat(Date dateStrat) {
        this.dateStrat = dateStrat;
    }

    public LessonsBasePage goToLesson() {
        thisElement.click();
        return new LessonsBasePage(guiceScoped);
    }

    public SpecializationBasePage goToSpecialization() {
        thisElement.click();
        return new SpecializationBasePage(this.guiceScoped);
    }

    public WebDriver getDriver() {
        return this.guiceScoped.driver;
    }

    public void setDriver(WebDriver driver) {
        this.guiceScoped.driver = driver;
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
