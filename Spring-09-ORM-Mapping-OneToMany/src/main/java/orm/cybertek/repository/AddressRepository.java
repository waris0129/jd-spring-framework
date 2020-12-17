package orm.cybertek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import orm.cybertek.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
