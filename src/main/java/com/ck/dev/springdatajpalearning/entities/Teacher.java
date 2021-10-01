package com.ck.dev.springdatajpalearning.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_seq",
            sequenceName="teacher_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "teacher_seq",
            strategy = GenerationType.SEQUENCE
    )
    private long teacherId;
    private String fName;
    private String lName;

    @OneToMany(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private List<Course> courses;

}
