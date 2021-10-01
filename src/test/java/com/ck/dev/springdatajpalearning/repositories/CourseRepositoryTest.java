package com.ck.dev.springdatajpalearning.repositories;

import com.ck.dev.springdatajpalearning.entities.Course;
import com.ck.dev.springdatajpalearning.entities.CourseMaterial;
import com.ck.dev.springdatajpalearning.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void addCourses() {
        courseRepository.save(Course.builder().courseMaterial(CourseMaterial.builder().build()).courseCredit(12).courseTitle("Applied Physics").build());
     /*   courseRepository.save(Course.builder().courseCredit(6).courseTitle("Computer Science").build());
        courseRepository.save(Course.builder().courseCredit(2).courseTitle("Programming with Java").build());
        courseRepository.save(Course.builder().courseCredit(10).courseTitle("Discrete Mathematics").build());
        courseRepository.save(Course.builder().courseCredit(5).courseTitle("Artificial Intelligence").build());*/
    }

    @Test
    public void addCoursesWithTeacher() {
        Teacher teacher1 = Teacher.builder().fName("Pankaj").lName("Sri").build();
        Teacher teacher2 = Teacher.builder().fName("Mona").lName("Lisa").build();
        Teacher teacher3 = Teacher.builder().fName("Ramanujan").lName("Mathiya").build();
        courseRepository.save(Course.builder().courseMaterial(CourseMaterial.builder().build()).courseCredit(12).courseTitle("Data Structures and Algorithms").teacher(teacher1).build());
        courseRepository.save(Course.builder().courseMaterial(CourseMaterial.builder().courseMaterialUrl("helloc.com").build()).courseCredit(6).courseTitle("Operating System").teacher(teacher2).build());
        courseRepository.save(Course.builder().courseMaterial(CourseMaterial.builder().courseMaterialUrl("welloc.com").build()).courseCredit(2).courseTitle("Machine Learning").teacher(teacher3).build());
        courseRepository.save(Course.builder().courseMaterial(CourseMaterial.builder().courseMaterialUrl("yelloc.com").build()).courseCredit(10).courseTitle("Big Data Analytics").teacher(teacher2).build());
        courseRepository.save(Course.builder().courseMaterial(CourseMaterial.builder().courseMaterialUrl("gelloc.com").build()).courseCredit(5).courseTitle("Behavioural Science").teacher(teacher3).build());
    }

    @Test
    public void getAllCourses() {
        System.out.println(courseRepository.findAll());
    }
}