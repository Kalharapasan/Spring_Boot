package com.CRUD_Operation.CRUD.Operation.service;

import com.CRUD_Operation.CRUD.Operation.doa.AdminDoa;
import com.CRUD_Operation.CRUD.Operation.model.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<Admin> getAdminByID(Long adminId) {
        if (adminId == null) {
            throw new RuntimeException("Admin Id is Null");
        }else{
            Optional <Admin> admin = adminDoa.findById(adminId);
            if (admin.isPresent()) {
                return ResponseEntity.ok(admin.get());
            }else{
                throw new RuntimeException("Admin Not Found");
            }
        }
    }


    public ResponseEntity<Admin> updateAdmin(Long adminId, Admin admin) {
        if (adminId == null) {
            throw new RuntimeException("Admin Id is Null");
        }else {
            Optional <Admin> adminOptional = adminDoa.findById(adminId);
            if (adminOptional.isPresent()) {
                Admin updatedAdmin = adminOptional.get();
                updatedAdmin.setFirstname(admin.getFirstname());
                updatedAdmin.setLastname(admin.getLastname());
                updatedAdmin.setEmail(admin.getEmail());
                updatedAdmin.setAge(admin.getAge());
                updatedAdmin.setAddress(admin.getAddress());

                updatedAdmin = adminDoa.save(updatedAdmin);
                return ResponseEntity.ok(updatedAdmin);
            }else{
                throw new RuntimeException("Admin Not Found");
            }
        }

    }

    public ResponseEntity<String> deleteAdmin(Long adminId) {
        if (adminId == null) {
            throw new RuntimeException("Admin Id is Null");
        }else {
            Optional <Admin> adminOptional = adminDoa.findById(adminId);
            if (adminOptional.isPresent()) {
                adminDoa.deleteById(adminId);
                return ResponseEntity.ok("Admin Delete");
            }else{
                throw new RuntimeException("Admin Not Found");
            }
        }
    }
}
