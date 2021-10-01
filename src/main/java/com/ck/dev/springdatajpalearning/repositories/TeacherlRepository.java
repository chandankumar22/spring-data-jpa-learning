package com.ck.dev.springdatajpalearning.repositories;

import com.ck.dev.springdatajpalearning.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherlRepository extends JpaRepository<Teacher, Long> {

}
