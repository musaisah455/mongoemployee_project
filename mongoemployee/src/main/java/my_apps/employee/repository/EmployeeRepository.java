package my_apps.employee.repository;

import my_apps.employee.model.EmployeeModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<EmployeeModel, Long> {
    //Optional<EmployeeModel> findByEmail(String email);
    boolean existsByEmail(String email);
}