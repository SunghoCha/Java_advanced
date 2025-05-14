package com.lambda.ex1;

import com.lambda.MyFunction;

public class Solution5 {
    static MyFunction getOperator(String operator) {
        switch (operator) {
            case "add" : return (a, b) -> a + b;
            case "sub" : return (a, b) -> a - b;
            default: return (a, b) -> 0;
        }
    }

    public static void main(String[] args) {
        MyFunction add = getOperator("add");
        System.out.println("add(1, 2) = " + getOperator("add").apply(1, 2));
        System.out.println("sub(1, 2) = " + getOperator("sub").apply(1, 2));
        System.out.println("xxx(1, 2) = " + getOperator("xxx").apply(1, 2));
    }
}
