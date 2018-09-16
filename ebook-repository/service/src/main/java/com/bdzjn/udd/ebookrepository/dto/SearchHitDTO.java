package com.bdzjn.udd.ebookrepository.dto;

public class SearchHitDTO {

    private long id;

    private String title;

    private String text;

    private String author;

    private String category;

    public SearchHitDTO() {
    }

    public SearchHitDTO(String title, String text, String author) {
        this.title = title;
        this.text = text;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public SearchHitDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public SearchHitDTO setText(String text) {
        this.text = text;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public SearchHitDTO setAuthor(String author) {
        this.author = author;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Long.parseLong(id);
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
