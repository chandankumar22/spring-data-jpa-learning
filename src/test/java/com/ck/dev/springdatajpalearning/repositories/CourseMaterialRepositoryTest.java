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
    public void addCourses() {

        //The operations below will be successful as we are not providing any information about the course to the
        //course material table and hence the course id will be set as null

        /*courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("aaa.aa.aa").build());
        courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("bbb.aa.aa").build());
        courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("vvv.aa.aa").build());
        courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("ccc.aa.aa").build());*/

        //The operation below will fail because we are trying to add a course (internally the course id) in the
        //course material which has course_id as the foreign key. But since the course is not yet persisted in the
        //course table, course_material table cannot add the info saying that the course object is referencing toi the
        //transient state(not persisted state.

        //courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("ववव.aa.aa").course(Course.builder().courseCredit(12).courseTitle("Sanskrit").build()).build());

        //To solve this issue , hibernate provides the cascading concepts, provide cascade attribute to the @OneToOne mapped object
        courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("ववव.aa.aa").course(Course.builder().courseCredit(12).courseTitle("Sanskrit").build()).build());
        courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("saas.aa.aa").course(Course.builder().courseCredit(10).courseTitle("Hindi").build()).build());
        courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("dfcx.aa.aa").course(Course.builder().courseCredit(8).courseTitle("Maths").build()).build());
        courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("cvcfd.aa.aa").course(Course.builder().courseCredit(6).courseTitle("Science").build()).build());
        courseMaterialRepository.save(CourseMaterial.builder().courseMaterialUrl("cvcv.aa.aa").course(Course.builder().courseCredit(4).courseTitle("English").build()).build());

    }

    @Test
    public void getAll(){
        System.out.println(courseMaterialRepository.findAll());
    }
}