package com.otus.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

//@Component("//*[contains(@class, 'container-lessons')]/div[text()='Популярные курсы']//following-sibling::div[@class='lessons']")
public class FavouriteCoursesComponent extends BaseComponent<FavouriteCoursesComponent> {

    public BaseCourseTileComponent baseCourseTileComponent;

    @FindBy(xpath = "//*[contains(@class, 'container-lessons')]/div[text()='Популярные курсы']//following-sibling::div/a")
    private List<WebElement> lessons;

    public FavouriteCoursesComponent(WebDriver driver) {
        super(driver);
        baseCourseTileComponent = new BaseCourseTileComponent(driver, lessons);
    }

}
