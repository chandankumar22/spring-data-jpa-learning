package com.ck.dev.springdatajpalearning.entities;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(
        name = "students",
        uniqueConstraints = @UniqueConstraint(
                name = "student_non_nulls",
                columnNames = {"email_address", "f_name"}
        )
)
@ToString
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_id_seq",
            sequenceName = "student_id_seq_name",
            allocationSize = 2
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_seq"
    )
    private Long studentId;

    @Column(name = "f_name")
    private String firstName;
    @Column(name = "l_name")
    private String lastName;
    @Column(name = "email_address",
            nullable = false)
    private String emailId;
    /*@Column(name = "guardian_email")
    private String guardianEmail;
    @Column(name = "guardian_mob_no")
    private String guardianMobile;
    @Column(name = "guardian_name")
    private String guardianName;*/

    @Embedded
    private Guardian guardian;

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Student(String firstName, String lastName, String emailId, Guardian guardian) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.guardian = guardian;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }
}
