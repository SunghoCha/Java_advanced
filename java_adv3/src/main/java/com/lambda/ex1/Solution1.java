package com.lambda.ex1;

public class Solution1 {

    public static void greet(String value) {
        System.out.println("=== 시작 ===");
        System.out.println(value);
        System.out.println("=== 끝 ===");
    }

    public static void main(String[] args) {
        greet("Good Morning!");
        greet("Good Afternoon!");
        greet("Good Evening!");
    }
}
