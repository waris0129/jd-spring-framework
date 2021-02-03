package com.school.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.school.enums.AddressType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
@JsonIgnoreProperties(value = {"parent","teacher","student"},ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    private String city;
    private String country;
    private Integer currentTemperature;
    private String postalCode;
    private String state;
    private String street;

    @OneToOne(mappedBy = "address")
    private Parent parent;

    @OneToOne(mappedBy = "address")
    private Teacher teacher;

    @OneToOne(mappedBy = "address")
    private Student student;


    public Integer getTemperature(){
        RestTemplate restTemplate = new RestTemplate();

        final String URL = "http://api.weatherstack.com/current?access_key=02a009b8e3922c395677a1e85406aca6&query="+this.getCity();

        Object obj = restTemplate.getForObject(URL,Object.class);

        Map<String,Object>map = (Map<String,Object>)obj;

        Map<String,Object>map2=(Map<String,Object>)map.get("current");

        Integer _temp = (Integer) map2.get("temperature");

        return _temp;

    }


}
