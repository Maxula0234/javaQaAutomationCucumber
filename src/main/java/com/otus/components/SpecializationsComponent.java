package com.otus.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

//@Component("//div[@class='container container-lessons']//div[@class='container-padding-bottom']")
public class SpecializationsComponent extends BaseComponent<SpecializationsComponent> {
    public BaseCourseTileComponent baseCourseTileComponent;

    @FindBy(xpath = ".//div[@class='lessons__new-item-container']")
    private List<WebElement> lessons;

    public SpecializationsComponent(WebDriver driver) {
        super(driver);
        baseCourseTileComponent = new BaseCourseTileComponent(driver, lessons);
    }

}
