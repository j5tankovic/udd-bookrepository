package com.bdzjn.udd.ebookrepository.dto;

import com.bdzjn.udd.ebookrepository.model.Category;
import com.bdzjn.udd.ebookrepository.model.UserType;

public class UserDTO {

    private long id;

    private String firstname;

    private String lastname;

    private String username;

    private String password;

    private UserType type;

    private Category subscribedTo;

    public UserDTO() {
    }

    public UserDTO(long id, String firstname, String lastname, String username, String password, UserType type) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Category getSubscribedTo() {
        return subscribedTo;
    }

    public UserDTO setSubscribedTo(Category subscribedTo) {
        this.subscribedTo = subscribedTo;
        return this;
    }
}
