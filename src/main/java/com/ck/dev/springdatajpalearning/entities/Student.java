package com.ck.dev.springdatajpalearning.entities;

import javax.persistence.*;

@Entity
@Table(
        name = "students",
        uniqueConstraints = @UniqueConstraint(
                name = "student_non_nulls",
                columnNames = {"email_address", "f_name"}
        )
)
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
    @Column(name = "guardian_name")
    private String guardianName;
    @Column(name = "email_address",
            nullable = false)
    private String emailId;
    @Column(name = "guardian_email")
    private String guardianEmail;
    @Column(name = "guardian_mob_no")
    private String guardianMobile;

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Student(Long studentId, String firstName, String lastName, String guardianName, String emailId, String guardianEmail, String guardianMobile) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.guardianName = guardianName;
        this.emailId = emailId;
        this.guardianEmail = guardianEmail;
        this.guardianMobile = guardianMobile;
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

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getGuardianEmail() {
        return guardianEmail;
    }

    public void setGuardianEmail(String guardianEmail) {
        this.guardianEmail = guardianEmail;
    }

    public String getGuardianMobile() {
        return guardianMobile;
    }

    public void setGuardianMobile(String guardianMobile) {
        this.guardianMobile = guardianMobile;
    }
}
