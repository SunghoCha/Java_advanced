package com.lambda3.mystream;

import com.lambda3.filter.GenericFilter;
import com.lambda3.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex2_Student {

    public static void main(String[] args) {
        // 점수가 80점 이상인 학생의 이름을 추출해라.
        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Tomato", 40)
        );
        List<String> directResult = direct(students);
        System.out.println("directResult = " + directResult);
        List<String> lambdaResult = lambda(students);
        System.out.println("lambdaResult = " + lambdaResult);
    }

    private static List<String> direct(List<Student> students) {
        ArrayList<String> filtered = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore() >= 80) {
                filtered.add(student.getName());
            }
        }
        return filtered;
    }

    private static List<String> lambda(List<Student> students) {
        return GenericMapper.map(GenericFilter.filter(students, s -> s.getScore() >= 80), Student::getName);
    }
}
