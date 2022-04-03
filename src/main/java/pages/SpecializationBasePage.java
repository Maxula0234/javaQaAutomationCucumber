package pages;

import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class SpecializationBasePage extends BasePage<SpecializationBasePage> {

    @FindBy(xpath = "//div[@class='tn-atom' and text()='Специализация']")
    private WebElement elementSpec;

    public SpecializationBasePage(GuiceScoped guiceScoped) {
        super(guiceScoped, "/");
    }

    public void checkPage() {
        assertThat(elementSpec.isDisplayed()).as("Страница не отображена").isTrue();
    }
}
