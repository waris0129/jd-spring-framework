package com.derivedquery.repository;

import com.derivedquery.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // displays all employees with email address ''
    List<Employee> findByEmail(String email);

    // displays all employees with firstName '' and lastName'', also show all employees with email ''
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName,String lastName,String email);


    // displays all employees the firstName is not ''
    List<Employee> findByFirstNameIsNot(String firstName);


    // displays all employees where lastName starts with ''
    List<Employee> findByLastNameStartingWith(String pattern);


    // displays all employees with salary higher than ''
    List<Employee> findBySalaryGreaterThan(double salary);


    // displays all employees with salary less than ''
    List<Employee> findBySalaryLessThanEqual(double salary);


    // displays all employees that has been hired between '' and ''
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);



    //displays all employees salary greater or equal to ''
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(double salary);


    // displays top unique 3 employees that making less than '' amount
    List<Employee> findDistinctTop3BySalaryLessThan(double salary);



    // displays all employees that do not have email address
    List<Employee> findByEmailIsNull();
}
