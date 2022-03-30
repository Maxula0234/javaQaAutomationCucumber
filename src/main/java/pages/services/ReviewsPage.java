package pages.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@UrlPrefix("/reviews")
public class ReviewsPage extends BasePage<ReviewsPage> {

    @FindBy(xpath = "//a[contains(@href,'reviews')]//div[contains(@class,'fvPXwD')]")
    private List<WebElement> reviewsItems;

    public ReviewsPage(WebDriver driver) {
        super(driver,"/");
    }

    public void checkReviewsPage() {
        assertThat(reviewsItems).as("Отзыввы не найдены").isNotEmpty();
    }
}
