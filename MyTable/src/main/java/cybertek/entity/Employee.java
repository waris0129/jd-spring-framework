package cybertek.entity;

import cybertek.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Employee extends User{

    private String role;
    private BigDecimal salary;


    public Employee(String firstName, String lastName, Gender gender, LocalDate dateBirth, String role, BigDecimal salary) {
        super(firstName, lastName, gender, dateBirth);
        this.role = role;
        this.salary = salary;
    }

    public Employee() {
        super();
    }
}
