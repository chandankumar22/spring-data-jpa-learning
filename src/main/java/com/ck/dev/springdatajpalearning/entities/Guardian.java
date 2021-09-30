package com.ck.dev.springdatajpalearning.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Guardian {


    @Column(name = "guard_name")
    private String guardianName;
    @Column(name = "guard_email")
    private String guardianEmail;
    @Column(name = "guard_mob")
    private String guardianMob;
}
