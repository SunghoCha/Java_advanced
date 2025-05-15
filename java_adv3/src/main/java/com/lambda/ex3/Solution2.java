package com.lambda.ex3;

import com.lambda.ex2.MyFunction;

public class Solution2 {

    public static MyFunction<String> buildGreeter(String greeting) {
        return (str -> greeting + ", " + str);
    }

    public static void main(String[] args) {
        System.out.println("buildGreeter(\"Hello\").apply(\"Java\") = " + buildGreeter("Hello").apply("Java"));
        System.out.println("buildGreeter(\"Hi\").apply(\"Lambda\") = " + buildGreeter("Hi").apply("Lambda"));
    }
}
