package com.lambda3.filter;

import java.util.List;

public class FilterMainV4 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        List<Integer> evenNumbers = GenericFilter.filter(numbers, num -> num % 2 == 0);
        System.out.println("evenNumbers = " + evenNumbers);

        List<Integer> oddNumbers = GenericFilter.filter(numbers, num -> num % 2 == 1);
        System.out.println("oddNumbers = " + oddNumbers);

        List<String> strings = List.of("A", "BB", "CCC");
        List<String> filtered = GenericFilter.filter(strings, s -> s.length() >= 2);
        System.out.println("filtered = " + filtered);
    }


}
