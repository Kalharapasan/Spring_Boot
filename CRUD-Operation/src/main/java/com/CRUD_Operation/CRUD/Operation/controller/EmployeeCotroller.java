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

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId ) {
        return employeeService.getEmployeeById(employeeId);

    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable Long employeeId,@RequestBody Employee employee ) {
            return employeeService.updateEmployee(employeeId,employee);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }



}
