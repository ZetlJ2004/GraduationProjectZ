package org.example.backend.repository;


import org.example.backend.dox.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ListCrudRepository<User, String> {
    User findByAccount(String account);

    @Query("select * from user where cast(department->>'$.depId' as char(19))=:depId and role=:role")
    List<User> findByDepIdAndRole(String depId, String role);

    @Modifying
    @Query("update user u set student=json_set(student,'$.teacherId',:tid) where id=:sid")
    void updateStudentById(String sid,String tid);
}
