package com.company.carservices.repository;

import com.company.carservices.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String userName);
}
