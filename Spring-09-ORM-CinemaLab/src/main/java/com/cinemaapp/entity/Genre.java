package com.cinemaapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Genre extends BaseEntity{

    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<Movie>movies;


    public Genre(String name) {
        this.name = name;
    }
}
