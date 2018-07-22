package com.bdzjn.udd.ebookrepository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EBook {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String filename;

    @ManyToOne
    private Language language;

    @ManyToOne
    private Category category;

    private String author;

    private String keywords;

    private int publicationYear;

    private String mimeType;

    @ManyToOne
    private User cataloguer;

    public EBook() {
    }

    public EBook(String title, String filename, Language language, Category category, String author, String keywords, int publicationYear, String mimeType, User cataloguer) {
        this.title = title;
        this.filename = filename;
        this.language = language;
        this.category = category;
        this.author = author;
        this.keywords = keywords;
        this.publicationYear = publicationYear;
        this.mimeType = mimeType;
        this.cataloguer = cataloguer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public User getCataloguer() {
        return cataloguer;
    }

    public void setCataloguer(User cataloguer) {
        this.cataloguer = cataloguer;
    }
}
