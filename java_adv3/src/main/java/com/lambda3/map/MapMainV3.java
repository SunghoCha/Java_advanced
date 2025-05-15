package com.lambda3.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV3 {

    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        List<Integer> numbers = StringToIntegerMapper.map(list, Integer::valueOf);
        System.out.println("numbers = " + numbers);

        List<Integer> lengths = StringToIntegerMapper.map(list, String::length);
        System.out.println("lengths = " + lengths);
    }

}
