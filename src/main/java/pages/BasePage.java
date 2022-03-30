package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage<T> {

    protected WebDriver driver;

    private final String path;

    @FindBy(tagName = "h1")
    private WebElement header;

    public BasePage(WebDriver driver, String path) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.path = path;
    }

    public T open() {
        driver.get(System.getProperty("base.url"));

        return (T) this;
    }

    public T pageHeaderShouldBeSameAs(String header) {
        assert this.header.getText().equals(header) : "Error: Заголовок на странице не корректный";

        return (T) this;
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

}
