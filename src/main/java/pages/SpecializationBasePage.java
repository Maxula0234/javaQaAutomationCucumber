package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class SpecializationBasePage extends BasePage<SpecializationBasePage> {

    @FindBy(xpath = "//div[@class='tn-atom' and text()='Специализация']")
    private WebElement elementSpec;

    public SpecializationBasePage(WebDriver driver) {
        super(driver, "/");
    }

    public void checkPage() {
        assertThat(elementSpec.isDisplayed()).as("Страница не отображена").isTrue();
    }
}
