package com.lambda.lambda1;

import com.lambda.Procedure;

public class InstanceMain {
    public static void main(String[] args) {
        Procedure procedure1 = new Procedure() {
            @Override
            public void run() {
                System.out.println("args = " + args);
            }
        };
        System.out.println("procedure1.class = " + procedure1.getClass());
        System.out.println("procedure1.instance = " + procedure1);

        Procedure procedure2 = () -> System.out.println("args = " + args);
        System.out.println("procedure2.class = " + procedure2.getClass());
        System.out.println("procedure2.instance = " + procedure2);
    }
}
