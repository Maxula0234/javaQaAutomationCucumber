package com.otus.components.header_menu;

import com.otus.components.BaseComponent;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.services.ContactsPage;
import pages.services.FaqPage;
import pages.services.ReviewsPage;
import pages.services.SubscriptionPage;

//@Component("//header[@class='header2_subheader']")
public class HeaderMenu1Component extends BaseComponent<HeaderMenu1Component> {

    @FindBy(xpath = ".//a[@title='Подписка']")
    private WebElement subscription;

    @FindBy(xpath = ".//a[@title='Отзывы']")
    private WebElement reviews;

    @FindBy(xpath = ".//a[@title='FAQ']")
    private WebElement faq;

    @FindBy(xpath = ".//a[@title='OTUS JOURNAL']")
    private WebElement otusJournal;

    @FindBy(xpath = ".//a[@title='Контакты']")
    private WebElement contacts;

    public HeaderMenu1Component(GuiceScoped guiceScoped) {
        super(guiceScoped);
    }

    public SubscriptionPage goToSubscription() {
        subscription.click();
        return new SubscriptionPage(guiceScoped);
    }

    public ReviewsPage goToReviews() {
        reviews.click();
        return new ReviewsPage(guiceScoped);
    }

    public FaqPage goToFaqPage() {
        faq.click();
        return new FaqPage(guiceScoped);
    }

    public ContactsPage goToContactsPage() {
        contacts.click();
        return new ContactsPage(guiceScoped);
    }
}
