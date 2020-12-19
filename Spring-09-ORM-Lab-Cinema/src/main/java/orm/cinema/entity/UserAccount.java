package orm.cinema.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class UserAccount {
    //email, password, username, account_details_id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;


    @Length(min = 6)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private AccountDetails accountDetails;

    @OneToMany(mappedBy = "userAccount")
    private Set<Ticket>ticketSets = new HashSet<>();

    public UserAccount(String email, @Length(min = 6) String password, String username, AccountDetails accountDetails) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.accountDetails = accountDetails;
    }
}
