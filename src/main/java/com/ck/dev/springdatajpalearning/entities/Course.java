package com.ck.dev.springdatajpalearning.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_seq",
            sequenceName="course_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "course_seq",
            strategy = GenerationType.SEQUENCE
    )
    private long courseId;
    private String courseTitle;
    private int courseCredit;

    /*
    * to achieve bi-directional one to one mapping, we need to map the foreign key in class B(course material here) with
    * the reference of class B in class A (Course here)
    * */
    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private  Teacher teacher;
}
