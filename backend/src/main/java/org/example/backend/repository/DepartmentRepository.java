package org.example.backend.repository;

import org.example.backend.dox.Department;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,String> {

    @Query("SELECT * from department")
    List<Department> showAll();


}
