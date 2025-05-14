package com.lambda.ex2;


import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public static List<String> map(List<String> list, MyFunction<String> func) {
        ArrayList<String> result = new ArrayList<>();
        for (String str : list) {
            result.add(func.apply(str));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = List.of("hello", "java", "lambda");
        System.out.println("map(list, String::toUpperCase) = " + map(list, String::toUpperCase));
        System.out.println("map(list, a -> \"***\" + a + \"***\") = " + map(list, a -> "***" + a + "***"));
    }
}
