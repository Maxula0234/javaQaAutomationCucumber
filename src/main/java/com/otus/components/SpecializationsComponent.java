package com.otus.components;

import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

//@Component("//div[@class='container container-lessons']//div[@class='container-padding-bottom']")
public class SpecializationsComponent extends BaseComponent<SpecializationsComponent> {
    public BaseCourseTileComponent baseCourseTileComponent;

    @FindBy(xpath = ".//div[@class='lessons__new-item-container']")
    private List<WebElement> lessons;

    public SpecializationsComponent(GuiceScoped guiceScoped) {
        super(guiceScoped);
        baseCourseTileComponent = new BaseCourseTileComponent(guiceScoped, lessons);
    }

}
