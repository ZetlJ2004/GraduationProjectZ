package org.example.backend.repository;


import org.example.backend.dox.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository<User, String> {
    User findByAccount(String account);
}
