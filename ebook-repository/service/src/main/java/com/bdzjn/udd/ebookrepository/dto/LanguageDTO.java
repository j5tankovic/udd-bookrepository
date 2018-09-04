package com.bdzjn.udd.ebookrepository.dto;

public class LanguageDTO {

    private long id;

    private String name;

    public LanguageDTO() {
    }

    public LanguageDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
