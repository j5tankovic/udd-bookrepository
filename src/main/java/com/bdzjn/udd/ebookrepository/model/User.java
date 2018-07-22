package com.bdzjn.udd.ebookrepository.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String firstname;

    private String lastname;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @ManyToOne
    private Category subscribedCategory;

    public User() {
    }

    public User(String firstname, String lastname, String username, String password, UserType type, Category subscribedCategory) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.type = type;
        this.subscribedCategory = subscribedCategory;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Category getSubscribedCategory() {
        return subscribedCategory;
    }

    public void setSubscribedCategory(Category subscribedCategory) {
        this.subscribedCategory = subscribedCategory;
    }
}
