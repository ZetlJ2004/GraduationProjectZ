package org.example.backend.repository;

import org.example.backend.dox.Process;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessRepository extends CrudRepository<Process,String> {

}
