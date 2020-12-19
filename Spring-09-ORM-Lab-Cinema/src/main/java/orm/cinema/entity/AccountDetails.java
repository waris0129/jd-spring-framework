package orm.cinema.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "accountDetails")
    private UserAccount userAccount;

    //address, age, city, country, name, postal_code, role, state
    private String address;
    private int age;
    private String city;
    private String country;
    private String name;
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private Role role;
    private String state;

    public AccountDetails(String address, int age, String city, String country, String name, String postalCode, Role role, String state) {
        this.address = address;
        this.age = age;
        this.city = city;
        this.country = country;
        this.name = name;
        this.postalCode = postalCode;
        this.role = role;
        this.state = state;
    }
}
