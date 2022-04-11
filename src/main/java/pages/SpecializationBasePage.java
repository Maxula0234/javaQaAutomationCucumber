package pages;

import com.google.inject.Inject;
import com.otus.annotations.UrlPrefix;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

@UrlPrefix("/lessons/")
public class SpecializationBasePage extends BasePage<SpecializationBasePage> {

    @FindBy(xpath = "//div[@class='tn-atom' and text()='Специализация']")
    private WebElement elementSpec;

    @Inject
    public SpecializationBasePage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public void checkPage() {
        assertThat(elementSpec.isDisplayed()).as("Страница не отображена").isTrue();
    }
}
