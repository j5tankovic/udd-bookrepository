package com.bdzjn.udd.ebookrepository.informationRetrieval.model;

import com.bdzjn.udd.ebookrepository.model.Category;
import com.bdzjn.udd.ebookrepository.model.Language;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "erepository", createIndex = false)
public class IREBook {

    public static final String INDEX_NAME = "erepository";
    public static final String TYPE_NAME = "ebook";

    @Id
    @Field(type = FieldType.Keyword, index = false, store = true)
    private String filename;

//    @Field(type = FieldType.Text, store = true, analyzer = "serbian-analyzer")
    private String text;

//    @Field(type = FieldType.Text, store = true)
    private String title;

//    @Field(type = FieldType.Text, store = true, analyzer = "serbian-analyzer")
    private String keywords;

//    @Field(type = FieldType.Text, store = true)
    private String author;

//    @Field(type = FieldType.Integer, store = true)
    private int publicationYear;

//    @Field(type = FieldType.Object, store = true)
    private Language language;

//    @Field(type = FieldType.Object, store = true)
    private Category category;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public IREBook setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
        return this;
    }

    public Language getLanguage() {
        return language;
    }

    public IREBook setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public IREBook setCategory(Category category) {
        this.category = category;
        return this;
    }
}
