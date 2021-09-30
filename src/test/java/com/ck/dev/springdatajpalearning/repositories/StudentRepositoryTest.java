package com.ck.dev.springdatajpalearning.repositories;

import com.ck.dev.springdatajpalearning.entities.Guardian;
import com.ck.dev.springdatajpalearning.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        studentRepository.save(new Student(
                "Chandan", "Kumar", "cka@ack.ck", Guardian.builder().guardianEmail("gemail.em").guardianMob("1234").guardianName("anish kumar").build()
        ));
    }

    @Test
    public void getStudents() {
        List<Student> all = studentRepository.findAll();
        all.forEach(System.out::println);
    }
}