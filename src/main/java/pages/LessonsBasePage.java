package pages;

import com.google.inject.Inject;
import com.otus.annotations.UrlPrefix;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

@UrlPrefix("/lessons/")
public class LessonsBasePage extends BasePage<LessonsBasePage> {

    @FindBy(css = ".hide-sm .course-teachers")
    private WebElement courseTeacher;

    @FindBy(xpath = "//div[@class='course-header2-bottom']")
    private WebElement courseInfo;

    @FindBy(xpath = "//div[@class='course-about']")
    private WebElement courseAbout;

    @Inject
    public LessonsBasePage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public void checkLessonPage() {
        assertThat(courseTeacher.isDisplayed()).as("На странице курса отсутствуют преподователи").isTrue();
        assertThat(courseInfo.isDisplayed()).as("На странице курса отсутствует информация").isTrue();
        assertThat(courseAbout.isDisplayed()).as("На странице курса отсутствует информация о чем курс").isTrue();
    }

}
