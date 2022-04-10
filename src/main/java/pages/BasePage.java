package pages;

import com.otus.annotations.UrlPrefix;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public abstract class BasePage<T> {

    private final GuiceScoped guiceScoped;
    public Logger reporter = Logger.getLogger(BasePage.class.getName());
    private final WebDriver webDriver;

    @FindBy(tagName = "h1")
    private WebElement header;

    public BasePage(GuiceScoped guiceScoped) {
        this.guiceScoped = guiceScoped;
        this.webDriver = guiceScoped.driver;
        PageFactory.initElements(guiceScoped.driver, this);
    }

    private String getUrlPrefix() {
        UrlPrefix urlAnnotation = getClass().getAnnotation(UrlPrefix.class);
        if (urlAnnotation != null) {
            return urlAnnotation.value();
        }

        return "";
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

    public WebDriver getDriver() {
        return webDriver;
    }
}
