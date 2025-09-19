package com.CRUD_Operation.CRUD.Operation.service;

import com.CRUD_Operation.CRUD.Operation.doa.EmployeeRepository;
import com.CRUD_Operation.CRUD.Operation.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
