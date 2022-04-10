package com.otus.constant;

import java.util.LinkedList;
import java.util.List;

public enum Month {
    январь("янв", 1),
    февраль("фев", 2),
    март("мар", 3),
    апрель("апр", 4),
    май("мая", 5),
    июнь("июн", 6),
    июль("июл", 7),
    август("авг", 8),
    сентябрь("сен", 9),
    октябрь("окт", 10),
    ноябрь("ноя", 11),
    декабрь("дек", 12);

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
        list.add(Month.январь);
        list.add(Month.февраль);
        list.add(Month.март);
        list.add(Month.апрель);
        list.add(Month.май);
        list.add(Month.июнь);
        list.add(Month.июль);
        list.add(Month.август);
        list.add(Month.сентябрь);
        list.add(Month.октябрь);
        list.add(Month.ноябрь);
        list.add(Month.декабрь);

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

    public static String[] getMonths() {
        return new String[]{январь.getMonth(), февраль.getMonth(), март.getMonth(), апрель.getMonth(), май.getMonth(), июнь.getMonth(), июль.getMonth(), август.getMonth(), сентябрь.getMonth(), октябрь.getMonth(), ноябрь.getMonth(), декабрь.getMonth()};
    }
}
