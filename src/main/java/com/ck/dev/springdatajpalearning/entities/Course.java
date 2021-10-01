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
}
