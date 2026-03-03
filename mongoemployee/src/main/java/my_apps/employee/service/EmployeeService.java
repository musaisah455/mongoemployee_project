package my_apps.employee.service;

import my_apps.employee.mapper.EmployeeMapper;
import my_apps.employee.model.EmployeeModel;
import my_apps.employee.dto.EmployeeRequest;
import my_apps.employee.exceptions.ResourceNotFoundException;
import my_apps.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;


    public List<EmployeeModel> getAllEmployees() {
        return mapper.toResponse(repository.findAll());
    }


    public EmployeeModel getEmployeeById(Long id) {
        EmployeeModel model = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return mapper.toResponse(model);
    }

    public EmployeeModel createEmployee(EmployeeRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setFirstName(request.getFirstName());
        employeeModel.setLastName(request.getLastName());
        employeeModel.setEmail(request.getEmail());
        employeeModel.setDepartment(request.getDepartment());
        employeeModel.setPosition(request.getPosition());
        employeeModel.setSalary(request.getSalary());

        EmployeeModel model = repository.save(employeeModel);
        return mapper.toResponse(model);
    }

    public EmployeeModel updateEmployee(Long id, EmployeeRequest request) {
        EmployeeModel employeeModel = getEmployeeById(id);

        if (!employeeModel.getEmail().equals(request.getEmail()) && repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        mapper.updateModelFromEmployeeRequest(request, employeeModel);

        EmployeeModel model = repository.save(employeeModel);
        return mapper.toResponse(model);
    }

    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}