package com.otus.components;

import com.otus.constant.Month;
import com.otus.dao.CourseTileItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LessonsBasePage;
import pages.SpecializationBasePage;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseCourseTileComponent extends BaseComponent<BaseCourseTileComponent> {
    List<WebElement> courseTile;

    By dateLessonStart = By.xpath(".//div[@class='lessons__new-item-time']");
    By nameCourse = By.xpath(".//div[contains(@class,'lessons__new-item-title_with-bg')]");

    public BaseCourseTileComponent(WebDriver driver, List<WebElement> courseTile) {
        super(driver);
        this.courseTile = courseTile;

    }

    public List<CourseTileItem> getAllLessons() {
        List<CourseTileItem> allLesson = new ArrayList<>();

        courseTile.forEach(f -> {
            CourseTileItem a = new CourseTileItem();

            try {
                a.setName(f.findElement(nameCourse));
                a.setDate(f.findElement(dateLessonStart));
                a.setThisElement(f);
                a.setDriver(driver);
            } catch (Exception e) {
            }

            allLesson.add(a);
        });

        return allLesson;
    }

    public CourseTileItem getLessonByName(String nameLesson) {
        List<CourseTileItem> allLessons = getAllLessons();
        CourseTileItem courseTileItem = allLessons.stream()
                .filter(f -> f.getName().getText().contains(nameLesson))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Урок с именем " + nameLesson + " не найден"));

        assertThat(courseTileItem).as("Урок не найден").isNotNull();
        return courseTileItem;
    }

    private Date getStartDateCourse(WebElement lesson) {
        String[] s = lesson.findElement(dateLessonStart).getText().split(" ", 3);

        int month = 0;
        int num = 0;

        try {
            month = Month.findMonth(s[1]);
            num = Integer.parseInt(s[0]);
        } catch (Exception e) {
            return new Date(2099, 12, 1);
        }

        Calendar calendar = new GregorianCalendar(LocalDate.now().getYear(), month - 1, num);
        return calendar.getTime();
    }

    public BaseCourseTileComponent sortedLessonByDate() {
        courseTile = courseTile.stream().sorted((o1, o2) -> {
            Date date1 = getStartDateCourse(o1);
            Date date2 = getStartDateCourse(o2);

            return date1.compareTo(date2);
        }).collect(Collectors.toList());
        return this;
    }

    public LessonsBasePage clickLessons(int numLesson) {
        courseTile.get(numLesson).click();
        return new LessonsBasePage(driver);
    }

    public SpecializationBasePage clickSpecialization(int numLesson) {
        courseTile.get(numLesson).click();
        return new SpecializationBasePage(driver);
    }
}
