package com.ck.dev.springdatajpalearning.repositories;

import com.ck.dev.springdatajpalearning.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findStudentsByEmailIdContains(String name);

    public Long countDistinctByFirstNameIsNotNull();

    //if need to specify query explicitly which is jpql(formed by hibernate), use @Query annotation
    @Query("select distinct count(s.firstName) from Student s where s.firstName is not null")
    public Long getUniqueNameCount();

    @Query("select s.emailId from Student s where s.firstName is null")
    public List<String> getNullNamesEmailId();

    //if need to specify query explicitly which is native sql query, use @Query annotation, be careful to use
    //only table related info like table name, attributes, must be same as in the database
    @Query(value = "SELECT s.guard_email from students s where s.f_name=?1 AND s.l_name=?2",nativeQuery = true)
    public List<String> getGuardianNamesFromStudentEmail(String fName, String lName);

    //native query named parameter
    @Query(value = "SELECT s.student_id from students s where s.email_address=:email",nativeQuery = true)
    public Long getIdByEmail(@Param("email") String email);

    //for any create/update operations to be performed on db, @Transactional and @Modifying annotation is used
    @Query(value = "update students s set s.f_name = ?1 where s.email_address=?2",nativeQuery = true)
    @Transactional
    @Modifying
    int updateNameBasedOnEmailId(String name,String email);
}
