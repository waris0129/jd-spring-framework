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
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name, sponsored_name;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private Location location;

    @OneToMany(mappedBy = "cinema")
    private Set<MovieCinema>movieCinemaSets = new HashSet<>();

    public Cinema(String name, String sponsored_name, Location location) {
        this.name = name;
        this.sponsored_name = sponsored_name;
        this.location = location;
    }
}
