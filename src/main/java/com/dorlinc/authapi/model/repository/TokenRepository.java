package com.dorlinc.authapi.model.repository;

import com.dorlinc.authapi.model.data.Token;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token, String> {
}
