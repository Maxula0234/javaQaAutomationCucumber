package pages;

import com.otus.components.BaseCourseTileComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryLessonsPage extends BasePage<CategoryLessonsPage> {
    public BaseCourseTileComponent baseCourseTileComponent;

    @FindBy(xpath = ".//div[@class='lessons__new-item-container']")
    private List<WebElement> courseTile;

    public CategoryLessonsPage(WebDriver driver) {
        super(driver, "");
        baseCourseTileComponent = new BaseCourseTileComponent(driver, courseTile);
    }

    public List<WebElement> getCourseTile() {
        return courseTile;
    }

}
