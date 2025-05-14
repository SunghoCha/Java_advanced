package com.lambda.start;

public class Ex0RefMain {

    public static void hello(String value) {
        System.out.println("프로그램 시작");
        System.out.println("Hello" + value);
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        hello("Java");
        hello("Spring");
    }
}
