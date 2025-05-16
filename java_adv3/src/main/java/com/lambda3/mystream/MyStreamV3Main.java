package com.lambda3.mystream;

import java.util.List;

public class MyStreamV3Main {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Tomato", 40)
        );

        List<String> list = MyStreamV3.of(students)
                .filter(s -> s.getScore() >= 80)
                .filter(s -> s.getName().length() == 5)
                .map(Student::getName)
                .map(String::toUpperCase)
                .toList();

        System.out.println("list = " + list);
    }

}
