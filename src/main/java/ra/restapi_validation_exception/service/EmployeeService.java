package ra.restapi_validation_exception.service;

import ra.restapi_validation_exception.dto.request.EmpRequest;
import ra.restapi_validation_exception.dto.response.EmpResponse;

import java.util.List;

public interface EmployeeService {
    List<EmpResponse> findAll();

    EmpResponse findById(long id);

    EmpResponse save(EmpRequest empRequest);

    EmpResponse update(EmpRequest empRequest, long id);

    EmpResponse delete(long id);
}
