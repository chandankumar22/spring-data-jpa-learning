package com.ck.dev.springdatajpalearning.repositories;

import com.ck.dev.springdatajpalearning.entities.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void addCourses(){
        courseRepository.save(Course.builder().courseCredit(12).courseTitle("Applied Physics").build());
        courseRepository.save(Course.builder().courseCredit(6).courseTitle("Computer Science").build());
        courseRepository.save(Course.builder().courseCredit(2).courseTitle("Programming with Java").build());
        courseRepository.save(Course.builder().courseCredit(10).courseTitle("Discrete Mathematics").build());
        courseRepository.save(Course.builder().courseCredit(5).courseTitle("Artificial Intelligence").build());
    }

    @Test
    public void getAllCourses(){
        System.out.println(courseRepository.findAll());
    }
}