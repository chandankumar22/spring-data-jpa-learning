package com.ck.dev.springdatajpalearning.repositories;

import com.ck.dev.springdatajpalearning.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findStudentsByEmailIdContains(String name);

    public Long countDistinctByFirstNameIsNotNull();

    //if need to specify query explicitly, use @Query annotation
    @Query("select distinct count(s.firstName) from Student s where s.firstName is not null")
    public Long getUniqueNameCount();

    @Query("select s.emailId from Student s where s.firstName is null")
    public List<String> getNullNamesEmailId();

}
