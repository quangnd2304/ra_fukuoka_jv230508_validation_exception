package ra.restapi_validation_exception.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.restapi_validation_exception.dto.request.EmpRequest;
import ra.restapi_validation_exception.dto.response.EmpResponse;
import ra.restapi_validation_exception.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<EmpResponse>> getAllEmployee(){
        List<EmpResponse> listEmp = employeeService.findAll();
        return  new ResponseEntity<>(listEmp, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmpResponse> getEmployeeById(@PathVariable long id){
        EmpResponse emp = employeeService.findById(id);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<EmpResponse> createEmployee(@Valid @RequestBody EmpRequest empRequest){
        EmpResponse emp = employeeService.save(empRequest);
        return new ResponseEntity<>(emp,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmpResponse> updateEmployee(@RequestBody EmpRequest empRequest,@PathVariable  long id){
        EmpResponse emp = employeeService.update(empRequest,id);
        return new ResponseEntity<>(emp,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<EmpResponse> deleteEmployee(@PathVariable long id){
        EmpResponse emp = employeeService.delete(id);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }
}
