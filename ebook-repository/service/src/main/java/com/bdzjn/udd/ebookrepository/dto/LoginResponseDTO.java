package com.bdzjn.udd.ebookrepository.dto;

import com.bdzjn.udd.ebookrepository.model.UserType;

public class LoginResponseDTO {

    private long id;

    private UserType type;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(long id, UserType type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
