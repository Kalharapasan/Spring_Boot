package com.CRUD_Operation.CRUD.Operation.service;

import com.CRUD_Operation.CRUD.Operation.doa.AdminDoa;
import com.CRUD_Operation.CRUD.Operation.model.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminDoa adminDoa;

    public ResponseEntity<List<Admin>> getAllAdmin() {
        List<Admin>adminList = adminDoa.findAll();
        return ResponseEntity.ok(adminList);
    }

    public ResponseEntity<Admin> saveAdmin(Admin admin) {
        admin =  adminDoa.save(admin);
       if (admin.getAdminId() == null) {
           throw new RuntimeException("Admin Save Failed");
       }else {
           return ResponseEntity.ok(admin);
       }

    }
}
