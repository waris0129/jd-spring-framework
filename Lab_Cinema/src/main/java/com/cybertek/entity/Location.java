package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Location extends BaseEntity {

    private String name;
    private String latitude;
    private String longtitude;
    private String postalCode;
    private String country;
    private String city;
    private String state;
    private String address;

    public Location(String name, String latitude, String longtitude, String postalCode, String country, String city, String state, String address) {
        this.name = name;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.postalCode = postalCode;
        this.country = country;
        this.city = city;
        this.state = state;
        this.address = address;
    }
}
