package cybertek.entity;

import cybertek.enums.Gender;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "studentFirstName")
    private String firstName;

    @Column(name = "studentLastName")
    private String lastName;

    @Column(name = "studentEmailAddress")
    private String email;

    @Transient
    private String city;

    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Temporal(TemporalType.TIME)
    private Date brithTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDateTime;


    @Column(columnDefinition = "DATE")
    private LocalDate localDate;
    @Column(columnDefinition = "TIME")
    private LocalDate localTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate localTimeStamp;


    @Enumerated(EnumType.STRING)
    private Gender gender;

}
