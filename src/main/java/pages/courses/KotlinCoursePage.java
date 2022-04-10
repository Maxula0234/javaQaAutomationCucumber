package pages.courses;

import com.google.inject.Inject;
import com.otus.annotations.UrlPrefix;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import static org.assertj.core.api.Assertions.assertThat;

@UrlPrefix("/kotlin")
public class KotlinCoursePage extends BasePage<KotlinCoursePage> {

    @Inject
    public KotlinCoursePage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public void checkKotlinCoursePage() {
        assertThat(getTitlePage()).as("").isNotEmpty();
    }
}
