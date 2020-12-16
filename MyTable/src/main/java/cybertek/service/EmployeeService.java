package cybertek.service;

import cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeService extends JpaRepository<Employee,Long> {
}
