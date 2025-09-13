package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/employee/")
public class EmplyeeController {

    @GetMapping
    public List<Employee> getEmployees (){

        return  List.of(
                new Employee(
                        1,
                        "Pasan",
                        "Kalhara",
                        "kalharap84@gmil.com",
                        "+94781927370",
                        "No 180 Dolakandha"
                )
        );

    }

}
