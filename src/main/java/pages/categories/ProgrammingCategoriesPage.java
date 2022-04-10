package pages.categories;

import com.google.inject.Inject;
import com.otus.annotations.UrlPrefix;
import com.otus.components.BaseCourseTileComponent;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

@UrlPrefix("/categories/programming/")
public class ProgrammingCategoriesPage extends BasePage<ProgrammingCategoriesPage> {

    public BaseCourseTileComponent baseCourseTileComponent;
    @FindBy(xpath = ".//div[@class='lessons__new-item-container']")
    private List<WebElement> courseTile;

    @Inject
    public ProgrammingCategoriesPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
        baseCourseTileComponent = new BaseCourseTileComponent(guiceScoped, courseTile);
    }

    public List<WebElement> getCourseTile() {
        return courseTile;
    }

}
