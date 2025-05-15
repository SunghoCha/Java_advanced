package com.lambda3.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV4 {

    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        List<Integer> numbers = GenericMapper.map(list, Integer::valueOf);
        System.out.println("numbers = " + numbers);

        List<Integer> lengths = GenericMapper.map(list, String::length);
        System.out.println("lengths = " + lengths);

        List<String> fruits = List.of("apple", "banana", "orange");
        List<String> upperFruits = GenericMapper.map(fruits, String::toUpperCase);
        System.out.println(upperFruits);

        List<Integer> lengthFruits = GenericMapper.map(fruits, String::length);
        System.out.println(lengthFruits);

        List<Integer> integers = List.of(1, 2, 3);
        List<String> starList = GenericMapper.map(integers, "*"::repeat);
        System.out.println(starList);

    }

}
