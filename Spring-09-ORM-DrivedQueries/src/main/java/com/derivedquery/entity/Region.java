package com.derivedquery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "regions")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Region extends BaseEntity{

    private String region, country;
}
