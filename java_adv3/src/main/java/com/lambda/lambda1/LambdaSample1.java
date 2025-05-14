package com.lambda.lambda1;

import com.lambda.MyFunction;

public class LambdaSample1 {

    public static void main(String[] args) {
        // 기본
        MyFunction myFunction1 = (int a, int b) -> {
            return a + b;
        };
        System.out.println("myFunction1 = " + myFunction1.apply(1, 2));

        // 단일 표현식인 경우 중괄호, return 생략 가능
        MyFunction myFunction2 = (int a, int b) -> a + b;
        System.out.println("myFunction2 = " + myFunction2.apply(1, 2));

        // 타입 생략
        MyFunction myFunction3 = (a, b) -> a + b;
        System.out.println("myFunction3 = " + myFunction3.apply(1, 2));

        // 메서드 참조
        MyFunction myFunction4 = Integer::sum;
        System.out.println("myFunction4 = " + myFunction4.apply(1, 2));

        // 단일 표현식 아닌 경우 중괄호, return 필수
        MyFunction myFunction5 = (int a, int b) -> {
            System.out.println("단일 표현식 아님");
            return a + b;
        };
        System.out.println("myFunction5 = " + myFunction5.apply(1, 2));

    }
}
