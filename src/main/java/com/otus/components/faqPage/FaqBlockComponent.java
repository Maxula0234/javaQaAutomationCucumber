package com.otus.components.faqPage;

import com.otus.components.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

//@Component("//div[contains(@data-hide,'.js-faq-linked-data')]/div[contains(@class,'container__col_md-4')]")
public class FaqBlockComponent extends BaseComponent<FaqBlockComponent> {

    @FindBy(xpath = "//div[contains(@class,'tabs-blank__section')]")
    private List<WebElement> faqBlockButton;

    public FaqBlockComponent(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getBlockButtonFaq() {
        return faqBlockButton;
    }
}
