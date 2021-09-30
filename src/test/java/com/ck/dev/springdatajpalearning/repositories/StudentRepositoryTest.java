package com.ck.dev.springdatajpalearning.repositories;

import com.ck.dev.springdatajpalearning.entities.Guardian;
import com.ck.dev.springdatajpalearning.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        studentRepository.save(new Student(
                null, "Kumar", "ckasa@ack.ck", Guardian.builder().guardianEmail("gemail.em").guardianMob("1234").guardianName("anish kumar").build()
        ));
        studentRepository.save(new Student(
                null, "Kumar", "asaka@ack.ck", Guardian.builder().guardianEmail("gemail.em").guardianMob("1234").guardianName("anish kumar").build()
        ));
    }

    @Test
    public void getStudents() {
        List<Student> all = studentRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void getStudentsByEmnail() {
        List<Student> all = studentRepository.findStudentsByEmailIdContains("ck");
        all.forEach(System.out::println);
    }

    @Test
    public void getNonNullNameCounts() {
        System.out.println("===============>"+studentRepository.countDistinctByFirstNameIsNotNull());
    }

    @Test
    public void getUniquwNameCounts() {
        System.out.println("===============>"+studentRepository.getUniqueNameCount());
    }

    @Test
    public void getNullFirstNamesEmail() {
        System.out.println("===============>"+studentRepository.getNullNamesEmailId());
    }
}