package pages.services.social_media;

import com.google.inject.Inject;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OkPublicPage extends BasePage<OkPublicPage> {

    @FindBy(xpath = "//div[@class='toolbar_logo_img']")
    private WebElement logoOk;

    @Inject
    public OkPublicPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public OkPublicPage checkVkPage(String pageTitle) {
        assertAll(
                () -> assertThat(getTitlePage()).contains(pageTitle),
                () -> assertTrue(logoOk.isDisplayed())
        );
        return this;
    }
}
