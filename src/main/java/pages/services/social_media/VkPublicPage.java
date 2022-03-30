package pages.services.social_media;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VkPublicPage extends BasePage<VkPublicPage> {

    @FindBy(xpath = "//li[contains(@class,'HeaderNav__item--logo')]")
    private WebElement logoVk;

    public VkPublicPage(WebDriver driver) {
        super(driver, "/");
    }

    public VkPublicPage checkVkPage(String pageTitle) {
        assertAll(
                () -> assertThat(getTitlePage()).contains(pageTitle),
                () -> assertTrue(logoVk.isDisplayed())
        );
        return this;
    }
}
