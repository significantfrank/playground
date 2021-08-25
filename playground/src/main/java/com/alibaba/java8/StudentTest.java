package com.alibaba.java8;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * StudentTest
 *
 * @author Frank Zhang
 * @date 2019-12-01 00:36
 */
public class StudentTest {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Frank", 32),
                new Student("Lucy", 23),
                new Student("Alex", 13),
                new Student("Martin", 17)
        );

        List<String> studentNames = students.stream()
                .filter(s -> s.getAge() > 18)
                .map(s -> {
                    System.out.println("name : " + s.getName());
                    return s.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
    }

}

@Data
class Student {
    int age;
    String name;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
}