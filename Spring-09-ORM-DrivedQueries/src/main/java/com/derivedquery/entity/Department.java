package com.derivedquery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@Setter
@Getter
@NoArgsConstructor
public class Department {

    @Id
    private String department;

    private String division;
}
