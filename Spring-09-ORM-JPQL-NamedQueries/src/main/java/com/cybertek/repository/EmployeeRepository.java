package com.cybertek.repository;


import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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



    // Not Equal <>
    @Query("SELECT e FROM Employee e WHERE e.salary<> ?1 ")
    List<Employee> getEmployeeBySalaryNotEqual(double Salary);


    // Like, Contains, StartsWith, EndsWith
    @Query("SELECT e from Employee e where e.firstName LIKE ?1")
    List<Employee> getEmployeeByFirstNameLike(String pattern);


    // LessThan
    @Query("SELECT e from Employee e where e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(double salary);

    // Greater Than
    @Query("SELECT e from Employee e where e.salary > ?1")
    List<Employee> getEmployeeBySalaryGreaterThan(double salary);


    // Between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeBySalaryBetween(double salary1, double salary2);


    // Before
    @Query("select e from Employee e where e.hireDate > ?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);


    // Null
    @Query("select e from Employee e where e.email is null")
    List<Employee> getEmployeeByEmailIsNull();


    // Not Null
    @Query("select e from Employee e where e.email is not null")
    List<Employee> getEmployeeByEmailIsNotNull();



    // Sort
    @Query("select e from Employee e order by e.salary desc")
    List<Employee> getEmployeeBySalarySortByDesc();



    // Native Query
    @Query(value = "SELECT * FROM employees where salary = ?1",nativeQuery = true)
    List<Employee> readEmployeeBySalary(double salary);


    // DDL @Transaction @Modifying
    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.email= 'waris@jmail.com' where e.id=?1")
    void updateEmployeeJPQL(long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET email = 'gina@jmail.com' where id = :id",nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") long id);




    /////////// Name Query
    // Property
    List<Employee> retrieveEmployeeBySalaryGreaterThan(double salary);

    // Annotation



}







































