package com.lambda.lambda1;

import com.lambda.MyFunction;

public class MyFunction2 {

    public static void main(String[] args) {
        MyFunction myFunction = (int a, int b) -> a + b;
        MyFunction myFunction2 = Integer::sum;

        int result = myFunction.apply(1, 2);
        int result2 = myFunction2.apply(1, 2);
        System.out.println("result = " + result);
        System.out.println("result2 = " + result2);
    }
}
