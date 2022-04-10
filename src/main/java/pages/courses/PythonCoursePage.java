package pages.courses;

import com.google.inject.Inject;
import com.otus.annotations.UrlPrefix;
import com.otus.support.GuiceScoped;
import pages.BasePage;

import static org.assertj.core.api.Assertions.assertThat;

@UrlPrefix("/lessons/avtomatizaciya-web-testirovaniya/")
public class PythonCoursePage extends BasePage<PythonCoursePage> {

    private final String title = "Курс по автоматизации тестирования и поиска неисправностей в бекенде и фронтенде с использованием Selenium и языка Python";

    @Inject
    public PythonCoursePage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public void checkOpenPage() {
        assertThat(getTitlePage()).isEqualToIgnoringCase(title);
    }
}
