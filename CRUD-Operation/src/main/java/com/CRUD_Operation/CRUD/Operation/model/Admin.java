package com.CRUD_Operation.CRUD.Operation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ADMIN")

public class Admin {

    @Id
    @Column(name = "ADMIN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminId;

    @Column(name = "FIRST_NAME",length = 100)
    private String firstname;

    @Column(name="LAST_NAME",length = 100)
    private String lastname;

    @Column(name="EMAIL")
    private String email;

    @Column(name="AGE")
    private Integer age;

    @Column(name="ADDRESS")
    private String address;


}
