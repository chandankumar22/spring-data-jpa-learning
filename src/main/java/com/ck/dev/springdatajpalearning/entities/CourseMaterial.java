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

    @OneToOne
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
