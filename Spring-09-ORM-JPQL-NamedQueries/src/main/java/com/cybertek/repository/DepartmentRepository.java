package com.cybertek.repository;


import com.cybertek.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    // displays all department in the Furniture Departments
    List<Department> findByDepartment(String department);


    // displays all departments in the health division
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    // displays all departments with division named end with 'ics'
    List<Department> findByDivisionEndsWith(String pattern);


    // displays Top 3 departments with division name includes 'hea' without duplicate
    List<Department> findDistinctTop3ByDivisionContaining(String pattern);


}
