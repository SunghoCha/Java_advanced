package com.stream.start;

import java.util.List;

public class StreamStartMain {

    public static void main(String[] args) {
        List<String> names = List.of("Apple", "Banana", "Berry", "Tomato");

        names.stream()
                .filter(n -> n.startsWith("B"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
        
    }
}
