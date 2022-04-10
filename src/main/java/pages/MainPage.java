package pages;

import com.google.inject.Inject;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage<MainPage> {

    @FindBy(css = ".cookies .cookies__button")
    private WebElement cookieButton;

    @Inject
    public MainPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public MainPage acceptCookie() {

        try {
            cookieButton.click();
        } catch (WebDriverException e) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click()", cookieButton);

        }
        return this;
    }
}
