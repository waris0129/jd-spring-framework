package orm.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST})
    @JoinTable(
            name= "post_tag_rel",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
            ) // specify join table and columns
    private Set<Tag> tags = new HashSet<>(); // many to many needs Set structure and initial Hashset
                                            // Set structure is preferable way comparing with List structure



    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
