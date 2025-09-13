package com.pasan.mysql_connection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table (name="Employee")
public class Employee {

    @Id
    @Column (name="id")
    private int id;

    @Column (name="fname")
    private String fname;

    @Column (name="lname")
    private String lname;

    @Column (name="email")
    private String email;

    @Column (name="phone")
    private String phone;

    @Column(name="addres")
    private String address;


}
