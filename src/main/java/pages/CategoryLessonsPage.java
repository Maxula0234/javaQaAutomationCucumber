package pages;

import com.otus.components.BaseCourseTileComponent;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryLessonsPage extends BasePage<CategoryLessonsPage> {

    public BaseCourseTileComponent baseCourseTileComponent;

    @FindBy(xpath = ".//div[@class='lessons__new-item-container']")
    private List<WebElement> lessons;

    public CategoryLessonsPage(GuiceScoped guiceScoped) {
        super(guiceScoped, "");
        baseCourseTileComponent = new BaseCourseTileComponent(guiceScoped, lessons);
    }

    public List<WebElement> getLessons() {
        return lessons;
    }

}
