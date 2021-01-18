package com.cinemaapp.repository;

import com.cinemaapp.entity.Account;
import com.cinemaapp.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    // ------------------- DERIVED QUERIES ------------------- //
//Write a derived query to list all accounts with a specific country or state
    List<Account> getAccountByCountryOrState(String country,String state);

//Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findAccountByAgeLessThanEqual(Integer age);

//Write a derived query to list all accounts with a specific role
    List<Account> findAccountByRole(UserRole role);

//Write a derived query to list all accounts between a range of ages
    List<Account> findAccountByAgeBetween(int age1, int age2);


//Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findAccountByAddressStartingWith(String pattern);


//Write a derived query to sort the list of accounts with age
    List<Account> findAccountByOrderByAge();


// ------------------- JPQL QUERIES ------------------- //
//Write a JPQL query that returns all accounts
    @Query("select a from Account a")
    List<Account> getAllAccounts();

//Write a JPQL query to list all admin accounts
    @Query("select a from Account a where a.role = 'ADMIN'")
    List<Account> getAllAdminsAccount();

//Write a JPQL query to sort all accounts with age
    @Query("select a from Account a order by a.age")
    List<Account> getAccountSortByAge();

// ------------------- Native QUERIES ------------------- //
//Write a native query to read all accounts with an age lower than a specific value

    @Query(value = "SELECT * FROM account_details WHERE age < ?1" , nativeQuery = true)
    List<Account> getAccountByAge(int age);

//Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "SELECT * FROM account_details WHERE name ilike concat('%',?1,'%')"
            ,nativeQuery = true)
    List<Account> readAccountByPattern(String pattern);



//Write a native query to read all accounts with an age greater than a specific value







}



































