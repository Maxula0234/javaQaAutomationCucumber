package pages;

import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class PreparatoryСoursesPage extends BasePage<PreparatoryСoursesPage> {

    @FindBy(xpath = "//div[@class='preparatory-intro__title']")
    private WebElement titleNameCourse;

    public PreparatoryСoursesPage(GuiceScoped guiceScoped) {
        super(guiceScoped, "/");
    }

    public void checkLessonPage() {
        assertThat(titleNameCourse.isDisplayed()).as("На странице курса отсутствуют преподователи").isTrue();
    }

}
