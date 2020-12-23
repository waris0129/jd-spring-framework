package com.cybertek.entity;

import com.cybertek.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "AccountDetails")
public class Account extends BaseEntity{

    private String name, address, country,city, state;
    private Integer age;
    private String postalCode;
    private UserRole role;


    @OneToOne(mappedBy = "account")
    private User user;


    public Account(String name, String address, String country, String city, String state, Integer age, String postalCode, UserRole role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
        this.state = state;
        this.age = age;
        this.postalCode = postalCode;
        this.role = role;
    }
}
