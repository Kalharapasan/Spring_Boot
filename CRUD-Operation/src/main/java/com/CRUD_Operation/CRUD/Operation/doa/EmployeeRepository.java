package com.CRUD_Operation.CRUD.Operation.doa;

import com.CRUD_Operation.CRUD.Operation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Long>{

}
