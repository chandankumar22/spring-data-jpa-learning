package com.ck.dev.springdatajpalearning.repositories;

import com.ck.dev.springdatajpalearning.entities.Course;
import com.ck.dev.springdatajpalearning.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherlRepositoryTest {

    @Autowired
    private TeacherlRepository teacherlRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void addTeachers(){
        List<Course> all = courseRepository.findAll();
        teacherlRepository.save(Teacher.builder().courses(all.subList(0,2)).fName("Sangram").lName("Singh").build());
        teacherlRepository.save(Teacher.builder().courses(all.subList(2,4)).fName("Mohan").lName("Kumar").build());
    }

}