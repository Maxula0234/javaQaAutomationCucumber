package com.otus.components.contacts;

import com.otus.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.services.social_media.OkPublicPage;
import pages.services.social_media.VkPublicPage;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

//@Component("//div[contains(@class,'dHdjyV') and text()='Социальные сети']")
public class SocialMediaComponent extends BaseComponent<SocialMediaComponent> {

    @FindBy(xpath = "//a[text()='Вконтакте']")
    private WebElement vk;

    @FindBy(xpath = "//a[text()='Facebook']")
    private WebElement faceBook;

    @FindBy(xpath = "//a[text()='ОК']")
    private WebElement ok;

    @FindBy(xpath = "//a[text()='Дзен']")
    private WebElement dzen;

    @FindBy(xpath = "//a[text()='YouTube']")
    private WebElement youTube;

    @FindBy(xpath = "//a[text()='Канал в Telegram']")
    private WebElement channelTelegram;

    @FindBy(xpath = "//a[text()='Группа в Telegram']")
    private WebElement groupTelegram;

    public SocialMediaComponent(WebDriver driver) {
        super(driver);
    }

    public void checkSocialMedia() {
        assertAll(
                () -> assertThat(vk.isDisplayed()).as("Вк не отображен").isTrue(),
                () -> assertThat(faceBook.isDisplayed()).as("FaceBook не отображен").isTrue(),
                () -> assertThat(ok.isDisplayed()).as("ОК не отображен").isTrue(),
                () -> assertThat(dzen.isDisplayed()).as("Дзен не отображен").isTrue(),
                () -> assertThat(youTube.isDisplayed()).as("YouTube не отображен").isTrue(),
                () -> assertThat(channelTelegram.isDisplayed()).as("Канал в ТГ не отображен").isTrue(),
                () -> assertThat(groupTelegram.isDisplayed()).as("Группа в ТГ не отображена").isTrue()
        );
    }

    public VkPublicPage goToVk() {
        goToWindow(vk);
        return new VkPublicPage(driver);
    }

    public OkPublicPage goToOk() {
        goToWindow(ok);
        return new OkPublicPage(driver);
    }

    private void goToWindow(WebElement webElement) {
        Set<String> windowHandles = driver.getWindowHandles();
        webElement.click();
        Set<String> windowHandlesAfter = driver.getWindowHandles();
        windowHandlesAfter.removeAll(windowHandles);

        driver.switchTo().window(windowHandlesAfter.iterator().next());
    }
}
