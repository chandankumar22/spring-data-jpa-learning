package com.ck.dev.springdatajpalearning.repositories;

import com.ck.dev.springdatajpalearning.entities.Course;
import com.ck.dev.springdatajpalearning.entities.CourseMaterial;
import com.ck.dev.springdatajpalearning.entities.Teacher;
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

        Teacher teacher1 = Teacher.builder().fName("Pankaj").lName("Sri").build();
        Teacher teacher2 = Teacher.builder().fName("Mona").lName("Lisa").build();
        Teacher teacher3 = Teacher.builder().fName("Ramanujan").lName("Mathiya").build();
        Teacher teacher4 = Teacher.builder().fName("Moliyta").lName("Suke").build();
        Teacher teacher5 = Teacher.builder().fName("A.Kumwer").lName("Santre").build();
        Teacher teacher6 = Teacher.builder().fName("Poybin").lName("Mathiya").build();

        courseMaterialRepository.save(
                CourseMaterial.builder().courseMaterialUrl("ववव.aa.aa")
                        .course(Course.builder()
                                .courseCredit(12)
                                .courseTitle("Data Structures and Algorithms")
                                .teacher(teacher1)
                                .build()).build());
        courseMaterialRepository.save(
                CourseMaterial.builder().courseMaterialUrl("helloc.com")
                        .course(Course.builder()
                                .courseCredit(6)
                                .courseTitle("Operating System")
                                .teacher(teacher2)
                                .build()).build());
        courseMaterialRepository.save(
                CourseMaterial.builder().courseMaterialUrl("helloc.com")
                        .course(Course.builder()
                                .courseCredit(2)
                                .courseTitle("Machine Learning")
                                .teacher(teacher3)
                                .build()).build());
        courseMaterialRepository.save(
                CourseMaterial.builder().courseMaterialUrl("helloc.com")
                        .course(Course.builder()
                                .courseCredit(10)
                                .courseTitle("Big Data Analytics")
                                .teacher(teacher4)
                                .build()).build());
        courseMaterialRepository.save(
                CourseMaterial.builder().courseMaterialUrl("gelloc.com")
                        .course(Course.builder()
                                .courseCredit(5)
                                .courseTitle("Behavioural Science")
                                .teacher(teacher5)
                                .build()).build());

    }

    @Test
    public void getAll(){
        System.out.println(courseMaterialRepository.findAll());
    }
}