package com.lambda3.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV2 {

    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        List<Integer> numbers = map(list, Integer::valueOf);
        System.out.println("numbers = " + numbers);

        List<Integer> lengths = map(list, String::length);
        System.out.println("lengths = " + lengths);
    }

    static List<Integer> map(List<String> list, Function<String,Integer> mapper) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String value : list) {
            Integer result = mapper.apply(value);
            numbers.add(result);
        }
        return numbers;
    }


}
