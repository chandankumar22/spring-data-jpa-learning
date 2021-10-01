package com.ck.dev.springdatajpalearning.repositories;

import com.ck.dev.springdatajpalearning.entities.Course;
import com.ck.dev.springdatajpalearning.entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void addCourses(){
        courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("aaa.aa.aa").build());
        courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("ववव.aa.aa").course(Course.builder().courseCredit(12).courseTitle("Applied Physics").build()).build());
        courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("bbb.aa.aa").build());
        courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("vvv.aa.aa").build());
        courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("ccc.aa.aa").build());
    }
}