package com.dorlinc.authapi.model.repository;

import com.dorlinc.authapi.model.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
