package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
@Setter
@Getter
@NoArgsConstructor
@ToString
@NamedQuery(name = "Department.findOzzyDepartment",
            query = "SELECT d FROM Department d WHERE d.division=?1"
)
@NamedNativeQuery(name = "Department.countAllDepartments",
                  query = "SELECT count(*) FROM departments",
                 resultClass = Department.class
)
public class Department {

    @Id
    private String department;

    private String division;
}
