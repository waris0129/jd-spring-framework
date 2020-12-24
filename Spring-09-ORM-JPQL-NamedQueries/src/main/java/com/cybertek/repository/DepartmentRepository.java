package com.cybertek.repository;


import com.cybertek.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    // List
    @Query("select d from Department d where d.division in ?1")
    List<Department> getDepartmentByDivisionIn(List<String>divisions);


    /////////// Name Query
    // Property
    List<Department> retrieveDepartmentByDivision(String division);

}
