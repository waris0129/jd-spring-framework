package orm.cinema.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name, address, postal_code, country, state, city;

    public Location(String name, String address, String postal_code, String country, String state, String city) {
        this.name = name;
        this.address = address;
        this.postal_code = postal_code;
        this.country = country;
        this.state = state;
        this.city = city;
    }

    @OneToMany(mappedBy = "location")
    private Set<Cinema>cinemas= new HashSet<>();


}
