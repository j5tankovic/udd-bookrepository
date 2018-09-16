package com.bdzjn.udd.ebookrepository.dto;

import com.bdzjn.udd.ebookrepository.model.Category;
import com.bdzjn.udd.ebookrepository.model.Language;

public class EBookDTO {

    private long id;

    private String title;

    private String filename;

    private Language language;

    private Category category;

    private String author;

    private String keywords;

    private int publicationYear;

    private String mimeType;

    private long cataloguerId;

    public EBookDTO(long id, String title, String filename, Language language, Category category, String author, String keywords, int publicationYear, String mimeType, long cataloguerId) {
        this.id = id;
        this.title = title;
        this.filename = filename;
        this.language = language;
        this.category = category;
        this.author = author;
        this.keywords = keywords;
        this.publicationYear = publicationYear;
        this.mimeType = mimeType;
        this.cataloguerId = cataloguerId;
    }

    public EBookDTO() {
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

    public long getCataloguerId() {
        return cataloguerId;
    }

    public void setCataloguerId(long cataloguerId) {
        this.cataloguerId = cataloguerId;
    }
}
