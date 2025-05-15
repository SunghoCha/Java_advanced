package com.lambda.ex3;

import com.lambda.ex2.MyFunction;

public class Solution3 {

    static public MyFunction<String> compose(MyFunction<String> func1, MyFunction<String> func2) {
        return str -> func2.apply(func1.apply(str));
    }

    public static void main(String[] args) {
        MyFunction<String> composed = compose(String::toUpperCase, str -> "**" + str + "**");
        System.out.println("composed.apply(\"hello\") = " + composed.apply("hello"));
    }
}
