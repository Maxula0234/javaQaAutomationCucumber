package pages.services;

import com.otus.components.faqPage.FaqBlockComponent;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

//@UrlPrefix("/faq")
public class FaqPage extends BasePage<FaqPage> {
    public FaqBlockComponent faqBlockComponent;
    @FindBy(xpath = "//h1[normalize-space(text())='Отвечаем на ваши']")
    private WebElement headerInfo;
    @FindBy(xpath = "//div[contains(@class,'faq-question__question')]")
    private List<WebElement> questions;

    public FaqPage(GuiceScoped guiceScoped) {
        super(guiceScoped, "/");
        faqBlockComponent = new FaqBlockComponent(guiceScoped);
    }

    public void checkFaqPage() {
        assertAll(
                () -> assertThat(headerInfo.isDisplayed()).as("Не отборажен элемент 'Отвечаем на ваши вопросы'").isTrue(),
                () -> assertThat(faqBlockComponent.getBlockButtonFaq()).as("Не отображены категории вопросов").isNotEmpty()
        );
    }
}