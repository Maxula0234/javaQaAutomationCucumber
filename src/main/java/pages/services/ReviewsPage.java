package pages.services;

import com.google.inject.Inject;
import com.otus.annotations.UrlPrefix;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@UrlPrefix("/reviews")
public class ReviewsPage extends BasePage<ReviewsPage> {

    @FindBy(xpath = "//a[contains(@href,'reviews')]//div[contains(@class,'fvPXwD')]")
    private List<WebElement> reviewsItems;

    @Inject
    public ReviewsPage(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public void checkReviewsPage() {
        assertThat(reviewsItems).as("Отзыввы не найдены").isNotEmpty();
    }
}
