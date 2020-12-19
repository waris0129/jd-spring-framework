package orm.cinema.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket {

    //date_time, row_number, seat_number, movie_cinema_id, user_account_id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateTime;
    private int rowNumber;
    private int seatNumber;


    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private MovieCinema movieCinema;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private UserAccount userAccount;

    public Ticket(LocalDate dateTime, int rowNumber, int seatNumber, MovieCinema movieCinema, UserAccount userAccount) {
        this.dateTime = dateTime;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.movieCinema = movieCinema;
        this.userAccount = userAccount;
    }
}
