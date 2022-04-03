package pages;

import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public abstract class BasePage<T> {

    private final String path;
    public Logger reporter = Logger.getLogger(BasePage.class.getName());
    private final GuiceScoped guiceScoped;

    @FindBy(tagName = "h1")
    private WebElement header;

    public BasePage(GuiceScoped guiceScoped, String path) {
        this.guiceScoped = guiceScoped;
        this.path = path;
        PageFactory.initElements(guiceScoped.driver, this);
    }

    public T open() {
        guiceScoped.driver.get(System.getProperty("base.url"));

        return (T) this;
    }

    public T pageHeaderShouldBeSameAs(String header) {
        assert this.header.getText().equals(header) : "Error: Заголовок на странице не корректный";

        return (T) this;
    }

    public String getTitlePage() {
        return guiceScoped.driver.getTitle();
    }

    public String getHeader() {
        return header.getText();
    }

}
