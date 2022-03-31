package com.otus.steps;

import com.google.inject.Inject;
import com.otus.support.GuiceScoped;
import io.cucumber.java.ru.Затем;
import pages.CategoryLessonsPage;

public class CoursesPageSteps {
    @Inject
    GuiceScoped guiceScoped;

    @Затем("выбираем курс {string}")
    public void selectCourse(String nameCourse) {
        new CategoryLessonsPage(guiceScoped)
                .baseCourseTileComponent.getLessonByName(nameCourse)
                .getThisElement()
                .click();

    }
}
