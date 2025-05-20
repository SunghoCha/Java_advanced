package com.util;

import java.util.List;

public class Test {


    public static class Apple {

        private String color;
        private int weight;

        public Apple(String color, int weight) {
            this.color = color;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    public static void main(String[] args) {

        List<Apple> apples = List.of(
                new Apple("green", 100),
                new Apple("red", 200)
        );

        List<Apple> filtered = apples.stream()
                .filter(a -> a.getWeight() >= 150)
                .toList();
        System.out.println(filtered.get(0) == apples.get(1));
    }
}
