package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

//@UrlPrefix("/lessons/")
public class LessonsBasePage extends BasePage<LessonsBasePage> {

    @FindBy(xpath = "//div[@class='course-teachers js-tabs']")
    private WebElement courseTeacher;

    @FindBy(xpath = "//div[@class='course-header2-bottom']")
    private WebElement courseInfo;

    @FindBy(xpath = "//div[@class='course-about']")
    private WebElement courseAbout;

    public LessonsBasePage(WebDriver driver) {
        super(driver, "/");
    }

    public void checkLessonPage() {
        assertThat(courseTeacher.isDisplayed()).as("На странице курса отсутствуют преподователи").isTrue();
        assertThat(courseInfo.isDisplayed()).as("На странице курса отсутствует информация").isTrue();
        assertThat(courseAbout.isDisplayed()).as("На странице курса отсутствует информация о чем курс").isTrue();
    }

}
