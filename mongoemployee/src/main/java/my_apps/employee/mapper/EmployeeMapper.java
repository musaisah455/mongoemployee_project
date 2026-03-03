package my_apps.employee.mapper;

import my_apps.employee.dto.EmployeeRequest;
import my_apps.employee.model.EmployeeModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING   // Makes it a Spring @Component → injectable
)
public interface EmployeeMapper {
    void updateModelFromEmployeeRequest(EmployeeRequest request, @MappingTarget EmployeeModel model);

    List<EmployeeModel> toResponse(List<EmployeeModel> model);

    EmployeeModel toResponse(EmployeeModel model);
    
}