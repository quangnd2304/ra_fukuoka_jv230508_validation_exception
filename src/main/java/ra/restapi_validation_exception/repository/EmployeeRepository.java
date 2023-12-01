package ra.restapi_validation_exception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.restapi_validation_exception.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
