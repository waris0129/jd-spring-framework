package orm.cybertek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import orm.cybertek.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
