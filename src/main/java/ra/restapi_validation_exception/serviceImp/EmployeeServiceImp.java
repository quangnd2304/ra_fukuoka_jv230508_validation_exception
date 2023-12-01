package ra.restapi_validation_exception.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.restapi_validation_exception.dto.request.EmpRequest;
import ra.restapi_validation_exception.dto.response.EmpResponse;
import ra.restapi_validation_exception.mapper.EmployeeMapper;
import ra.restapi_validation_exception.model.Employee;
import ra.restapi_validation_exception.repository.EmployeeRepository;
import ra.restapi_validation_exception.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<EmpResponse> findAll() {
        //1. Gọi sang repository lay du lieu ve: List<Employee>
//        List<Employee> listEmpEntity = employeeRepository.findAll();
        //2. Convert List<Employee> sang List<EmpResponse>
//        List<EmpResponse> listEmpResponse = listEmpEntity.stream()
//                .map(employee -> employeeMapper.toResponse(employee)).collect(Collectors.toList());
        //3. return List<EmpResponse> ve controller
//        return listEmpResponse;
        return employeeRepository.findAll().stream()
                .map(employee -> employeeMapper.toResponse(employee)).collect(Collectors.toList());
    }

    @Override
    public EmpResponse findById(long id) {
        //1. Gọi Repository lây dữ liệu về: Employee
        //findById(id): empty - employee
        Optional<Employee> optEmp = employeeRepository.findById(id);
        if (optEmp.isPresent()) {
            //2. Convert Employee --> EmpResponse
            //3. return EmpResponse
            return employeeMapper.toResponse(optEmp.get());
        }
        return null;
    }

    @Override
    public EmpResponse save(EmpRequest empRequest) {
        //1. EmpRequest --> entity
        //2. Gọi repository để thêm mới: entity
        //3. entity --> empResponse
        //4. Return empResponse
        return employeeMapper.toResponse(employeeRepository.save(employeeMapper.toEntity(empRequest)));
    }

    @Override
    public EmpResponse update(EmpRequest empRequest, long id) {
        //1. Kiem tra id co ton tai khong
        Optional<Employee> optEmp = employeeRepository.findById(id);
        if (optEmp.isPresent()){
            //Có tồn tại --> cập nhật
            //EmpRequest --> entity
            //repository để cập nhật: entity
            //entity --> empRespose
            Employee empUpdate = optEmp.get();
            empUpdate.setName(empRequest.getName());
            empUpdate.setBirthDate(empRequest.getBirthDate());
            empUpdate.setEmail(empRequest.getEmail());
            empUpdate.setPhone(empRequest.getPhone());
            empUpdate.setAddress(empRequest.getAddress());
            empUpdate.setStatus(empRequest.isStatus());
            return employeeMapper.toResponse(employeeRepository.save(empUpdate));
        }
        return null;
    }

    @Override
    public EmpResponse delete(long id) {
        Optional<Employee> optEmp = employeeRepository.findById(id);
        if (optEmp.isPresent()){
            //Thực hiện xóa
            employeeRepository.deleteById(id);
            return employeeMapper.toResponse(optEmp.get());
        }
        return null;
    }
}
