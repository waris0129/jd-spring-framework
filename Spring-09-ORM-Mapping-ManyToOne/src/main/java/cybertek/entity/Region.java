package cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Regions")
@Getter
@Setter
@NoArgsConstructor
public class Region extends BaseEntity{

    private String region;
    private String country;

    @OneToOne(mappedBy = "region")
    private Employee employee;


    public Region(String region, String country) {
        this.region = region;
        this.country = country;
    }
}
