package cybertek.entity;

import cybertek.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@MappedSuperclass
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "employeeFirstName")
    private String firstName;
    @Column(name = "employeeLastName")
    private String lastName;
    @Column(name = "employeeGender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(columnDefinition = "DATE")
    private LocalDate dateBirth;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate userCreateTimeStamp;

    public User(String firstName, String lastName, Gender gender, LocalDate dateBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateBirth = dateBirth;
        userCreateTimeStamp = LocalDate.now();
    }

    public User(){

    }
}
