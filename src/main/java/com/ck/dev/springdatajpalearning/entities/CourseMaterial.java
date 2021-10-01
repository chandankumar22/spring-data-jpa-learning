package com.ck.dev.springdatajpalearning.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_mat_seq",
            sequenceName="course_mat_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "course_mat_seq",
            strategy = GenerationType.SEQUENCE
    )
    private long courseMaterialId;
    private String courseMaterialUrl;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
