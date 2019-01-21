package com.dorlinc.authapi.model.data;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Token {
    @NonNull
    @Id
    private String token;

    public Token(String token) {
        this.token = token;
    }
}
