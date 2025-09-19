package com.CRUD_Operation.CRUD.Operation.service;

import com.CRUD_Operation.CRUD.Operation.doa.EmployeeRepository;
import com.CRUD_Operation.CRUD.Operation.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository  employeeRepository;
   

    public ResponseEntity<Employee> saveEmployee(Employee employee) {
        employee =   employeeRepository.save(employee);
        if (employee.getEmployeeId() == null){
            throw new RuntimeException("Employee Id is null");

        }else {
            return ResponseEntity.ok(employee);
        }

    }

    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employeesList = employeeRepository.findAll();
        return ResponseEntity.ok(employeesList);
    }

    public ResponseEntity<Employee> getEmployeeById(Long employeeId) {
        if (employeeId == null){
            throw new RuntimeException("Employee Id is null");
        }else {
            Optional<Employee> optEmployee = employeeRepository.findById(employeeId);
            if(optEmployee.isPresent()){
                return ResponseEntity.ok(optEmployee.get());
            }else{
                throw new RuntimeException("Employee Id is not found");
            }
        }
    }

    public ResponseEntity<Employee> updateEmployee(Long employeeId, Employee employee) {
        if(employeeId == null){
            throw new RuntimeException("Employee Id is null");
        }else{
            Optional<Employee> optEmployee = employeeRepository.findById(employeeId);
            if(optEmployee.isPresent()){
               Employee employeeUpdate = optEmployee.get();
                employeeUpdate.setFirstName(employee.getFirstName());
                employeeUpdate.setLastName(employee.getLastName());
                employeeUpdate.setEmail(employee.getEmail());
                employeeUpdate.setAge(employee.getAge());
                employeeUpdate.setAddress(employee.getAddress());

                employeeUpdate = employeeRepository.save(employeeUpdate);
                return ResponseEntity.ok(employeeUpdate);

            }else{
                throw new RuntimeException("Employee Id is not found");
            }
        }
    }

    public ResponseEntity<String> deleteEmployee(Long employeeId) {
        if (employeeId == null) {
            throw new RuntimeException("Employee Id is null");
        }

        Optional<Employee> optEmployee = employeeRepository.findById(employeeId);
        if (optEmployee.isPresent()) {
            employeeRepository.deleteById(employeeId);
            return ResponseEntity.ok("Employee Deleted");
        } else {
            throw new RuntimeException("Employee Id is not found");
        }
    }

}
