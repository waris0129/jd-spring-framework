package orm.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;


    // case 2
    @OneToMany(mappedBy = "person")
    private List<Address> address;

    // case 1
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "person_id")
//    private List<Address> address;


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
