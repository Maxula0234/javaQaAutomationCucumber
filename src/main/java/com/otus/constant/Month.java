package com.otus.constant;

import java.util.LinkedList;
import java.util.List;

public enum Month {
    января("JANUARY", 1),
    февраля("FEBRUARY", 2),
    марта("MARCH", 3),
    апреля("APRIL", 4),
    мая("MAY", 5),
    июня("JUNE", 6),
    июля("JULY", 7),
    августа("AUGUST", 8),
    сентября("SEPTEMBER", 9),
    октября("OCTOBER", 10),
    ноября("NOVEMBER", 11),
    декабря("DECEMBER", 12);


    private final String month;
    private final int monthNumber;

    Month(String month, int monthNumber) {
        this.month = month;
        this.monthNumber = monthNumber;
    }

    public static int findMonth(String nameMonth) {
        if (nameMonth.contains("О дате старта будет объявлено позже")) {
            return 990;
        }
        List<Month> list = new LinkedList<>();
        list.add(Month.января);
        list.add(Month.февраля);
        list.add(Month.марта);
        list.add(Month.апреля);
        list.add(Month.мая);
        list.add(Month.июня);
        list.add(Month.июля);
        list.add(Month.августа);
        list.add(Month.сентября);
        list.add(Month.октября);
        list.add(Month.ноября);
        list.add(Month.декабря);

        Month first = list.stream()
                .filter(f -> f.name().contains(nameMonth))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("месяц не найден - " + nameMonth));
        return first.getMonthNumber();
    }

    public String getMonth() {
        return month;
    }

    public int getMonthNumber() {
        return monthNumber;
    }
}
