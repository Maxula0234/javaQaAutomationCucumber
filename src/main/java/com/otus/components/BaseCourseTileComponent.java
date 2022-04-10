package com.otus.components;

import com.otus.annotations.Component;
import com.otus.constant.Month;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LessonsBasePage;
import pages.SpecializationBasePage;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Component("//header[@class='header2_subheader']")
public class BaseCourseTileComponent extends BaseComponent<BaseCourseTileComponent> {
    List<WebElement> lessons;

    private final By dateSpecializationStart = By.xpath(".//div[@class='lessons__new-item-time']");
    private final By dateLessonStart = By.xpath(".//div[@class='lessons__new-item-start']");
    private final By nameCourse = By.xpath(".//div[contains(@class,'lessons__new-item-title_with-bg')]");
    private final By price = By.xpath(".//div[@class='lessons__new-item-price']");

    public BaseCourseTileComponent(GuiceScoped guiceScoped, List<WebElement> lessons) {
        super(guiceScoped);
        this.lessons = lessons;
    }

    public BaseCourseTileComponent sortedLessonByDate(By dateStart) {
        lessons = lessons.stream().sorted((o1, o2) -> {
            LocalDate date1 = getDateFromTileLesson(o1, dateStart);
            LocalDate date2 = getDateFromTileLesson(o2, dateStart);

            return date1.compareTo(date2);
        }).collect(Collectors.toList());
        return this;
    }

    public LessonsBasePage clickLessons(int numLesson) {
        lessons.get(numLesson).click();
        return new LessonsBasePage(guiceScoped);
    }

    public SpecializationBasePage clickSpecialization(int numLesson) {
        lessons.get(numLesson).click();
        return new SpecializationBasePage(guiceScoped);
    }

    private LocalDate getDateFromTileLesson(WebElement lesson, By dateStart) {
        Pattern pattern = Pattern.compile("\\d{2}\\s(.{3})");
        String date = lesson.findElement(dateStart).getText();
        Matcher matcher = pattern.matcher(date);

        DateFormatSymbols symbols = new DateFormatSymbols(new Locale("ru"));
        String[] shortestMonths = Month.getMonths();
        symbols.setShortMonths(shortestMonths);

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM", symbols);

        Date date1;
        try {
            if (matcher.find()) {
                date1 = formatter.parse(matcher.group());
            } else {
                return LocalDate.of(2099, 12, 1);
            }
        } catch (ParseException e) {
            return LocalDate.of(2099, 12, 1);
        }

        return date1.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDate().withYear(LocalDate.now().getYear());
    }

    public Map<WebElement, LocalDate> parseDateFromTile(By dateStart) {
        Map<WebElement, LocalDate> map = new HashMap<>();

        lessons.forEach(f -> {
            LocalDate startDateCourseV2;
            try {
                startDateCourseV2 = getDateFromTileLesson(f, dateStart);
                map.put(f, startDateCourseV2);
            } catch (Exception e) {
                reporter.info(e.getMessage());
            }
        });
        return map;
    }

    public LessonsBasePage clickSpecializationAfterDate(LocalDate date) {
        Map<WebElement, LocalDate> specializationAfterDate = parseDateFromTile(dateSpecializationStart);

        specializationAfterDate.entrySet()
                .stream().filter(f -> f.getValue().isAfter(date))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден курс до даты - " + date.toString()))
                .getKey().click();
        return new LessonsBasePage(guiceScoped);
    }

    public LessonsBasePage clickLessonAfterDate(LocalDate date) {
        Map<WebElement, LocalDate> specializationAfterDate = parseDateFromTile(dateLessonStart);

        Map.Entry<WebElement, LocalDate> webElementLocalDateEntry = specializationAfterDate.entrySet()
                .stream().filter(f -> f.getValue().isAfter(date))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден курс до даты - " + date.toString()));

        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElementLocalDateEntry.getKey())).click();
        LessonsBasePage lessonsBasePage = new LessonsBasePage(guiceScoped);

        reporter.info("Открыли кура \"" + lessonsBasePage.getHeader() + "\" дата = " + date);
        return lessonsBasePage;
    }

    public void clickSpecializationByDate(LocalDate date) {
        Map<WebElement, LocalDate> specializationAfterDate = parseDateFromTile(dateSpecializationStart);

        specializationAfterDate.entrySet()
                .stream().filter(f -> f.getValue().isEqual(date))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден курс до даты - " + date.toString()))
                .getKey().click();
    }

    public LessonsBasePage clickLessonByDate(LocalDate date) {
        Map<WebElement, LocalDate> specializationAfterDate = parseDateFromTile(dateLessonStart);

        specializationAfterDate.entrySet()
                .stream().filter(f -> f.getValue().isEqual(date))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден курс до даты - " + date.toString()))
                .getKey().click();
        return new LessonsBasePage(guiceScoped);
    }

    public LessonsBasePage goToLesson(int idLesson) {
        lessons.get(idLesson).click();
        return new LessonsBasePage(guiceScoped);
    }

    public void clickLessonByName(String nameLesson) {
        reporter.info("Кликаем по уроку - " + nameLesson);
        WebElement webElement = lessons.stream()
                .filter(f -> f.getText().contains(nameLesson))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Урок с именем " + nameLesson + " не найден"));

        try {
            webElement.click();
        } catch (WebDriverException e) {
            ((JavascriptExecutor) guiceScoped.driver).executeScript("arguments[0].click()", webElement);

        }
        assertThat(webElement).as("Урок не найден").isNotNull();
    }

    public WebElement getMaxPrice() {
        Map<WebElement, Double> map = parsePriceLesson();

        Map.Entry<WebElement, Double> webElementDoubleEntry = map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("НЕ НАЙДЕН САМЫЙ ДОРОГОЙ"));

        return webElementDoubleEntry.getKey();
    }

    public WebElement getMinPrice() {
        Map<WebElement, Double> map = parsePriceLesson();

        Map.Entry<WebElement, Double> webElementDoubleEntry = map.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("НЕ НАЙДЕН САМЫЙ ДОРОГОЙ"));

        return webElementDoubleEntry.getKey();
    }

    private Map<WebElement, Double> parsePriceLesson() {
        Map<WebElement, Double> map = new HashMap<>();

        lessons.forEach(lesson -> {
            Double priceLesson;
            try {
                priceLesson = Double.parseDouble(lesson.findElement(price).getText().replace(" ₽", ""));
                map.put(lesson, priceLesson);
            } catch (Exception e) {
                reporter.info(e.getMessage());
            }
        });
        return map;
    }
}
