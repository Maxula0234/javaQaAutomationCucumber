package pages.categories;

import com.otus.components.BaseCourseTileComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

//@UrlPrefix("/categories/programming/")
//@Slf4j
public class ProgrammingCategoriesPage extends BasePage<ProgrammingCategoriesPage> {

    public BaseCourseTileComponent baseCourseTileComponent;
    @FindBy(xpath = ".//div[@class='lessons__new-item-container']")
    private List<WebElement> courseTile;

    public ProgrammingCategoriesPage(WebDriver driver) {
        super(driver, "/");
        baseCourseTileComponent = new BaseCourseTileComponent(driver, courseTile);
    }

    public List<WebElement> getCourseTile() {
        return courseTile;
    }

}
