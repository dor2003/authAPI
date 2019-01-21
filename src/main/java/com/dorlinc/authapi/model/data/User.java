package com.dorlinc.authapi.model.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class User {

    @Id
    @NonNull
    @JsonView(CREDENTIALS.class)
    private String userName;

    @NonNull
    @JsonView(DATA.class)
    private String firstName;

    @NonNull
    @JsonView(DATA.class)
    private String lastName;

    @NonNull
    @JsonView(CREDENTIALS.class)
    private String userPassword;

    @JsonIgnore
    @OneToOne
    private Token token;


    public User(String userName, String firstName, String lastName, String userPassword) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userPassword = userPassword;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public static class CREDENTIALS {}

    public static class DATA {}
}
