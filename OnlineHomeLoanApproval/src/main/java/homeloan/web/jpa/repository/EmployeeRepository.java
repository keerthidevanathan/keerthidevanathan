package homeloan.web.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import homeloan.web.jpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
