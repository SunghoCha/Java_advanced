package com.lambda.ex3;

import java.util.List;

public class Solution1 {

    public static int reduce(List<Integer> nums, MyReducer reducer) {
        Integer result = nums.getFirst();
        for (int i = 1; i < nums.size(); i++) {
            result = reducer.reduce(result, nums.get(i));
        }
        return result;
    }

    public static int reduce2(List<Integer> nums, int initial, MyReducer reducer) {
        Integer result = initial;
        for (Integer num : nums) {
            result = reducer.reduce(result, num);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);
        System.out.println("reduce(list, Integer::sum) = " + reduce(list, Integer::sum));
        System.out.println("reduce(list, (a, b) -> a * b) = " + reduce(list, (a, b) -> a * b));

        System.out.println("reduce2(list, 0, Integer::sum) = " + reduce2(list, 0, Integer::sum));
        System.out.println("reduce2(list, 1, (a, b) -> a * b) = " + reduce2(list, 1, (a, b) -> a * b));
    }
}
