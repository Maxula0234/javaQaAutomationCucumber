package com.otus.components;

import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

public abstract class BaseComponent<T> {

    protected GuiceScoped guiceScoped;
    protected Actions actions;
   public Logger reporter = Logger.getLogger(BaseComponent.class.getName());

    public BaseComponent(GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
        this.actions = new Actions(guiceScoped.driver);
        PageFactory.initElements(guiceScoped.driver, this);

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
            return convertInstanceOfObject(constructor.newInstance(guiceScoped.driver), page);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
