package com.lambda3.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GenericFilter {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> filtered = new ArrayList<>();
        for (T value : list) {
            if (predicate.test(value)) {
                filtered.add(value);
            }
        }
        return filtered;
    }
}
