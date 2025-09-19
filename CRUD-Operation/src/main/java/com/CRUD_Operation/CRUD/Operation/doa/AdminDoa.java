package com.CRUD_Operation.CRUD.Operation.doa;

import com.CRUD_Operation.CRUD.Operation.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDoa extends JpaRepository<Admin,Long> {
}
