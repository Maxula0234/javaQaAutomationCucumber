package com.otus.components;

import com.otus.annotations.Component;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

public abstract class BaseComponent<T> {

    public Logger reporter = Logger.getLogger(BaseComponent.class.getName());
    protected GuiceScoped guiceScoped;
    protected Actions actions;
    protected WebDriverWait webDriverWait;
    protected String baseLocator;

    public BaseComponent(GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
        this.actions = new Actions(guiceScoped.driver);
        this.webDriverWait = new WebDriverWait(guiceScoped.driver, 10);
        this.webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(getComponentLocator()));

        PageFactory.initElements(guiceScoped.driver, this);

    }

    private static <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
        try {
            return clazz.cast(o);
        } catch (ClassCastException e) {
            return null;
        }
    }

    public By getComponentLocator() {
        Component component = getClass().getAnnotation(Component.class);

        if (component != null) {
            String value = component.value();

            baseLocator = value;

            if (value.startsWith("/")) {
                return By.xpath(value);
            }
            return By.cssSelector(value);
        }

        return null;
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
