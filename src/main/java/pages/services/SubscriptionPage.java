package pages.services;

import com.google.inject.Inject;
import com.otus.annotations.UrlPrefix;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@UrlPrefix("/subscription")
public class SubscriptionPage extends BasePage<SubscriptionPage> {

    @FindBy(xpath = "//div[contains(@class,'doKqzP')]//h2[text()='Как работает подписка?']")
    private WebElement info;

    @FindBy(xpath = "//div[contains(@class,'kqgEaR')]")
    private List<WebElement> optionItemComponent;

    @Inject
    public SubscriptionPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public void checkSubscriptionPage() {
        assertAll(
                () -> assertThat(info.isDisplayed()).as("Не отображен элемент 'Как работает подписка?'").isTrue(),
                () -> assertThat(optionItemComponent).as("Не найдены варианты подпискок").isNotEmpty()
        );
    }
}
