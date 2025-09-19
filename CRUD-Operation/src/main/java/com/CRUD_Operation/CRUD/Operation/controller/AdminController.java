package com.CRUD_Operation.CRUD.Operation.controller;

import com.CRUD_Operation.CRUD.Operation.model.Admin;
import com.CRUD_Operation.CRUD.Operation.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    @GetMapping
    public ResponseEntity<List<Admin>>getAllAdmin(){
        return adminService.getAllAdmin();
    }

    @PostMapping
    public ResponseEntity<Admin>  saveAdmin(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }



}
