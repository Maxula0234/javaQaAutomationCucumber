package pages.courses;

import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static org.assertj.core.api.Assertions.assertThat;

//@UrlPrefix("/kotlin")
public class KotlinCoursePage extends BasePage<KotlinCoursePage> {

    public KotlinCoursePage(GuiceScoped guiceScoped) {
        super(guiceScoped,"/");
    }

    public void checkKotlinCoursePage() {
        assertThat(getTitlePage()).as("").isNotEmpty();
    }
}
