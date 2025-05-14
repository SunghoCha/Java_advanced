package com.lambda.ex2;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    static List<Integer> filter(List<Integer> list, MyPredicate predicate) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer value : list) {
             if (predicate.test(value)) {
                 result.add(value);
             }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(-3, -2, -1, 1, 2, 3, 5);

        System.out.println("음수만: " + filter(list, a -> a < 0));
        System.out.println("짝수만: " + filter(list, a -> a % 2 == 0));

    }
}
