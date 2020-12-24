package com.cybertek.repository;


import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT e From Employee e WHERE e.email = 'dtrail8@tamu.edu'")
    Employee getEmployeeDetail();


    @Query("SELECT e.salary from Employee e where e.email= 'dtrail8@tamu.edu'")
    Integer getEmployeeSalary();


    // Parameter: single Positional Bind Parameter --> ?1
    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Optional<Employee> getEmployeeByEmail(String email);
    // double
    @Query("SELECT e FROM Employee e WHERE e.email = ?1 AND e.salary= ?2")
    Employee getEmployeeByEmailAndSalary(String email, double salary);


    // Parameter : Named bind parameter --> single
    @Query("SELECT e FROM Employee e WHERE e.salary= :salary")
    Employee getEmployeeBySalary(@Param("salary") double salary);
    // multiple
    @Query("SELECT e FROM Employee e WHERE e.firstName = :firstName OR e.salary= :salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param("firstName") String firstName, @Param("salary") double salary);








}
