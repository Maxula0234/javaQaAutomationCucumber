package pages;

import com.google.inject.Inject;
import com.otus.support.GuiceScoped;

public class MainPage extends BasePage<MainPage> {

    @Inject
    public MainPage(GuiceScoped guiceScoped) {
        super(guiceScoped, "/");
    }

}
