package pages.courses;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static org.assertj.core.api.Assertions.assertThat;

//@UrlPrefix("/kotlin")
public class KotlinCoursePage extends BasePage<KotlinCoursePage> {

    public KotlinCoursePage(WebDriver webDriver) {
        super(webDriver,"/");
    }

    public void checkKotlinCoursePage() {
        assertThat(getTitlePage()).as("").isNotEmpty();
    }
}
