package com.CRUD_Operation.CRUD.Operation.controller;

import com.CRUD_Operation.CRUD.Operation.doa.EmployeeRepository;
import com.CRUD_Operation.CRUD.Operation.model.Employee;
import com.CRUD_Operation.CRUD.Operation.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeCotroller {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);

    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return employeeService.getAllEmployee();
    }
}
