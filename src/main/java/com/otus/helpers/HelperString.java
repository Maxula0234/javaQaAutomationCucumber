package com.otus.helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelperString {

    public static Map<String, String> parseStringToMap(List<String> collect) {
        Map<String, String> data = new HashMap<>();

        collect.forEach(f -> {
            String[] s = f.split(" ", 2);
            f.split(" ", 2);

            if (s.length > 1)
                data.put(s[0], s[1]);
        });

        return data;
    }
}
