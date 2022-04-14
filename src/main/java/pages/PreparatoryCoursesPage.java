package pages;

import com.google.inject.Inject;
import com.otus.annotations.UrlPrefix;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

@UrlPrefix("/online/")
public class PreparatoryCoursesPage extends BasePage<PreparatoryCoursesPage> {

    @FindBy(xpath = "//div[@class='preparatory-intro__title']")
    private WebElement titleNameCourse;

    @Inject
    public PreparatoryCoursesPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public void checkLessonPage() {
        assertThat(titleNameCourse.isDisplayed()).as("На странице курса отсутствуют преподователи").isTrue();
    }

}
