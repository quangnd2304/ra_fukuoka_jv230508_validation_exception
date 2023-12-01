package ra.restapi_validation_exception.mapper;

import org.springframework.stereotype.Component;
import ra.restapi_validation_exception.dto.request.EmpRequest;
import ra.restapi_validation_exception.dto.response.EmpResponse;
import ra.restapi_validation_exception.model.Employee;

@Component
public class EmployeeMapper implements GenericMapper<Employee, EmpRequest, EmpResponse>{

    @Override
    public Employee toEntity(EmpRequest empRequest) {
        //Tạo constructor dùng 1 lần và khởi tạo luôn đối tượng từ constructor đó
        return Employee.builder().id(empRequest.getId())
                .name(empRequest.getName())
                .birthDate(empRequest.getBirthDate())
                .email(empRequest.getEmail())
                .phone(empRequest.getPhone())
                .address(empRequest.getAddress())
                .status(empRequest.isStatus()).build();
    }

    @Override
    public EmpResponse toResponse(Employee employee) {
        return EmpResponse.builder().id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .address(employee.getAddress())
                .status(employee.isStatus()).build();
    }
}
