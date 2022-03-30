package com.otus.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class BaseComponent<T> {

    protected WebDriver driver;
    protected Actions actions;

    public BaseComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.actions = new Actions(driver);

    }

    private static <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
        try {
            return clazz.cast(o);
        } catch (ClassCastException e) {
            return null;
        }
    }

    public <T extends BasePage> T moveElementAndClickAction(WebElement webElement, Class<T> page) {
        actions.moveToElement(webElement).click().build().perform();
        try {
            Constructor<T> constructor = page.getConstructor(WebDriver.class);
            return convertInstanceOfObject(constructor.newInstance(driver), page);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
