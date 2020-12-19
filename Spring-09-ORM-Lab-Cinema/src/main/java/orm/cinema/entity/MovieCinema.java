package orm.cinema.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class MovieCinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime dateTime;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private Cinema cinema;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private Movie movie;

    @OneToMany(mappedBy = "movieCinema")
    private Set<Ticket> ticketSets= new HashSet<>();

    public MovieCinema(LocalTime dateTime, Cinema cinema, Movie movie) {
        this.dateTime = dateTime;
        this.cinema = cinema;
        this.movie = movie;
    }
}
