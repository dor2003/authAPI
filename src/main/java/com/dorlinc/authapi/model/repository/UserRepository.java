package com.dorlinc.authapi.model.repository;

import com.dorlinc.authapi.model.data.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
