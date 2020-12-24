package com.cybertek.entity;



import com.cybertek.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Employee extends BaseEntity {

    private String firstName,lastName,email;

    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    private double salary;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region regionId;


}
