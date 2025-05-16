package com.lambda3.mystream;

import com.lambda3.filter.GenericFilter;
import com.lambda3.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;

public class Ex1_Number {

    public static void main(String[] args) {
        // 짝수만 남기고, 남은 값의 2배를 반환
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> directResult = direct(numbers);
        System.out.println("directResult = " + directResult);
        List<Integer> lambdaResult = lambda(numbers);
        System.out.println("lambdaResult = " + lambdaResult);
    }
    static List<Integer> direct(List<Integer> numbers) {
        // TODO 코드 작성
        List<Integer> list = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                list.add(number * 2);
            }
        }
        return list;
    }

    static List<Integer> lambda(List<Integer> numbers) {
        // TODO 코드 작성
        return GenericMapper.map(GenericFilter.filter(numbers, n1 -> n1 % 2 == 0), n -> n * 2);
    }
}
