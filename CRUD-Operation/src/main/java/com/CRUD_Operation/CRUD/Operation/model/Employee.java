package com.CRUD_Operation.CRUD.Operation.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EMPLYEE_ID")
    private  Long employeeId;

    @Column(name="FIRST_NAME",length = 100)
    private String firstName;

    @Column(name="LAST_NAME",length = 100)
    private String lastName;

    @Column(name="EMAIL")
    private String email;

    @Column(name="AGE")
    private  int age;

    @Column(name="ADDRESS")
    private  String address;




}
