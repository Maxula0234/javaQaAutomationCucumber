package pages.services.social_media;

import com.google.inject.Inject;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VkPublicPage extends BasePage<VkPublicPage> {

    @FindBy(xpath = "//li[contains(@class,'HeaderNav__item--logo')]")
    private WebElement logoVk;

    @Inject
    public VkPublicPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public VkPublicPage checkVkPage(String pageTitle) {
        assertAll(
                () -> assertThat(getTitlePage()).contains(pageTitle),
                () -> assertTrue(logoVk.isDisplayed())
        );
        return this;
    }
}
