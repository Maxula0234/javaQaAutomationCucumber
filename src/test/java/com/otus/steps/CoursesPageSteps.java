package com.otus.steps;

import com.google.inject.Inject;
import com.otus.support.GuiceScoped;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
import pages.CategoryLessonsPage;
import pages.LessonsBasePage;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CoursesPageSteps {
    @Inject
    GuiceScoped guiceScoped;
    LessonsBasePage lessonsBasePage;

    @Затем("выбираем курс {string}")
    public void selectCourse(String nameCourse) {
        new CategoryLessonsPage(guiceScoped)
                .baseCourseTileComponent.clickLessonByName(nameCourse);

    }

    @ParameterType("\\d{2}\\.\\d{2}\\.\\d{4}")
    public LocalDate mydate(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Затем("выбираем курс стартующий после {mydate}")
    public void selectCourseAfterDate(LocalDate date) {
        LessonsBasePage lessonsBasePage = new CategoryLessonsPage(guiceScoped)
                .baseCourseTileComponent.clickLessonAfterDate(date);
    }

    @Затем("выбираем курс стартующий {mydate}")
    public void selectCourseByDate(LocalDate date) {
        lessonsBasePage = new CategoryLessonsPage(guiceScoped)
                .baseCourseTileComponent.clickLessonByDate(date);
    }

    @Тогда("открыта страница курса")
    public void checkCoursePgae() {
        lessonsBasePage.checkLessonPage();
    }
}
